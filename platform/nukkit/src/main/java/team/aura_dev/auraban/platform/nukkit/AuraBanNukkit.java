package team.aura_dev.auraban.platform.nukkit;

import cn.nukkit.Server;
import java.nio.file.Path;
import team.aura_dev.auraban.api.AuraBan;
import team.aura_dev.auraban.platform.common.AuraBanBase;
import team.aura_dev.auraban.platform.common.player.PlayerManagerCommon;
import team.aura_dev.auraban.platform.nukkit.listener.PlayerEventListenerNukkit;
import team.aura_dev.auraban.platform.nukkit.player.PlayerManagerNukkit;

public class AuraBanNukkit extends AuraBanBase {
  private final AuraBanNukkitBootstrap plugin;
  private final Server server;

  public AuraBanNukkit(AuraBanNukkitBootstrap plugin, Server server, Path configDir) {
    super(configDir);

    this.plugin = plugin;
    this.server = server;

    // Instance is initialized
    AuraBan.setApi(this);
  }

  @Override
  public String getBasePlatform() {
    return "Nukkit";
  }

  @Override
  public String getPlatformVariant() {
    return server.getCodename();
  }

  @Override
  protected PlayerManagerCommon generatePlayerManager() {
    return new PlayerManagerNukkit(storageEngine);
  }

  @Override
  protected void registerEventListeners() {
    server.getPluginManager().registerEvents(new PlayerEventListenerNukkit(this), plugin);
  }
}
