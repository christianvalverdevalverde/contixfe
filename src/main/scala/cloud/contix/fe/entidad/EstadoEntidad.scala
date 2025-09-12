package cloud.contix.fe.entidad

import cloud.contix.fe.ComprobanteElectronico.DestinarioCorreo
import cloud.contix.fe.MiSerializador
import cloud.contix.fe.entidad.Entidad.{HostCorreo, MailPassword, MailUSername}

import java.security.PrivateKey
import java.security.cert.X509Certificate
import java.util.Date

case class EstadoEntidad(
                          mailUSername: Option[MailUSername]=None,
                          mailPassword: Option[MailPassword]=None,
                          hostCorreo: HostCorreo,
                          destinarioCorreoNotificadorError: Option[List[DestinarioCorreo]]=None,
                          privatekey:Option[PrivateKey]=None,
                          x509Certificate:Option[X509Certificate],
                          fechaExpiracionCertificado:Option[Date]=None
                        ) extends MiSerializador
