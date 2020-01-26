package pw.byakuren.hudplugin.segments

import java.awt.TextComponent

import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.entity.Player

trait HUDSegment {

  def name: String

  def placeholder: String

  def generate(player: Player): Vector[BaseComponent]

}
