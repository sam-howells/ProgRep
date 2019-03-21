import java.io.IOException;

public class MainServerMulti {


    public static void main(String args[]) throws IOException {
        ServerTcpEchoMulti servtcp = new ServerTcpEchoMulti(5);
        servtcp.connexion();
    }
}
