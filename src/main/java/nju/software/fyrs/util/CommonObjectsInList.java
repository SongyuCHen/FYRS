package nju.software.fyrs.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonObjectsInList<T> {
   /**
    * 找出两个集合当中两个相同的对象
    * @param t1
    * @param t2
    * @return
    */
   public  List<T> commonObjects(List<T> t1,List<T> t2)
   {
	   Set<T> sets = new HashSet<T>();
	   for(T t_1 : t1)
	   {
		   for(T t_2 : t2)
		   {
			   if(t_1.equals(t_2))
			   {
				   sets.add(t_1);
				   continue;
			   }
		   }
	   }
	   t1.clear();
	   t1.addAll(sets);
	   return t1;
   }
   /**
    * 找出一个多个集合当中的相同对象
    * @param lists
    * @return
    */
   public List<T> commonObjects(List<List<T>> lists)
   {
	  if(lists.size() == 0)
	  {
		  return new ArrayList<T>();
	  }
	  if(lists.size() == 1)
	  {
		  return lists.get(0);
	  }
	  if(lists.size() == 2)
	  {
		 return  this.commonObjects(lists.get(0),lists.get(1));
	  }
	  List<T> temp = this.commonObjects(lists.get(0),lists.get(1));
	  for(int i = 2; i < lists.size(); i++)
	  {
		  if(temp.size() == 0)
		  {
			  return temp;  
		  }
		  temp = this.commonObjects(temp,lists.get(i));  
	  }
	  return temp;
   }
}
