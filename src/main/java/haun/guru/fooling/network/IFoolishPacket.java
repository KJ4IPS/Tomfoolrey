package haun.guru.fooling.network;

import io.netty.buffer.ByteBuf;

/**
 * Created by KJ4IPS on 11/30/2014.
 *
 * A Simple interface for FMLs packet handling
 */
public interface IFoolishPacket {
    public void readBytes(ByteBuf bytes);
    public void writeBytes(ByteBuf bytes);
    public void postprocess();
}
