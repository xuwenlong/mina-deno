package com.client;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by xuwenlong on 2016/6/24.
 */
public class WriteMessageHandler extends IoHandlerAdapter {

    private static final Logger logger = Logger.getLogger(WriteMessageHandler.class);

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.info("WriteMessageHandler.sessionCreated...");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("WriteMessageHandler.sessionOpened...");
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.info("WriteMessageHandler.sessionClosed...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("WriteMessageHandler.sessionClosed...");
    }

    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.info("WriteMessageHandler.exceptionCaught...");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("接收到消息======"+message.toString());
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        logger.info("发送消息给对方:"+message.toString());
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        logger.info("WriteMessageHandler.inputClosed...");
    }
}
