package cloud.contix.fe

import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.ClusterSharding

object ServicioComprobantesElectronicos {
  
  def main(args: Array[String]): Unit = {
    implicit val actorSystem: ActorSystem[Nothing] =ActorSystem[Nothing](Behaviors.empty,"contixfe")
    val sharding = ClusterSharding(actorSystem)
  }
}
