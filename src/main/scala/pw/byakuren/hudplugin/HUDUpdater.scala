package pw.byakuren.hudplugin

import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.{BaseComponent, ComponentBuilder}
import org.bukkit.Bukkit
import pw.byakuren.hudplugin.segments.HUDSegment
import pw.byakuren.hudplugin.users.{PlayerHUDContainer, PlayerState}
import pw.byakuren.hudplugin.users.PlayerState._

import scala.jdk.CollectionConverters._

class HUDUpdater(implicit segments: Seq[HUDSegment], playerHUDs: PlayerHUDContainer) extends Runnable {

  override def run(): Unit = {
    for (player <- Bukkit.getOnlinePlayers.asScala) {
      playerHUDs(player)(player.playerState(playerHUDs)) match {
        case Some(formatString) =>
          val vectors: Array[Vector[BaseComponent]] = for (group <- formatString.replace("&", "§").split(" ")) yield {
            segments.find(_.placeholder == group) match {
              case Some(segment) =>
                segment.generate(player)
              case None =>
                new ComponentBuilder(s" $group ").create().toVector
            }
          }
          player.spigot().sendMessage(ChatMessageType.ACTION_BAR, vectors.flatten: _*)
        case None => //this player has no string assigned for this action.
      }
    }
  }

}
