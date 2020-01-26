package pw.byakuren.hudplugin.segments
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class CompassSegment extends HUDSegment {
  override def name: String = "Compass"

  override def placeholder: String = "%c"

  override def generate(player: Player): Vector[BaseComponent] = {
    val heading = player.getLocation.getYaw
    val firstIndex = ((heading/360f)*20).toInt
    var finalString = ""
    for (i <- firstIndex to firstIndex+5) {
      finalString = finalString + {
        compassString.charAt(i % 20) match {
          case 'N' => "§cN"
          case 'S' => "§9S"
          case _ => "§r"+_
        }
      }
    }
    new ComponentBuilder(finalString).create().toVector
  }

  private val compassString = "S----W----N----E----"
}
