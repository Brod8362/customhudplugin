package pw.byakuren.hudplugin.users

import org.bukkit.entity.Player

import scala.collection.mutable

class PlayerHUD(player: Player) {

  val hudMap: mutable.Map[PlayerState, String] = new mutable.HashMap
  var lastDamaged: Long = 0

  def put(state: PlayerState, str: String): Unit = {
    hudMap.put(state, str)
  }

  def apply(state: PlayerState): Option[String] = {
    hudMap.get(state)
  }

}
