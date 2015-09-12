package MUDGame

import scala.collection.mutable
import scala.collection.mutable._
import java.io._
import java.net._
import scala.actors.Actor._

class MUDEditor {

  def writeNewRooms(curRoomNum: Int) {
    //import scala.xml.XML._

    println("what is filename?")
    val filename = readLine()
    println("New Room name?")
    val newRmName = readLine()
    var newRmNumber = curRoomNum + 1
    println("New Room Description?")
    val description = readLine()

    var nextRmNum = 0

    println("What is exit direction?")
    val exitDir = readLine()
    println("Are you moving forwards or backwards?")
    var move = readLine()
    if (move == "forwards") {
      var nextRmNum = newRmNumber + 1
    } else if (move == "backwards") {
      var nextRmNum = newRmNumber - 1
    } else { var nextRmNum = newRmNumber + 1 }

    val exit1 = new Exit(exitDir, nextRmNum)

    val exits = Buffer[Exit](exit1)

    //val newRoom = new Room(newRmNumber, newRmName, description, exits)

    //save(filename, newRoom.toXML)

  }

}