package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.Material
import org.bukkit.entity.Player

class ArrowSegment extends HUDSegment {
  override def name: String = "Arrows"

  override def placeholder: String = "%arr"

  override def generate(player: Player): Vector[BaseComponent] = {
    val array = for (itemMaybe <- player.getInventory.getContents) yield {
      Option(itemMaybe) match {
        case Some(item) =>
          itemMaybe.getType match {
            case Material.ARROW | Material.SPECTRAL_ARROW | Material.TIPPED_ARROW =>
              item.getAmount
            case _ =>
              0
          }
        case None =>
          0
      }
    }
    new ComponentBuilder(array.sum + "").create().toVector
  }
}
