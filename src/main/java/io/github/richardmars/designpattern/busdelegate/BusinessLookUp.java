package io.github.richardmars.designpattern.busdelegate;

public class BusinessLookUp {
	public BusinessService getBusineseService(String serviceType) {
		if (serviceType.equalsIgnoreCase("EJB")) {
			return new EJBService();
		} else {
			return new JMSService();
		}
	}
}
