package cloud.contix.fe

import cloud.contix.fe.ComprobanteElectronico.{ClaveAcceso, ComprobanteXmlFirmado}
import org.apache.pekko.http.scaladsl.model.{HttpEntity, HttpMethods, HttpRequest, RequestEntity, Uri}

trait RecepcionAutorizacionSRI {
  def generarRequestRecepcionProduccion(comprobanteXmlFirmado: ComprobanteXmlFirmado):HttpRequest={
    val request=HttpRequest(post,uriRecepcionProduccion,entity = construyeHttpEntity(envolverEnSoapRecepcion(comprobanteXmlFirmado)))
      request
  }

  def generarRequestRecepcionPruebas(comprobanteXmlFirmado: ComprobanteXmlFirmado): HttpRequest = {
    val request = HttpRequest(post, uriRecepcionPruebas, entity = construyeHttpEntity(envolverEnSoapRecepcion(comprobanteXmlFirmado)))
    request
  }

  def generarRequestAutorizacionProduccion(claveAcceso:ClaveAcceso):HttpRequest={
    val request=HttpRequest(post,uriRecepcionProduccion,entity = construyeHttpEntity(envolverEnSoapAutorizacion(claveAcceso)))
    request
  }

  def generarRequestAutorizacionPruebas(claveAcceso:ClaveAcceso): HttpRequest = {
    val request = HttpRequest(post, uriRecepcionPruebas, entity = construyeHttpEntity(envolverEnSoapAutorizacion(claveAcceso)))
    request
  }
  private val post=HttpMethods.POST
  private val uriRecepcionProduccion=Uri("https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline")
  private val uriRecepcionPruebas=Uri("https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline")
  private val uriAutorizacionProduccion=Uri("https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline")
  private val uriAutorizacionPruebas=Uri("https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline")
  private val uriConsultaComprobantesProduccion=Uri("https://cel.sri.gob.ec/comprobantes-electronicos-ws/ConsultaComprobante")
  private val uriConsultaFactura=Uri("https://cel.sri.gob.ec/comprobantes-electronicos-ws/ConsultaFactura")
  private def construyeHttpEntity(soapRequestBody:String):RequestEntity={
    ???
  }
  private def envolverEnSoapRecepcion(comprobanteXmlFirmado: ComprobanteXmlFirmado):String={
    s"""
       |<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ec="http://ec.gob.sri.ws.recepcion">
       |   <soapenv:Header/>
       |   <soapenv:Body><ec:validarComprobante>
       |   <xml>${comprobanteXmlFirmado.value.getBytes()}</xml></ec:validarComprobante></soapenv:Body></soapenv:Envelope>
       |""".stripMargin
  }
  private def envolverEnSoapAutorizacion(claveAcceso:ClaveAcceso):String={
    s"""<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ec="http://ec.gob.sri.ws.autorizacion">
       |   <soapenv:Header/>
       |   <soapenv:Body>
       |      <ec:autorizacionComprobante>
       |         <claveAccesoComprobante>${claveAcceso.value}</claveAccesoComprobante>
       |      </ec:autorizacionComprobante>
       |   </soapenv:Body>
       |</soapenv:Envelope>""".stripMargin
  }
  private def envolverEnSoapConsultaComprobante(claveAcceso: ClaveAcceso):String={
    s"""
       |<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ec="http://ec.gob.sri.ws.consultas">
       |   <soapenv:Header/>
       |   <soapenv:Body>
       |      <ec:consultarEstadoAutorizacionComprobante>
       |         <claveAcceso>${claveAcceso.value}</claveAcceso>
       |      </ec:consultarEstadoAutorizacionComprobante>
       |   </soapenv:Body>
       |</soapenv:Envelope>
       |""".stripMargin
  }
  private def envolverEnSoapConsultaEstadoFacturaNegociable(claveAcceso: ClaveAcceso):String={
    s"""<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ec="http://ec.gob.sri.ws.consultas">
      |   <soapenv:Header/><soapenv:Body>
      |      <ec:consultarEstadoConfirmacionFacturaComercialNegociable>
      |         <claveAcceso>${claveAcceso.value}</claveAcceso>
      |      </ec:consultarEstadoConfirmacionFacturaComercialNegociable>
      |   </soapenv:Body>
      |</soapenv:Envelope>""".stripMargin
  }
}
