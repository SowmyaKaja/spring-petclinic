package org.springframework.samples.petclinic.detect;

import org.springframework.web.client.RestTemplate;

public class IpLookup {

	public Result giveDetails(String ipAddress) {
//		String uri = "http://api.ipaddress.com/iptocountry?format=json&ip=" + ipAddress + "&language=en";
		String uri = "http://ipwho.is/" + ipAddress;
		System.out.println("URL is: " + uri);
		RestTemplate restTemplate = new RestTemplate();
//		WebResult result = restTemplate.getForObject(uri, WebResult.class);
		Result result = restTemplate.getForObject(uri, Result.class);
		String resp = restTemplate.getForObject(uri, String.class);
		System.out.println("Response: " + resp);
//		System.out.println("Result: " + result);
		return result;
	}
}
