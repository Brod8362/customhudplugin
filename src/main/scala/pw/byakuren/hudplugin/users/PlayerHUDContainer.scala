package pw.byakuren.hudplugin.users

import org.bukkit.entity.Player

import scala.collection.mutable

class PlayerHUDContainer {

  private val data = new mutable.HashMap[Player, PlayerHUD]

  def apply(player: Player): PlayerHUD = {
    data.get(player) match {
      case Some(x) => x
      case None =>
        data(player) = new PlayerHUD(player)
        apply(player)
    }
  }

}
