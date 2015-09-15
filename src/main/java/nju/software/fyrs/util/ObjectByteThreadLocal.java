package nju.software.fyrs.util;
/**
 * ������ŵ�ǰ�߳���Ҫ���µĶ�������Ӧ�ľɶ�����ֽ�
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
