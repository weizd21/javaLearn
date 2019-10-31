package top.oldwei.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import top.oldwei.netty.constant.Base;
import top.oldwei.netty.constant.Command;

/**
 * @Author:weizd
 * @Date:19-10-30
 */
public class Spliter extends LengthFieldBasedFrameDecoder {


    public Spliter() {
        super(Integer.MAX_VALUE, Base.LENGTH_FIELD_OFFESET,Base.LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if(in.getInt(in.readerIndex()) != Base.MAGIC_NUMBER){
            ctx.channel().close();
            return null;
        }
        return super.decode(ctx, in);
    }
}




