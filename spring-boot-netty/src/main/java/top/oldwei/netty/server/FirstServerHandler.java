package top.oldwei.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author:weizd
 * @Date:19-10-22
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(FirstServerHandler.class);


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;

        logger.info("[ByteBuf] capacity:"+byteBuf.capacity());
        logger.info("[ByteBuf] maxCapacity:"+byteBuf.maxCapacity());

        logger.info(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
        logger.info(new Date() + ": 服务端写出数据");
        ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "来自服务端的数据".getBytes(Charset.forName("utf-8"));

        ByteBuf buffer = ctx.alloc().buffer();

        buffer.writeBytes(bytes);

        return buffer;
    }
}
