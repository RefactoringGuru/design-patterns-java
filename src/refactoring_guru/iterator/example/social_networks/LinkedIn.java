package refactoring_guru.iterator.example.social_networks;

import refactoring_guru.iterator.example.iterators.LinkedInIterator;
import refactoring_guru.iterator.example.iterators.ProfileIterator;
import refactoring_guru.iterator.example.profile.Profile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LinkedIn implements SocialNetwork {
  private final List<Profile> contacts;

  public LinkedIn(List<Profile> cache) {
    this.contacts = Objects.requireNonNullElseGet(cache, ArrayList::new);
  }

  /**
   * EN: Here would be a POST request to one of the LinkedIn API
   * endpoints. Instead, we emulates long network connection, which you
   * would expect in the real life...
   * <p>
   * RU: Здесь бы был POST запрос к одному из адресов API LinkedIn. Но
   *  вместо этого мы эмулируем долгое сетевое соединение, прямо как в
   *  реальной жизни
   * @param profileEmail the given mail
   * @return the data
   */
  public Profile requestContactInfoFromLinkedInAPI(String profileEmail) {
    simulateNetworkLatency();
    System.out.println("LinkedIn: Loading profile '" + profileEmail + "' over the network...");
    return findContact(profileEmail);
  }

  public List<String> requestRelatedContactsFromLinkedInAPI(String profileEmail, String contactType) {
    simulateNetworkLatency();
    System.out.println("LinkedIn: Loading '" + contactType + "' list of '" + profileEmail + "' over the network...");
    Profile profile = findContact(profileEmail);
    if (profile != null) {
      return profile.getContacts(contactType);
    }
    return Collections.emptyList();
  }

  private Profile findContact(String profileEmail) {
    for (Profile profile : contacts) {
      if (profile.getEmail().equals(profileEmail)) {
        return profile;
      }
    }
    throw new IllegalArgumentException("Contact isn't found");
  }

  private void simulateNetworkLatency() {
    try {
      Thread.sleep(2500);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public ProfileIterator createFriendsIterator(String profileEmail) {
    return new LinkedInIterator(this, "friends", profileEmail);
  }

  @Override
  public ProfileIterator createCoworkersIterator(String profileEmail) {
    return new LinkedInIterator(this, "coworkers", profileEmail);
  }
}
