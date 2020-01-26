package pw.byakuren.hudplugin

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import pw.byakuren.hudplugin.segments.{AirSegment, BootsDurabilitySegment, ChestplateDurabilitySegment, CompassSegment, HUDSegment, HealthSegment, HelmetDurabilitySegment, LeggingDurabilitySegment, TimeSegment}

class CustomHUDPlugin extends JavaPlugin {

  implicit val segments: Seq[HUDSegment] = Seq(new HealthSegment, new TimeSegment, new AirSegment,
    new BootsDurabilitySegment, new LeggingDurabilitySegment, new ChestplateDurabilitySegment,
    new HelmetDurabilitySegment, new CompassSegment)

  override def onLoad(): Unit = super.onLoad()

  override def onDisable(): Unit = {
  }

  override def onEnable(): Unit = {
    Bukkit.getScheduler.scheduleSyncRepeatingTask(this, new HUDUpdater(), 20, 20)
  }

}
