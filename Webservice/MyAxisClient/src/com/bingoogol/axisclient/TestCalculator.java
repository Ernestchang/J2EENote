package com.bingoogol.axisclient;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import java.net.URL;

public class TestCalculator {
    public static void main(String[] args) throws Exception {
        // 创建服务对象
        Service service = new Service();
        // 通过服务对象创建调用对象
        Call call = (Call) service.createCall();
        String url = "http://localhost:8888/Calculator.jws";
        // 设置调用对象的目标终端地址
        call.setTargetEndpointAddress(new URL(url));
        // 设置调用对象的操作名
        call.setOperationName("add");
        // 进行调用
        Object result = call.invoke(new Object[]{1,2});
        System.out.println(result);
    }
}

