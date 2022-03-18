package com.bingo.salute.mq.remoting;

import com.bingo.salute.mq.remoting.netty.NettyClientConfig;
import com.bingo.salute.mq.remoting.netty.NettyRemotingClient;
import com.bingo.salute.mq.remoting.protocol.RemotingCommand;

/**
 * Author : bingo624
 * Date : 2022/3/18 19:29
 * Description :
 * version : 1.0
 */
public class NettyClientTest {

    public static void main(String[] args) {
        NettyClientConfig clientConfig = new NettyClientConfig();
        NettyRemotingClient client = new NettyRemotingClient(clientConfig);
        client.start();

        String world = "Hello World!";

        RemotingCommand command = new RemotingCommand();
        command.setOpaque(1);
        command.setCode(2);
        command.setFlag(0);
        command.setRemark("备注A");
        command.setVersion(5);
        command.setBody(world.getBytes());
        try {
            RemotingCommand response = client.invokeSync("192.168.1.3:8888", command, 100000);
            System.err.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
