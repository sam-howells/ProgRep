import java.io.IOException;

public class MainServer {


    public static void main(String args[]) throws IOException {
        ServeurTcpEcho servtcp = new ServeurTcpEcho(5,64000);
        servtcp.connexion();
    }
}
