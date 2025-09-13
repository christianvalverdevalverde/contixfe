package cloud.contix.fe.retencion

import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.persistence.typed.PersistenceId
import org.apache.pekko.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}

object RetencionElectronica:
  def apply(claveAcceso:ClaveAcceso):Behavior[ComandoCRetElectronica]=Behaviors.setup { contexto =>
    contexto.log.info("instanciando Retención electrónica")
    EventSourcedBehavior[ComandoCRetElectronica, EventoRetencionElectronica, EstadoRetencionElectronica](
      persistenceId = PersistenceId.ofUniqueId(claveAcceso.value),
      emptyState = EstadoRetencionElectronica(),
      commandHandler = (estado, comando) => Effect.none,
      eventHandler = (estado, evento) => estado
    )
  }

