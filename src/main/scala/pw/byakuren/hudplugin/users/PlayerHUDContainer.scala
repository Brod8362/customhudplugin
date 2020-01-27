package pw.byakuren.hudplugin.users

import java.util.UUID

import org.bukkit.entity.Player

import scala.collection.mutable

class PlayerHUDContainer {

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
