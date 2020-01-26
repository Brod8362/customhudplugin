package pw.byakuren.hudplugin.segments
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class CompassSegment extends HUDSegment {
  override def name: String = "Compass"

  override def placeholder: String = "%c"

  override def generate(player: Player): Vector[BaseComponent] = {
    val heading = player.getLocation.getYaw-20
    val firstIndex = (((heading)%360/360f)*compassString.length).toInt
    var finalString:String = ""
    for (i <- firstIndex to firstIndex+4) {
      finalString += {
        compassString.charAt(i % 20) match {
          case 'N' => "§cN§r"
          case 'S' => "§9S§r"
          case a => a
        }
      }
    }
    new ComponentBuilder(finalString).create().toVector
  }

  private val compassString = "S----W----N----E----"
}
