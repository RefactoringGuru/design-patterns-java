package refactoring_guru.iterator.example.social_networks;

import refactoring_guru.iterator.example.iterators.FacebookIterator;
import refactoring_guru.iterator.example.iterators.ProfileIterator;
import refactoring_guru.iterator.example.profile.Profile;

import java.util.ArrayList;
import java.util.List;

public class Facebook implements SocialNetwork {
    private List<Profile> profiles;

    public Facebook(List<Profile> cache) {
        if (cache != null) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    public Profile requestProfileFromFacebook(String profileEmail) {
        // EN: Here would be a POST request to one of the Facebook API
        // endpoints. Instead, we emulates long network connection, which you
        // would expect in the real life...
        //
        // RU: Здесь бы был POST запрос к одному из адресов API Facebook. Но
        // вместо этого мы эмулируем долгое сетевое соединение, прямо как в
        // реальной жизни...
        simulateNetworkLatency();
        System.out.println("Facebook: Loading profile '" + profileEmail + "' over the network...");

        // EN: ...and return test data.
        //
        // RU: ...и возвращаем тестовые данные.
        return findProfile(profileEmail);
    }

    public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
        // EN: Here would be a POST request to one of the Facebook API
        // endpoints. Instead, we emulates long network connection, which you
        // would expect in the real life...
        //
        // RU: Здесь бы был POST запрос к одному из адресов API Facebook. Но
        // вместо этого мы эмулируем долгое сетевое соединение, прямо как в
        // реальной жизни...
        simulateNetworkLatency();
        System.out.println("Facebook: Loading '" + contactType + "' list of '" + profileEmail + "' over the network...");

        // EN: ...and return test data.
        //
        // RU: ...и возвращаем тестовые данные.
        Profile profile = findProfile(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findProfile(String profileEmail) {
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
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