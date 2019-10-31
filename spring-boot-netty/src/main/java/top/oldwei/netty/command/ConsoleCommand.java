package top.oldwei.netty.command;


import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author:weizd
 * @Date:19-10-31
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
