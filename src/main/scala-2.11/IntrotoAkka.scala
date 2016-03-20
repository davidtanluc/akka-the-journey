/**
  * Created by davidtan on 3/20/16.
  */

import akka.actor.{ActorSystem, Props, Actor}


case class WhoToGreet(who: String)

class Greeter extends Actor {
  def receive = {
    case WhoToGreet(who) => println(s"Hello $who")
  }
}

object IntrotoAkka extends App {

  val system = ActorSystem("Hello-Akka")
  val greeter = system.actorOf(Props[Greeter], name = "greeter")
  greeter ! WhoToGreet("AkkaBoing".reverse)
  system.terminate()

}
/*
Hello gnioBakkA
 */