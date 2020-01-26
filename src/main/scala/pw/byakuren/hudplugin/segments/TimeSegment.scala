package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class TimeSegment extends HUDSegment  {
  override def name: String = "Time"

  override def placeholder: String = "%t"

  override def generate(player: Player): Array[BaseComponent] = {
    new ComponentBuilder(player.getWorld.getTime+"").create()
  }
}
