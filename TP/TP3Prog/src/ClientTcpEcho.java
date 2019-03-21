import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.BufferOverflowException;

public class ClientTcpEcho {
    public int port;
    public String hostname;
    private Socket socket = new Socket();

    public ClientTcpEcho(String hostname,int port) throws IOException {
        this.port = port;
        this.hostname = hostname;
        socket.connect(new InetSocketAddress(hostname,port));
    }

    public void lancerBW() throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        String message = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        try {
            message = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!message.equals("stop")){


            out.write(message);
            out.newLine();
            out.flush();
            System.out.println(
                    in.readLine().toUpperCase()
            );
            try {
                message = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        in.close();
        out.close();
        reader.close();
        socket.close();
    }

}
