/*
Learning inheritance
as alll classes are FINAL by default .
to make other classes inherit it's properties we need to make it "open" class
as shown below:-
 */

open class Base{
    var str:String = "something"
    fun printString(str:String):String{
        return "String given is : $str"
    }
}

class Subclass1(): Base(){

    var age:Int=10
    var striiing:String = "soft"
    fun print(str:String){
        println("printing string ...$str")
    }

}

fun main() {

    //try-catch in kotlin
    //all exception classes are subclass of Throwable class

    try{
        var a:Int = 10
        var b:Int=0
        if(b == 0) throw Exception("cannot divide by 0")
        var res = a/b
        println(res)

    }catch(e:Exception){
        println(e.message)
    }finally{
        println("after catch block...")
    }

    var para:String?
    para ="some paragraph"

    para?.let { println(para.length) }


}