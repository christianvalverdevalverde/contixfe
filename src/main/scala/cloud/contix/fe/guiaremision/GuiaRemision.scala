package cloud.contix.fe.guiaremision

import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.EntityTypeKey
import org.apache.pekko.persistence.typed.PersistenceId
import org.apache.pekko.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}

object GuiaRemision {
  val typeKey = EntityTypeKey[ComandoGRElectronica]("guiaremision")
  def apply(claveAcceso:ClaveAcceso):Behavior[ComandoGRElectronica]=Behaviors.setup{ contexto=>
   EventSourcedBehavior[ComandoGRElectronica,EventoGuiaRemision,EstadoGuiaRemision](
     persistenceId = PersistenceId.ofUniqueId(claveAcceso.value),
     emptyState = EstadoGuiaRemision(),
     commandHandler = (estado,comando)=>Effect.none,
     eventHandler = (estado,evento)=>estado
   )
  }
}
