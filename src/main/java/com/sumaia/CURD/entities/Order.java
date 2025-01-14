package com.sumaia.CURD.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;;


@Entity
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false,  referencedColumnName = "id", foreignKey = @ForeignKey(name = "foreignk_order_user"))
    private User user;

    @Column(name = "product_id" , nullable = false)
    private Long productId;

    @Column(name = "product_quantity" , nullable = false)
    private Integer productQuantity;

    @Column(name = "unit_price", nullable=false)
    private Double unitPrice;
    
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @PrePersist
    public void calculateTotalPrice()
    {
        this.totalPrice = this.unitPrice * this.productQuantity;
    }

    public Long getID()
    {
        return id;
    }

    public void setID(Long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Long getProductID()
    {
        return productId;
    }

    public void setProductID(Long productId)
    {
        this.productId = productId;
    }

    public Integer getProductQuantity()
    {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity)
    {
        this.productQuantity = productQuantity;
    }

    public Double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public <Users> void setUser(Users user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    }
}
