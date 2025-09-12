package cloud.contix.fe.guiaremision

import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object GuiaRemision {
  def apply(claveAcceso:ClaveAcceso):Behavior[ComandoGRElectronica]=Behaviors.setup{ contexto=>
    Behaviors.same
  }
}
