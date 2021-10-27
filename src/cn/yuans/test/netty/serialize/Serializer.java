package cn.yuans.test.netty.serialize;

import cn.yuans.test.netty.serialize.Impl.JSONSerializer;

/**
 * 序列化器接口
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 获取序列化算法类型
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
