/*
 * By: Amitesh Ranjan
 * Roll: 191885
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientChat {

	public static void main(String[] args) throws IOException{
		String strIn,strOut="";
		Socket conSoc = new Socket("127.0.0.1",440); //Valid port number between 0 - 65535
		
		
		BufferedReader BufRead = new BufferedReader(new InputStreamReader(System.in));
		
		DataInputStream DataInStream =  new DataInputStream(conSoc.getInputStream());
		DataOutputStream DataOutStream = new DataOutputStream(conSoc.getOutputStream());
		
		while(!strOut.equals("Bye")) {
			System.out.print("Me: ");
			strOut = BufRead.readLine();
			DataOutStream.writeUTF(strOut);
			DataOutStream.flush();
			strIn=DataInStream.readUTF();
			System.out.println("SERVER: "+strIn);
		}
		
		conSoc.close();
	}

}
