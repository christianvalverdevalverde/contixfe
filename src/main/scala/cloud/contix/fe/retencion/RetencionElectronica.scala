package cloud.contix.fe.retencion

import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object RetencionElectronica {
  def apply(claveAcceso:ClaveAcceso):Behavior[ComandoCRetElectronica]=Behaviors.setup{ contexto=>
    contexto.log.info("instanciando Retención electrónica")
    Behaviors.same
  }
}
