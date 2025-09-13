package cloud.contix.fe

import cloud.contix.fe.ComprobanteElectronico.{ComprobanteXml, ComprobanteXmlFirmado}
import org.apache.pekko.actor.typed.ActorRef

sealed trait ComandoFirmador
case class firmaComprobante(comprobanteXml: ComprobanteXml,actorRef:ActorRef[ComprobanteXmlFirmado]) extends ComandoFirmador