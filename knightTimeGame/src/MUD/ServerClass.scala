package MUDGame

import scala.collection.mutable._
import scala.collection.mutable
import java.io._
import java.net._
import scala.actors.Actor._

object ServerClass {
    //val mapRooms = new buildRooms
//  val chatLog = new ArrayBuffer[(String,String)] with SynchronizedBuffer[(String,String)] {}
//  val commandQueue = new PriorityQueue((x, y) => if (x < y) -1 else if (x > y) 1 else 0)
//  val npcCommand = new PriorityQueue((x, y) => if (x < y) -1 else if (x > y) 1 else 0)
//  val printQueue = new PriorityQueue((x, y) => if (x < y) -1 else if (x > y) 1 else 0)
  var playerNumber = 0
  //val clients = new ArrayBuffer[Client] with SynchronizedBuffer[Client] {}
  def startServer(port: Int) {
    val server = new ServerSocket(port)
    while (true) {
      val socket = server.accept() //forever wait for new clients
      playerNumber += 1  //read from file unique number
      println("accepted player number " +playerNumber)
    //  actor{runUser(socket, playerNumber)}                                                                   //ACTOR DEF
    }
  }
  def runUser(socket: Socket, pNumber: Int) {
D   val commandList = Buffer[String]()
    var gameWon = false
    var won2 = false
  //  count += 1
    //DEFINE CLIENT OBJECT
    var win = 0
    var client = new Client(
    socket,
    new BufferedInputStream(socket.getInputStream),
    new PrintStream(new BufferedOutputStream(socket.getOutputStream), true),
    pNumber,
    0,
    "",
    null
    )
    //clients += client
    client.ps.println
    (scala.Console.BOLD+
    "\n[SERVER: New Player In Room: "+
    clients.filter(_.curRoom == client.curRoom).map(_ name).mkString.map(_ +", ")
    +"]"+scala.Console.RESET)
    client.ps.println("Player No. "+pNumber.toString+".")
    println(client.name)
//	Main Menu     
    val userInput = new BufferedReader(new InputStreamReader(client.is))
    client.ps.println("[1] Play Game [2] Instructions [3] About")
    var flag = true
    while (flag) {
      userInput.readLine() match {
        case "1" => client = createPlayer.characterSelect(client)//.characterSelect(client)
                    flag = false
        case "2" => client.ps.println("It's a game\n")    //function: keep on screen until a user presses a button
        case "3" => client.ps.println("Ian & Addison\n")
        case "4" => flag = false
        case _   => null
      }
    }
    
    var command = ("")
    //Inner Loop inside client actor (each runs mini-game connected by synchronized collections)
    while (command != "quit") {
//        client.ps.println(scala.Console.BOLD); client.ps.println(mapRooms.printRoom(nc.curRoom)); client.ps.print(scala.Console.RESET); client.ps.print(mapRooms.formatMazeRet(nc.curRoom))
//	      var room = false
//	      if(!room) nc.ps.println("\n"+mapRooms.listNPC("Teacher").name+"\n"+mapRooms.listNPC("teacher").description)
//	      client.ps.println("you are in room: "+client.curRoom)
//	
//	      var itemExists = mapRooms.items(nc.curRoom)
//	      var itemCarrying = if(nc.item!=null) nc.item else {new Item("Nothing", "Nothing", 0)}
//	      
//
//	      nc.ps.print("\n["+nc.name+": "+nc.character.health+"/100hp] >")
//	      commandQueue.enqueue((nc.usrLvl, userInput.readLine()), nc.id)
//	      
	      
//	      var whoIs = commandQueue.peekID 
//	      var thisClient = clients.find(_.id == whoIs).get
	     
//	      command = commandQueue.dequeue._2
//	      chatLog.append((nc.name,command))
	      
//	      val exec = commandParser(command)
//	      exec(nc, mapRooms)
//	      if ((command == "steps to end") && (nc.usrLvl == 4)) {}
//	      if (nc.socket.isClosed) { command = "quit" }
	
//	      if(nc.item.itemName=="First-Aid Kit") gameWon=true//if you win, do some trick to make you win
	      
//	      if(nc.curRoom==11) won2 = true
//	      
//	      if(nc.curRoom==1) nc.ps.println(scala.Console.RED+"Oh my, oh dear, oh my, oh my. I've been wounded in the war. Please help revive me! Please fetch me a band-aid! HURRY!"+scala.Console.RESET)
//	      if(nc.name=="Nond") while(true) {nc.ps.println(scala.Console.BOLD+scala.Console.CYAN+"TROLOLOLOL!!!"+scala.Console.BLINK+"\nTROLOLOLOL!!!!"+scala.Console.BLINK+"\nTROLOLOLOL!!!!!"+scala.Console.BLUE+"\nTROLOLOLOL!!!!!"+scala.Console.CYAN_B+"\nTROLOLOLOL!!!"+scala.Console.BLUE+"\nTROLOLOLOL!!!!!")}
//	      if((nc.curRoom==1) && (gameWon) && (won2)) {nc.ps.println("Good Job, Dear Boy!, I've been saved!"); if(win==1) nc.ps.println(scala.Console.BOLD+scala.Console.CYAN+"YOU WIN!!!"+scala.Console.BLINK+"\nYOU WIN!!!"+scala.Console.BLINK+"\nYOU WIN!!!"+scala.Console.BLUE+"\nYOU WIN!!!"+scala.Console.CYAN_B+"\nYOU WIN!!!"+scala.Console.BLUE+"\nYOU WIN!!!")+scala.Console.RESET; Thread.sleep(2000); command = "quit"; win = 1}
//	      
	      
//	      clients.foreach(e => println("player # " + e.id + " in room " + e.curRoom + " " + command))
//	      
    }
//    
  if(win!=1) println("Game Over")
    client.socket.close
  //createPlayer.storePlayers(clients)
  }
  */
}

