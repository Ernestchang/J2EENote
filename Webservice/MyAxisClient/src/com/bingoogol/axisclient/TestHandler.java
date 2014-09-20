package com.bingoogol.axisclient;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import java.net.URL;

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

