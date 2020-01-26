package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player
import pw.byakuren.hudplugin.util.ItemUtils._

class BootsDurabilitySegment extends DurabilitySegment {
  override def name: String = "Boots Durability"

  override def placeholder: String = "%db"

  override def generate(player: Player): Vector[BaseComponent] = {
   generate(player.getInventory.getBoots, "B")
  }
}
