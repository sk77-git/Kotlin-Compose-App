/*
*
*
* Tablet Responsive
Jetpack Compose- Row/COlumn/States/Sidebar Nav/ Coil/ NavGraph-> Backstack/ Alwys response in ststaus code

Notification
DI- Koin
Helper Class for view stattic
Font Family
Dynamic Widget
Unit Testing
Theme -Light/dark
Data Store instead of Shared Pref.


--Completed ---
Rows
Columns
Navigation (Navbar, navgraph, bottombar, backstack)
Dynamic Widget
Data Store - Pref data Store
Flow
--Remaining --
Data Store - Proto
Coil
DI- Koin
Theming
Notification
Stateful Stateless
* * */
package com.example.composeapp

/*
* Tablet Responsive
Jetpack Compose- Row/COlumn/States/Sidebar Nav/ Coil/ NavGraph-> Backstack/ Always response in ststaus code

Notification
DI- Koin
Helper Class for view static
Font Family
Dynamic Widget
Unit Testing
Theme -Light/dark
Data Store instead of Shared Pref.


--Completed ---
Rows
Columns
Navigation (Navbar, navgraph, bottombar, backstack)
Dynamic Widget
Data Store - Pref data Store
Stateful Stateless
Flow
Coil
--Remaining --
Data Store- Proto
DI- Koin
Theming
Notification
Responsive Layout
* */


/*fun main(){
    println("sum is ${ calculate(3.0, 2.0, ::sum)}")
    println("mul is ${ calculate(3.0, 2.0, ::mul)}")

    val c= Container(10)
    var x= c.setValue(20)
    println(c.getValue())
}

class Container<T>(var data: T){
    fun getValue():T{
        return  data
    }
    fun setValue(value: T){
        data= value
    }
}

fun sum(a: Double, b: Double): Double{
    return  a+b
}

fun mul(a: Double, b: Double): Double{
    return a*b
}

fun calculate(a: Double, b: Double, operation: (Double, Double) -> Double): Double{
    return operation(a,b)
}*/


/*-----------------Scope Function -------------------------*/
/*fun main(){

    //we can use .apply function on object to get rid of typing object each time
    //returns the type of object applied with, in this case-> Employee
   *//* e.apply {
        name= "Shyam"
        age= 12
        println(name)
        println(age)
        println(e)
    }*//*

    // let is similar to apply but return type is same as last line used inside let block or Unit type
    // let can be used on nullable objects, for example if e can be null then,
    *//*val e: Employee?= null
    e?.name= "ram"
    e?.age=10
    e?.let {
        println("name is ${it.name}") // wont be printed if null
    }*//*

    //similar to apply but returns what comes as end line
    *//*var emp = Employee()
    emp.name= "Ram"
    emp.age=10
    with(emp){
        name= "Shyam"
        println("with name is $name")
    }*//*

    //combination of let and apply, returns types as last lne
    *//*var emp = Employee()
    emp.name= "Ram"
    emp.age=10
    emp.run {
        name= "hari"
        age= 16
        println(name)
    }*//*


}
data class Employee(var name: String= "Empty", var age: Int =0)*/




/* ----------------- Extension Functions -------------------------*/
// can be usd to add extra methods and function in open classes, for eg
/*fun String.myCustomFormattingFunction(): String{
    return "--------------\n$this\n--------------"
}
fun main(){
    println("Hello".myCustomFormattingFunction())
}*/


/* -------------- Lambdas and list ------------------------ */
//lambdas are nameless anonymous functions whose return type is same as value of last line in lambda function
//for example
/*fun sum(a: Int, b: Int): Int {
    return a + b
}

//becomes
val sumLambda1 = { a: Int, b: Int -> a + b }

//Or
val sumLambda2: (Int, Int) -> Int = { a, b -> a + b }

//Main function
fun main() {
    println("sum-> ${sum(3, 4)}")
    println("sumLambda1 -> ${sumLambda1(3, 4)}")
    println("sumLambda2 -> ${sumLambda2(3, 4)}")
    val list= listOf(1,2,3,4,5,6)
    //val oddList= list.filter (::isOdd) //function referencing
    //val oddList= list.filter { a:Int-> a%2!=0 } //only one parameter so lambda can be placed out
    val oddList= list.filter { it%2!=0 } //simplified of above , most efficient
    //val oddList= list.filter (fun(a: Int): Boolean{ return a%2!=0}) //pass function directly

    println(oddList)
}

fun isOdd(a: Int):Boolean{
    return a%2!=0
}*/
//But using lambda function are not efficient to use since
// for each lambda it creates a class then instance then executes a function


/* ------------------Kotlin Higher Order Functions and Function Types---------------*/
/*fun main() {
    println("sum is ${ calculate(3.0, 2.0, ::sum)}")
    println("mul is ${ calculate(3.0, 2.0, ::multiply)}")

}

fun sum(a: Double, b: Double): Double {
    return a + b
}

fun multiply(a: Double, b: Double): Double {
    return a * b
}

fun calculate(a: Double, b: Double, operation: (Double, Double) -> Double): Double {
    var result: Double = operation(a, b)
    return result
}*/

/*---------------Nullable types ------------------*/
/*fun main() {
    var name: String? =null
    var gender: String

    if (name != null) println("1. Name is ${name.uppercase()}") //if name is not null then do this
    println("2. Name is ${name?.uppercase()}") //if name is not null then do this otherwise print null safely-> safe call operator
    println("3. Name is ${name?.uppercase() ?: "Empty"}") //if name is null put a default value-> elvis operator
    println(
        "4. Name is ${
            name.let {
                it?.uppercase()
            }
        }"
    ) // if name is not null perform multiple actions, its sure name is not null inside let

    var userName= name?: "Username"
    println("5. Username is $userName")
    println("6. Name is "+ name!!.uppercase()) //call it even value is null causing exception -->Not null asserted operator

}*/
