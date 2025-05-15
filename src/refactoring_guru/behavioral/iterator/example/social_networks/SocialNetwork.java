package refactoring_guru.behavioral.iterator.example.social_networks;

import refactoring_guru.behavioral.iterator.example.iterators.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
