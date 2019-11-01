package top.oldwei.netty.command;

import cn.hutool.core.util.IdUtil;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.constant.Base;
import top.oldwei.netty.domain.LoginRequestPacket;
import top.oldwei.netty.util.LoginUtil;


import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-10-31
 */
public class LoginConsoleCommand implements ConsoleCommand {

    private final static Logger logger = LoggerFactory.getLogger(LoginConsoleCommand.class);

    @Override
    public void exec(Scanner scanner, Channel channel) {
        logger.info("---> 请输入用户名:");
        String userName = scanner.nextLine();

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(IdUtil.getSnowflake(Base.WORK_ID,Base.DATA_CENTER_ID).nextId());
        loginRequestPacket.setUserName(userName);
        loginRequestPacket.setPassword(IdUtil.fastUUID());
        channel.writeAndFlush(loginRequestPacket);

    }
}
