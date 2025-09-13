package cloud.contix.fe.entidad

import cloud.contix.fe.entidad.ComandoEntidad
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.EntityTypeKey
import org.apache.pekko.persistence.typed.PersistenceId
import org.apache.pekko.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}

object Entidad {

  val typeKey = EntityTypeKey[ComandoEntidad]("entidad")
  def apply(uuid:String,ruc:String):Behavior[ComandoEntidad]=Behaviors.setup{ contexto=>
   contexto.log.info("Instanciando actor Entidad")
   EventSourcedBehavior[ComandoEntidad,EventoEntidad,EstadoEntidad](
     persistenceId = PersistenceId.ofUniqueId(uuid),
     emptyState = EstadoEntidad(),
     commandHandler = (estado,comando)=>Effect.none,
     eventHandler = (estado,evento)=>estado
   )
  }
}
