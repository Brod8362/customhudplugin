package pw.byakuren.hudplugin.segments

import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class TimeSegment extends HUDSegment  {
  override def name: String = "Time"

  override def placeholder: String = "%t"

  override def generate(player: Player): Vector[BaseComponent] = {
    new ComponentBuilder(f"${(player.getWorld.getTime/1000+6)%24}:" +
      f"${Math.floor(((player.getWorld.getTime%1000)/1000.0)*60)}%02.0f").create().toVector
  }
}
