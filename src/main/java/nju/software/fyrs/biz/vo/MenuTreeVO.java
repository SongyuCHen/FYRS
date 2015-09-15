package nju.software.fyrs.biz.vo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nju.software.fyrs.data.dataobject.Menu;
@SuppressWarnings("rawtypes")
public class MenuTreeVO
{
   private String data;
   
private Map attr = new HashMap();
   private List<MenuTreeVO> children = null;
   @SuppressWarnings("unchecked")
public MenuTreeVO(Menu menu)
   {
       this.data = menu.getMenuName();
       this.attr.put("id",menu.getId());

       Set<Menu> ms = menu.getMenus();
       if(ms != null && ms.size() > 0)
       {
           this.children = new ArrayList<MenuTreeVO>();
           for(Menu m : ms)
           {
               this.children.add(new MenuTreeVO(m));
           }
       }
   }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public Map getAttr()
    {
        return attr;
    }

    public void setAttr(Map attr)
    {
        this.attr = attr;
    }

    public List<MenuTreeVO> getChildren()
    {
        return children;
    }

    public void setChildren(List<MenuTreeVO> children)
    {
        this.children = children;
    }
}
