package pw.byakuren.hudplugin

import org.bukkit.Bukkit
import pw.byakuren.hudplugin.segments.TimeSegment

import scala.jdk.CollectionConverters._

class HUDUpdater extends Runnable {


  val segments = Seq(new TimeSegment)

  override def run(): Unit = {
    while (true) {
      for (player <- Bukkit.getOnlinePlayers.asScala) {
      }
    }
  }
}
