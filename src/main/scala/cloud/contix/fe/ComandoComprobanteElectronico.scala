package cloud.contix.fe

import cloud.contix.fe.ComprobanteElectronico.{ClaveAcceso, ComprobanteXml, ComprobanteXmlFirmado}
import cloud.contix.fe.MiSerializador
import org.apache.pekko.actor.typed.ActorRef

trait ComandoComprobanteElectronico extends MiSerializador