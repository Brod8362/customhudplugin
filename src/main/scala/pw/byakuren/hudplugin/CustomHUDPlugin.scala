package pw.byakuren.hudplugin

import org.bukkit.plugin.java.JavaPlugin

class CustomHUDPlugin extends JavaPlugin {

  var runThread: Option[Thread] = None

  override def onLoad(): Unit = super.onLoad()

  override def onDisable(): Unit = {
    runThread = Some(new Thread(new HUDUpdater))
    for (t <- runThread) t.start()
  }

  override def onEnable(): Unit = {
    for (t <- runThread) t.stop()
    runThread = None
  }

}
