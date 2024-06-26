package cn.cagurzhan.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 空闲检测
 * @author AjaxZhan
 */
public class IMIdleStateHandler extends IdleStateHandler {
    private static final int READER_IDLE_TIME = 15;

    public IMIdleStateHandler(){
        super(READER_IDLE_TIME,0,0,TimeUnit.SECONDS);
    }

    /**
     * 连接假死回调
     */
    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
        ctx.channel().close();
    }
}
