package cloud.contix.fe.estados

import cloud.contix.fe.ComprobanteElectronico.*
import cloud.contix.fe.MiSerializador


case class EstadoComprobanteElectronico(
                                         claveAcceso: ClaveAcceso,
                                         identificacionBeneficiario: String,
                                         razonSocialBeneficiario: String,
                                         comprobanteXml: ComprobanteXml,
                                         comprobanteXmlFirmado: ComprobanteXmlFirmado,
                                         autorizacionXml: Option[AutorizacionXml] = None,
                                         notificados:Set[DestinarioCorreo]=Set()
                                       ) extends MiSerializador