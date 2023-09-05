package ua.com.alevel;

class Person {
    private final String name;
    private boolean receivedMessage = false;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasReceivedMessage() {
        return receivedMessage;
    }

    public void sendMessage(Person receiver) {
        if (!receivedMessage) {
            System.out.println(name + " отправила сообщение  " + receiver.getName());
            receiver.receiveMessage();
        } else {
            System.out.println(name + " получила сообщение.");
        }
    }

    public void receiveMessage() {
        System.out.println(name + " получила сообщение.");
        receivedMessage = true;
    }
}