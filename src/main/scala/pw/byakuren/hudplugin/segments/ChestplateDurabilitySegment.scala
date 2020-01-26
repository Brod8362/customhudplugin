package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.Material
import org.bukkit.entity.Player

class ChestplateDurabilitySegment extends DurabilitySegment {
  override def name: String = "Chestplate Durability"

  override def placeholder: String = "%dc"

  override def generate(player: Player): Vector[BaseComponent] = {
    val item = player.getInventory.getChestplate
    val symbol = Option(item) match {
      case Some(i) => i.getType match {
        case Material.ELYTRA => "E"
        case _ => "C"
      }
      case None => "C"
    }
    generate(item, symbol)
  }
}
