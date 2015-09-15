package nju.software.fyrs.data.dao;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;

public class DaoUtils {
   public static int getMaxId(Session session,String hql)
   {
		Query query = session.createSQLQuery(hql);
		Object object = query.uniqueResult();
		int maxBh = 1;
		if(null != object)
		{
			maxBh = (Integer)object;
		}
		return maxBh;
   }
   /**
    * ���ص� N_ID �Ѿ������� 1������� 0 Ĭ�ϴ� 1 ��ʼ 510000000001 ���磺��Ժ 51
    * @param session
    * @param fydm
    * @param hql
    * @return
    */
   public static BigDecimal getMaxIdRyjbxx(Session session,int fydm,String hql)
   {
//	   try
//	   {
//		   System.out.println(session.connection().getMetaData().getURL());
//	   }
//	   catch(Exception ex)
//	   {
//		   ex.printStackTrace();
//	   }
	   
		Query query = session.createSQLQuery(hql);
		Object object = query.uniqueResult();
		BigDecimal maxBh = BigDecimal.valueOf(fydm,-10).add(BigDecimal.valueOf(1));
		if(null != object)
		{
			maxBh = (BigDecimal)object;
			maxBh = maxBh.add(BigDecimal.valueOf(1));
		}
        return maxBh;
   }
   public static BigDecimal getMaxIdBigDecimal(Session session,String hql)
   {
//	   try
//	   {
//		   System.out.println(session.connection().getMetaData().getURL());
//	   }
//	   catch(Exception ex)
//	   {
//		   ex.printStackTrace();
//	   }
	   
		Query query = session.createSQLQuery(hql);
		Object object = query.uniqueResult();
		BigDecimal maxBh = BigDecimal.valueOf(1);
		if(null != object)
		{
			maxBh = (BigDecimal)object;
			maxBh = maxBh.add(BigDecimal.valueOf(1));
		}
		return maxBh;
   }
   /**
    * ��Խ�������Ƶ� ID
    * @param session
    * @param fydm
    * @param hql
    * @return
    */
   public static BigDecimal getMaxIdBeginFydmBigDecimal(Session session,int fydm,String hql,Object[] parameters)
   {	   
		Query query = session.createSQLQuery(hql);
		for(int i = 0; i < parameters.length; i++)
		{
			query.setParameter(i, parameters[i]);
		}
		Object object = query.uniqueResult();
		BigDecimal maxBh = BigDecimal.valueOf(fydm,-11).add(BigDecimal.valueOf(1));
		if(null != object)
		{
			BigDecimal temp = (BigDecimal)object;
			if(temp.compareTo(maxBh) < 0)
			{
				return maxBh;
			}
			maxBh = temp.add(BigDecimal.valueOf(1));
		}
        return maxBh;
   }
}
