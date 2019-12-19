package team.aura_dev.auraban.platform.spigot.player;

import org.bukkit.entity.Player;
import team.aura_dev.auraban.platform.common.player.PlayerManagerCommon;
import team.aura_dev.auraban.platform.common.storage.StorageEngine;

public class PlayerManagerSpigot extends PlayerManagerCommon {
  public PlayerManagerSpigot(StorageEngine storageEngine) {
    super(storageEngine);
  }

  @Override
  protected BasePlayerData nativePlayerToBasePlayerData(Object player)
      throws IllegalArgumentException {
    if (!(player instanceof Player)) {
      throw new IllegalArgumentException(
          "The passed player object (" + player + ") is not of type " + Player.class.getName());
    }

    final Player nativePlayer = (Player) player;

    return new BasePlayerData(nativePlayer.getUniqueId(), nativePlayer.getName());
  }
}
