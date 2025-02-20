package entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // int ekk wenna one auto generate kjrnkota
    private int id;

    @Embedded
    private CustomerFullName name;

    @Column(name = "customer_email", nullable = false)   // Specifies name and not null
    private String email;

    @Transient   // non-persistent
    private String visaCardNumber;

    @Lob        //storing large text or binary data
    private String description;

    private String phone;

    public Customer(int id, CustomerFullName name, String email, String visaCardNumber, String description, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.visaCardNumber = visaCardNumber;
        this.description = description;
        this.phone = phone;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerFullName getName() {
        return name;
    }

    public void setName(CustomerFullName name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVisaCardNumber() {
        return visaCardNumber;
    }

    public void setVisaCardNumber(String visaCardNumber) {
        this.visaCardNumber = visaCardNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", visaCardNumber='" + visaCardNumber + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
