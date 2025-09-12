package cloud.contix.fe

import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object ComprobanteElectronico {
  opaque type ComprobanteXml = String
  opaque type AutorizacionXml = String
  opaque type ComprobanteXmlFirmado = String
  opaque type ClaveAcceso = String
  opaque type DestinarioCorreo = String


  def apply(claveAcceso: ClaveAcceso):Behavior[ComandoComprobanteElectronico]=Behaviors.setup{ contexto=>
    contexto.log.info("Inicializando el actor ComprobanteElectronico")
    Behaviors.withTimers{ timers=>

      Behaviors.same
    }
  }

  object ClaveAcceso:
    def apply(c: String): ClaveAcceso = {
      require(c.length == 49, "la clave de acceso debe tener 49 digitos")
      require(c.forall(d => d.isDigit), "todos los caracteres deben ser digitos")
      c
    }
  extension (c: ClaveAcceso)
    def value: String = c


  object ComprobanteXml:
    def apply(c:String):ComprobanteXml={
      require(c.nonEmpty,"el xml no puede estar vacio")
      c
    }
    extension (c:ComprobanteXml)
      def value:String=c

  object ComprobanteXmlFirmado:
    def apply(c: String): ComprobanteXmlFirmado = {
      require(c.nonEmpty, "el xml no puede estar vacio")
      c
    }

    extension (c: ComprobanteXmlFirmado)
      def value: String = c

  object AutorizacionXml:

    def apply(c: String): AutorizacionXml = {
      require(c.nonEmpty, "el xml no puede estar vacio")
      c
    }

    extension (c: AutorizacionXml)
      def value: String = c
}
