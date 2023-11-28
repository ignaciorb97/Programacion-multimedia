package ejerciciosClases

fun main(parametro: Array<String>) {
    val Salario1 = Salario()
    Salario1.inicializar("Paco", 2500.0)
    Salario1.pantalla()
    Salario1.complemento()
    Salario1.esMayorIngresos()

}
class Salario {
    var nombre: String = ""
    var ingresos: Double = 0.0

    fun inicializar(nombre: String, ingresos: Double) {
        this.nombre = nombre
        this.ingresos = ingresos
    }

    fun pantalla() {
        println("Nombre: $nombre tiene unos ingresos de $ingresos")
    }

    fun esMayorIngresos() {
        if (ingresos >= 2000)
            println("Eres rico")
    }

    fun complemento(): Double {
        var complemento = 0.0
        if (ingresos in 2000.0..3000.0) {
            complemento = 0.10
        } else if (ingresos > 3000) {
            complemento = 0.20
        } else {
            complemento = 0.05
        }
        var total = ingresos * complemento
        var suma = ingresos + total
        println("Su complemento es %.2f".format(total))

        var retencion=suma*0.15
        println("le retienen $retencion")
        suma-=retencion
        println("En total tienes $suma euros")

        return total
    }


}

