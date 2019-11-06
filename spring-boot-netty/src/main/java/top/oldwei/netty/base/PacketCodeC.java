package top.oldwei.netty.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import top.oldwei.netty.constant.Base;
import top.oldwei.netty.constant.Command;
import top.oldwei.netty.constant.SerializerAlgorithm;
import top.oldwei.netty.domain.CreateGroupRequestPacket;
import top.oldwei.netty.domain.CreateGroupResponsePacket;
import top.oldwei.netty.domain.GroupMessageRequestPacket;
import top.oldwei.netty.domain.GroupMessageResponsePacket;
import top.oldwei.netty.domain.JoinGroupRequestPacket;
import top.oldwei.netty.domain.LoginRequestPacket;
import top.oldwei.netty.domain.LoginResponsePacket;
import top.oldwei.netty.domain.MessageRequestPacket;
import top.oldwei.netty.domain.MessageResponsePacket;
import top.oldwei.netty.domain.Packet;
import top.oldwei.netty.serializer.Serializer;

/**
 * @Author:weizd
 * @Date:19-10-28
 */
public class PacketCodeC {


    public final static PacketCodeC INSTANCE = new PacketCodeC();


    public void encode(Packet packet,ByteBuf byteBuf){
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 魔法数据 代表收到的数据是约定的内容
        byteBuf.writeInt(Base.MAGIC_NUMBER);
        // 版本
        byteBuf.writeByte(packet.getVersion());
        // 序列化算法标识
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        //
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }


    @Deprecated
    public ByteBuf encode(Packet packet){

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();

        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 魔法数据 代表收到的数据是约定的内容
        byteBuf.writeInt(Base.MAGIC_NUMBER);
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
        }else if(command == Command.LOGIN_RESPONSE){
            return LoginResponsePacket.class;
        }else if(command == Command.MESSAGE_REQUEST){
            return MessageRequestPacket.class;
        }else if(command == Command.MESSAGE_RESPONSE){
            return MessageResponsePacket.class;
        }else if(command == Command.CREATE_GROUP_REQUEST){
            return CreateGroupRequestPacket.class;
        }else if(command == Command.CREATE_GROUP_RESPONSE){
            return CreateGroupResponsePacket.class;
        }else if(command == Command.JOIN_GROUP_REQUEST){
            return JoinGroupRequestPacket.class;
        }else if(command == Command.SEND_GROUP_MESSAGE_REQUEST){
            return GroupMessageRequestPacket.class;
        }else if(command == Command.SEND_GROUP_MESSAGE_RESPONSE){
            return GroupMessageResponsePacket.class;
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
