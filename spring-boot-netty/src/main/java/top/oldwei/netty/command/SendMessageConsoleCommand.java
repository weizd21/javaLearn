package top.oldwei.netty.command;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.domain.MessageRequestPacket;

import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-11-1
 */
public class SendMessageConsoleCommand implements ConsoleCommand {

    private final static Logger logger = LoggerFactory.getLogger(SendMessageConsoleCommand.class);

    @Override
    public void exec(Scanner scanner, Channel channel) {
        logger.info("---> 请输入接收人：");
        String userName = scanner.nextLine();
        logger.info("---> 请输入信息：");
        String msg = scanner.nextLine();
        MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
        messageRequestPacket.setToUserName(userName);
        messageRequestPacket.setMsg(msg);
        channel.writeAndFlush(messageRequestPacket);

    }
}
