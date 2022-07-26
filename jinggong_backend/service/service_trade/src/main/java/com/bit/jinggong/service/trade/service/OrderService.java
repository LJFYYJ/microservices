package com.bit.jinggong.service.trade.service;

import com.bit.jinggong.service.trade.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-10
 */
public interface OrderService extends IService<Order> {

    String saveOrder(String courseId, String id);

    Order getByOrderId(String orderId, String id);

    Boolean isBuyByCourseId(String courseId, String id);

    List<Order> selectByMemberId(String id);

    boolean removeById(String orderId, String id);

    Order getOrderByOrderNo(String orderNo);

//    void updateOrderStatus(Map<String, String> notifyMap);
    void updateOrderStatus(String orderNo);

    boolean queryPayStatus(String orderNo);
}
