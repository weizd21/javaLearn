package top.oldwei.netty.handler;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.base.PacketCodeC;
import top.oldwei.netty.constant.Base;
import top.oldwei.netty.domain.LoginRequestPacket;
import top.oldwei.netty.domain.LoginResponsePacket;
import top.oldwei.netty.domain.Packet;
import top.oldwei.netty.util.LoginUtil;

/**
 * @Author:weizd
 * @Date:19-10-29
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(ClientHandler.class);



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        logger.info("client channelActive....");

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(IdUtil.getSnowflake(Base.WORK_ID,Base.DATA_CENTER_ID).nextId());
        loginRequestPacket.setUsername(IdUtil.fastSimpleUUID());
        loginRequestPacket.setPassword(SecureUtil.md5(loginRequestPacket.getUsername()));

        logger.info("loginRequestPacket:"+ JSONObject.toJSONString(loginRequestPacket));


        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(loginRequestPacket);

        ctx.channel().writeAndFlush(byteBuf);

    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        logger.info("client receive msg...");
        ByteBuf byteBuf = (ByteBuf)msg;

        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if(packet instanceof LoginResponsePacket){
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket)packet;

            logger.info("登录响应：loginResponsePacket:{}",JSONObject.toJSONString(loginResponsePacket));

            logger.info("判断是否登录:"+LoginUtil.hasLogin(ctx.channel()));
            LoginUtil.markAsLogin(ctx.channel());
            logger.info("判断是否登录:"+LoginUtil.hasLogin(ctx.channel()));

        }







    }
}
