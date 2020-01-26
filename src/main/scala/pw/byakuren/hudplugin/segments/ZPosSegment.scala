package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class ZPosSegment extends HUDSegment {
  override def name: String = "Z pos"

  override def placeholder: String = "%posz"

  override def generate(player: Player): Vector[BaseComponent] = {
    new ComponentBuilder(player.getLocation.getBlockZ+"").create().toVector
  }
}
