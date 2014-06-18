/**
 * @(#)$CurrentFile
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 *<br> Copyright:  Copyright (c) 2014
 *<br> Company:厦门畅享信息技术有限公司
 *<br> @author bingo
 *<br> 14-1-1 下午11:10
 *<br> @version 1.0
 *————————————————————————————————
 *修改记录
 *    修改者：
 *    修改时间：
 *    修改原因：
 *————————————————————————————————
 */
package com.bingoogol.axisclient;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import java.net.URL;

/**
 * <pre></pre>
 * <br>----------------------------------------------------------------------
 * <br> <b>功能描述:</b>
 * <br>
 * <br> 注意事项:
 * <br>
 * <br>
 * <br>----------------------------------------------------------------------
 * <br>
 */
public class TestHandler {
    public static void main(String[] args) throws Exception {
        // 创建服务对象
        Service service = new Service();
        // 通过服务对象创建调用对象
        Call call = (Call) service.createCall();
        String url = "http://localhost:8080/myaxis/services/LogTestService";
        // 设置调用对象的目标终端地址
        call.setTargetEndpointAddress(new URL(url));
        // 设置调用对象的操作名
        call.setOperationName("doHandle");
        // 进行调用
        Object result = call.invoke(new Object[]{"我的第一个handler"});
        System.out.println(result);
    }
}

