package top.oldwei.netty.command;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.domain.CreateGroupRequestPacket;
import top.oldwei.netty.domain.JoinGroupRequestPacket;

import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-11-5
 */
public class JoinGroupCommand implements ConsoleCommand {

    private final static Logger logger = LoggerFactory.getLogger(JoinGroupCommand.class);

    @Override
    public void exec(Scanner scanner, Channel channel) {
        logger.info("---> 请输入用户组名称：");
        String groupName  = scanner.nextLine();

        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();
        joinGroupRequestPacket.setGroupName(groupName);

        channel.writeAndFlush(joinGroupRequestPacket);

    }


}
