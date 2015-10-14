package com.naughtyzombie.recipesearch.controller

import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatra.{Accepted, FutureSupport, ScalatraServlet}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class FileController(system: ActorSystem) extends ScalatraServlet with FutureSupport {
  implicit val timeout = new Timeout(2 seconds)
  protected implicit def executor: ExecutionContext = system.dispatcher
}
