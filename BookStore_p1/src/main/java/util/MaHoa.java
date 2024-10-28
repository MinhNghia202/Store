package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
	public static String toSHA1(String password)
	{
		String str = "nfjskfjfielfnmjkeoalmdnujw";
		String result = null;
		
		password = password + str;
		
		try {
			byte[] dataByte = password.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataByte));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(toSHA1("123452"));
	}
}
