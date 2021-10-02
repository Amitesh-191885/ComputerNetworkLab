/*
 * By: Amitesh Ranjan
 * Roll: 191885
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class CliGetDateandTime {

	public static void main(String[] args) throws IOException {
		System.out.println("Connecting to server....");
		Socket sc = new Socket("127.0.0.1",84); 
		
		/* IP Address of server and port number 
		 * any number which is used in server.
		 * Between 0 to 65535
		*/
		
		/* BufferedReader Reads text from a character-input stream, 
		 * buffering characters so as to provide 
		 * for the efficient reading of characters, arrays, and lines.
		 * It's default size is enough to read strings.
		 */
		
		System.out.println("Connected.");
		BufferedReader Buf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		System.out.println(Buf.readLine());
		sc.close();
	}
}