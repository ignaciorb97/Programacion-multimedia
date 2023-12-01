package JuegoDados
//Ejercicio 9 de ejercicios de clase
class JuegoDeDados {
    val dado1 = Dado(6)
    val dado2 = Dado(6)
    val dado3 = Dado(6)

    fun jugar() {
        dado1.tirar()
        dado2.tirar()
        dado3.tirar()
        println("dado1=${dado1.valor}dado2=${dado2.valor}dado3=${dado3.valor}")
    }
}

fun main(parametro: Array<String>) {
    val juego1 = JuegoDeDados()
    juego1.jugar()
}