package pw.byakuren.hudplugin.segments
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.entity.Player

class BiomeSegment extends HUDSegment {
  override def name: String = "Biome"

  override def placeholder: String = "%b"

  override def generate(player: Player): Vector[BaseComponent] = {
    val biome = player.getWorld.getBiome(player.getLocation().getBlockX, player.getLocation.getBlockZ)
    new ComponentBuilder(biome.name()).create().toVector
  }
}
