package com.example

import akka.actor.ActorSystem

object ApplicationMain extends App {
  def run = {
    val server = new ChatServer(2222)
    val user = new ChatClient(String: name)
    server.Connect(user)


  }


  val system = ActorSystem("MyActorSystem")
  val pingActor = system.actorOf(PingActor.props, "pingActor")
  pingActor ! PingActor.Initialize
  // This example app will ping pong 3 times and thereafter terminate the ActorSystem - 
  // see counter logic in PingActor
  system.awaitTermination()
}