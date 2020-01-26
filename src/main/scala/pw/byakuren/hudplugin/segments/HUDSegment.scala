package pw.byakuren.hudplugin.segments

import org.bukkit.entity.Player

trait HUDSegment {

  def name: String

  def placeholder: String

  def generate(player: Player): String

}
