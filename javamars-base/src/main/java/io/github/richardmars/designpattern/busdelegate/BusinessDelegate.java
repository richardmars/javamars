package io.github.richardmars.designpattern.busdelegate;

public class BusinessDelegate {
	private BusinessLookUp lookupService = new BusinessLookUp();
	private BusinessService businessService;
	private String serviceType;
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public void doTask() {
		businessService = lookupService.getBusineseService(this.serviceType);
		businessService.doProcessing();
	}
}

