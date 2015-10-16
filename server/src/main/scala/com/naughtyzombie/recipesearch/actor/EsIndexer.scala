package com.naughtyzombie.recipesearch.actor

import akka.actor.Actor

class EsIndexer extends Actor {
  def receive = {
    case "x" => sender ! "Hello"
    case "y" => println("sss")
    case _ => println("everything else!")
  }
}
