
# Chat Room Application
In a chat room, multiple users can send messages to each other. Instead of directly communicating with each other, users send messages to a central mediator, which then distributes the messages to the intended recipients. This way, users are not dependent on each other, and the mediator handles the communication between them.
```java
interface ChatRoomMediator {
    public void sendMessage(String message, User user);
    public void addUser(User user);
}
 
class ChatRoom implements ChatRoomMediator {
    private List<User> users;
 
    public ChatRoom() {
        this.users = new ArrayList<>();
    }
 
    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
 
    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
 
class User {
    private String name;
    private ChatRoomMediator chatRoom;
 
    public User(String name, ChatRoomMediator chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
        chatRoom.addUser(this);
    }
 
    public void sendMessage(String message) {
        chatRoom.sendMessage(message, this);
    }
 
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}
 
public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoomMediator chatRoom = new ChatRoom();
        User user1 = new User("John", chatRoom);
        User user2 = new User("Bob", chatRoom);
        User user3 = new User("Alice", chatRoom);
 
        user1.sendMessage("Hi all!");
        user2.sendMessage("Hey John, what's up?");
        user3.sendMessage("Hello everyone!");
    }
}
```
The `ChatRoom` class acts as the mediator, which receives messages from each user and distributes them to all the other users in the chat room. The `User` class represents the users in the chat room and communicates with the mediator to send and receive messages.

By using the Mediator design pattern, we are able to decouple the communication between users in the chat room, and instead, rely on the mediator to handle the communication. This makes it easier to manage and scale the chat room application, as all communication flows through a single point of contact (the mediator).