package top.oldwei.netty.serializer;

/**
 * @Author:weizd
 * @Date:19-10-28
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * Java 序列化成二进制
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制反序列化成Java对象
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> clazz,byte [] bytes);

}
