package com.naughtyzombie.recipesearch.controller

import java.io.{FileInputStream, BufferedInputStream}
import java.util.zip.GZIPInputStream

import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatra.{Accepted, FutureSupport, ScalatraServlet}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.io.Source

class FileController(system: ActorSystem) extends ScalatraServlet with FutureSupport {
  implicit val timeout = new Timeout(2 seconds)
  protected implicit def executor: ExecutionContext = system.dispatcher

  post("/load") {
    //val jsonString = request.body
    val loc = "http://openrecipes.s3.amazonaws.com/recipeitems-latest.json.gz"

    val remoteFile = Source.fromURL(loc)
    //new BufferedInputStream()


  }
}
