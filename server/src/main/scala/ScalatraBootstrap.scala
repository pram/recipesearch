import com.naughtyzombie.recipesearch._
import com.naughtyzombie.recipesearch.controller.GreetingController
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new RecipeSearchServlet, "/*")
    context.mount(new GreetingController, "/sample/*")
  }
}
