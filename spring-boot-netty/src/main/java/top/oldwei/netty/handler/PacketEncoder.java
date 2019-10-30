package top.oldwei.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import top.oldwei.netty.base.PacketCodeC;
import top.oldwei.netty.domain.Packet;

/**
 * @Author:weizd
 * @Date:19-10-30
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws Exception {
        PacketCodeC.INSTANCE.encode(packet,byteBuf);
    }
}
