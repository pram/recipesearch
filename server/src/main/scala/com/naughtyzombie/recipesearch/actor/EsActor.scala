package com.naughtyzombie.recipesearch.actor

import akka.actor.Actor

/**
 * Created by pram on 12/10/2015.
 */
class EsActor extends Actor {
  def receive = {
    case "x" => sender ! "Hello"
    case "y" => println("woooooo!")
  }
}
