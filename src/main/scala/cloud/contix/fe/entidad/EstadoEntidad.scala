package cloud.contix.fe.entidad

import cloud.contix.fe.ComprobanteElectronico.DestinarioCorreo
import cloud.contix.fe.MiSerializador
import cloud.contix.fe.entidad.Entidad.{HostCorreo, MailPassword, MailUSername}

case class EstadoEntidad(
                          mailUSername: Option[MailUSername]=None,
                          mailPassword: Option[MailPassword]=None,
                          hostCorreo: HostCorreo,
                          destinarioCorreoNotificadorError: Option[List[DestinarioCorreo]]=None
                        ) extends MiSerializador
