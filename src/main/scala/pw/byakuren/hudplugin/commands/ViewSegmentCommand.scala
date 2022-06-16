package pw.byakuren.hudplugin.commands

import org.bukkit.command.CommandSender
import pw.byakuren.hudplugin.segments.HUDSegment

class ViewSegmentCommand(implicit val segments: Seq[HUDSegment]) extends PluginCommand {
  override def name: String = "segments"

  override def run(sender: CommandSender, label: String, args: Array[String]): Boolean = {
    val str = for (segment <- segments) yield {
      s"${segment.placeholder} - ${segment.name}"
    }
    sender.sendMessage(str.toArray:_*)
    true
  }
}
