package casino;

public class Customer {
    private CustomerBelonging customerBelonging;

    public Customer(CustomerBelonging customerBelonging) {
        this.customerBelonging = customerBelonging;
    }

    public CustomerBelonging getCustomerBelonging(){
        return customerBelonging;
    }
}
