package entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.UUID;


public class Thing {
    private UUID id;
    private NameofThing name;
    private Size size;
    private ConditionOfThing condition;
    private double price;

    public Thing(){}

    public Thing(NameofThing name, double price, Size size, ConditionOfThing condition) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.condition = condition;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(NameofThing name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ConditionOfThing getCondition() {
        return condition;
    }

    public void setCondition(ConditionOfThing condition) {
        this.condition = condition;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public NameofThing getName(){
        return name;
    }

    @Override
    public String toString(){
        return "ID: " + id + "; thing name: " + name + "; condition: "+ condition + "; size: "
                + size + "; price: " + price + ".";
    }
}
