package test.timer;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import test.timer.commands.countdown_class;

import java.util.Objects;

public final class Timer extends JavaPlugin implements Listener {


    private  static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(this, this);

        Objects.requireNonNull(getCommand("timer")).setExecutor(new countdown_class());

        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onEnable();
    }
}
