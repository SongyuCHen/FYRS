/**
 * created by 2010-11-4
 */
package nju.software.fyrs.dynamicds;

import nju.software.fyrs.service.model.UserContext;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author HBG
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	
	@Override
	protected Object determineCurrentLookupKey() {
		/**
		 * Ϊ�˱���״̬,����ʹ�� ThreadLocal
		 */
		UserContext userContext = UserContextHolder.getUserContext();
	    if(userContext == null)
	    {
	    	System.out.println("this method invoke when ?+"+ "fyrs");
	    	return "fyrs";
	    }
	    else
	    {
	        System.out.println("this method invoke when ?+"+userContext.getCurrentDataSource());
	    	return userContext.getCurrentDataSource();
	    }
	}
}
