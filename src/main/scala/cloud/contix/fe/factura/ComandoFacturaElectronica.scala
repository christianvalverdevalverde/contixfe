package cloud.contix.fe.factura

import cloud.contix.fe.ComandoComprobanteElectronico
import cloud.contix.fe.ComprobanteElectronico.{ClaveAcceso, ComprobanteXml, ComprobanteXmlFirmado}
import org.apache.pekko.actor.typed.ActorRef

sealed trait ComandoFacturaElectronica extends ComandoComprobanteElectronico

case class RegistrarComprobante(claveAcceso:ClaveAcceso,comprobanteXml: ComprobanteXml,comprobanteXmlFirmado: ComprobanteXmlFirmado,reply:ActorRef[String]) extends ComandoFacturaElectronica