# ProductDevelopment
Scala Topics 
-------------------
What is Scala programming?
-
- Scala is a high-level programming language that combines object-oriented and functional programming paradigms. It was designed to be concise, scalable, and type-safe. 

New features added in Scala 3 from Scala 2
----------------------------------------------------

>> **Enums**: Scala 3 supports enums, making it easier to define algebraic data types more concisely.

>> **Contextual Abstractions**: Scala 3 replaces the implicit keyword with more explicit keywords like given, using, and extension, making the intent clearer and reducing confusion.

>> **Metaprogramming**:  Scala 3 introduces a new metaprogramming model that uses TASTy (Typed Abstract Syntax Trees) reflect and macros, offering more powerful and safer ways to perform compile-time operations and code generation.

>> **Compiler Improvements**: The Scala 3 compiler, known as Dotty, has been completely rewritten. This new compiler is designed to be more robust, with better error messages and improved performance. 

>> **Scala 2 and Scala 3 Interoperability**: Projects can mix Scala 2.13 and Scala 3 code, allowing a gradual migration.

What is a case class in Scala and what are its advantages?
--
- **Immutability**: By default, the fields of a case class are immutable
- **Automatic apply Method**: Case classes automatically have an apply method, which means you don't need to use the new keyword to create an instance of the class.
- **Pattern Matching**: Case classes are designed to work seamlessly with Scala's pattern matching.
- **Equality and Hashing**: Case classes automatically generate equals and hashCode methods based on the fields.
- **Copy Method**: Case classes come with a copy method, which allows you to create a new instance with some fields modified while the rest remain unchanged.
- **Serializable**: Case classes implement the Serializable trait, making them easy to use in distributed systems.

# Scala Notes

## 1. Operators in Scala

```scala
val list = List(2, 3, 4)
val prepended = 1 :: list         // List(1, 2, 3, 4)
val appended = list :+ 5          // List(2, 3, 4, 5)
val prependedAlt = 1 +: list      // List(1, 2, 3, 4)
val concatenated = list ++ List(5, 6) // List(2, 3, 4, 5, 6)
```
## 2. Assert in Scala
```scala
val left = 2
val right = 1
assert(left == right)
```

## 3. Class in Scala
```scala
class Point(x: Int, y: Int) {
override def toString(): String = "(" + x + ", " + y + ")"
}
```
Classes in Scala are parameterized with constructor arguments. x and y are constructor arguments.

Classes are instantiated with the new primitive, as the following example shows:
```scala
object Classes {
def main(args: Array[String]) = {
val pt = new Point(1, 2)
println(pt)
}
}
```
```scala
class ClassWithValParameter(val name: String)
val aClass = new ClassWithValParameter("Gandalf")
aClass.name should be("Gandalf")
```
This demonstrates the use of value parameters in ClassWithValParameter(val name: String), which automatically creates an internal property val name: String in the class.

## 4. Options in Scala
Option is a container that represents an optional value. It can either be Some(value) if there is a value, or None if there is no value. This helps to avoid null values and makes handling the absence of values more explicit and safer.
```scala
val someValue: Option[Int] = Some(5)
val noneValue: Option[Int] = None

def getValue(opt: Option[Int]): Int = opt.getOrElse(0)
println(getValue(someValue)) // Outputs 5
println(getValue(noneValue)) // Outputs 0

val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None
val result1 = number.fold(1)(_ * 3)
val result2 = noNumber.fold(1)(_ * 3)
result1 should be(9)
result2 should be(1)
```

## 5. Objects in Scala
An object is a singleton. This object is a replacement for static in Java.

```scala
object Greeting {
  def english = "Hi"
  def espanol = "Hola"
}
Greeting.english should be("Hi")
Greeting.espanol should be("Hola")
```
Object is not a static method in a class.
```scala
object Greeting {
  def english = "Hi"
  def espanol = "Hola"
}
val x = Greeting
val y = x
x eq y should be(true) // Reminder: eq checks for reference
val z = Greeting
x eq z should be(true)

```
An object that has the same name as a class is called a companion object of the class, and it is often used to contain factory methods for the class.

