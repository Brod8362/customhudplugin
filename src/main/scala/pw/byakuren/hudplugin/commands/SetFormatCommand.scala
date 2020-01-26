package pw.byakuren.hudplugin.commands
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import pw.byakuren.hudplugin.users.{PlayerHUDContainer, PlayerState}

class SetFormatCommand(implicit val playerHUDs: PlayerHUDContainer) extends PluginCommand {
  override def name: String = "setformat"

  override def run(sender: CommandSender, label: String, args: Array[String]): Boolean = {
    if (!sender.isInstanceOf[Player]) return false
    if (args.length<2) return false
    val player = sender.asInstanceOf[Player]
    PlayerState.fromString(args(0)) match {
      case Some(state) =>
        playerHUDs(player).put(state, args.drop(1).mkString(" "))
        true
      case None =>
        sender.sendMessage("State not recognized.")
        false
    }
  }
}
