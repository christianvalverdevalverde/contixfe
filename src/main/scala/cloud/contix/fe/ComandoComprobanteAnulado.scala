package cloud.contix.fe

import cloud.contix.fe.ComprobanteElectronico.ClaveAcceso
import org.apache.pekko.actor.typed.ActorRef

trait ComandoComprobanteAnulado extends MiSerializador
case class MarcarComoNoAnulado(claveAcceso:ClaveAcceso,reply:ActorRef[String]) extends ComandoComprobanteAnulado