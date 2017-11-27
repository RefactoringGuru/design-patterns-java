package refactoring_guru.iterator.example.social_networks;

import refactoring_guru.iterator.example.iterators.ProfileIterator;

public interface SocialNetwork {
    public ProfileIterator createFriendsIterator(String profileEmail);

    public ProfileIterator createCoworkersIterator(String profileEmail);
}
