package com.naughtyzombie.recipesearch.actor

import akka.actor.{Actor, ActorLogging, Props}
import akka.event.LoggingReceive
import com.naughtyzombie.recipesearch.actor.EsActor.{QueryResults, StartQuery}
import com.naughtyzombie.recipesearch.executor.RequestExecutor
import akka.pattern.pipe
import org.elasticsearch.action.search.{SearchResponse, SearchType}
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.client.{ElasticsearchClient, Client}
import org.elasticsearch.common.transport.InetSocketTransportAddress

import scala.concurrent.Future

object EsActor {
  def props(): Props = Props(new EsActor())

  case class StartQuery()
  case class QueryResults(recipes: Seq[String])
}

class EsActor() extends Actor with ActorLogging {

  import context.dispatcher

  def queryRecipes(): Future[Seq[String]] = {

    val client = new TransportClient()
    client addTransportAddress(new InetSocketTransportAddress("0.0.0.0", 9300))
    val index = "recipes"
    val types: Seq[String] = "recipe" :: Nil

    val req = client.prepareSearch(index)
                .setSearchType(SearchType.DEFAULT)
                .setTypes(types: _*)

    RequestExecutor[SearchResponse]().execute(req).map { response =>
      import scala.collection.JavaConversions._
      val recipes= response.getHits.map(a => a.sourceAsString()).toSeq
      recipes.dropRight(1).map(_.toString)
    }
  }

  def receive = LoggingReceive {
    case query: StartQuery =>
        queryRecipes() map (QueryResults(_)) recover {
          case ex => log.error(ex, s"Retrieving Recipes Failed")
        } pipeTo sender()
  }
}
