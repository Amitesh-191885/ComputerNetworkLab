import java.io.PrintStream;
import java.util.Scanner;
/**
 * 	Write a program to calculate checksum based on the given binary strings of 8 bits (data) 
 * 	which is sent with the data as redundant bits. This data + checksum is received at receiver
 * 	end and checksum is calculated again,if checksum is 0 it means no error in data received, 
 * 	else there exists some error in the received data.
 */
/**
 * @author Amitesh Ranjan
 *         Roll 191885
 */
public class CheckSum {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PrintStream stream = new PrintStream(System.out);

		char[] ain = new char[30], bin = new char[30];
		char[] sum = new char[30], complement = new char[30];
		int i;
		
		System.out.print("Enter Input Binary String: ");
		ain = scan.next().toCharArray();

		System.out.print("Enter Output received binary string: ");
		bin = scan.next().toCharArray();

		if(ain.length==bin.length)
		{
			char carry = '0';
			int length = ain.length;

			for(i=length-1; i>=0; i--)
			{
				if(ain[i]=='0' && bin[i]=='0' && carry=='0')
				{
					sum[i]='0';
					carry='0';
				}

				else if(ain[i]=='0' && bin[i]=='0' && carry=='1')
				{
					sum[i]='1';
					carry='0';
				}

				else if(ain[i]=='0' && bin[i]=='1' && carry=='0')
				{
					sum[i]='1';
					carry='0';
				}

				else if(ain[i]=='0' && bin[i]=='1' && carry=='1')
				{
					sum[i]='0';
					carry='1';
				}

				else if(ain[i]=='1' && bin[i]=='0' && carry=='0')
				{
					sum[i]='1';
					carry='0';
				}
				
				else if(ain[i]=='1' && bin[i]=='0' && carry=='1')
				{
					sum[i]='0';
					carry='1';
				}

				else if(ain[i]=='1' && bin[i]=='1' && carry=='0')
				{
					sum[i]='0';
					carry='1';
				}

				else if(ain[i]=='1' && bin[i]=='1' && carry=='1')
				{
					sum[i]='1';
					carry='1';
				}

				else break;
			}
			System.out.printf("Sum=%c",carry);
			stream.println(sum);
            stream.flush();

			for(i=0; i<length; i++)
			{
				if(sum[i]=='0') complement[i]='1';
				else complement[i]='0';
			}

			if(carry=='1') carry='0';
        	else carry='1';
			
			System.err.print("CheckSum: ");
			stream.print(complement);
			stream.flush();

		}
		else {
			System.err.println("\nWrong input strings");
		}
	}
}
