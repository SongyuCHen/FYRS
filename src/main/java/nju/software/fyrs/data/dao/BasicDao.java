package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.service.model.Pager;
import nju.software.fyrs.service.model.PagerContext;

import org.hibernate.Query;
import org.hibernate.Session;

public class BasicDao<T> {
	private Session session;
    public BasicDao(Session session)
    {
    	this.session = session;
    }
    public Pager<T> pageList(String hql, Object[] args)
    {
    	 /**
         * �Ѿ��Ƿ��ص�ֵ�����޸�
         */
        hql = initSqlSort(hql);
        Query query = session.createQuery(hql);
        setParematers(query,args);
        /**
         * ���÷�ҳ����
         */

        Pager<T> pages = new Pager<T>();
        setPageSizes(query,pages);
        /**
         * ����б�
         */
        @SuppressWarnings("unchecked")
		List<T> datas = query.list();
        pages.setDatas(datas);
        /**
         * �������
         */
        String countHql = getCountHql(hql,true);
        Query queryCount = session.createQuery(countHql);
        setParematers(queryCount,args);
        long total = (Long)queryCount.uniqueResult();
        pages.setTotal(total);
        return pages;
    }
    public Pager<T> pageList(String hql, Object args)
    {
    	return pageList(hql, new Object[]{args});
    }

    public Pager<T> pageList(String hql)
    {
        return this.pageList(hql,null);
    }
    /**
     * ֻ�Ƿ�������������ȡ����ʼ�� hql
     * @param hql
     * @return
     */
    private String initSqlSort(String hql)
    {
        String order = PagerContext.getOrder();
        String sort = PagerContext.getSort();
        if(sort != null && !"".equals(sort.trim()))
        {
            hql += " order by " + sort;
            if(!"desc".equals(order))
            {
                hql += " asc ";
            }
            else
            {
                hql += " desc ";
            }
        }
        return hql;
    }
    /**
     * �Զ������ò����ķ���
     * @param query
     * @param args
     */
    private void setParematers(Query query,Object[] args)

    {
        if(args != null && args.length > 0)
        {
            int index = 0;
            for(Object arg : args)
            {
                query.setParameter(index++,arg);
            }
        }
    }
    /**
     * ���÷�ҳ����
     * @param query
     */
    @SuppressWarnings("rawtypes")
	private void setPageSizes(Query query,Pager pages)
    {
        Integer pageSize = PagerContext.getPageSize();
        Integer pageOffset = PagerContext.getPageOffset();
        if(pageOffset == null || pageOffset < 0)
        {
            pageOffset = 0;
        }
        if(pageSize == null || pageSize < 0)
        {
            pageSize = 15;
        }
        pages.setOffset(pageOffset);
        pages.setSize(pageSize);
        /**
         * Hibernate ��װ�ķ�ҳ��ѯ
         */
        query.setFirstResult(pageOffset).setMaxResults(pageSize);
    }
    /**
     * ƴ�ӻ�������� hql ���
     * @param hql
     * @return
     */
    private String getCountHql(String hql,boolean isHql)
    {
        String behind_from = hql.substring(hql.indexOf("from"));
        String returnSql = "SELECT count(*) " + behind_from;
        /**
         * ȡ�� fetch
         */
        if(isHql)
        {
            return returnSql.replaceAll("fetch","");
        }
        return returnSql;
    }
}
