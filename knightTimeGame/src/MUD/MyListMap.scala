package MUDGame

trait MyListMap[A] {
  def enqueue(o: A)
  def dequeue(): A
  def peek: A
  def isEmpty: Boolean
}