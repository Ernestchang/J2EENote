/**
 * @(#)$CurrentFile
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 *<br> Copyright:  Copyright (c) 2014
 *<br> Company:厦门畅享信息技术有限公司
 *<br> @author bingo
 *<br> 14-1-2 下午8:14
 *<br> @version 1.0
 *————————————————————————————————
 *修改记录
 *    修改者：
 *    修改时间：
 *    修改原因：
 *————————————————————————————————
 */
package com.bingoogol.axisserver.service;

import com.bingoogol.axisserver.pojo.Order;

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
public class OrderService {

    public Order returnOrder(Order order) {
        Order newOrder = new Order();
        if(order.getId().equals("1")){
            newOrder.setName("Jacky");
        }else{
            newOrder.setName("Tom");
        }
        return newOrder;
    }
}