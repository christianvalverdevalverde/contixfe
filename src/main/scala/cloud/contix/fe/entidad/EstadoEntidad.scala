package cloud.contix.fe.entidad

import cloud.contix.fe.ComprobanteElectronico.{DestinarioCorreo, HostCorreo, MailPassword, MailUSername}
import cloud.contix.fe.MiSerializador
import org.apache.pekko.http.javadsl.HostConnectionPool

import java.security.PrivateKey
import java.security.cert.X509Certificate
import java.util.Date

case class EstadoEntidad(
                          mailUSername:Option[MailUSername]=Some(MailUSername("facturacion@tu-efactura.ec")),
                          mailPassword: Option[MailPassword]=Some(MailPassword("Mt1cMt1c")),
                          hostCorreo: HostCorreo=HostCorreo("mail.oncomed.ec"),
                          destinarioCorreoNotificadorError: Option[List[DestinarioCorreo]]=None,
                          privatekey:Option[PrivateKey]=None,
                          x509Certificate:Option[X509Certificate]=None,
                          fechaExpiracionCertificado:Option[Date]=None
                        ) extends MiSerializador
