package org.example

import org.example.domain.{Article, Book}

object Example3_TypeClasses1 {
  trait Scorable[T] {
    def score(t: T): Int
  }

    implicit val scorableBook = new Scorable[Book] {
      override def score(b: Book): Int = b.pages
    }

  implicit val scorableArticle = new Scorable[Article] {
    override def score(t: Article): Int = 1
  }

  case class CurrentScore(value: Int) {
    def addItem[T: Scorable](item: T): CurrentScore =
      CurrentScore(value + implicitly[Scorable[T]].score(item))
  }

  def main(args: Array[String]): Unit = {
    val book = Book("Dune", 600)
    val initialScore = CurrentScore(0).addItem(book)
    println(s"Score with $book: $initialScore")
    val article = Article("Understanding type classes")
    val newScore = initialScore.addItem(article)
    println(s"Score with $article: $newScore")
  }

}
