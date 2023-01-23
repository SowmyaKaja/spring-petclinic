package org.springframework.samples.petclinic.detect;

import org.springframework.web.client.RestTemplate;

public class GSuggestion {

	private String domainName;

	public String getDomainName() {
		return domainName;
	}

	public String getSuggestions(String url) {

		extractDomain(url);
		String uri = "https://suggestqueries.google.com/complete/search?output=toolbar&hl=en&q=" + domainName;
		System.out.println("URL is: " + uri);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, String.class);
	}

	private void extractDomain(String url) {
//		String domain;
		String[] temp = url.split("\\.");
		int count = temp.length;
		/**
		 * If the URL is www.xyz.co.in,
		 * Use the first commented lines, if you want to use domain name as xyz.co.in
		 * Use the second commented line, if you want to use domain name as xyz
		 */
		if (count >= 2) {
			if (count == 4 || (count == 3 && temp[count - 2].length() <= 3)) {
//				domain = temp[count-3]+"."+temp[count-2]+"."+temp[count-1];
				domainName = temp[count-3];
			} else {
//				domain = temp[count-2]+"."+temp[count-1];
				domainName = temp[count-2];
			}
		} else {
			domainName = temp[0];
		}
	}
}
