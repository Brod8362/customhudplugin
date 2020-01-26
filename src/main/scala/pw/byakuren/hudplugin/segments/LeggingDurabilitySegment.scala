package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.entity.Player

class LeggingDurabilitySegment extends DurabilitySegment {
  override def name: String = "Leggings Durability"

  override def placeholder: String = "%dl"

  override def generate(player: Player): Vector[BaseComponent] = {
   generate(player.getInventory.getLeggings, "L")
  }
}
