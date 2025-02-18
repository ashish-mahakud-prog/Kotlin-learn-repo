import kotlin.collections.ArrayList

//All basics are going to be covered in this single file
//from base to advance topics in kotlin lang.

//entry point to running code in kotlin is the main function
// can be written in 2 ways
/*
1. fun main(args: Array<String>) {
    println(args.toString())
}
 */
/*
2. fun main() {
    println(args.toString())
}
 */
//both are valid entry points, unlike java arguments are not necessary in main function in kotlin

fun main(){
    println("hello ashish")
    variablePrintCall()
    //readText()
    forLooping()
    ArraySystem()
    arraylistFunc()
    mapFunc()
    
    var emp1 = Customer()
    emp1.customer("Arun",28)
    emp1.printCustomer("Shalima", 29)
    
}

/*
The most fundamental data type in Kotlin is the Primitive data type
and all others are reference types like array and string.
Java needs to use wrappers (java.lang.Integer) for primitive data types
to behave like objects but Kotlin already has all data types as objects.

There are different data types in Kotlin:

   1. Integer Data type
    2. Floating-point Data Type
    3. Boolean Data Type
    4. Character Data Type

 */
var numInt : Int =13
var numLong : Long = 23 // you can write as 23L also
var numFloat : Float = 33F // must add F after the number
var numDouble : Double = 43.0 //add decimal to not get error
var isChecked : Boolean = false
var letter : Char = 'A' //takes single character
var some = "liquid "+5 //string and number can only concat when string is written first
fun variablePrintCall(){
    println("this is int = $numInt")
    println("this is long = $numLong")
    println("this is a float value = $numFloat")
    println("this is a double value = $numDouble")
    println("letter is a char value with single character = $letter")
    println("isChecked is a boolean value = $isChecked")
    println("$some *just testing for string and number cancat... ")
}

/*
variables are declared using two types –
    1. Immutable using val keyword
    2. Mutable using var keyword

    **NOTE : val is not const
 */

//read input from user example
fun readText(){
    println("enter your text :")
    val text = readlnOrNull()
    println(text)
    var num : Int
    num = 5
    println(num)
}

// Kotlin Type Conversion
/*
Kotlin does not support implicit type conversion.
 An integer value can not be assigned to the long data type.

 In Kotlin, the helper function can be used to explicitly convert one data type to another data type.
 */
fun typeCasting(){
    println("converted int to long ${numInt.toLong()}")
    println("converted long to int ${numLong.toInt()}")
}

/*
if else statement in kotlin are same as java.
 */
fun ifElseSatements(){
    var isCorrect : Boolean = true
    if(isCorrect) println("value of isCorrect is :  $isCorrect")

    if(!isCorrect) println("going to else condition")
    else println("printing else statement...")
}

/*
In Kotlin, for loop is equivalent to foreach loop of other languages like C#. Here for loop
 is used to traverse through any data structure which provides an iterator. It is used very
 differently then the for loop of other programming languages like Java or C.

 In Kotlin, for loop is used to iterate through the following because all of them provides iterator.

    Range
    Array
    String
    Collection

 */

fun forLooping(){
    println("printing via for loop ...")
    for (i in numInt.rangeTo(23)){
        print("$i ")
    }
    println("for every value i am jumping 3 places")
    for (i in numInt.rangeTo(23) step 3){
        print("$i ")
    }
    //for loop cannot print in reverse
    /*
    fun main(){
	for (i in 5..1) {
		print("$i ")
	}
	println("It prints nothing")
}  output : It prints nothing
     */

    //to print in reverse order .USE "downTo"


    for(i in 5 downTo 0){
        print("$i ")
    }
//step can be used for downTo also

    for(i in 5 downTo 0 step 2){
        print("$i ")
    }

    println()
    //looping through an array
    var arr = intArrayOf(1,2,3,4,5)
    //looping by getting all elements
    for(num in arr) if(num/2 == 1) print("$num ")

    println()
//looping by getting all elements via index value
    for(num in arr.indices) println("${num}th index value is ${arr[num]}")

    //print an array
    println(arr.joinToString(separator = " | ", prefix = "{", postfix = "}"))

    //looping using the withIndex() method
    for((index,value) in arr.withIndex()){
        println("value is $value at index $index")
    }

    /*
    In Kotlin, when replaces the switch operator of other languages like Java.
    A certain block of code needs to be executed when some condition is fulfilled.
     The argument of when expression compares with all the branches one by one until
      some match is found. After the first match is found, it reaches to end
      of the when block and executes the code next to the when block.
      Unlike switch cases in Java or any other programming language,
       we do not require a break statement at the end of each case.
       In Kotlin, when can be used in two ways:

    1. when as a statement
    2. when as an expression

     */
    var something :Int = 24
    when{
        something%2 == 0 -> println("is divisible.. ")
        something%2 != 0 -> println("not divisible..")
        else -> println("what is it ??")
    }

    //continue statement
    var i =1
    while (i in 1..5){
        println("code $i working...")
        i++
        if (i%2 == 0) continue
        i++
    }

    outer@ for (i in 1..5) {
        inner@ for (j in 1..3){
            if ( j == 1) continue@inner
            print("$i")}
        println()
    }
}


