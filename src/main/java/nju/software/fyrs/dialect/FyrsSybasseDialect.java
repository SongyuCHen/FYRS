package nju.software.fyrs.dialect;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SybaseDialect;

public class FyrsSybasseDialect extends SybaseDialect
{
   public FyrsSybasseDialect()
   {
	   super();
	   registerHibernateType(Types.LONGVARCHAR,Hibernate.TEXT.getName());
	   registerHibernateType(Types.CHAR,Hibernate.STRING.getName());
	   registerHibernateType(Types.LONGVARBINARY,Hibernate.BLOB.getName());
   }
}
