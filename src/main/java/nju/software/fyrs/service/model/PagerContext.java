package nju.software.fyrs.service.model;

/**
 * ���ݷ�ҳ�� ThreadLocal
 */
public class PagerContext
{
    /**
     * ҳ�Ĵ�С
     */
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    /**
     * ҳ����ʼ
     */
    private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
    /**
     * �б�������ֶ�
     */
    private static ThreadLocal<String> sort = new ThreadLocal<String>();
    /**
     * ������ǽ���
     */
    private static ThreadLocal<String> order = new ThreadLocal<String>();

    public static Integer getPageSize()
    {
        return pageSize.get();
    }

    public static void setPageSize(Integer mpageSize)
    {
        pageSize.set(mpageSize);
    }

    public static Integer getPageOffset()
    {
        return pageOffset.get();
    }

    public static void setPageOffset(Integer mpageOffset)
    {
        pageOffset.set(mpageOffset);
    }

    public static String getSort()
    {
        return sort.get();
    }

    public static void setSort(String msort)
    {
        sort.set(msort);
    }

    public static String getOrder()
    {
        return order.get();
    }

    public static void setOrder(String morder)
    {
       order.set(morder);
    }
    public static void removePageSize()
    {
        pageSize.remove();
    }
    public static void removePageOffset()
    {
        pageOffset.remove();
    }
    public static void removeSort()
    {
        sort.remove();
    }
    public static void removeOrder()
    {
        order.remove();
    }

}
