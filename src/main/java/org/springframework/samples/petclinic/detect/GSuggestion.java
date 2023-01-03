package org.springframework.samples.petclinic.detect;

import org.springframework.web.client.RestTemplate;

public class GSuggestion {

	public String getSuggestions(String query) {
		String uri = "https://suggestqueries.google.com/complete/search?output=toolbar&hl=en&q=" + query;
		System.out.println("URL is: " + uri);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, String.class);
	}
}
