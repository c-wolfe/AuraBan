package team.aura_dev.auraban.platform.spigot.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import team.aura_dev.auraban.platform.common.AuraBanBase;
import team.aura_dev.auraban.platform.common.player.PlayerManagerCommon;
import team.aura_dev.auraban.platform.common.player.PlayerManagerCommon.BasePlayerData;

public class PlayerEventListenerSpigot implements Listener {
  private final PlayerManagerCommon playerManager;

  public PlayerEventListenerSpigot(AuraBanBase plugin) {
    this.playerManager = plugin.getPlayerManager();
  }

  @EventHandler(priority = EventPriority.LOW)
  public void onPlayerJoinAsync(AsyncPlayerPreLoginEvent event) {
    playerManager.fromNativePlayer(new BasePlayerData(event.getUniqueId(), event.getName()));
  }

  @EventHandler(priority = EventPriority.MONITOR)
  public void onPlayerLeave(PlayerQuitEvent event) {
    playerManager.unloadPlayer(event.getPlayer().getUniqueId());
  }
}
