package top.oldwei.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import top.oldwei.netty.handler.LoginRequestHandler;
import top.oldwei.netty.handler.MessageRequestHandler;
import top.oldwei.netty.handler.PacketDecoder;
import top.oldwei.netty.handler.PacketEncoder;
import top.oldwei.netty.handler.Spliter;


/**
 * @Author:weizd
 * @Date:19-10-22
 */
public class NettyServer {


    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        // ch.pipeline().addLast(new ServerHandler());
                        // 拆包粘包 同时过滤非约定协议的 通信
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new MessageRequestHandler());
                        ch.pipeline().addLast(new PacketEncoder());

                    }
                });

        serverBootstrap.bind(8600);
    }



}
