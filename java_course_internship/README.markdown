# Java Internship Course

This file describes tasks the project is covering.

### FirstTask

Write a program which will 
* count days till Xmas; 
* count time remained till Xmas(how many months, days and hours);
* find out what day of the week was on 18/10/1985;
* count time elapsed on a loop.

### SecondTask

Make a project from image. Create interfaces, abstract classes and classes. Overload constructors, 
override methods, use appropriate access modifiers.

### ThirdTask
 
Task:
1)	Having an input txt file with user’s order details (attached)
2)	Read file itself
3)	Parse data from it in java objects:\
a.	User\
b.	Product (enum with id + name)\
c.	Order Details
4)	Check if order (input file) was made before 10.30.2018

### FourthTask

Create a generic utility-class for ArrayList, define methods:
- concatenate two lists
- for defining difference between two lists
- for defining the intersection between two lists
- for defining if two lists are elements in common (see Collections.disjoint())

Write generic DataTransfer class for aggregating two objects. Use it in passing two coffees from CoffeeMachine (with method .makeCoffee(), that creates two types of coffee, for example, an Americano and a Latte) to class Waiter with method .serveCoffee. Use these classes in flow, where coffee will be created and passed to clients (just call related methods, I dont expect much logic in here)

Write a generic class for adding and subtracting some amount of time (all classes extended from TemporalAmount) from dates (all classes extended from Temporal). Use it  for several calculations: to add/subtract Duration or Period from LocalDate, LocalDateTime, LocalTime etc.

### FifthTask

Create test scenarios using cucumber which will cover third task.

### SixthTask

1. Using File, FileInputStream and FileOutputStream classes do the following flow: create directory, create file, ensure you have create it using isFile() method, write to file a String (remember of .getBytes() method), read from file this string (ensure they are the same), delete file, delete directory.
    * Adjust code above using FileReader and FileWriter to write and read a string/chars
2. Using the static method form Paths class, get current absolute path (project directory). Resolve the pom file relatively from this path. Resolve target directory relatively from path to pom file.
3. Continue with class we have created during practic exercise (Gangster with attributes like nationality, name, rank etc) or create yor own class. Write a method, which will write an object of this class to file and recover it back from file to another object (use ObjectOutputStream and FileOutputStream for writing and ObjectInputStream and FileInputStream for reading respectively)
    * Write a method that will try to recover serialized and stored object (of Gangster or your class) to object of another class with same content, but other name.
    * Add transient field in your class. Run methods again, note if value for transient field was persisted in  file and recovered in object.

### SeventhTask

Write Log in scenario using selenium

### EightTask

Write at least 2 cucumber test scenarios for UI page, using:
- Pageobject pattern for storing locators for UI elements,
- factory method for running tests on chrome/firefox browsers,
- wrapper around WebElement (to separate Link, Button, Input etc)
- ScenarioContext singleton object to share data between tests
