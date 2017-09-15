package refactoring_guru.iterator.example.iterators;

import refactoring_guru.iterator.example.profile.Profile;

public interface ProfileIterator {
    public boolean hasNext();

    public Profile getNext();

    public void reset();
}