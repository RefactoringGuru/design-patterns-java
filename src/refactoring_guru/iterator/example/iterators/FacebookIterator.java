package refactoring_guru.iterator.example.iterators;

import refactoring_guru.iterator.example.profile.Profile;
import refactoring_guru.iterator.example.social_networks.Facebook;

import java.util.ArrayList;
import java.util.List;

public class FacebookIterator implements ProfileIterator {
  private final Facebook facebook;
  private final String type;
  private final String email;
  private int currentPosition = 0;
  private final List<String> emails = new ArrayList<>();
  private final List<Profile> profiles = new ArrayList<>();

  public FacebookIterator(Facebook facebook, String type, String email) {
    this.facebook = facebook;
    this.type = type;
    this.email = email;
  }

  @Override
  public boolean hasNext() {
    lazyLoad();
    return currentPosition < emails.size();
  }

  @Override
  public Profile getNext() {
    if (!hasNext()) {
      throw new IllegalArgumentException("Next is null ");
    }

    String friendEmail = emails.get(currentPosition);
    Profile friendProfile = profiles.get(currentPosition);
    if (friendProfile == null) {
      friendProfile = facebook.requestProfileFromFacebook(friendEmail);
      profiles.set(currentPosition, friendProfile);
    }
    currentPosition++;
    return friendProfile;
  }

  @Override
  public void reset() {
    currentPosition = 0;
  }

  private void lazyLoad() {
    if (emails.isEmpty()) {
      List<String> socialProfiles = facebook.requestProfileFriendsFromFacebook(this.email, this.type);
      for (String profile : socialProfiles) {
        this.emails.add(profile);
        this.profiles.add(null);
      }
    }
  }
}
