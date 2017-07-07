import javax.servlet.ServletContext

import org.scalatra.LifeCycle
import com.shadowjarcxfproblem.ComponentRegistry

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(ComponentRegistry.myController, "/endpoint")
  }
}