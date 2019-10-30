package top.oldwei.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import top.oldwei.netty.base.PacketCodeC;

import java.util.List;

/**
 * @Author:weizd
 * @Date:19-10-29
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        list.add(PacketCodeC.INSTANCE.decode(byteBuf));
    }



}
