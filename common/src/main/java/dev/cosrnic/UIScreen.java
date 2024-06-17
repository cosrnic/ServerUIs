package dev.cosrnic;

import dev.cosrnic.packet.ClientboundUIPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;

public class UIScreen extends Screen {

    private final ClientboundUIPacket packet;

    public UIScreen(ClientboundUIPacket packet) {
        super(packet.title());
        this.packet = packet;

        if (this.minecraft == null) this.minecraft = Minecraft.getInstance();

        addRenderableOnly((guiGraphics, mouseX, mouseY, unknown) -> guiGraphics.drawCenteredString(this.minecraft.font, packet.title(), width/2, 20, 1));
    }

    @Override
    protected void renderBlurredBackground(float f) {
        if (packet.blur()) {
            super.renderBlurredBackground(f);
        }
    }

    @Override
    protected void renderMenuBackground(GuiGraphics guiGraphics) {
        if (packet.darken()) {
            super.renderMenuBackground(guiGraphics);
        }
    }
}
