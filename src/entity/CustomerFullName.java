package entity;

public class CustomerFullName {
    private String firstName;
    private String lastName;

    public CustomerFullName() {
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "CustomerFullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CustomerFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
