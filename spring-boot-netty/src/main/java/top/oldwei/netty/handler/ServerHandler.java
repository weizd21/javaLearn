package top.oldwei.netty.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import top.oldwei.netty.base.PacketCodeC;
import top.oldwei.netty.domain.LoginRequestPacket;
import top.oldwei.netty.domain.LoginResponsePacket;
import top.oldwei.netty.domain.MessageRequestPacket;
import top.oldwei.netty.domain.Packet;

/**
 * @Author:weizd
 * @Date:19-10-29
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    private final static Log logger = LogFactory.get();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf requestByteBuf = (ByteBuf)msg;

        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        if(packet instanceof LoginRequestPacket){
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket)packet;


            logger.info("server receive loginRequest:"+ JSONObject.toJSONString(loginRequestPacket));


            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(loginRequestPacket.getVersion());
            loginResponsePacket.setMsg("connect success");
            loginResponsePacket.setSuccess(true);

            logger.info("loginResponse : {}" ,JSONObject.toJSONString(loginResponsePacket));

            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(loginResponsePacket);


            ctx.channel().writeAndFlush(responseByteBuf);


        }else if (packet instanceof MessageRequestPacket){
            MessageRequestPacket messageRequestPacket = (MessageRequestPacket)packet;

            logger.info("receive message:{}",JSONObject.toJSONString(messageRequestPacket));
        }


    }
}
