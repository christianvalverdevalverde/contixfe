package cloud.contix.fe

object ServicioComprobantesElectronicos {

  def main(args: Array[String]): Unit = {
    import ComprobanteElectronico.*
    val clave=ClaveAcceso("0807202501091222018300120010020000000230000002619")
    val valor=clave.value
    println(valor.reverse)

  }
}
