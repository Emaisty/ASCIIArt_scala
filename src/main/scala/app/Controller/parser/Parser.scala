package app.Controller.parser

/*
 * Parse item R and return R
 */

trait Parser[R, T] {

  /** Parse item R or what was already given. */
  def parse(item: R): T
}
