package nju.software.fyrs.util;
/**
 * 用来存放当前线程需要更新的对象所对应的旧对象的字节
 */
public class ObjectByteThreadLocal {
  private static ThreadLocal<byte[]> objectByte = new ThreadLocal<byte[]>();
  public static byte[] getObjectByte()
  {
	  return objectByte.get();
  }
  public static void setObjectByte(byte[] mObjectByte)
  {
	  objectByte.set(mObjectByte);
  }
  public static void remove()
  {
	  objectByte.remove();
  }
}