```scala
class Movie(val name: String, val year: Short)

object Movie {
  def academyAwardBestMoviesForYear(x: Short) = {
    x match {
      case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
      case 1931 => Some(new Movie("Cimarron", 1931))
      case 1932 => Some(new Movie("Grand Hotel", 1932))
      case _ => None
    }
  }
}
Movie.academyAwardBestMoviesForYear(1932).get.name should be("Grand Hotel")

```
A companion object can also see private values and variables of the corresponding classes' instantiated objects.
```scala
class Person(val name: String, private val superheroName: String)

object Person {
  def showMeInnerSecret(x: Person) = x.superheroName
}

val clark = new Person("Clark Kent", "Superman")
val peter = new Person("Peter Parker", "Spider-Man")
Person.showMeInnerSecret(clark) should be("Superman")
Person.showMeInnerSecret(peter) should be("Spider-Man")

```
## 6. Tuples in Scala
Scala tuple combines a fixed number of items together so that they can be passed around as a whole. Unlike an array or list, a tuple can hold objects with different types but they are also immutable.
```scala
val t = (1, "hello", Console)

```
Which is syntactic sugar (short cut) for the following:
```scala
val t = new Tuple3(1, "hello", Console)
val tuple = ("apple", "dog")
val fruit = tuple._1
val animal = tuple._2
fruit should be("apple")
animal should be("dog")

```
## 7. Higher Order Functions in Scala
Higher Order Functions are functions that take functions as arguments and/or return functions.
```scala
def summation(x: Int, y: Int => Int) = y(x)
var incrementer = 3

def closure = (x: Int) => x + incrementer

val result = summation(10, closure)
result should be(13)
incrementer = 4
val result2 = summation(10, closure)
result2 should be(14)

```

Define a function literal and assign it to a variable:

```scala
val add: (Int, Int) => Int = (x, y) => x + y
// Use the function value
val sum = add(3, 5) // sum is 8

```
Here (x, y) => x + y is a function literal and add is a function value of type (Int, Int) => Int.

## 8. Closure in Scala
A closure is a function which maintains a reference to one or more variables outside of the function scope. Scala will detect that you are using variables outside of scope and create an object instance to hold the shared variables.
```scala
var increment = 1
def closure = { x: Int => x + increment }
val result1 = closure(10)
result1 should be(11)

increment = 2
val result2 = closure(10)
result2 should be(12)

```

## 9. Higher Order Function Returning Another Function
```scala
def addWithoutSyntaxSugar(x: Int): Function1[Int, Int] = {
  new Function1[Int, Int]() {
    def apply(y: Int): Int = x + y
  }
}
addWithoutSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] should be(true)
addWithoutSyntaxSugar(2)(3) should be(5)
def fiveAdder: Function1[Int, Int] = addWithoutSyntaxSugar(5)
fiveAdder(5) should be(10)

```
## 10. Function Returning Another Function Using an Anonymous Function
```scala
def addWithSyntaxSugar(x: Int) = (y: Int) => x + y
addWithSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] should be(true)
addWithSyntaxSugar(2)(3) should be(5)
def fiveAdder = addWithSyntaxSugar(5)
fiveAdder(5) should be(10)

```
## 11. List in Scala
    Scala Lists are quite similar to arrays, which means all the elements of a list have the same type, but there are two important differences. First, lists are immutable, which means elements of a list cannot be changed by assignment. Second, lists represent a linked list whereas arrays are flat.
```scala
val a = List(1, 2, 3)
val b = List(1, 2, 3)
(a eq b) should be(false)

val a = List(1, 2, 3)
val b = List(1, 2, 3)
(a == b) should be(true)

// Nil lists are identical, even of different types:
val a: List[String] = Nil
val b: List[Int] = Nil
(a == Nil) should be(true)
(a eq Nil) should be(true)
(b == Nil) should be(true)
(b eq Nil) should be(true)
(a == b) should be(true)
(a eq b) should be(true)

val a = List(1, 2, 3)
a.headOption should equal(Some(1))
a.tail should equal(List(2, 3))

```
## 12. Maps in Scala
A Map is an Iterable consisting of pairs of keys and values (also named mappings or associations). The fundamental operations on maps are similar to those on sets.

