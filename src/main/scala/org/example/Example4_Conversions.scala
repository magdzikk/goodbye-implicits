package org.example

import org.example.OtherPackage._
import org.example.Example4_Conversions.Item
import org.example.domain.Book

object Example4_Conversions {
  case class Item(value: String) extends AnyVal

  def printItem(item: Item): Unit = println(s"*** ${item.value} ***")

  def main(args: Array[String]): Unit = {
    val book = Book("Dune", 600)
    printItem(book)
  }
}

object OtherPackage {
  implicit def bookToItem(book: Book): Item = Item(book.title)
}
