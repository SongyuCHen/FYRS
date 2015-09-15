package nju.software.fyrs.service.model;

import java.util.List;

/**
 * 分页类
 * @param <T>
 */
public class Pager<T>
{
    /**
     * 分页大小
     */
    private int size;
    /**
     * 分页的起始页,也表示当前是第几页
     */
    private int offset;
    /**
     * 总记录
     */
    private long total;
    /**
     * 分页的数据
     */
    private List<T> datas;
    /**
     * 一共有多少页
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
