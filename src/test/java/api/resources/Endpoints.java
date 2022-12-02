package api.resources;

public enum Endpoints {

    Authentifications("/auth/login"),
    CreateProduct("/product/add-product"),
    CreateOrder("/order/create-order"),
    ViewOrder("/order/get-orders-details?id="),
    DeleteProduct("product/delete-product/");

    private String endpoint;
    Endpoints(String endpoint){
        this.endpoint = endpoint;
    }
    public String getEndpoint(){
        return endpoint;
    }
}
