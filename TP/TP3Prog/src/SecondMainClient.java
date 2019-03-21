import java.io.IOException;

public class SecondMainClient {
    public static void main(String args[]) throws IOException {
        ClientTcpEcho clientest2=new ClientTcpEcho("127.0.0.1",64000);
        clientest2.lancerBW();
    }
}

