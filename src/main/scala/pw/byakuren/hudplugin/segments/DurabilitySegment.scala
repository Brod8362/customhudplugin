package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.inventory.ItemStack
import pw.byakuren.hudplugin.util.ItemUtils._

trait DurabilitySegment extends HUDSegment {

  private val fullSegment = "▮"
  private val emptySegment = "▯"

  final def createDurabilityBar(damage: Int, capacity: Int, segments: Int): String = {
    val full = (((capacity-damage)/capacity.toDouble)*segments).toInt
    (fullSegment*full)+(emptySegment*(segments-full))
  }

  final def generate(item: ItemStack, symbol: String): Vector[BaseComponent] = {
    Option(item) match {
      case Some(x) =>
        new ComponentBuilder(s"$symbol").color(item.materialColor).
          append(s"[${createDurabilityBar(x.durability, x.maxDurability, 4)}]").color(ChatColor.WHITE).
          create().toVector
      case None =>
        new ComponentBuilder(s"$symbol[").append("X").color(ChatColor.RED).append("]").color(ChatColor.WHITE).create().toVector
    }
  }

}
