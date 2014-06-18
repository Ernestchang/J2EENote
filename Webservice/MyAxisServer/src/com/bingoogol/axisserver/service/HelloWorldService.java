/**
 * @(#)$CurrentFile
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 *<br> Copyright:  Copyright (c) 2013
 *<br> Company:厦门畅享信息技术有限公司
 *<br> @author bingo
 *<br> 13-12-30 下午11:58
 *<br> @version 1.0
 *————————————————————————————————
 *修改记录
 *    修改者：
 *    修改时间：
 *    修改原因：
 *————————————————————————————————
 */
package com.bingoogol.axisserver.service;

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
public class HelloWorldService {
    public String sayHello(String name) {
        System.out.println("sayHello:" + name);
        return "hello " + name;
    }

    public String sayHehe(String name) {
        System.out.println("sayHehe:" + name);
        return "hehe " + name;
    }

    private String testPrivate() {
        System.out.println("testPrivate" );
        return "private";
    }
}