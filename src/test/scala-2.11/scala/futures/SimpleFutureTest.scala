package scala.futures

import org.scalatest.FlatSpec
import akka.actor.{Props, ActorSystem}
import akka.util
import scala.concurrent.duration._
import scala.concurrent.Await


class SimpleFutureTest extends FlatSpec{

  behavior of "Simple Future Test"

  it should "receive message" in {
    import akka.pattern.ask
    implicit val timeout = util.Timeout(3 seconds)

    val system = ActorSystem("Simple-Future")
    val futureActor = system.actorOf(Props[SimpleFuture], "simpleFuture")
    val promise = futureActor ? "Number One" //Ask
    Await.result(promise, timeout.duration) //Blocking
    Thread.sleep(2000)
    val promise2 = futureActor ? "beep" //Ask
    Await.result(promise2, timeout.duration) //Blocking

    system.terminate()
  }



}