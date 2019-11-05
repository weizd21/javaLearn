package top.oldwei.netty.command;

import com.google.common.collect.Maps;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.constant.Command;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-10-31
 */
public class ConsoleCommandManager implements ConsoleCommand {

    private final static Logger logger = LoggerFactory.getLogger(ConsoleCommandManager.class);

    private Map<String,ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager(){
        consoleCommandMap = Maps.newConcurrentMap();
        consoleCommandMap.put(Command.CREATE_GROUP,new CreateGroupCommand());
        consoleCommandMap.put(Command.JOIN_GROUP,new JoinGroupCommand());
        consoleCommandMap.put(Command.SEND_MESSAGE,new SendMessageConsoleCommand());
        consoleCommandMap.put(Command.SEND_CROUP_MSG,new SendGroupMessageConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        logger.info("---> 请输入命令：");
        logger.info("--->----------------------------");
        logger.info("---> 单聊:sendMsg");
        logger.info("---> 创建群组:createGroup");
        logger.info("---> 群聊:sendGroupMsg");
        logger.info("---> 加入群聊:joinGroup");
        logger.info("--->----------------------------");
        String command = scanner.nextLine();
        consoleCommandMap.get(command).exec(scanner,channel);
    }


}
