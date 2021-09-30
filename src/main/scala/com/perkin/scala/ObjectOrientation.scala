package com.perkin.scala

object ObjectOrientation extends App {

  // class and instance a class
  class Animal {
    private val age: Int = 42
    protected val size: Int = 43
    def eat() = println("I am eating NOW")
  }
  val animal = new Animal

  //inheritance
  class Dog(var name: String) extends Animal{
    println(size)
  }

  val aDog = new Dog("Lassie")
  println(aDog.name)

  val aDeclaredAnimal = new Dog("Hachi")
  aDeclaredAnimal.eat()

  abstract class WalkingAnimal {
    protected val hasLegs = true //by default public, can restrict by using private or protected
    def walk(): Unit
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating")
    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")

  }


  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // Only valid for method with One argument

  aCroc ?! "hey"

  //singlenton object
  object MySinglenton{
    val myNumber = 562
    def mymethod(): Int = 45
    def apply(x: Int): Int = x + 1

  } //the only instance of the MySinglenton type
  println(MySinglenton.mymethod())
  println(MySinglenton(32)) // it is the same that MySinglenton.apply(32)


  // badval animalCanLifeForever = Animal.eat()
  val animalito = new Animal
  animalito.eat()

  object Animal {
    val canLifeIndefinitely = false
  }

  val could_live = Animal.canLifeIndefinitely

  /*
  case class = lightweitgth data structure

  - sensible equals and hash code
  - serilization
  - companion with apply
   */

  case class Person(name: String, age: Int)

  //may be constructed withoud new
  val bob = Person("Bob", 54)
  println(bob)


  // case class compare themselves by value
  class MyClassn(x: Int){}

  val classInst = new MyClassn(10)
  val classInst2 = new MyClassn(10)
  println("Comparing normal class with same values")
  val comparison = classInst == classInst2
  println(comparison)

  // However case class chack equals
  case class MyClassn_c(x: Int){}

  val classInst3 = new MyClassn_c(10)
  val classInst4 = new MyClassn_c(10)
  println("Comparing case class with same values")
  val comparison2 = classInst3 == classInst4
  println(comparison2)
}
