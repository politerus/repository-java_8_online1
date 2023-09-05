package ua.com.alevel;

public class SixDegreesOfHandshaking {
    public static void main(String[] args) {
        Person[] people = createPeople();
        simulateHandshaking(people);
    }

    private static Person[] createPeople() {
        Person[] people = new Person[6];
        for (int i = 0; i < 6; i++) {
            people[i] = new Person("Персона " + (i + 1));
        }
        return people;
    }

    private static void simulateHandshaking(Person[] people) {
        for (int i = 0; i < people.length - 1; i++) {
            people[i].sendMessage(people[i + 1]);
        }

        while (!people[5].hasReceivedMessage()) {
            // продолжает пока 6 персона  не получит сообщение
            for (int i = 0; i < people.length - 1; i++) {
                people[i].sendMessage(people[i + 1]);
            }
        }
    }
}