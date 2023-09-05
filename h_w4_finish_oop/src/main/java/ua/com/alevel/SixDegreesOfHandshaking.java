package ua.com.alevel;

public class SixDegreesOfHandshaking {
    public static void main(String[] args) {
        Person[] people = createPeople(6);
        simulateHandshaking(people);
    }

    private static Person[] createPeople(int count) {
        Person[] people = new Person[count];
        for (int i = 0; i < count; i++) {
            people[i] = new Person("Персона " + (i + 1));
        }
        return people;
    }

    private static void simulateHandshaking(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            people[i].sendMessage(people[i + 1]);
        }

        while (!people[5].hasReceivedMessage()) {
            // Continue simulating until the 6th person receives a message.
            for (int i = 0; i < people.length - 1; i++) {
                people[i].sendMessage(people[i + 1]);
            }
        }
    }
}