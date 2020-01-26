package pw.byakuren.hudplugin.segments
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class XPLevelSegment extends HUDSegment {
  override def name: String = "XP Level"

  override def placeholder: String = "%xpl"

  override def generate(player: Player): Vector[BaseComponent] = {
    new ComponentBuilder(player.getLevel+"").create().toVector
  }
}
