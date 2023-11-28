package ejerciciosClases
fun main(){
    var nota:Nota
    nota=Nota()
    nota.inicializar("manolo","matematicas","7",6.75F)
nota.imprimir()

}
class Nota {
    var nombre:String=""
    var asignatura:String=""
    var puntos:String=""
    var nota:Float= 0.0F

    fun inicializar(nombre: String,asignatura:String,puntos:String,nota:Float){

        this.nombre=nombre
        this.asignatura=asignatura
        this.puntos=puntos
        this.nota=nota
    }
    fun imprimir(){
      var resultado:String=  when (puntos) {
            "5" -> "Suficiente"
            "6" -> "Bien"
            "7", "8" -> "Notable"
            "9", "10" -> "Sobresaliente"
            else -> "suspenso"
        }
        var resultado2:String=  when {
          nota in  5.0F ..6.0F-> "Suficiente"
          nota in  6.0F..7.0F -> "Bien"
           nota in 7.0F.. 9.0F-> "Notable"
           nota in 9.0F.. 10.0F -> "Sobresaliente"
            else -> "suspenso"
        }
        println("el alumno $nombre ha sacado $resultado2 en $asignatura")
    }
}