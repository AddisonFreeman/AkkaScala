package com.example

import akka.actor.{Actor, ActorRef, OneForOneStrategy}
import com.sun.glass.ui.Application.EventHandler

/**
 * Created by Addison on 9/14/2015.
 */
trait ChatServer extends Actor {
  self.faultHandler = OneForOneStrategy(List(classOf[Exception]),5,5000)
  val storage: ActorRef

  EventHandler.info(this, "Chat server starting...")

  def receive: Receive = sessionManagement orElse chatManagement

  protected def chatManagement: Receive
  protected def sessionManagement: Receive
  protected def shutdownSessions():Unit

  override def postStop() = {
    EventHandler.info(this, "Chat server is shutting down...")
    shutdownSessions()self.unlink(storage)
    storage.stop()

  }
  }
}
