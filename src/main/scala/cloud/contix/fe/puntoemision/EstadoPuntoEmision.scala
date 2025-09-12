package cloud.contix.fe.puntoemision

import cloud.contix.fe.MiSerializador

case class EstadoPuntoEmision(
                               secuenciaFactura:Int=1,
                               secuenciaNc:Int=1,
                               secuenciaNd:Int=1,
                               secuenciaGr:Int=1,
                               secuenciaLc:Int=1,
                               secuenciaCRet:Int=1
                             )extends MiSerializador
