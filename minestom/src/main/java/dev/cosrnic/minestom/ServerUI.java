package dev.cosrnic.minestom;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.packet.server.common.PluginMessagePacket;
import net.minestom.server.utils.PacketUtils;

public class ServerUI {

    private final Component title;
    private final boolean blur;
    private final boolean darken;

    public ServerUI(Component title, boolean blur, boolean darken) {
        this.title = title;
        this.blur = blur;
        this.darken = darken;
    }

    public void sendTo(Audience audience) {
        PacketUtils.sendPacket(audience, getPacket());
    }

    public PluginMessagePacket getPacket() {
        return new PluginMessagePacket("serverui:ui", NetworkBuffer.makeArray(buf -> {
            buf.write(NetworkBuffer.COMPONENT, title);
            buf.write(NetworkBuffer.BOOLEAN, blur);
            buf.write(NetworkBuffer.BOOLEAN, darken);
        }));
    }

}
