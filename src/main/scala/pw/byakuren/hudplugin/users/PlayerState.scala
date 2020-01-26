package pw.byakuren.hudplugin.users

import org.bukkit.Material
import org.bukkit.entity.Player


sealed trait PlayerState {
  def name:String
}

object PlayerState {

  val states = Seq(Standard, Swimming, Combat, Flying, Archery)

  case object Standard extends PlayerState {
    def name = "standard"
  }

  case object Swimming extends PlayerState {
    def name = "swimming"
  }

  case object Combat extends PlayerState {
    def name = "combat"
  }

  case object Flying extends PlayerState {
    def name = "flying"
  }

  case object Archery extends PlayerState {
    def name = "archery"
  }

  def fromString(str: String): Option[PlayerState] = {
    states.find(_.name==str)
  }

  implicit class GetPlayerState(player: Player) {
    def playerState(playerHUDs: PlayerHUDContainer): PlayerState = {
      val location = player.getLocation
      val currentTime = player.getWorld.getFullTime
      val heldItem = Option(player.getInventory.getItemInMainHand)
      if (currentTime-playerHUDs(player).lastDamaged<100) return PlayerState.Combat
      if (player.getWorld.getBlockAt(player.getEyeLocation).isLiquid) return PlayerState.Swimming
      if (location.getY-player.getWorld.getHighestBlockYAt(location)>5) return PlayerState.Flying
      for (item <- heldItem) {
        if (item.getType==Material.BOW || item.getType==Material.CROSSBOW) return PlayerState.Archery
      }
      PlayerState.Standard
    }
  }



}