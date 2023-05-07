package behavioral.mediator.chatroom;

public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoomMediator chatRoom = new ChatRoom();
        User user1 = new User("John", chatRoom);
        User user2 = new User("Bob", chatRoom);
        User user3 = new User("Alice", chatRoom);

        user1.sendMessage("Hi all");
        user2.sendMessage("Hey John, what's up?");
        user3.sendMessage("Hello everyone!");
    }
}
