package pw.byakuren.hudplugin

import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.Bukkit
import pw.byakuren.hudplugin.segments.HUDSegment

import scala.jdk.CollectionConverters._

class HUDUpdater(implicit segments: Seq[HUDSegment]) extends Runnable {

  val formatString = "%t %hp"

  override def run(): Unit = {
    for (player <- Bukkit.getOnlinePlayers.asScala) {
      val vectors: Array[Vector[BaseComponent]] = for (group <- formatString.split(" ")) yield {
        segments.find(_.placeholder == group) match {
          case Some(segment) =>
            segment.generate(player)
          case None =>
            new ComponentBuilder(group + " ").create().toVector
        }
      }
      player.spigot().sendMessage(ChatMessageType.ACTION_BAR, vectors.flatten: _*)
    }
  }

}
