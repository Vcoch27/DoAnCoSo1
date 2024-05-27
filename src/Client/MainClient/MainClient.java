package Client.MainClient;

import java.io.*;
import java.net.Socket;

public class MainClient {
    private String hostname;
    private int port;
    private Socket socket;
    public DataOutputStream dataOutput;
    public DataInputStream dataInput;
    public ObjectOutputStream objectOutput;
    public ObjectInputStream objectInput;

    public MainClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(hostname, port);

        OutputStream output = socket.getOutputStream();
        dataOutput = new DataOutputStream(output);
        objectOutput = new ObjectOutputStream(output);

        InputStream input = socket.getInputStream();
        dataInput = new DataInputStream(input);
        objectInput = new ObjectInputStream(input);
    }

    public void disconnect() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }

    public void sendString(String message) throws IOException {
        dataOutput.writeUTF(message);
    }

    public String receiveString() throws IOException {
        return dataInput.readUTF();
    }

    public void sendInt(int number) throws IOException {
        dataOutput.writeInt(number);
    }

    public int receiveInt() throws IOException {
        return dataInput.readInt();
    }

    public void sendDouble(double number) throws IOException {
        dataOutput.writeDouble(number);
    }

    public double receiveDouble() throws IOException {
        return dataInput.readDouble();
    }

    public void close() throws IOException {
        try {
            if (dataOutput != null) {
                dataOutput.close();
            }
            if (dataInput != null) {
                dataInput.close();
            }
            if (objectOutput != null) {
                objectOutput.close();
            }
            if (objectInput != null) {
                objectInput.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Error closing resources: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


//    static class MyObject implements Serializable {
//        private String name;
//        private int value;
//
//        public MyObject(String name, int value) {
//            this.name = name;
//            this.value = value;
//        }
//
//        @Override
//        public String toString() {
//            return "MyObject{name='" + name + "', value=" + value + "}";
//        }
//    }
//    public boo
}
