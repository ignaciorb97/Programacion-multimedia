package JuegoDados

open class Vehiculo(val modelo: String,val tipo: String,val fabricante: String) {


}
    // Clase derivada (subclase) que hereda de Animal
    class Coche(modelo: String, tipo: String, fabricante: String, val nombre: String) : Vehiculo(modelo, tipo, fabricante) {
        fun pitar() {
            println("mec mec")
        }
    }

    fun main() {
        val miCoche = Coche("ModeloXYZ", "Sedan", "FabricanteABC", "Mi Carro")
        println("Modelo: ${miCoche.modelo}, Tipo: ${miCoche.tipo}, Fabricante: ${miCoche.fabricante}, Nombre: ${miCoche.nombre}")
        miCoche.pitar()
    }
