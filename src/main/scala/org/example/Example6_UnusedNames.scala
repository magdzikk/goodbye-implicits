package org.example

import org.example.domain.Book

object Example6_UnusedNames {
  implicit val byTitle: Ordering[Book] = new Ordering[Book] {
    override def compare(x: Book, y: Book): Int = {
      println("using implicit val type class")
      x.title.compareTo(y.title)
    }
  }

  implicit object OrderingByTitle extends Ordering[Book] {
    override def compare(x: Book, y: Book): Int = {
      println("using implicit object type class")
      x.title.compareTo(y.title)
    }
  }

  val byLength: Ordering[Book] = (x: Book, y: Book) => -1 * x.pages.compareTo(y.pages)

  def main(args: Array[String]): Unit = {
    val myBooks = List(Book("Dune", 600), Book("Bla", 100), Book("Other", 250))

    printSorted(myBooks)
    printSortedByLength(myBooks)
  }


  def printSorted(myBooks: List[Book]): Unit = {
    println("My books:")
    println(myBooks.sorted)
  }

  def printSortedByLength(myBooks: List[Book]): Unit = {
    println("My books:")
    println(myBooks.sorted(byLength))
  }
}
