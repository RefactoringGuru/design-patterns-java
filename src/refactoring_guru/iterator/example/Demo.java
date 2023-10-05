package refactoring_guru.iterator.example;

import refactoring_guru.iterator.example.profile.Profile;
import refactoring_guru.iterator.example.social_networks.Facebook;
import refactoring_guru.iterator.example.social_networks.LinkedIn;
import refactoring_guru.iterator.example.social_networks.SocialNetwork;
import refactoring_guru.iterator.example.spammer.SocialSpammer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {
  private static final Scanner scanner = new Scanner(System.in);
  private static final String ANNA_EMAIL = "anna.smith@bing.com";

  public static void main(String[] args) {
    System.out.println("Please specify the social network to target the spam tool (default: Facebook):");
    System.out.println("1. Facebook");
    System.out.println("2. LinkedIn");
    String choice = scanner.nextLine();

    SocialNetwork network = (choice.equals("2")) ? new LinkedIn(createTestProfiles()) : new Facebook(createTestProfiles());

    SocialSpammer spammer = new SocialSpammer(network);
    spammer.sendSpamToFriends(ANNA_EMAIL,
            "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
    spammer.sendSpamToCoworkers(ANNA_EMAIL,
            "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
  }

  @SuppressWarnings("all")
  private static List<Profile> createTestProfiles() {
    List<Profile> data = new ArrayList<>();
    data.add(createProfile(ANNA_EMAIL, "Anna Smith", "friends", "mad_max@ya.com", "catwoman@yahoo.com", "coworkers", "sam@amazon.com"));
    data.add(createProfile("mad_max@ya.com", "Maximilian", "friends", ANNA_EMAIL, "coworkers", "sam@amazon.com"));
    data.add(createProfile("bill@microsoft.eu", "Billie", "coworkers", "avanger@ukr.net"));
    data.add(createProfile("avanger@ukr.net", "John Day", "coworkers", "bill@microsoft.eu"));
    data.add(createProfile("sam@amazon.com", "Sam Kitting", "coworkers", ANNA_EMAIL, "mad_max@ya.com", "friends", "catwoman@yahoo.com"));
    data.add(createProfile("catwoman@yahoo.com", "Liza", "friends", ANNA_EMAIL, "sam@amazon.com"));
    return data;
  }

  private static Profile createProfile(String email, String name, String... contacts) {
    Map<String, List<String>> contactMap = new HashMap<>();
    for (int i = 0; i < contacts.length; i += 2) {
      var contactType = contacts[i];
      var contactEmail = contacts[i + 1];
      contactMap.merge(contactType, new ArrayList<>(Collections.singletonList(contactEmail)), (oldList, newList) -> {
        oldList.addAll(newList);
        return oldList;
      });
    }
    return new Profile(email, name, contactMap);
  }
}