Lookup operations: apply, get, getOrElse, contains, and isDefinedAt.
Additions and updates: +, ++, updated.
Removals: -, --.
Subcollection producers: keys, keySet, keysIterator, values, valuesIterator.
Transformations: filterKeys and mapValues.
```scala
val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
myMap.size should be(3)

val aNewMap = myMap + ("IL" -> "Illinois")
aNewMap.contains("IL") should be(true)

val mapValues = myMap.values
mapValues.size should be(3)
mapValues.head should be("Michigan") // The order in maps is not guaranteed
val lastElement = mapValues.last
lastElement should be("Wisconsin")

myMap("MI") should be("Michigan")
intercept[NoSuchElementException] {
  myMap("TX")
}
myMap.getOrElse("TX", "missing data") should be("missing data")

val myMap2 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa") withDefaultValue "missing data"
myMap2("TX") should be("missing data")

val aNewMap = myMap -- List("MI", "OH")
aNewMap.contains("MI") should be(false)
myMap.contains("MI") should be(true)
aNewMap.contains("WI") should be(true)
aNewMap.size should be(2)
myMap.size should be(3)

```
## 13. Sets in Scala
Sets are Iterables that contain no duplicate elements.
```scala
**Sets contain distinct values:**
val mySet = Set("Michigan", "Ohio", "Wisconsin", "Michigan")
mySet.size should be(3)

**Sets may be of mixed type:**
val mySet = Set("Michigan", "Ohio", 12)

**Sets can be checked for member existence:**
val mySet = Set("Michigan", "Ohio", 12)
mySet(12) should be(true)
mySet("MI") should be(false)

**Set elements can be removed easily:**
val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val aNewSet = mySet - "Michigan"

**Set elements can be removed in multiple:**
val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val aNewSet = mySet -- List("Michigan", "Ohio")

**Attempted removal of nonexistent elements from a set is handled gracefully:**
val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val aNewSet = mySet - "Minnesota"
aNewSet.equals(mySet) should be(true)

**Two sets can be intersected easily:**
val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
val aNewSet = mySet1 intersect mySet2  // NOTE: You can use the "&" operator

**Two sets can be joined as their union easily:**
val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
val aNewSet = mySet1 union mySet2 // NOTE: You can also use the "|" operator

**The difference between two sets can be obtained easily:**
val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val mySet2 = Set("Wisconsin", "Michigan")
val aNewSet = mySet1 diff mySet2 // Note: you can use the "&~" operator if you *really* want aNewSet.equals(Set("Ohio", "Iowa")) should be(true)

**Set equivalency is independent of order:**
val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
val mySet2 = Set("Wisconsin", "Michigan", "Ohio", "Iowa")
mySet1.equals(mySet2) should be()

```
**Pattern Matching** 

-----
Scala has a built-in general pattern matching mechanism. Match expression can be seen as a generalization of Java-style switches.
>> Pattern matching returns something:
```scala
val stuff = "blue"

val myStuff = stuff match {
  case "red" =>
    println("RED"); 1
  case "blue" =>
    println("BLUE"); 2
  case "green" =>
    println("GREEN"); 3
  case _ =>
    println(stuff); 0 // case _ will trigger if all other cases fail.
}
myStuff should be 2
```

**Wildcard Patterns**

```scala
def goldilocks(expr: Any) =
  expr match {
    case ("porridge", _) => "eating"
    case ("chair", "Mama") => "sitting"
    case ("bed", "Baby") => "sleeping"
    case _ => "what?"
  }

goldilocks(("porridge", "Papa")) should be("eating")
goldilocks(("chair", "Mama")) should be("sitting")
```

**Variable Patterns**

```scala
def goldilocks(expr: (String, String)) =
  expr match {
    case ("porridge", bear) =>
      bear + " said someone's been eating my porridge"
    case ("chair", bear) => bear + " said someone's been sitting in my chair"
    case ("bed", bear) => bear + " said someone's been sleeping in my bed"
    case _ => "what?"
  }

```
**Constructor Patterns with case class**

Constructor patterns in Scala are a specific form of pattern matching that allows you to destructure objects created from case classes or classes with a well-defined constructor pattern.

```scala
case class Person(name: String, age: Int)
def matchPerson(person: Person): String = person match {
  case Person("Alice", _) => "Found Alice"
  case Person(name, age) if age < 18 => s"$name is underage"
  case Person(name, _) => s"Found $name"
}
```

**Constructor Patterns with regular class**

```scala
class Book(title: String, author: String, year: Int)
object BookStore {
  def matchBook(book: Book): String = book match {
    case b @ Book("Scala Programming", _, _) => s"Found Scala book: $b"
    case Book(_, _, 2023) => "Book published in 2023"
    case _ => "Other book"
  }
}
```

**Sequence Patterns**
```scala
val secondElement = List(1, 2, 3) match {
  case x :: xs => xs.head
  case _ => 0
}
secondElement should be 2

val secondElement = List(1, 2, 3) match {
  case x :: y :: xs => y
  case _ => 0
}
secondElement should be 2

val secondElement = List(1) match {
  case x :: y :: xs => y // only matches a list with two or more items
  case _ => 0
}
secondElement should be 0

val r = List(1, 2, 3) match {
  case x :: y :: Nil => y // only matches a list with exactly two items
  case _ => 0
}
r should be 0

val r = List(1, 2, 3) match {
  case x :: y :: z :: tail => tail
  case _ => 0
}
r = List()


```

**Variable Binding**
A pattern with variable binding (via the @sign)

```scala
case class Person(name: String, age: Int)

val person = Person("Alice", 30)

person match {
  case p @ Person(name, age) => println(s"Person found: $p")
  case _ => println("Unknown person")
}
Person found: Person(Alice,30)
```
**Pattern guards**









