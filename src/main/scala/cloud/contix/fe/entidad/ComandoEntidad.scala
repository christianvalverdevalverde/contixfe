package cloud.contix.fe.entidad

import cloud.contix.fe.ComprobanteElectronico.{ComprobanteXml, ComprobanteXmlFirmado}
import cloud.contix.fe.MiSerializador
import org.apache.pekko.actor.typed.ActorRef

sealed trait ComandoEntidad extends MiSerializador
case class FirmarComprobante(comprobanteXml: ComprobanteXml, reply:ActorRef[Option[ComprobanteXmlFirmado]]) extends ComandoEntidad

