package cloud.contix.fe



object ComprobanteElectronico {
  opaque type HostCorreo = String
  object HostCorreo:
    def apply(s: String): HostCorreo = s
    extension (c: HostCorreo)
      def value: String = c
      
      
  opaque type MailUSername = String
  object MailUSername:
    def apply(s: String): MailUSername = s
    extension (c: MailUSername)
      def value: String = c
  
  opaque type MailPassword = String
  object MailPassword:
    def apply(s: String): MailPassword = s
    extension (c: MailPassword)
      def value: String = c
  
  opaque type ComprobanteXmlFirmado=String
  opaque type ComprobanteXml=String
  object ComprobanteXml:
    def apply(s:String):ComprobanteXml=s
    extension (c:ComprobanteXml)
      def value:String=c

  object ComprobanteXmlFirmado:
    def apply(s: String): ComprobanteXmlFirmado = s
    extension (c: ComprobanteXmlFirmado)
      def value: String = c


  opaque type AutorizacionXml=String

  object AutorizacionXml:
    def apply(s: String): AutorizacionXml = s

    extension (c: AutorizacionXml)
      def value: String = c
  opaque type ClaveAcceso=String

  object ClaveAcceso:
    def apply(s: String): ClaveAcceso = s
    extension (c: ClaveAcceso)
      def value: String = c

  opaque type DestinarioCorreo=String

  object DestinarioCorreo:
    def apply(s: String): DestinarioCorreo = s

    extension (c: DestinarioCorreo)
      def value: String = c
}
