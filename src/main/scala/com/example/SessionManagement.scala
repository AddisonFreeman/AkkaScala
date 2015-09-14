package com.example

import java.beans.EventHandler

import akka.actor.{Actor, ActorRef}

import scala.collection.mutable

/**
 * Created by Addison on 9/14/2015.
 */
trait SessionManagement { this: Actor =>

  val storage: ActorRef
  val sessions = new mutable.HashMap[String, ActorRef]

  protected def sessionManagement: Receive ={
    case Login(username) =>
      EventHandler.info(this, "User [%s} has logged in".format(username))
      val session = actorOf(new Session(username, storage))
      session.start()
      sessions += (username -> session)
    case Logout(username) =>
      EventHandler.info(this, "User [%s] has logged out.format(username)")
      val session = sessions(username)
      session.stop()
      sessions -= username
  }

  protected def shutdownSessions =
    sessions.foreach { case (_, session) => session.stop() }
}
