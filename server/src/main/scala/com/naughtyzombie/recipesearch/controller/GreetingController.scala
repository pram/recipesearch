package com.naughtyzombie.recipesearch.controller

import org.scalatra.ScalatraServlet

class GreetingController extends ScalatraServlet {
  get("/") {
    "Hello World"
  }

  get("/:name") {
    val name = params.getOrElse("name", "world")
    "Hello " + name
  }

}
