package top.oldwei.netty.domain;

import lombok.Data;

/**
 * @Author:weizd
 * @Date:19-10-28
 * 传输对象
 */
@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     * @return
     */
    public abstract Byte getCommand();
}
