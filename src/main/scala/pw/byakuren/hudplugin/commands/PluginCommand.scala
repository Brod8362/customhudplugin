package pw.byakuren.hudplugin.commands

import org.bukkit.command.CommandSender

trait PluginCommand {

  def name: String

  def run(sender: CommandSender, label: String, args: Array[String]): Boolean

}
