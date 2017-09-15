package refactoring_guru.iterator.example.social_networks;

import refactoring_guru.iterator.example.iterators.ProfileIterator;

public interface SocialNetwork {
    public ProfileIterator getFriendsIterator(String profileEmail);

    public ProfileIterator getCoworkersIterator(String profileEmail);
}
