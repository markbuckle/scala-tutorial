package com.rockthejvm

object FunctionalProgramming extends App {
  // Scala is Object-Oriented
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  // new instance of the above class
  val bob = new Person("Bob")
  bob.apply(43) //  INVOKING bob as function
  bob(43) // same as above

  /*
  Scala runs on the JVM
  Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

  Scala Programmers invented FunctionX. Example below of a function with 1 arguement and an Integer return type
  */
  val simpleIncremeter = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncremeter.apply(23) // 24
  simpleIncremeter(23) // same as above.

  // All Scala functions are instances of these function_x types
  // Another example of functionX: A function with 2 arguements and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  stringConcatenator("I love", "Scala")

  // syntax sugars
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  doubler(4) // 8

  /* same as longer version:
    val doubler: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int) = 2 * x
    }
   */

  // higher-order functions (HOF): take functions as arguments or return functions as results(or both)
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1) // the map method is a HOF - allows an argument of the method to be passed as a function
  println(aMappedList)

  // another HOF example: a flat map. Used often in real life
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))
  val aFlatMappedList2 = List(1, 2, 3).flatMap { x => // alternative syntax
    List(x, 2 * x)
  }
  println(aFlatMappedList)

  // another HOF example: a filtered list
  val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3) // x <=3 returns a boolean, x => x <= 3 is a function. Filter takes the function and returns a new list containing only the specified elements that mean the boolean (1, 2 and 3).
  val aFilteredList2 = List(1,2,3,4,5).filter(x => x <= 3) // alternative syntax
  println(aFilteredList)

  // for comprehensions
  val alternativePairs = for { // not a for loop
    number <- List(1,2,3)
    letter <- List('a','b','c')
  } yield s"$number-$letter"

  /** Collections */
  // Lists
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrePendedList = 0 :: aList // "::" means applicable to aList(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // "+:" means prepend, ":+" means append. Result is List(0,1,2,3,4,5,6)

  // sequences 
  val aSequence: Seq[Int] = Seq(1,2,3) // returns an instance of a derived type from sequence. Allows us to access the element at a given index below
  val accessedElement = aSequence.apply(1) // the element at index 1 is 2

  // vectors - a sequence that is fast for large data
  val aVector = Vector(1,2,3,4,5)
  
  // sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) // duplicated numbers appear only once: Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 // Set(1,2,4)
  
  // ranges 
  val aRange = 1 to 1000
  val toByTwo = aRange.map(x => 2 * x).toList //List(2,4,6,8...,2000)
  
  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)
  
  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 6437812),
    "Jane" -> 327285 // equivalent to ("Jane", 327285)
  )
  
  
}


