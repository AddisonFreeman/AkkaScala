package MUDGame

import scala.collection.mutable
import scala.collection.mutable._
import java.io._
import java.net._
import scala.actors.Actor._
import scala.collection.parallel.mutable
/*
class buildRooms {
  //fill this list with all possible exit directions! whoo!
  //private var xmlFile = xml.XML.loadFile("MUDRooms2.xml")
  def itemFromXML(elem: xml.Node): Item = new Item((elem \ "@name").text, (elem \ "@atkName").text,(elem \ "@damage").text.toInt)
  val roomLength = (xmlFile \ "room").length
  def readItems(): Array[Item] = {
    (for (r <- xmlFile \ "room") yield {
      itemFromXML((r \\ "item").head)
    }).toArray
  }
  var arr = readItems
  var it1 = arr
  val items = it1.par
  for(i <- 0 to items.length-1) {
    println(items(i).itemName)
  }
     
  val commandList = Buffer[String]("N", "S", "E", "W", "need help")

  def exitFromXML(elem: xml.Node): Exit = new Exit((elem \ "@dir").text, (elem \ "@destination").text.toInt)
  def exitBufferFromXML(elem: xml.Node): Buffer[Exit] = Buffer[Exit]((for (i <- (elem \ "exit")) yield { exitFromXML(i) }): _*)
  def roomFromXML(elem: xml.Node): Room = new Room((elem \ "@number").text.toInt, (elem \ "@letter").text, (elem \ "@name").text, (elem \ "description").text, exitBufferFromXML(elem))

  def readRooms(): Array[Room] = {
    (for (r <- xmlFile \ "room") yield {
      roomFromXML(r)
    }).toArray
  }
  
  val rooms = readRooms

  def printRoom(cr: Int): String = {
    (rooms(cr).name + (": ") + rooms(cr).description).toString
  }
  
//  def attkOptsFromXML(elem: xml.Node): attkOpts = new attkOpts((elem \ "@opts").text.toInt, (elem \ "@name").text, (elem \ "@damage").text.toInt)
//  def arrAttkOptsFromXML(elem: xml.Node): Array[attkOpts] = Array[attkOpts]((for (i <- (elem \ "attack")) yield { attkOptsFromXML(i) }): _*)
//  //def npcFromXML(elem: xml.Node): NPCCharacter = new NPCCharacter((elem \ "@name").text, (elem \ "@health").text.toInt, (elem \ "description").text, arrAttkOptsFromXML(elem), (elem \ "@room").text.toInt)
//  
//  
//  def readNPC(): Array[NPCCharacter] = {
//    (for (r <- xmlFile \ "npc") yield {
//      npcFromXML(r)
//    }).toArray
//  }
//  val NPCList = readNPC()
//    
//  def listNPC(npcName:String):NPCCharacter = {
//    if(NPCList.exists(n => n.name==npcName)) NPCList.find(n => n.name==npcName).get
//    else null
//  }
//  
  def printRoomExits(cr: Int): String = {
    val string = new StringBuilder
    rooms(cr).exits.foreach(e => {
      (string.append("These are the places you can go: " + e.exitDir + "\n"))
    })
    string.toString
  }

  def makeMazeArr(curRoom:Int): Array[Array[Int]] = { //doesn't do anything with the array input  
    var ret = Array.fill(3)(Array.fill(3)(0))
    ret(1)(1)=8
    if(rooms(curRoom).exits.exists(_.exitDir=="N")) ret(0)(1)=1
    if(rooms(curRoom).exits.exists(_.exitDir=="S")) ret(2)(1)=1
    if(rooms(curRoom).exits.exists(_.exitDir=="E")) ret(1)(2)=1
    if(rooms(curRoom).exits.exists(_.exitDir=="W")) ret(1)(0)=1
    ret
  }
  
  def formatMazeRet(curRoom: Int): String = {
    val maze = makeMazeArr(curRoom)
    val a = new StringBuilder()
    var counter = 1
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        if (counter % 3 == 0) {
          a.append(maze(i)(j) + "\n")
        } else {
          a.append(maze(i)(j))
        }
        counter += 1
      }
    }
    a.toString
  }
  
  /*
  def buildAndPopulateWorldMap(rooms:Array[Room]):Array[Array[Int]] = {
      var nsCount = 0
      var ewCount = 0
      val dirs = "N E S W" split " "
      for (dir <- dirs) yield {
        rooms.count(r => r.exits.filter(e => e.exitDir == dir).nonEmpty )
      }
      rooms.foreach(r => r.exits.foreach(e => {
        nsCount+= {if (e.exitDir == "N") 1 else 0}
        nsCount += {if (e.exitDir == "S") 1 else 0}})
      
      var ret = Array.fill(3)(Array.fill(3)(0)))
  }
  
  def FormatMap(curRoom: Int): String = {
    val maze = buildAndPopulateWorldMap
    val a = new StringBuilder()
    var counter = 1
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        if (counter % 3 == 0) {
          a.append(maze(i)(j) + "\n")
        } else {
          a.append(maze(i)(j))
        }
        counter += 1
      }
    }
    a.toStr
  }*/
}
*/
