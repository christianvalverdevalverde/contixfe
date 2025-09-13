package cloud.contix.fe

import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object ServicioComprobantesElectronicos {
  
  def main(args: Array[String]): Unit = {
    implicit val actorSystem: ActorSystem[Nothing] =ActorSystem[Nothing](Behaviors.empty,"contixfe") 
  
  }
}
