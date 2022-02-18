package org.example

import org.example.domain.Book

object Example2_ImplicitClass {
  trait Score[Book] {
    def score(book: Book): Int
  }

    implicit object countScore extends Score[Book] {
      def score(book: Book): Int = 1
    }

  implicit object pagesScore extends Score[Book] {
    def score(book: Book): Int = book.pages
  }

  def isChallengeCompleted(books: Seq[Book], goal: Int)(implicit scoring: Score[Book]): Boolean = {
    books.map(book => scoring.score(book)).sum >= goal
  }

  def main(args: Array[String]): Unit = {

  }
}
