package cloud.contix.fe.nd
import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.persistence.typed.PersistenceId
import org.apache.pekko.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}
object NotaDebito {
  def apply(claveAcceso: ClaveAcceso):Behavior[ComandoNdElectronico]=Behaviors.setup{ contexto=>
    EventSourcedBehavior[ComandoNdElectronico,EventoNd,EstadoNDElectronico](
      persistenceId = PersistenceId.ofUniqueId(claveAcceso.value),
      emptyState = EstadoNDElectronico(),
      commandHandler = (estado,comando)=>Effect.none,
      eventHandler = (estado,evento)=>estado
    )
  }
}
