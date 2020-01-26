package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class YPosSegment extends HUDSegment {
  override def name: String = "Y pos"

  override def placeholder: String = "%posy"

  override def generate(player: Player): Vector[BaseComponent] = {
    new ComponentBuilder(player.getLocation.getBlockY+"").create().toVector
  }
}
