package com.naughtyzombie.recipesearch.actor

import akka.actor.Actor

class EsActor extends Actor {
  def receive = {
    case "x" => sender ! "Hello"
    case "y" => println("woooooo!")
  }
}
