package dev.cosrnic.fabric.client;

import dev.cosrnic.UIScreen;
import dev.cosrnic.packet.ClientboundUIPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public final class ServerUIFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PayloadTypeRegistry.playS2C().register(ClientboundUIPacket.type, ClientboundUIPacket.STREAM_CODEC);

        ClientPlayConnectionEvents.JOIN.register((ignored1, ignored2, mc) -> {

            ClientPlayNetworking.registerReceiver(ClientboundUIPacket.type, (payload, context) -> {
                UIScreen testScreen = new UIScreen(payload);
                mc.setScreen(testScreen);
            });
        });
    }
}
