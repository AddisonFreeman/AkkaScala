package MUDGame

trait Queue[A] {
  def enqueue(o: A)
  def dequeue(): A
  def peek: A
  def isEmpty: Boolean
}