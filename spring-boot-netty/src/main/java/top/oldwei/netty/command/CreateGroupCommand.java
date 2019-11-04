package top.oldwei.netty.command;

import cn.hutool.core.util.IdUtil;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.domain.CreateGroupRequestPacket;

import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-11-4
 */
public class CreateGroupCommand implements ConsoleCommand{

    private final static Logger logger = LoggerFactory.getLogger(CreateGroupCommand.class);

    @Override
    public void exec(Scanner scanner, Channel channel) {
        logger.info("---> 请输入用户组名称：");
        String groupName  = scanner.nextLine();

        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        createGroupRequestPacket.setGroupId(IdUtil.simpleUUID());
        createGroupRequestPacket.setGroupName(groupName);

        channel.writeAndFlush(createGroupRequestPacket);

    }


}
