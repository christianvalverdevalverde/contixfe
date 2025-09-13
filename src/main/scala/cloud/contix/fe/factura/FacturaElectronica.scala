package cloud.contix.fe.factura

import cloud.contix.fe.RecepcionAutorizacionSRI
import cloud.contix.fe.ComprobanteElectronico.{ClaveAcceso, ComprobanteXmlFirmado}
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.http.scaladsl.Http
import org.apache.pekko.persistence.typed.PersistenceId
import org.apache.pekko.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}

object FacturaElectronica extends RecepcionAutorizacionSRI{
  
  
  def apply(claveAcceso:ClaveAcceso):Behavior[ComandoFacturaElectronica]=Behaviors.setup{contexto=>

    EventSourcedBehavior[ComandoFacturaElectronica,EventoFactura,EstadoFactura](
      persistenceId = PersistenceId.ofUniqueId(claveAcceso.value),
      emptyState = EstadoFactura(),
      commandHandler = (estado,comando)=>Effect.none,
      eventHandler = (estado,evento)=>estado
    )
  }
}