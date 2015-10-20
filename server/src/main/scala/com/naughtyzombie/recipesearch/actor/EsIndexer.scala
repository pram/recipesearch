package com.naughtyzombie.recipesearch.actor

import akka.actor.Actor
import org.json4s.JsonAST.JObject
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

class EsIndexer extends Actor {
  def receive = {
    case JObject(x) => println(compact(x))
    case _ => println("Unknown")
  }
}
