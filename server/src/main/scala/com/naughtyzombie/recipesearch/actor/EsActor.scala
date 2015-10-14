package com.naughtyzombie.recipesearch.actor

import akka.actor.{Actor, ActorLogging, Props}
import akka.event.LoggingReceive
import com.naughtyzombie.recipesearch.actor.EsActor.{QueryResults, StartQuery}
import com.naughtyzombie.recipesearch.executor.RequestExecutor
import dispatch.as.String
import org.elasticsearch.action.search.{SearchResponse, SearchType}
import org.elasticsearch.client.Client

import scala.concurrent.Future

object EsActor {
  def props(client: Client, index: String, types: Seq[String]): Props = Props(new EsActor(client, index, types))

  case class StartQuery()
  case class QueryResults(recipes: Seq[String])
}

class EsActor(client: Client, index:String, types: Seq[String]) extends Actor with ActorLogging {

  import context.dispatcher

  def queryRecipes(): Future[Seq[String]] = {
    val req = client.prepareSearch(index)
                .setSearchType(SearchType.DEFAULT)
                .setTypes(types: _*)

    RequestExecutor[SearchResponse]().execute(req).map { response =>
      import scala.collection.JavaConversions._
      val recipes = response.getHits.hits().map(hit => println(hit)).toSeq
    }
  }

  def receive = LoggingReceive {
    case "x": StartQuery =>
        queryRecipes() map (QueryResults(_)) recover {

        }
  }

  /*def receive = {
    case "x" => sender ! "Hello"
    case "y" => "goooober"
  }*/
}
