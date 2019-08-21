package team.aura_dev.auraban.platform.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import lombok.Getter;
import org.slf4j.Logger;
import team.aura_dev.auraban.api.AuraBan;
import team.aura_dev.auraban.api.AuraBanApi;
import team.aura_dev.auraban.platform.common.AuraBanBase;
import team.aura_dev.auraban.platform.common.dependency.RuntimeDependency;

@Plugin(
  id = AuraBanApi.ID,
  name = AuraBanApi.NAME,
  version = AuraBanApi.VERSION,
  description = AuraBanApi.DESCRIPTION,
  url = AuraBanApi.URL,
  authors = {AuraBanApi.AUTHOR}
)
public class AuraBanVelocity implements AuraBanBase {
  private final ProxyServer server;
  @Getter private final Logger logger;
  @Getter private final File configDir;

  @Inject
  public AuraBanVelocity(ProxyServer server, Logger logger, @DataDirectory Path dataDir) {
    AuraBan.setApi(this);

    this.server = server;
    this.logger = logger;
    this.configDir = dataDir.toFile();
  }

  @Subscribe
  public void onProxyInitialization(ProxyInitializeEvent event) {
    startPlugin();
  }

  @Override
  public Collection<RuntimeDependency> getDependencies() {
    return Arrays.asList(RuntimeDependency.HIKARI_CP);
  }
}
