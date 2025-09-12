package cloud.contix.fe

import cloud.contix.fe.ComprobanteElectronico.{ClaveAcceso, ComprobanteXmlFirmado}

trait RecepcionAutorizacionSRI {
  val urlRecepcionProduccion="https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline"
  val urlRecepcionPruebas="https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline"
  val urlAutorizacionProduccion="https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline"
  val urlAutorizacionPruebas="https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline"

  def envolverEnSoapRecepcion(comprobanteXmlFirmado: ComprobanteXmlFirmado):String={
    s"""
       |<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ec="http://ec.gob.sri.ws.recepcion">
       |   <soapenv:Header/>
       |   <soapenv:Body><ec:validarComprobante>
       |   <xml>${comprobanteXmlFirmado.value.getBytes()}</xml></ec:validarComprobante></soapenv:Body></soapenv:Envelope>
       |""".stripMargin
  }
  def envolverEnSoapAutorizacion(claveAcceso:ClaveAcceso):String={
    s"""<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ec="http://ec.gob.sri.ws.autorizacion">
       |   <soapenv:Header/>
       |   <soapenv:Body>
       |      <ec:autorizacionComprobante>
       |         <claveAccesoComprobante>${claveAcceso.value}</claveAccesoComprobante>
       |      </ec:autorizacionComprobante>
       |   </soapenv:Body>
       |</soapenv:Envelope>""".stripMargin
  }
}
