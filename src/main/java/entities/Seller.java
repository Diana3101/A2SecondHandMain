package entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.UUID;

public class Seller {
    private UUID id;
    private String firstName;
    private String lastName;
    private SellerWish wish;

    public Seller(){

    }

    public Seller(String firstName, String lastName, SellerWish wish) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wish = wish;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }


    public SellerWish getWish(){
        return wish;
    }

    public void setWish(SellerWish wish){
        this.wish = wish;
    }

    @Override
    public String toString(){
        return "ID: " + id + "; First Name: " + firstName + "; Last Name: " + lastName + "; " + "I`m a seller.";
    }

}
