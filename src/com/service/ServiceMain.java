package com.service;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class ServiceMain {

    private static final int PORT = 8080;

    private static final int BUFF_SIZE = 2048;

    private static Logger logger= Logger.getLogger(ServiceMain.class);

    public static void main(String[] args) throws IOException {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptor.getSessionConfig().setReceiveBufferSize(BUFF_SIZE);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE, 10);
        acceptor.setHandler(new ReadMessageHandler());
        acceptor.bind(new InetSocketAddress(PORT));
        logger.info("Listening on port 8080");

    }

}