//alright let's discuss arrays .
//creating an array

fun ArraySystem(){
    var  arr = arrayOf(1,2,3,4,5)
    //or
    var arr2  = arrayOf<Int>(6,7,8,9,10)

    //as array is a class then we can create array using constructor
    var arr3 = Array(5, {num -> num + 1})


    //get length of array
    println(arr.size)

    //printing an array
    println(arr.contentToString())
    //or use joinToString() for more control over printing
    println(arr3.joinToString(separator = " | ", prefix = "{", postfix = "}"))

    //iterating through the array using index
    for(index in arr.indices){
        print("${arr[index]} ")
    }

    for((index,value) in arr.withIndex()){
        println("value $value at index $index")
    }

    //basic
    for(num in arr){
        print("$num ")
    }

    //accessing and setting the values of array
    //using get() and set() methods
    println(arr2.get(3)) //get(index)
    arr2.set(1,132024) //set(index,value)


    //we can use foreach for array traversal
    arr3.forEach({num -> num*10})
    println("after using forEach() on arr3 -> ${arr3.joinToString()}")

}

//functions in kotlin
//basic way to create a function is
fun greet(){
    println("greet")
}

//with arguments
fun greet(name : String){
    println("Hello! $name")
}

//when you want to tell the function what thte return type should be
fun greeting(name :String) :String{
    return "Hello! $name"
}

//you can add default values to the variables in function
//in the below function the default value is "Ashish"
//if you don't give a value then it will take that value fo printing
fun sayHello(name : String = "Ashish") : String{
    return "Hello to my friend $name"
}

//what about multiple arguments
var studentName = "Loco Poco"
var age = 28
var emailId = "poco@gmail.com"

fun displayStudent(name: String, age : Int, email:String):String{
    return "$name is of age : $age and has email id : $email"
}

/*
In Kotlin, collections are used to store and manipulate groups of objects or data. There are several types of collections available in Kotlin, including:

    Lists – Ordered collections of elements that allow duplicates.
    Sets – Unordered collections of unique elements.
    Maps – Collections of key-value pairs, where each key is unique.
    Arrays – Fixed-size collections of elements with a specific type.
    Sequences – Lazily evaluated collections of elements that can be processed in a pipeline.

    there are 2 types of collections
    1.mutable

    List – mutableListOf(),arrayListOf() and ArrayList
    Set – mutableSetOf(), hashSetOf()
    Map – mutableMapOf(), hashMapOf() and HashMap

    2.immutable

    List – listOf() and listOf<T>()
    Set – setOf()
    Map – mapOf()
 */
//ARRAYLIST

fun arraylistFunc(){
    var list = ArrayList<String>()
    list.add("marco")
    list.add("polo")
    list.add("han solo")
    list.add("falcon")
    list.add("champa")
    list.add("life's good")
    list.add("space")

    //print the list
    println(list)

    //get from list
    println("third item in list is : ${list.get(3)}")
    //set the value
    list.set(3,"winter")
    //remove
    list.remove("life's good")
    //clear the whole list
    list.clear()

    //similar to java Arrays.asList()
    //kotlin has arrayListOf()
    var newList= arrayListOf(1,2,3,4,5)

}

fun setFunc(){
    //creating a set
    //1. immutabke set
    var setA  =setOf(1,2,3,4,5,6,7,8,9)
    //2. mutable set
    var setB = mutableSetOf(1,2,3,4,5)
    var hashSetA =hashSetOf(1,2,3,4,5,6,7)

    //get element at index
    setA.elementAt(3)
    //find index of element
    setB.indexOf(5)
  //learn other set functions by practicing
}

//maps in kotlin
fun mapFunc(){
    //creating a map in kotlin
    //maps are also of 2 types , A)mutable B) immutable
    //empty map
    var emptyMap = mapOf<Int , String>()
    var mapp = hashMapOf(1 to "A",2 to "B",3 to "C")
    println(mapp)
    //get all entries
    mapp.entries
    //get all keys
    mapp.keys
    //get all values
    mapp.values
    //learn other map funtions

}

//class and object in kotlin
//NOTE : ALL CLASSES ARE FINAL BY DEFAULT

class Customer{
    var name:String =""
    var age:Int=0



    fun customer(name:String ,age:Int){
        this.name =name
        this.age=age
    }

    fun printCustomer(name:String, age:Int):String{
        return "name : $name and age : $age"
    }
}

