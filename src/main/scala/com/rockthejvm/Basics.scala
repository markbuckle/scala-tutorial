package com.rockthejvm

object Basics extends App {
  // defining a value. You cannot reassign a value to val
  val meaningOfLife: Int = 42 // equivalent to const int meaningOfLife = 42; in Java.

  // Types include Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type is optional

  // strings and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + "" + "love" + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  // in Scala we think in terms of values rather than instructions
  val anExpression = 2 + 3
  val ifExpression = if(meaningOfLife > 43) 56 else 999 // in other languages: meaningOfLife 43 ? 56 : 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // value of block is the value of the last expression
    aLocalValue + 3

    // define a function
    def myFunction(x: Int, y: String): String = {
      y + " " + x
    }

    // recursive functions
    def factorial(n: Int): Int =
      if (n <= 1) 1
      else n * factorial(n - 1)

    // In Scala, we don't use loops or iteration, we use RECURSION

    // The unit types = no meaningful value === "void" in other languages
    // type of SIDE EFFECTS. Side effects return unit(void)
    println("I love Scala") // same as System.out.println (Java), printf (C/C++), print/console.log (Python)

    def myUnitReturnFunction(): Unit = {
      println("I don't love returning unit")
    }

    // the parenthesis unit value below is the same as the println value above.
    val theUnit = ()
  }
}
