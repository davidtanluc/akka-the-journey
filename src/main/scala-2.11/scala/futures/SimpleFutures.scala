package scala.futures

import akka.actor.{Props, ActorSystem, Actor}
import akka.event.Logging
import akka.util
import scala.concurrent.duration._
import scala.concurrent.Await

class SimpleFuture extends Actor{
  val log = Logging(context.system, this)

  def receive ={
    case "Number One"=>{
      //Thread.sleep(450)
      sender ! log.info("THIS IS Number One")
    }
    case _=>{
      sender ! log.info("THIS IS not Number One")
    }
  }
}

object SimpleFutures extends App{
  import akka.pattern.ask
  implicit val timeout = util.Timeout(3 seconds)

  val system = ActorSystem("Simple-Future")
  val futureActor = system.actorOf(Props[SimpleFuture], "simpleFuture")
  val promise = futureActor ? "Number One"
  val result = Await.result(promise, timeout.duration) //Blocking
  Thread.sleep(2000)
  val promise2 = futureActor ? "beep"
  val result2 = Await.result(promise2, timeout.duration) //Blocking

  system.terminate()

}
