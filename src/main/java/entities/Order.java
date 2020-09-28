package entities;

import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Thing> orderedThing;
    private Seller seller;
    private Customer customer;

    public Order() {
    }

    public Order(List<Thing> orderedThing, Seller seller, Customer customer) {
        this.orderedThing = orderedThing;
        this.seller = seller;
        this.customer = customer;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Thing> getOrderedThing() {
        return orderedThing;
    }

    public void setOrderedThing(List<Thing> orderedThing) {
        this.orderedThing = orderedThing;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public List<Thing> getOrderedProduct() {
        return orderedThing;
    }

    public Seller getSeller() {
        return seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", thing=" + orderedThing +
                ", seller=" + seller +
                ", customer=" + customer +
                '}';
    }
}
