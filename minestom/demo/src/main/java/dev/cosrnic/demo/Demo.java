package dev.cosrnic.demo;

import dev.cosrnic.minestom.ServerUI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.GameMode;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.instance.InstanceContainer;

public class Demo {

    public static void main(String[] args) {
        MinecraftServer server = MinecraftServer.init();

        InstanceContainer instanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer();

        GlobalEventHandler handler = MinecraftServer.getGlobalEventHandler();
        handler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(instanceContainer);
            event.getPlayer().setGameMode(GameMode.CREATIVE);
        });

        handler.addListener(PlayerSpawnEvent.class, event -> {
            var player = event.getPlayer();
            player.setFlying(true);
            new ServerUI(Component.text("abcdef").color(NamedTextColor.GOLD), false, false).sendTo(player);
        });

        server.start("localhost", 25565);
    }
}
