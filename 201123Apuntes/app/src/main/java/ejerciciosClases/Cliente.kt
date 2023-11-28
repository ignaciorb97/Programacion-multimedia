package ejerciciosClases


class Cliente constructor(nombre: String, apellidos: String, tipo: String, ingresos: Double) {
    var nombre: String = nombre
    var apellidos: String = apellidos
    var tipo:String=tipo
    var ingresos:Double = ingresos

    fun imprimir() {
// imprime los datos
    }

    fun tipo() {
        if (tipo== "Empresa")
            println("Le atiende la oficina central")
        else
            println("Le atiende la oficina local")
    }
}

fun main() {
    val Cliente1 = Cliente("Juan", "Perez", "Empresa",120000.00)
    Cliente1.imprimir()
    Cliente1.tipo()
}