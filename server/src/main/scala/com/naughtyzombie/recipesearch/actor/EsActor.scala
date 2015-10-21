package com.naughtyzombie.recipesearch.actor

import akka.actor.{Actor, ActorLogging, Props}
import akka.event.LoggingReceive
import akka.pattern.pipe
import com.naughtyzombie.recipesearch.actor.EsActor.{QueryResults, StartQuery}
import com.naughtyzombie.recipesearch.executor.RequestExecutor
import org.elasticsearch.action.search.{SearchResponse, SearchType}
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.index.query.{QueryStringQueryBuilder, QueryBuilders}
import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.concurrent.Future

object EsActor {
  def props(): Props = Props(new EsActor())

  case class StartQuery(query: String = "chicken")
  case class QueryResults(recipes: Seq[JValue])
}

class EsActor() extends Actor with ActorLogging {

  import context.dispatcher

  def queryRecipes(qu: String): Future[Seq[JValue]] = {

    val client = new TransportClient()
    client addTransportAddress(new InetSocketTransportAddress("0.0.0.0", 9300))
    val index = "recipes"
    val types: Seq[String] = "recipe" :: Nil

    val query: QueryStringQueryBuilder = QueryBuilders.queryStringQuery(qu)

    val req = client.prepareSearch(index)
                .setSearchType(SearchType.DEFAULT)
                .setTypes(types: _*)
                .setQuery(query)


    RequestExecutor[SearchResponse]().execute(req).map { response =>
      import scala.collection.JavaConversions._
      response.getHits.map(a => parse(a.sourceAsString())).toSeq
    }
  }

  def receive = LoggingReceive {
    case StartQuery(startQuery)  =>
        queryRecipes(startQuery) map (QueryResults(_)) recover {
          case ex => log.error(ex, s"Retrieving Recipes Failed")
        } pipeTo sender

    case _ => log.error("Error!")
  }
}
