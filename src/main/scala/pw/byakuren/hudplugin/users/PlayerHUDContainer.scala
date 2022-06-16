package pw.byakuren.hudplugin.users

import org.bukkit.configuration.file.FileConfiguration

import java.util.UUID
import org.bukkit.entity.Player

import scala.collection.mutable

class PlayerHUDContainer(implicit config: FileConfiguration) {

  private val data = new mutable.HashMap[UUID, PlayerHUD]

  def apply(player: Player): PlayerHUD = {
    data.get(player.getUniqueId) match {
      case Some(x) => x
      case None =>
        data(player.getUniqueId) = new PlayerHUD(player)
        apply(player)
    }
  }

}
