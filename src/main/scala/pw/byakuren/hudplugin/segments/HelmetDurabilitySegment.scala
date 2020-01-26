package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.entity.Player

class HelmetDurabilitySegment extends DurabilitySegment {
  override def name: String = "Helmet Durability"

  override def placeholder: String = "%dh"

  override def generate(player: Player): Vector[BaseComponent] = {
   generate(player.getInventory.getHelmet, "H")
  }
}
