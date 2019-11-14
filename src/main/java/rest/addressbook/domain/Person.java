package rest.addressbook.domain;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

/**
 * A person entry in an address book
 */
public class Person {

  private String name;
  private int id;

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) && id == person.id && Objects.equals(email, person.email) && Objects.equals(href, person.href) && Objects.equals(phoneList, person.phoneList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, email, href, phoneList);
  }
  private String email;
  private URI href;
  private List<PhoneNumber> phoneList = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void addPhone(PhoneNumber phone) {
    getPhoneList().add(phone);
  }

  public List<PhoneNumber> getPhoneList() {
    return phoneList;
  }

  public void setPhoneList(List<PhoneNumber> phones) {
    this.phoneList = phones;
  }

  public boolean hasEmail() {
    return getEmail() != null;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }
}
