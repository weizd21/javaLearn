package top.oldwei.netty.command;

import com.google.common.collect.Maps;
import io.netty.channel.Channel;


import java.util.Map;
import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-10-31
 */
public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String,ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager(){
        consoleCommandMap = Maps.newConcurrentMap();
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {

    }
}
