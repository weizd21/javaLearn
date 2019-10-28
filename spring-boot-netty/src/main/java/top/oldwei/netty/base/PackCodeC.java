package top.oldwei.netty.base;

import cn.hutool.core.util.StrUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import top.oldwei.netty.constant.Command;
import top.oldwei.netty.constant.SerializerAlgorithm;
import top.oldwei.netty.domain.LoginRequestPacket;
import top.oldwei.netty.domain.Packet;
import top.oldwei.netty.serializer.Serializer;

/**
 * @Author:weizd
 * @Date:19-10-28
 */
public class PackCodeC {

    private static final  int MAGIC_NUMBER = 0x12345678;

    public ByteBuf encode(Packet packet){

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();

        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 魔法数据 代表收到的数据是约定的内容
        byteBuf.writeInt(MAGIC_NUMBER);
        // 版本
        byteBuf.writeByte(packet.getVersion());
        // 序列化算法标识
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        //
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);

        return byteBuf;
    }


    public Packet decode(ByteBuf byteBuf){
        // 跳过magic number
        byteBuf.skipBytes(4);
        // 跳过版本号
        byteBuf.skipBytes(1);
        // 序列化算法标识
        byte serializeAlgorithm = byteBuf.readByte();
        // 指令
        byte command = byteBuf.readByte();
        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];

        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);

        Serializer serializer = getSerializer(serializeAlgorithm);

        if(null != requestType && null != serializer){
            return serializer.deserialize(requestType,bytes);
        }
        return null;

    }


    private Class<? extends Packet> getRequestType(byte command){

        if(command == Command.LOGIN_REQUEST){
            return LoginRequestPacket.class;
        }
        return null;
    }

    private Serializer getSerializer(byte serializerAlgorithm){
        if(serializerAlgorithm == SerializerAlgorithm.JSON){
            return Serializer.DEFAULT;
        }
        return Serializer.DEFAULT;
    }


}
