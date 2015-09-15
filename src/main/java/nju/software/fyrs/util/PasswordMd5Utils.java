package nju.software.fyrs.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordMd5Utils
{
   public static String generatorPassword(String oldPassword) throws Exception
   {
       MessageDigest md = MessageDigest.getInstance("MD5");
       md.update(oldPassword.getBytes());
       BigInteger bi = new BigInteger(1,md.digest());
       // 以十六进制输出
       return bi.toString(16);
   }
}
