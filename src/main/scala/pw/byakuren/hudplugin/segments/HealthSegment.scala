package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class HealthSegment extends HUDSegment {
  override def name: String = "Health"

  override def placeholder: String = "%hp"

  override def generate(player: Player): Vector[BaseComponent] = {
    val hp = player.getHealth.toInt
    new ComponentBuilder(s"❤$hp").color(ChatColor.RED).create().toVector
  }
}
