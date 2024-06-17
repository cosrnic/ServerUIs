package dev.cosrnic.neoforge;

import dev.cosrnic.ServerUIMod;
import net.neoforged.fml.common.Mod;

@Mod(ServerUIMod.MOD_ID)
public final class ServerUINeoForge {
    public ServerUINeoForge() {
        // Run our common setup.
        ServerUIMod.init();
    }
}
