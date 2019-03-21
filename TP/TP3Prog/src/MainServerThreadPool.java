import java.io.IOException;

public class MainServerThreadPool {
    public static void main(String args[]) throws IOException {
        ServerTcpEchoPool servtcp = new ServerTcpEchoPool(500);
        servtcp.connexion();
    }
}
