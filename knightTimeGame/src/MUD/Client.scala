package MUDGame

//import scala.actors.Actor
import scala.collection.mutable._
import scala.collection.mutable
import java.io._
import java.net._
import akka.actor

class Client(
//    val actor = akka.remote
)


class Client(
  @transient var socket: Socket,
  @transient var is: InputStream,
  @transient var ps: PrintStream,
  var id: Int,
  var curRoom: Int,
//var usrLvl: Int,
  var name: String,
//var pass: String,
//var item: Item,
  var character: MUDCharacter) extends Serializable {
//  def passMatch(possiblePass: String): Boolean = {
//    if (possiblePass == pass) true else false
//  }
//  def toXML = <client curRoom={ curRoom.toString } usrLvl={ usrLvl.toString } name={ name } pass={ pass }> { character.toXML } </client>
}
