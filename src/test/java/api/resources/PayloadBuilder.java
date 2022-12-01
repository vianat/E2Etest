package api.resources;

import api.pojo.LoginREQ;
import api.pojo.Order;
import api.pojo.Orders;

import java.util.ArrayList;
import java.util.List;

public class PayloadBuilder {

    public LoginREQ loginPayload(String email, String pass) {

        LoginREQ loginPayload = new LoginREQ();
        loginPayload.setUserEmail(email);
        loginPayload.setUserPassword(pass);

        return loginPayload;
    }

    public Orders createOrderPayload(String productId) {

        Orders createOrderPayload = new Orders();
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();

        order.setCountry("Fuflandia");
        order.setProductOrderedId(productId);

        orderList.add(order);
        createOrderPayload.setOrders(orderList);

        return createOrderPayload;
    }
}
