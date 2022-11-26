package api.pojo;

import java.util.List;

@SuppressWarnings("unused")
public class Orders {

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
