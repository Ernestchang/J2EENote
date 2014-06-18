/**
 * @(#)$CurrentFile
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 *<br> Copyright:  Copyright (c) 2014
 *<br> Company:厦门畅享信息技术有限公司
 *<br> @author bingo
 *<br> 14-1-2 下午8:17
 *<br> @version 1.0
 *————————————————————————————————
 *修改记录
 *    修改者：
 *    修改时间：
 *    修改原因：
 *————————————————————————————————
 */
package com.bingoogol.axisclient;

import com.bingoogol.axisclient.pojo.Order;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
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
public class TestOrder {
    public static void main(String[] args) throws Exception {
        // 调用的ws的方法,返回值是javaObject对象,要求在客户端,必须创建java类型
        Order order = new Order();
        order.setId("1");// 创建了发送的参数

        // 创建ws连接服务
        String url = "http://localhost:8080/myaxis/services/OrderService";
        Service service = new Service();
        Call call = (Call) service.createCall();
        // 注册JavaBean 注意:和server-config.wsdd编写的内容一致
        QName qn = new QName("urn:BeanService", "Order");
        call.registerTypeMapping(Order.class, qn, new BeanSerializerFactory(
                Order.class, qn), new BeanDeserializerFactory(Order.class, qn));
        String name = "no  !";
        //创建调用
        call.setTargetEndpointAddress(new URL(url));
        //调用服务器的方法
        call.setOperationName(new QName("order", "returnOrder"));
        //设定传入的参数
        call.addParameter("arg1", qn, ParameterMode.IN);
        //设置返回的类型
        call.setReturnType(qn, Order.class);
        //接受结果
        Order result = (Order) call.invoke(new Object[]{order});
        if (result != null) {
            name = result.getName();
        }
        System.out.println(name);
    }
}

