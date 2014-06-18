/**
 * @(#)$CurrentFile
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 *<br> Copyright:  Copyright (c) 2014
 *<br> Company:厦门畅享信息技术有限公司
 *<br> @author bingo
 *<br> 14-1-1 下午10:37
 *<br> @version 1.0
 *————————————————————————————————
 *修改记录
 *    修改者：
 *    修改时间：
 *    修改原因：
 *————————————————————————————————
 */
package com.bingoogol.axisserver.handler;

import org.apache.axis.AxisFault;
import org.apache.axis.Handler;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre></pre>
 * <br>----------------------------------------------------------------------
 * <br> <b>功能描述:日志处理器（相当与web中的filter）</b>
 * <br>
 * <br> 注意事项:
 * <br>
 * <br>
 * <br>----------------------------------------------------------------------
 * <br>
 */
public class LogHandler extends BasicHandler {
    @Override
    public void invoke(MessageContext msgContext) throws AxisFault {
        try {
            Handler serviceHandler = msgContext.getService();
            // 获取配置文件参数
            String filename = (String) getOption("filename");

            FileOutputStream fos = new FileOutputStream(filename, true);

            PrintWriter writer = new PrintWriter(fos);
            // 从处理器对象中获得一个属性值，功能类似与request.getAttribute("list")
            Integer numAccesses = (Integer) serviceHandler.getOption("accesses");
            if (numAccesses == null)
                numAccesses = new Integer(0);
            // 在控制台上显示
            msgContext.getMessage().writeTo(System.out);

            numAccesses = new Integer(numAccesses.intValue() + 1);
            // 向处理器对象中添加一个属性值，功能类似与request.setAttribute("list",list)
            serviceHandler.setOption("accesses", numAccesses);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            String result = sdf.format(date) + ": service " + msgContext.getTargetService() + " accessed " + numAccesses + " time(s).";
            writer.println(result);
            writer.close();
        } catch (Exception e) {
            throw AxisFault.makeFault(e);
        }
    }
}