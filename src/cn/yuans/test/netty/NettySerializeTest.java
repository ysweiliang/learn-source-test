package cn.yuans.test.netty;

import cn.yuans.test.netty.command.LoginRequestPacket;
import cn.yuans.test.netty.command.Packet;
import cn.yuans.test.netty.command.PacketCodeC;
import cn.yuans.test.netty.serialize.Impl.JSONSerializer;
import cn.yuans.test.netty.serialize.Serializer;
import io.netty.buffer.ByteBuf;
import org.junit.Assert;

/**
 * @author ys
 * @create 2021/10/27 15:18
 */
public class NettySerializeTest {
    //魔数 版本号 序列化算法 指令 数据长度 数据
    //4     1     1       1    4    N字节
    public static void main(String[] args) {
        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId(123);
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = new PacketCodeC();
        ByteBuf byteBuf = packetCodeC.encode(loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket),
                serializer.serialize(decodedPacket));
    }
}
