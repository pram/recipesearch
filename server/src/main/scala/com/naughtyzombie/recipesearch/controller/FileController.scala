package com.naughtyzombie.recipesearch.controller

import java.io._
import java.net.{URLConnection, URL}
import java.util.zip.GZIPInputStream

import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatra.{Accepted, FutureSupport, ScalatraServlet}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.io.Source
import java.net.URL;
import java.net.URLConnection;

class FileController(system: ActorSystem) extends ScalatraServlet with FutureSupport {
  implicit val timeout = new Timeout(2 seconds)
  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/load") {
    //val jsonString = request.body
    val loc = "http://openrecipes.s3.amazonaws.com/recipeitems-latest.json.gz"

    val url = new URL(loc)
    val conn = url.openConnection

    val raw = conn.getInputStream
    val in = new BufferedInputStream(raw)

    val gzin = new GZIPInputStream(in)
    val decoder = new InputStreamReader(gzin,"UTF-8")

    val reader = new BufferedReader(decoder)

    val takeWhile: Stream[String] = Stream.continually(reader.readLine()).takeWhile(_ != null)

    takeWhile foreach {
      println _
      //todo pipe into esindexer here
    }

  }
}
