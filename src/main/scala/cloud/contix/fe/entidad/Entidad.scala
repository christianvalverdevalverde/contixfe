package cloud.contix.fe.entidad

import cloud.contix.fe.entidad.ComandoEntidad
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object Entidad {
  opaque type HostCorreo=String
  opaque type MailUSername=String
  opaque type MailPassword=String

  def apply():Behavior[ComandoEntidad]=Behaviors.setup{ contexto=>
   contexto.log.info("Instanciando actor Entidad")
    Behaviors.same
  }
}
