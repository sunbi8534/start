package logistic;

import org.springframework.stereotype.Component;

@Component
public class UI {
    Employee employee;
    Order order;
    PersonalInformation personalInformation;
    Product product;
    Shipping shipping;
    TaskResource taskResource;
    Warehouse warehouse;
    public UI(Employee employee,
              Order order,
              PersonalInformation personalInformation,
              Product product,
              Shipping shipping,
              TaskResource taskResource,
              Warehouse warehouse) {
        this.employee = employee;
        this.order = order;
        this.personalInformation = personalInformation;
        this.product = product;
        this.shipping = shipping;
        this.taskResource = taskResource;
        this.warehouse = warehouse;


    }


}
