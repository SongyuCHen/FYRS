package nju.software.fyrs.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializedUtils {
  /**
   * ��һ���������л����ڴ�
   * @param object
   * @return
   * @throws Exception
   */
  public static byte[] writeObjectToMemory(Object object) throws Exception
  {
	  ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	  ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	  objectOutputStream.writeObject(object);
	  byteArrayOutputStream.toByteArray();
	  byte[] result = byteArrayOutputStream.toByteArray();
	  if(null != objectOutputStream)
	  {
		  objectOutputStream.close();
	  }
	  if(null != byteArrayOutputStream)
	  {
		  byteArrayOutputStream.close();
	  }
	  return result;
  }
  /**
   * ���ڴ��ж�ȡ��һ������
   * @param objectByte
   * @return
   * @throws Exception
   */
  public static Object  readObjectFromMemory(byte[] objectByte) throws Exception
  {
	  ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(objectByte);
	  ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
	  Object obj = objectInputStream.readObject();
	  if(null != objectInputStream)
	  {
		  objectInputStream.close();
	  }
	  if(null != byteArrayInputStream)
	  {
		  byteArrayInputStream.close();
	  }
	  return obj;
  }
}

