/**
 * created by 2010-11-4
 */
package nju.software.fyrs.dynamicds;

/**
 * @author HBG
 *
 */
public class CustomerContextHolder {
	
	@SuppressWarnings("rawtypes")
	private static final ThreadLocal contextHolder = new ThreadLocal();  
      
    @SuppressWarnings("unchecked")
	public static void setCustomerType(String customerType) {  	
    	contextHolder.set(customerType);  
    }  
      
    public static String getCustomerType() {  
    	return (String) contextHolder.get();  
    }  
      
    public static void clearCustomerType() {  
    	contextHolder.remove();  
    }  
  
}
