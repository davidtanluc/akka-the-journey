package akka.intro

import akka.actor.{Props, ActorSystem}
import akka.intro.{WhoToGreet, Greeter}
import org.scalatest.FlatSpec

class IntrotoAkkaTest extends FlatSpec{

    behavior of "Intro to Akka"

    it should "receive message" in {
        val system = ActorSystem("Hello-Akka")
        val greeter = system.actorOf(Props[Greeter], name = "greeter")
        greeter ! WhoToGreet("AkkaBoing".reverse)
        system.terminate()
    }



}
/*
Hello gnioBakkA
 */