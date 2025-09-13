package cloud.contix.fe.liquidacion
import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.EntityTypeKey
import org.apache.pekko.persistence.typed.PersistenceId
import org.apache.pekko.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}
object LiquidacionCompra {
  val typeKey =  EntityTypeKey[ComandoLiCElectronica]("liquidacion")
  def apply(claveAcceso: ClaveAcceso):Behavior[ComandoLiCElectronica]=Behaviors.setup{ contexto=>
    EventSourcedBehavior[ComandoLiCElectronica,EventoLiquidacionCompra,EstadoLiquidacionCompra](
      persistenceId = PersistenceId.ofUniqueId(claveAcceso.value),
      emptyState=EstadoLiquidacionCompra(),
      commandHandler = (estado,commando)=>Effect.none,
      eventHandler = (estado,evento)=>estado
    )
  }
}
