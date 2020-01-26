package pw.byakuren.hudplugin.util

import net.md_5.bungee.api.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable

object ItemUtils {

  implicit class ItemStackUtil(item: ItemStack) {
    def durability: Int = {
      item.getItemMeta match {
        case x: Damageable => x.getDamage
        case _ => -1
      }
    }
    def materialColor: ChatColor = {
      item.getType match {
        case Material.ELYTRA =>
          ChatColor.LIGHT_PURPLE
        case Material.DIAMOND_BOOTS | Material.DIAMOND_LEGGINGS | Material.DIAMOND_CHESTPLATE | Material.DIAMOND_HELMET =>
          ChatColor.AQUA
        case Material.IRON_BOOTS | Material.IRON_LEGGINGS | Material.IRON_CHESTPLATE | Material.IRON_HELMET =>
          ChatColor.GRAY
        case Material.GOLDEN_BOOTS | Material.GOLDEN_LEGGINGS | Material.GOLDEN_CHESTPLATE | Material.GOLDEN_HELMET =>
          ChatColor.YELLOW
        case _ => ChatColor.WHITE
      }
    }

    def maxDurability: Int = item.getType.getMaxDurability
  }

}
