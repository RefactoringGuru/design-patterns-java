package refactoring_guru.iterator.example.social_networks;

import refactoring_guru.iterator.example.iterators.FacebookIterator;
import refactoring_guru.iterator.example.iterators.ProfileIterator;
import refactoring_guru.iterator.example.profile.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Facebook implements SocialNetwork {
  private final List<Profile> profiles;

  public Facebook(List<Profile> cache) {
    this.profiles = Objects.requireNonNullElseGet(cache, ArrayList::new);
  }

  /**
   * EN: Here would be a POST request to one of the Facebook API
   * endpoints. Instead, we emulates long network connection, which you
   * would expect in the real life
   * <p>
   * RU: Здесь бы был POST запрос к одному из адресов API Facebook. Но
   * вместо этого мы эмулируем долгое сетевое соединение, прямо как в
   * реальной жизни
   *
   * @param profileEmail provided the profile mail
   * @return expected result
   */
  public Profile requestProfileFromFacebook(String profileEmail) {
    simulateNetworkLatency();
    System.out.println("Facebook: Loading profile '" + profileEmail + "' over the network...");
    return findProfile(profileEmail);
  }

  /**
   * EN: Here would be a POST request to one of the Facebook API
   * endpoints. Instead, we emulates long network connection, which you
   * would expect in the real life
   * <p>
   * RU: Здесь бы был POST запрос к одному из адресов API Facebook. Но
   * вместо этого мы эмулируем долгое сетевое соединение, прямо как в
   * реальной жизни
   *
   * @param profileEmail provided the profile mail
   * @param contactType  concrete type of given contact
   * @return given data
   */
  public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
    simulateNetworkLatency();
    System.out.println("Facebook: Loading '" + contactType + "' list of '" + profileEmail + "' over the network...");
    Profile profile = findProfile(profileEmail);
    return profile.getContacts(contactType);
  }

  private Profile findProfile(String profileEmail) {
    for (Profile profile : profiles) {
      if (profile.getEmail().equals(profileEmail)) {
        return profile;
      }
    }
    throw new IllegalArgumentException("Profile isn't found");
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
    return new FacebookIterator(this, "friends", profileEmail);
  }

  @Override
  public ProfileIterator createCoworkersIterator(String profileEmail) {
    return new FacebookIterator(this, "coworkers", profileEmail);
  }
}