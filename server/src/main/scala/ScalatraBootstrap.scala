import javax.servlet.ServletContext

import _root_.akka.actor.{ActorSystem, Props}
import com.naughtyzombie.recipesearch._
import com.naughtyzombie.recipesearch.actor.{EsActor, EsIndexer}
import com.naughtyzombie.recipesearch.controller.{ElasticSearchController, FileController, GreetingController}
import org.scalatra._

class ScalatraBootstrap extends LifeCycle {

  val system = ActorSystem()
  val esActor = system.actorOf(Props[EsActor])
  val esIndexer = system.actorOf(Props[EsIndexer])

  /*val server = new ElasticsearchServer*/

  override def init(context: ServletContext) {
    context.mount(new RecipeSearchServlet, "/*")
    context.mount(new GreetingController, "/sample/*")
    context.mount(new FileController(system, esIndexer), "/file/*")
    context.mount(new ElasticSearchController(system, esActor, esIndexer),"/actors/*")

/*    server.start()
    server.createAndWaitForIndex("recipes")*/
  }

  override def destroy(context: ServletContext): Unit = {
    /*server.stop()
    system.shutdown()*/
  }
}
