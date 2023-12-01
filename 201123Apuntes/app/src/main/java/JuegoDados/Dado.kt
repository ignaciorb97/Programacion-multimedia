package JuegoDados

import kotlin.random.Random

class Dado constructor(var max:Int
){
var valorMax:Int=max
    var valor:Int=0


    fun tirar(){
        valor= Random.nextInt(1,valorMax)
    }
}