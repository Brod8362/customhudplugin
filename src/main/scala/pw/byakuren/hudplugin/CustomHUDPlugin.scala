package pw.byakuren.hudplugin

import org.bukkit.Bukkit
import org.bukkit.command.{Command, CommandSender}
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import pw.byakuren.hudplugin.commands.{PluginCommand, SetFormatCommand, ViewSegmentCommand}
import pw.byakuren.hudplugin.listeners.PlayerDamageListener
import pw.byakuren.hudplugin.segments._
import pw.byakuren.hudplugin.users.{PlayerHUD, PlayerHUDContainer}

import scala.collection.mutable

class CustomHUDPlugin extends JavaPlugin {

  implicit val segments: Seq[HUDSegment] = Seq(new HealthSegment, new TimeSegment, new AirSegment,
    new BootsDurabilitySegment, new LeggingDurabilitySegment, new ChestplateDurabilitySegment,
    new HelmetDurabilitySegment, new CompassSegment, new XPosSegment, new YPosSegment, new ZPosSegment)

  implicit val players: PlayerHUDContainer = new PlayerHUDContainer

  val commands: Seq[PluginCommand] = Seq(new ViewSegmentCommand, new SetFormatCommand)

  override def onLoad(): Unit = super.onLoad()

  override def onDisable(): Unit = {
  }

  override def onEnable(): Unit = {
    getServer.getPluginManager.registerEvents(new PlayerDamageListener, this)
    Bukkit.getScheduler.scheduleSyncRepeatingTask(this, new HUDUpdater(), 20, 10)
  }

  override def onCommand(sender: CommandSender, command: Command, label: String, args: Array[String]): Boolean = {
    commands.find(_.name==command.getName) match {
      case Some(cmd) => cmd.run(sender, label, args)
      case None => false
    }
  }



}
