package ejerciciosClases
fun main() {
    val Cliente1 = ClienteFinal("Juan", "Perez", "Empresa",120000.00)
    Cliente1.imprimir()
    Cliente1.tipo()
    val Cliente2 = ClienteFinal("Luisa", "Lopez", "Sociedad")
    Cliente2.imprimir()
    Cliente2.tipo()
}
class ClienteFinal (nombre: String, apellidos: String, tipo: String, ingresos: Double) {
    constructor (nombre: String, apellidos: String, tipo: String) : this(nombre,apellidos,tipo,0.0)
    var nombre: String = nombre
    var apellidos: String = apellidos
    var tipo:String=tipo
    var ingresos:Double = ingresos

    fun imprimir() {
        println("Nombre: $nombre, Apellidos: $apellidos, Tipo: $tipo, Ingresos: $ingresos")
    }

    fun tipo() {
        if (tipo== "Empresa")
            println("Le atiende la oficina central")
        else
            println("Le atiende la oficina local")
    }
}

