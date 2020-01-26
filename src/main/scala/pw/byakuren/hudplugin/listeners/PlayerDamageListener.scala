package pw.byakuren.hudplugin.listeners

import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.{EventHandler, Listener}
import pw.byakuren.hudplugin.users.PlayerHUDContainer

class PlayerDamageListener(implicit playerHUDs: PlayerHUDContainer) extends Listener {

  @EventHandler
  def onPlayerDamage(event: EntityDamageEvent): Unit = {
    event.getEntity match {
      case p: Player =>
        playerHUDs(p).lastDamaged = p.getWorld.getFullTime
      case _ =>
    }
  }

}
