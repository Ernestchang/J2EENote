package com.bingoogol.axisclient;

import com.bingoogol.axisclient.pojo.Customer;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import javax.xml.namespace.QName;
import java.net.URL;

public class TestCustomer {
    public static void main(String[] args) throws Exception {
        // 创建服务对象
        Service service = new Service();
        // 通过服务对象创建调用对象
        Call call = (Call) service.createCall();
        String url = "http://localhost:8080/myaxis/services/CustomerService";
        // 设置调用对象的目标终端地址
        call.setTargetEndpointAddress(new URL(url));
        // 设置调用对象的操作名
        call.setOperationName("getCustomerByName");
        Class clazz = Customer.class;
        QName qName = new QName("urn:BeanService","Customer");
        call.registerTypeMapping(clazz,qName, new BeanSerializerFactory(clazz,qName),new BeanDeserializerFactory(clazz,qName));
        // 进行调用
        Object result = call.invoke(new Object[]{"bingo"});
        System.out.println(result);
    }
}