/**
 * created by 2010-7-2
 */
package nju.software.fyrs.service.sign;
import java.security.SignatureException;

/**
 * @author zym
 *
 */
public class SignatureTest {
	public static void main(String args[]) throws SignatureException{
		Signature sign = new MD5Signature();
		boolean s = sign.check("ah=(2010)service=getAjxx", "aeddbcd8213424ef93ac107f7d795c2a", SignKey.KEY, "UTF-8");
		
		String signStr = sign.sign("ah=(2009)153&service=getAjxx",SignKey.KEY, "UTF-8");
	
		System.out.println(s);
		System.out.println(signStr);
	}
}
