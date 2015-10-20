package com.naughtyzombie.recipesearch.controller

import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import com.naughtyzombie.recipesearch.actor.EsActor.StartQuery
import org.scalatra.{Accepted, FutureSupport, ScalatraServlet}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class ElasticSearchController(system: ActorSystem, esActor: ActorRef, esIndexer: ActorRef) extends ScalatraServlet with FutureSupport {

  implicit val timeout = new Timeout(2 seconds)
  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/ask") {
    esActor ! StartQuery()
  }

  get("/tell") {
    esActor ! "y"
    Accepted()
  }

  post("/indexfile") {
    esIndexer ? params("fileURL")
  }

}
