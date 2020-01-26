package pw.byakuren.hudplugin.users

import org.bukkit.entity.Player


sealed trait PlayerState

object PlayerState {

  case object Standard extends PlayerState

  case object Swimming extends PlayerState

  case object Combat extends PlayerState

  case object Flying extends PlayerState

  implicit class GetPlayerState(player: Player) {
    def playerState: PlayerState = {
      if (player.isSwimming) return PlayerState.Swimming
      val location = player.getLocation
      if (location.getY-player.getWorld.getHighestBlockYAt(location)>5) return PlayerState.Flying
      //TODO combat
      PlayerState.Standard
    }
  }

}