package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yar on 3/17/14.
 */

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne
    //@Column(name = "ORDER_CLIENT")
    private Client client;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    private Date date;

    @Column(name = "ORDER_AMOUNT")
    private Integer amount;

    private String address;

    public Order() {
    }

    public Order(Client client, String address, Integer amount) {
        this.client = client;
        this.date = new Date();
        this.amount = amount;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
//                ", client=" + client +
                ", date=" + date +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        if (amount != null ? !amount.equals(order.amount) : order.amount != null) return false;
        if (client != null ? !client.equals(order.client) : order.client != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (!id.equals(order.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
//        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
