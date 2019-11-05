package top.oldwei.netty.command;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-11-5
 */
public class SendGroupMessageConsoleCommand implements ConsoleCommand {

    private final static Logger logger = LoggerFactory.getLogger(SendGroupMessageConsoleCommand.class);


    @Override
    public void exec(Scanner scanner, Channel channel) {
        logger.info("---> 请输入用户组名称：");
        String groupName  = scanner.nextLine();
        logger.info("---> 请输入信息：");
        String msg  = scanner.nextLine();



    }
}
