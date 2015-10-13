package com.naughtyzombie.recipesearch.executor

import org.elasticsearch.action.{ActionRequestBuilder, ActionListener, ActionResponse}
import scala.concurrent.{Future, Promise}

object RequestExecutor {
  def apply[T <: ActionResponse](): RequestExecutor[T] = {
    new RequestExecutor[T]
  }
}

class RequestExecutor[T <: ActionResponse] extends ActionListener[T] {
  private val promise = Promise[T]()

  def onResponse(response: T) {
    promise.success(response)
  }

  def onFailure(e: Throwable) {
    promise.failure(e)
  }

  def execute[RB <: ActionRequestBuilder[_, T, _, _]](request: RB): Future[T] = {
    request.execute(this)
    promise.future
  }
}
