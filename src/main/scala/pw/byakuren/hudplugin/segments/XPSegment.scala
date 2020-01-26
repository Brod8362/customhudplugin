package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class XPSegment extends HUDSegment {
  override def name: String = "XP points"

  override def placeholder: String = "%xp"

  override def generate(player: Player): Vector[BaseComponent] = {
    new ComponentBuilder(player.getTotalExperience+"").create().toVector
  }
}
