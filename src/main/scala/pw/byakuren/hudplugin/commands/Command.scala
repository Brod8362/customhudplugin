package pw.byakuren.hudplugin.commands

import org.bukkit.command.CommandSender

trait Command {

  def name: String

  def run(sender: CommandSender, label: String, args: Array[String]): Boolean

}
