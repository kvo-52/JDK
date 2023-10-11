import client.ClientGUI;
import server.ServerView;


public class Main {
    public static void main(String[] args) {
        ServerView serverWindow = new ServerView();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}