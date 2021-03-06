package team.aura_dev.auraban.platform.nukkit;

import cn.nukkit.plugin.PluginBase;
import team.aura_dev.auraban.platform.common.AuraBanBaseBootstrap;

public class AuraBanNukkitBootstrap extends PluginBase {
  private AuraBanBaseBootstrap bootstrapPlugin;

  @Override
  public void onLoad() {
    bootstrapPlugin = new AuraBanBaseBootstrap();
    bootstrapPlugin.checkAndLoadSLF4J(getDataFolder().toPath().resolve("libs"), "nukkit");
    bootstrapPlugin.initializePlugin(this, getServer(), getDataFolder().toPath());
  }

  @Override
  public void onEnable() {
    bootstrapPlugin.preInitPlugin();
    bootstrapPlugin.initPlugin();
  }
}
