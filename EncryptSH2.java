import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class EncryptSH2{

	public static void main(String[] args){
		try{
			Scanner in = new Scanner(System.in);
			String password = in.next();

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[]messageDigest = md.digest(password.getBytes("UTF-8"));
			
			StringBuilder strHex = new StringBuilder();
			for(byte b: messageDigest){
				strHex.append(String.format("%02X", 0xFF & b));
			}

			if(password.equals("pw")){
				password = strHex.toString();
				System.out.println(password);	
			}
			
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch (UnsupportedEncodingException ie){
			ie.printStackTrace();
		}
	}
}

