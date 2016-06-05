package scala.futuresnonakka
//http://alvinalexander.com/scala/future-example-scala-cookbook-oncomplete-callback

import scala.io.Source
import scala.util.{Random, Failure, Success}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object futuresnonakka extends App {

    println("1 - Goto IO devices ...")
    val f = Future {
      val source = Source.fromURL("http://docs.scala-lang.org/overviews/core/futures.html")
      sleep(Random.nextInt(500))
      source.getLines
    }

    println("2- before onComplete")
    f.onComplete {
      case Success(lineIterator) => {
        for (l <- lineIterator)
        println(if (l.length <= 13) l else l.substring(0, 10) + "...")
      }
      case Failure(e) => e.printStackTrace
    }

    println("D ..."); sleep(100)//blocking
    println("E ..."); sleep(100)
    println("F ..."); sleep(100)

    def sleep(duration: Long) { Thread.sleep(duration) }

}
/*
Please run a few times for html lines to appear...

 */
