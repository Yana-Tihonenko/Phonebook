package phonebooktest;

public class Contact {
  private String name;
  private String lastName;
  private String phone;
  private String emal;
  private String address;
  private String description;

  public String getName() {
    return name;
  }

  public Contact setName(String name) {
    this.name = name;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Contact setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Contact setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getEmal() {
    return emal;
  }

  public Contact setEmal(String emal) {
    this.emal = emal;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Contact setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Contact setDescription(String description) {
    this.description = description;
    return this;
  }
}