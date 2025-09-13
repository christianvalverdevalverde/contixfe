package cloud.contix.fe

import cloud.contix.fe.retencion.{ComandoServicio, CreaEntidad}
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object Servicio {

  def apply():Behavior[ComandoServicio]=Behaviors.setup{ contexto=>

    Behaviors.receiveMessage {
      case CreaEntidad(ruc, reply) =>
        Behaviors.same
    }

  }


}
