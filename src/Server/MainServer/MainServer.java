package Server.MainServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Controller.ControlDanhPhap.ControllerMucDanhPhap;
import Controller.ControlDanhPhap.ForNguyenTo;
import Controller.ControlUser.LoginUser;
import Controller.ControlUser.RegisterUser;
import Model.ElementDanhPhapHoaHoc;
import Model.ElementMucDanhPhap;
import Model.ElementNguyenTo;
import Model.PairModel;
import Model.User;

public class MainServer {
	public static void main(String[] args) {
		int port = 12345;
		ConnectionManager connectionManager = new ConnectionManager();

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server is listening on port " + port);

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("New client connected: " + socket);

				ServerThread serverThread = new ServerThread(socket, connectionManager);
				connectionManager.addClient(serverThread);
				serverThread.start();
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}

class ServerThread extends Thread {
	private Socket socket;
	private ConnectionManager connectionManager;
	private DataInputStream dataInput;
	private DataOutputStream dataOutput;
	private ObjectInputStream objectInput;
	private ObjectOutputStream objectOutput;

	public ServerThread(Socket socket, ConnectionManager connectionManager) {
		this.socket = socket;
		this.connectionManager = connectionManager;
		try {
			dataInput = new DataInputStream(socket.getInputStream());
			dataOutput = new DataOutputStream(socket.getOutputStream());
			objectInput = new ObjectInputStream(socket.getInputStream());
			objectOutput = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("Error setting up streams: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			String text;
			while ((text = dataInput.readUTF()) != null) {
				handleSignal(text);
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connectionManager.removeClient(this);
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// TASK1 : for login

	private void handleSignal(String signal) throws IOException, ClassNotFoundException {
		switch (signal) {
		case "START":
			System.out.println("oke");
			dataOutput.writeUTF("Start server");
			break;
		case "ACCOUNT":
			System.out.println("nhan duoc tin hieu Account");
			performForAccount();
			break;
		case "BTH":
			performBTH();
			break;
		case "DANHPHAP":
			performDP();
			break;
		case "POST":
			performCD();
			break;
		case "DISCONNECT":
			disconnect();
			break;
		default:
//                writer.println("Unknown signal: " + signal);
		}
	}

	private void disconnect() {
		// Xử lý ngắt kết nối
//        writer.println("Disconnecting...");
		System.out.println("Client disconnected");
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	private void performForAccount() throws IOException, ClassNotFoundException {
		//nhận tín hiệu là sẽ là, gì trong phần đăng nhập
		String signalAccount = dataInput.readUTF();
		switch (signalAccount) {
		case "LOGIN": {
			PairModel<String, String> account = (PairModel) objectInput.readObject();
			System.out.println("done nhan pair");
			User u = LoginUser.login(account.getKey(), account.getValue());
			objectOutput.writeObject(u);
			objectOutput.flush();
			break;
		}
		case "REGISTERMail":{
			String mail = dataInput.readUTF();	
			if(RegisterUser.checkMail(mail)) {
				dataOutput.writeUTF("OUT");
			}else {
				dataOutput.writeUTF("DONE");
				String codeVerification = RegisterUser.sentVari(mail);
				System.out.println(codeVerification);
				dataOutput.writeUTF(codeVerification);
			}
			break;
		}
		case "REGISTER":{
			User u = (User) objectInput.readObject();
			if(RegisterUser.addUser(u)) {
				dataOutput.writeUTF("DONE");
				
			}else {
				dataOutput.writeUTF("ACCEXISTS");
			}
			break;
		}
		case "AVATAR": {
			User avt = (User) objectInput.readObject();
			System.out.println("nhân được avt");
			String mail = dataInput.readUTF();
			System.out.println("nhan duocj mail");
			
			if(RegisterUser.updateAvt(mail,avt.getAvatar())) {
				
				dataOutput.writeUTF("DONE");
				System.out.println("done");
			}else {
				dataOutput.writeUTF("FALSE");
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + signalAccount);
		}
		System.out.println("ACCOUNT executed");
	}

	private void performBTH() throws IOException, ClassNotFoundException {
		String s = dataInput.readUTF();
		switch (s) {
		case "GETNT": {
			int soHieu = (int) objectInput.readObject();
			System.out.println("so hieu : "+soHieu);
			ElementNguyenTo nt = ForNguyenTo.getNguyenTo(soHieu);
			if(nt!=null) {
				dataOutput.writeUTF("DONE");
				objectOutput.writeObject(nt);
			}else {
				dataOutput.writeUTF("OUT");
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + s);
		}
		System.out.println("Task 2 executed");
	}

	private void performDP() throws IOException {
		String s = dataInput.readUTF();
		switch (s) {
		case "GETDP": {
			String codeMdp = dataInput.readUTF();
			ElementMucDanhPhap eMDP = ControllerMucDanhPhap.getMucDanhPhap(codeMdp);
			if(eMDP!=null) {
				dataOutput.writeUTF("DONE");
				objectOutput.writeObject(eMDP);
				ArrayList<ElementDanhPhapHoaHoc> l = ControllerMucDanhPhap.getListDanhPhap(codeMdp);
				objectOutput.writeObject(l);
			}else {
				dataOutput.writeUTF("OUT");
				System.out.println("out");
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + s);
		}
		System.out.println("Task 3 executed");
	}
	private void performCD() throws IOException {
		String s = dataInput.readUTF();
		switch (s) {
		case "GETTOP": {
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + s);
		}
	}

}

class ConnectionManager {
	private List<ServerThread> clients;

	public ConnectionManager() {
		clients = new CopyOnWriteArrayList<>();
	}

	public void addClient(ServerThread client) {
		clients.add(client);
		System.out.println("Added client: " + client.getSocket());
	}

	public void removeClient(ServerThread client) {
		clients.remove(client);
		System.out.println("Removed client: " + client.getSocket());
	}

	public List<ServerThread> getClients() {
		return clients;
	}
}
