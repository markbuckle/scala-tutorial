package com.rockthejvm

object PatternMatching extends App {

  // switch statement / expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // Pattern match is an expression available (almost) only for case classes

  // Case class decomposition
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43) // Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."  // if bob matches the struture Person with a name and an age, then let n and a be the constituent parts of bob as a Person
    case _=> "Something else" // if not, something else
  }

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }

  // decomposing Lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown list"
  }

  // if PM doesn't match anything, it will throw match error
  // PM will try all cases in sequence
}
