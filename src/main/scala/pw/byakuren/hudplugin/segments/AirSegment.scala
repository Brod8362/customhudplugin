package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class AirSegment extends HUDSegment {
  override def name: String = "Air"

  override def placeholder: String = "%a"

  override def generate(player: Player): Vector[BaseComponent] = {
    new ComponentBuilder(player.getRemainingAir+"").color(ChatColor.AQUA).create().toVector
  }
}
