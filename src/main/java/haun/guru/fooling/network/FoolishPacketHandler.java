package haun.guru.fooling.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraftforge.fml.common.network.FMLIndexedMessageToMessageCodec;

/**
 * Created by KJ4IPS on 11/30/2014.
 *
 * A handler for recieved IFoolishPackets
 */
public class FoolishPacketHandler extends FMLIndexedMessageToMessageCodec<IFoolishPacket> {
    @Override
    public void encodeInto(ChannelHandlerContext ctx, IFoolishPacket msg, ByteBuf target) throws Exception {
        msg.writeBytes(target);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, IFoolishPacket msg) {
        msg.readBytes(source);
        msg.postprocess();
    }
}
