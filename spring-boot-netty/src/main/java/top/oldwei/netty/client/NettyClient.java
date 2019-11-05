package top.oldwei.netty.client;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import top.oldwei.netty.base.PacketCodeC;
import top.oldwei.netty.command.ConsoleCommandManager;
import top.oldwei.netty.command.LoginConsoleCommand;
import top.oldwei.netty.command.SendMessageConsoleCommand;
import top.oldwei.netty.constant.Base;
import top.oldwei.netty.domain.LoginRequestPacket;
import top.oldwei.netty.domain.MessageRequestPacket;
import top.oldwei.netty.handler.ClientHandler;
import top.oldwei.netty.handler.GroupMessageResponseHandler;
import top.oldwei.netty.handler.LoginResponseHandler;
import top.oldwei.netty.handler.MessageResponseHandler;
import top.oldwei.netty.handler.PacketDecoder;
import top.oldwei.netty.handler.PacketEncoder;
import top.oldwei.netty.handler.Spliter;
import top.oldwei.netty.util.LoginUtil;
import top.oldwei.netty.util.SessionUtil;

import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-10-22
 */
public class NettyClient {


    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                // 1.指定线程模型
                .group(workerGroup)
                // 2.指定 IO 类型为 NIO
                .channel(NioSocketChannel.class)
                // 3.IO 处理逻辑
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        //channel.pipeline().addLast(new ClientHandler());
//                        channel.pipeline().addLast(new Spliter());
                        channel.pipeline().addLast(new PacketDecoder());
                        channel.pipeline().addLast(new LoginResponseHandler());
                        channel.pipeline().addLast(new MessageResponseHandler());
                        channel.pipeline().addLast(new GroupMessageResponseHandler());
                        channel.pipeline().addLast(new PacketEncoder());
                    }
                });


        // 4.建立连接
        bootstrap.connect("127.0.0.1", 8600).addListener(future -> {
            if (future.isSuccess()) {

                System.out.println("连接成功!");


                startConsoleThread(((ChannelFuture)future).channel());


            } else {
                System.err.println("连接失败!");
            }

        });



    }


    private static void startConsoleThread(Channel channel){
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
            ConsoleCommandManager consoleCommandManager  = new ConsoleCommandManager();
            while (!Thread.interrupted()){
                if(LoginUtil.hasLogin(channel)){
                    consoleCommandManager.exec(scanner,channel);
                }else{
                    loginConsoleCommand.exec(scanner,channel);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }

        }).start();
    }



//    private static void startConsoleThread(Channel channel){
//        new Thread(()->{
//            Scanner scanner = new Scanner(System.in);
//            LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
//            SendMessageConsoleCommand sendMessageConsoleCommand = new SendMessageConsoleCommand();
//            while (!Thread.interrupted()){
//                if(LoginUtil.hasLogin(channel)){
//                    sendMessageConsoleCommand.exec(scanner,channel);
//
//                }else{
//                    loginConsoleCommand.exec(scanner,channel);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//
//            }
//
//        }).start();
//    }



//    private static void startConsoleThreadOld(Channel channel){
//        new Thread(()->{
//            Scanner scanner = new Scanner(System.in);
//
//            while (!Thread.interrupted()){
//                if(LoginUtil.hasLogin(channel)){
//
//                    System.out.print("输入接收用户: ");
//                    String toUserId = scanner.nextLine();
//                    System.out.print("输入消息: ");
//                    String message = scanner.nextLine();
//                    MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
//                    messageRequestPacket.setToUserId(toUserId);
//                    messageRequestPacket.setMsg(message);
//
////                    // ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(messageRequestPacket);
////                    for(int i =0 ;i<100;i++){
////                        channel.writeAndFlush(messageRequestPacket);
////                    }
//
//                    System.out.println("MessageRequest:"+ JSONObject.toJSONString(messageRequestPacket));
//                    channel.writeAndFlush(messageRequestPacket);
////                    try {
//////                        tryThread.sleep(1000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//
//                }else{
//                    LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
//                    System.out.print("输入用户名登录: ");
//                    String username = scanner.nextLine();
//                    loginRequestPacket.setUsername(username);
//
//                    loginRequestPacket.setUserId(IdUtil.getSnowflake(Base.WORK_ID,Base.DATA_CENTER_ID).nextId());
////                    loginRequestPacket.setUsername(IdUtil.fastSimpleUUID());
//                    loginRequestPacket.setPassword(SecureUtil.md5(loginRequestPacket.getUsername()));
//
//                    channel.writeAndFlush(loginRequestPacket);
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//
//            }
//
//        }).start();
//    }

}
