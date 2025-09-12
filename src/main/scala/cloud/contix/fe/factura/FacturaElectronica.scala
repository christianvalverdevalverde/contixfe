package cloud.contix.fe.factura

import cloud.contix.fe.RecepcionAutorizacionSRI
import cloud.contix.fe.ComprobanteElectronico.{ClaveAcceso, ComprobanteXmlFirmado}
import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.http.scaladsl.Http

object FacturaElectronica extends RecepcionAutorizacionSRI{
  
  
  def apply(claveAcceso:ClaveAcceso):Behavior[ComandoFacturaElectronica]=Behaviors.setup{contexto=>
    import contexto.system
    Behaviors.receiveMessage{
      case RegistrarComprobante(comprobanteXml,comprobanteXmlFirmado,reply)=>
        contexto.log.info(s"se va a enviar a procesar el siguiente comprobante recién receptado ${claveAcceso.value}")
        val texto=if comprobanteXmlFirmado.isDefined then comprobanteXmlFirmado.get.value else ""
        val respuesta=Http().singleRequest(generarRequestRecepcionProduccion(ComprobanteXmlFirmado(texto)))
        Behaviors.same
      case _=>
        Behaviors.same
    }

  }




  //  def anulada(claveAcceso:ClaveAcceso):Behavior[ComandoComprobanteAnulado]=Behaviors.setup{ contexto=>
//    contexto.log.info(s"inicializando comportamiento Comprobante anulado ${claveAcceso.value}")
//    Behaviors.receiveMessage {
//      case MarcarComoNoAnulado(claveAcceso, reply) => ???
//      case _ => ???
//    }
//  }
}