package MUDGame

import scala.collection.mutable
import scala.collection.mutable._
import java.net._
import scala.actors.Actor._
import java.io.Serializable

class Exit(val exitDir: String, val destination: Int) { //extended serializable
 // def toXML = <exit dir={ exitDir } destination={ destination.toString }/>
  def addToList: String = exitDir
}

class Room(val number: Int, val letter: String, val name: String, val description: String, val exits: Buffer[Exit]) { //extended serializable
 // def toXML = <room number={ number.toString } name={ name }><description>{ description }</description> { exits.map(_.toXML) } </room>
}

class Item(val itemName:String, val atkName:String, val damage:Int)
