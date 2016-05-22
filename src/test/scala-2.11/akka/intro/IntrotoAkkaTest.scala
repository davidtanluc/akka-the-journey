package akka.intro

import org.scalatest.FlatSpec
import akka.actor.{Props, ActorSystem}
/**
  * Created by davidtan on 5/22/16.
  */
class IntrotoAkkaTest extends FlatSpec{

    behavior of "Intro to Akka"

    it should "receive message" in {
    val system = ActorSystem("Hello-Akka")
    val greeter = system.actorOf(Props[Greeter], name = "greeter")
    greeter ! WhoToGreet("AkkaBoing".reverse)
    system.terminate()
  }



}
