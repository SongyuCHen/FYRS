/**
 * created by 2010-6-28
 */
package nju.software.fyrs.service.sign;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import nju.software.fyrs.util.MD5;
import nju.software.fyrs.util.StringUtil;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * MD5签名工具的实现
 * @author zym
 *
 */
public class MD5Signature implements Signature {
	
	Log logger = LogFactory.getLog(MD5Signature.class);

	/* (non-Javadoc)
	 * @see nju.edu.software.cooperate.sign.Signature#sign(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String sign(String content, String privateKey, String charset) throws SignatureException {
		if (StringUtil.isBlank(privateKey)) {
            throw new SignatureException("privateKey is null!");
        }
        String tosign;
        if (content == null)
            tosign = privateKey;
        else
            tosign = content + privateKey;
        try {
            String sign = DigestUtils.md5Hex(tosign.getBytes(charset));

            logger.info("MD5签名[content = " + tosign + "; charset = " + charset + "]结果：" + sign);

            return sign;
        } catch (UnsupportedEncodingException e) {
            throw new SignatureException("Unsupported Encoding" + e);
        }
	}

	/* (non-Javadoc)
	 * @see nju.edu.software.cooperate.sign.Signature#check(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean check(String content, String signature, String publicKey,
			String charset) throws SignatureException {
		/*if (StringUtil.isBlank(content) || StringUtil.isBlank(publicKey)
	            || StringUtil.isBlank(signature)) {

	            throw new SignatureException("content or publicKey or signature is null!");
	        }*/

	        String tosign = content;

	        String mySign = MD5.getMD5(tosign.getBytes());

			boolean verify = false;
			if (mySign.equals(signature)) {
			    verify = true;
			}

			logger.info("MD5验证签名[content = " + content + "; charset = " + charset
			            + "; signature = " + signature + "]" + (verify ? "通过" : "失败"));

			return verify;
	}

	
}
