package pw.byakuren.hudplugin.users

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

import scala.collection.mutable

class PlayerHUD(player: Player)(implicit config: FileConfiguration) {

  val hudMap: mutable.Map[PlayerState, String] = new mutable.HashMap
  var lastDamaged: Long = 0

  def put(state: PlayerState, str: String): Unit = {
    hudMap.put(state, str)
    config.set(s"${player.getUniqueId.toString}:${state.name}", str)
  }

  def apply(state: PlayerState): Option[String] = {
    hudMap.get(state) match {
      case Some(x) => Some(x)
      case None => Option(config.getString(s"${player.getUniqueId.toString}:${state.name}"))
    }
  }

}
