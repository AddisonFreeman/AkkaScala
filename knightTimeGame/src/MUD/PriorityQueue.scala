package MUDGame

class PriorityQueue(comp: (Int, Int) => Int) {

  private val end = new Node((0, ("")), null, null, 0)

  end.next = end
  end.prev = end

  def enqueue(o: (Int, String), id: Int) {
    var rover = end.prev
    while (rover != end && comp(rover.data._1, o._1) > 0) rover = rover.prev
    rover.next.prev = new Node(o, rover.next, rover, id) //data is enqueued sorted
    rover.next = rover.next.prev
  }

  def dequeue(): (Int, String) = { //take data and sever ties
    val victim = end.next
    victim.prev.next = victim.next
    victim.next.prev = victim.prev
    victim.data
  }

  def peek: (Int, String) = end.next.data
  def peekID(): Int = end.next.id
  def peekUsrLvl: (Int) = end.next.data._1
  def peekCommand: (String) = end.next.data._2

  def isEmpty: Boolean = end.next == end

  private class Node(val data: (Int, String), var next: Node, var prev: Node, var id: Int /*, val priority*/ )
}