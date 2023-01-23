package org.springframework.samples.petclinic.detect;

import java.util.ArrayList;
import java.util.List;

public class WebResult {
	private String website;

	private String domainName;

	private String domainIPAddress;

	private String continentName;

	private String countryName;

	private String region;

	private String city;

	private String currentTime;

	private String isp;

	private String domain;

	private List<String> suggestions;

	public WebResult() {
		new WebResult(
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			new ArrayList<>());
	}

	public WebResult(String url, String domainName, String domainIPAddress, String continentName, String countryName, String region, String city, String currentTime, String isp, String domain, List<String> suggestions) {
		this.website = url;
		this.domainName = domainName;
		this.domainIPAddress = domainIPAddress;
		this.continentName = continentName;
		this.countryName = countryName;
		this.region = region;
		this.city = city;
		this.currentTime = currentTime;
		this.isp = isp;
		this.domain = domain;
		this.suggestions = suggestions;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainIPAddress() {
		return domainIPAddress;
	}

	public void setDomainIPAddress(String domainIPAddress) {
		this.domainIPAddress = domainIPAddress;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}
}
