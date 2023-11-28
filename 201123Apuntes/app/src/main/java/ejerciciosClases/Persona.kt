package ejerciciosClases

class Persona {
    private var nombre: String = ""
    private var edad: Int = 0
    private var apellidos: String = ""
    private var ciudad: String = ""
    private var provincia: String = ""
    private var codigoPostal: String = ""


    fun inicializar(
        nombre: String,
        apellidos: String,
        edad: Int,
        ciudad: String,
        provincia: String,
        codigoPostal: String
    ) {
        this.nombre = nombre
        this.apellidos = apellidos
        this.edad = edad
        this.ciudad = ciudad
        this.provincia = provincia
        this.codigoPostal = codigoPostal
    }

    //es como el tostring
    fun imprimir() {
        println("Nombre: $nombre $apellidos,es de $ciudad ,$provincia con codigo postal $codigoPostal y tiene una edad de $edad")
    }

    fun esMayorEdad() {
        if (this.edad > 18) {
            println("Es mayor de edad")
        } else
            println("Es menor de edad")
    }
}

fun main() {
    val persona1: Persona
    persona1 = Persona()
    persona1.inicializar("Juan", "Paquirrin", 12, "Malaga", "Malaga", "29006")
    persona1.imprimir()
    persona1.esMayorEdad()


}
