package cloud.contix.fe.nc
import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.EntityTypeKey
import org.apache.pekko.persistence.typed.PersistenceId
import org.apache.pekko.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}
object NotaCredito {
  val typeKey = EntityTypeKey[ComandoNcElectronica]("nc")
  def apply(claveAcceso: ClaveAcceso):Behavior[ComandoNcElectronica]=Behaviors.setup{ contexto=>
    EventSourcedBehavior[ComandoNcElectronica,EventoNc,EstadoNc](
      persistenceId = PersistenceId.ofUniqueId(claveAcceso.value),
      emptyState = EstadoNc(),
      commandHandler = (estado,comando)=>Effect.none,
      eventHandler = (estado,evento)=>estado
    )
  }
}
