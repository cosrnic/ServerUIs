package dev.cosrnic.packet;

import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record ClientboundUIPacket(
    Component title,
    boolean blur,
    boolean darken
) implements CustomPacketPayload {

    public static final StreamCodec<FriendlyByteBuf, ClientboundUIPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundUIPacket::write, ClientboundUIPacket::read);

    private static ClientboundUIPacket read(FriendlyByteBuf buf) {
        CompoundTag titleNBT = buf.readNbt();
        Component title;
        if (titleNBT == null) title = Component.empty();
        else title = Component.Serializer.fromJsonLenient(titleNBT.toString(), RegistryAccess.EMPTY);
        boolean blur = buf.readBoolean();
        boolean darken = buf.readBoolean();
        return new ClientboundUIPacket(title, blur, darken);
    }


    private void write(FriendlyByteBuf buf) {
        throw new UnsupportedOperationException("Clientbound packets cannot be serialized!");
    }

    public static Type<ClientboundUIPacket> type = new Type<>(ResourceLocation.parse("serverui:ui"));

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return type;
    }
}
