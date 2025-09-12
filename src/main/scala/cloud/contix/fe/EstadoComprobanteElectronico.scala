package cloud.contix.fe

import cloud.contix.fe.ComprobanteElectronico.{AutorizacionXml, ClaveAcceso, ComprobanteXml, ComprobanteXmlFirmado}

case class EstadoComprobanteElectronico(
                                         claveAcceso: ClaveAcceso,
                                         identificacionBeneficiario: String,
                                         razonSocialBeneficiario: String,
                                         comprobanteXml: ComprobanteXml,
                                         comprobanteXmlFirmado: ComprobanteXmlFirmado,
                                         autorizacionXml: Option[AutorizacionXml] = None
                                       ) extends MiSerializador