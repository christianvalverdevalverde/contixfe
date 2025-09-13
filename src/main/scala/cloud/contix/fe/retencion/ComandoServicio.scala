package cloud.contix.fe.retencion

import org.apache.pekko.actor.typed.ActorRef

sealed trait ComandoServicio 
case class CreaEntidad(ruc:String, reply:ActorRef[String]) extends ComandoServicio