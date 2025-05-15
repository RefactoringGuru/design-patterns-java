package refactoring_guru.behavioral.iterator.example.iterators;

import refactoring_guru.behavioral.iterator.example.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}