package com.naughtyzombie.recipesearch.actor

import akka.actor.Actor
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.json4s.JsonAST.JObject
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

class EsIndexer extends Actor {
  def receive = {
    case JObject(x) => {
      val client = new TransportClient()
      client addTransportAddress (
        new InetSocketTransportAddress("0.0.0.0",9300)
      )

      client.prepareIndex("recipes","recipe")
        .setSource(compact(x))
        .execute.actionGet

      client.close
    }
    case _ => println("Unknown")
  }
}
