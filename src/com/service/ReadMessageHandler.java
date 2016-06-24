package com.service;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by xuwenlong on 2016/6/24.
 */
public class ReadMessageHandler extends IoHandlerAdapter {

    private static final Logger logger = Logger.getLogger(ReadMessageHandler.class);

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.info("ReadMessageHandler.sessionCreated...");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("ReadMessageHandler.sessionOpened...");
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.info("ReadMessageHandler.sessionClosed...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("ReadMessageHandler.sessionClosed...");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.info("ReadMessageHandler.exceptionCaught...");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("接收到消息======我是:" + session.getId() + "  我对你说:" + message.toString());
        session.write("你好 :"+session.getId()+ "  我对你说:" + message.toString());
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        logger.info("发送消息给对方:" + message.toString());
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        logger.info("ReadMessageHandler.inputClosed...");
    }
}
