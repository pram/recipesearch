package com.naughtyzombie.recipesearch.controller

import akka.actor.{ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import com.naughtyzombie.recipesearch.actor.EsActor.{QueryResults, StartQuery}
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.{Accepted, FutureSupport, ScalatraServlet}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

class ElasticSearchController(system: ActorSystem, esActor: ActorRef, esIndexer: ActorRef) extends ScalatraServlet with FutureSupport with JacksonJsonSupport {

  implicit val timeout = new Timeout(2 seconds)
  protected implicit def executor: ExecutionContext = system.dispatcher
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/ask") {
    val future: Future[Any] = esActor ? StartQuery("cheese")
    val r: QueryResults = Await.result(future, Timeout(10 seconds).duration).asInstanceOf[QueryResults]
    r.recipes
  }

  get("/ask/:name") {
    val query = params.getOrElse("name", "world")
    val future: Future[Any] = esActor ? StartQuery(query)
    val r: QueryResults = Await.result(future, Timeout(10 seconds).duration).asInstanceOf[QueryResults]
    r.recipes
  }

  get("/tell") {
    esActor ! "y"
    Accepted()
  }

  post("/indexfile") {
    esIndexer ? params("fileURL")
  }

}
