package com.client;

import com.service.ServiceMain;
import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.*;
import org.apache.mina.core.session.*;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by xuwenlong on 2016/6/24.
 */
public class ClientMain {

    private static final int PORT = 8080;

    private static final int BUFF_SIZE = 2048;

    private static final String HOST = "127.0.0.1";

    private static Logger logger= Logger.getLogger(ServiceMain.class);

    public static void main(String[]args){
        IoConnector connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(50);
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        connector.getSessionConfig().setWriteTimeout(20);
        connector.getSessionConfig().setIdleTime(IdleStatus.WRITER_IDLE, 10);
        connector.setHandler(new WriteMessageHandler());
        ConnectFuture connectFuture= connector.connect(new InetSocketAddress(HOST, PORT));
        connectFuture.awaitUninterruptibly();
        IoSession ioSession = connectFuture.getSession();

//        for(int i =0;i<100;i++){
//            ioSession.write("hello =============="+i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        Scanner scanner= new Scanner(System.in);
        logger.info("请输入你想说的话:");
        while (scanner.hasNextLine()) {
            ioSession.write(scanner.nextLine());
            logger.info("请输入你想说的话:");
        }
    }

}
