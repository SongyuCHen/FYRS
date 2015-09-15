package nju.software.fyrs.service.model;

import java.util.List;

/**
 * ��ҳ��
 * @param <T>
 */
public class Pager<T>
{
    /**
     * ��ҳ��С
     */
    private int size;
    /**
     * ��ҳ����ʼҳ,Ҳ��ʾ��ǰ�ǵڼ�ҳ
     */
    private int offset;
    /**
     * �ܼ�¼
     */
    private long total;
    /**
     * ��ҳ������
     */
    private List<T> datas;
    /**
     * һ���ж���ҳ
     */
    private int totalPages;

    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int pagers)
    {
        this.totalPages = pagers;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<T> getDatas()
    {
        return datas;
    }

    public void setDatas(List<T> datas)
    {
        this.datas = datas;
    }
}
