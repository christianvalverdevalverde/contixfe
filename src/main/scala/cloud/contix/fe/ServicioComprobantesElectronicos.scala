package cloud.contix.fe

import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.ClusterSharding
import org.apache.pekko.http.scaladsl.model.Uri
import org.apache.pekko.management.scaladsl.PekkoManagement

import scala.concurrent.Future

object ServicioComprobantesElectronicos {
  
  def main(args: Array[String]): Unit = {
    implicit val actorSystem: ActorSystem[Nothing] =ActorSystem[Nothing](Behaviors.empty,"contixfe")
     PekkoManagement(actorSystem).start()
    val sharding = ClusterSharding(actorSystem)
  }
}
