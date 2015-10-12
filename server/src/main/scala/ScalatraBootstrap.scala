import _root_.akka.actor.{ActorSystem, Props}
import com.naughtyzombie.recipesearch._
import com.naughtyzombie.recipesearch.actor.EsActor
import com.naughtyzombie.recipesearch.controller.{ElasticSearchController, GreetingController}
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {

  val system = ActorSystem()
  val esActor = system.actorOf(Props[EsActor])

  override def init(context: ServletContext) {
    context.mount(new RecipeSearchServlet, "/*")
    context.mount(new GreetingController, "/sample/*")
    context.mount(new ElasticSearchController(system, esActor),"/actors/*")
  }

  override def destroy(context: ServletContext): Unit = {
    system.shutdown()
  }
}
