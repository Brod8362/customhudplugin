package pw.byakuren.hudplugin

import org.bukkit.Bukkit
import scala.jdk.CollectionConverters._

class HUDUpdater extends Runnable {
  override def run(): Unit = {
    while (true) {
      for (player <- Bukkit.getOnlinePlayers.asScala) {
      }
    }
  }
}
