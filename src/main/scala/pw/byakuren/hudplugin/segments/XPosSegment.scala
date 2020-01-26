package pw.byakuren.hudplugin.segments
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class XPosSegment extends HUDSegment {
  override def name: String = "X pos"

  override def placeholder: String = "%posx"

  override def generate(player: Player): Vector[BaseComponent] = {
    new ComponentBuilder(player.getLocation.getBlockX+"").create().toVector
  }
}
