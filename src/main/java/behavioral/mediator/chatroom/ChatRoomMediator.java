package behavioral.mediator.chatroom;

public interface ChatRoomMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
