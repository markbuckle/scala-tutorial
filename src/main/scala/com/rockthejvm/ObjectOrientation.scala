package com.rockthejvm

object ObjectOrientation extends App { // extending app has a main method already implemented - it's as if you already had a Java public static void main(String[] args)  

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0
    // define methods
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

  // inheritance - inheriting all of its classes and methods
  class Dog(val name: String) extends Animal // constructor definition
  val aDog = new Dog("Lassie")

  // constructor arguements are not fields: need to put a val before the constructor arguement
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by using private or protected
    def walk(): Unit
  }

  // interface = ultimate abstract type
  trait Carnivore {
    def eat (animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(though: String): Unit // ?! is a method name
  }

  // single-class inheritance, multi-trait "mixing" - when we add a trait, we call that mixing
  class Crocodile extends Animal with Carnivore{
    override def eat (animal: Animal): Unit = println("I am eating you, Animal")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")

  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with one argument
  aCroc ?! "What if we could fly?"

  // operators in Scala are the same as methods
  val basicMath = 1 + 2
  val antoherBasicMath = 1.+(2) // equivalent to above

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
  }

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) //equivalent to MySingleton.apply(65)

  // companions
  object Animal { // companions with the class Animal above - aka companion object
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }
  val animalsCanLiveForever = Animal.canLiveIndefinitely // the Animal singleton object is // similar to Java or C++ "static" fields / methods

  // case classes - lightweight data structures with some boilerplate
  case class Person (name: String, age: Int) // Compiler automatically generates sensible equals/hash code and serialization

  // companion with apply - case classes constructed without "new"
  val bob = Person("Bob", 54) // equivalent to Person.apply("Bob", 54)

  // exceptions - useful for closing connections, files or resources that would be dangerous to leave open
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch { // catch(Exception e) {...}
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList [T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head // String
  
  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /* 
    Benefits:
    1) works miracles in multithreaded/distributed environments
    2) helps make sense of the code ("reasoning about")
   */
  val reverseList = aList.reverse // returns a NEW list

  // Point #2:  Scala is closest to the Object-Oriented ideal since everything is held within an object or a class
  // 
  /* 
    
   */
}
