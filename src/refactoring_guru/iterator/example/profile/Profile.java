package refactoring_guru.iterator.example.profile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
  private final String name;
  private final String email;
  private final Map<String, List<String>> contacts = new HashMap<>();

  /**
   * Constructs a new Profile.
   *
   * @param email    the email address of the profile
   * @param name     the name of the profile
   * @param contacts the contact list categorized by contact type
   */
  public Profile(String email, String name, Map<String, List<String>> contacts) {
    this.email = email;
    this.name = name;
    this.contacts.putAll(contacts);
  }

  /**
   * Returns the email address of this profile.
   *
   * @return the email address
   */
  public String getEmail() {
    return email;
  }

  /**
   * Returns the name of this profile.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns an unmodifiable list of contacts of the specified type.
   *
   * @param contactType the type of contacts to retrieve
   * @return an unmodifiable list of contacts
   */
  public List<String> getContacts(String contactType) {
    List<String> contactList = contacts.computeIfAbsent(contactType, k -> new ArrayList<>());
    return Collections.unmodifiableList(contactList);
  }

  /**
   * Adds a contact to this profile.
   *
   * @param contactType  the type of contact
   * @param contactEmail the email address of the contact
   */
  public void addContact(String contactType, String contactEmail) {
    contacts.merge(contactType, new ArrayList<>(List.of(contactEmail)), (oldList, newList) -> {
      oldList.addAll(newList);
      return oldList;
    });
  }
}