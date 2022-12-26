package org.springframework.samples.petclinic.detect;

public class WebResult {
	private String ipaddress;

	private String continent_code;

	private String continent_name;

	private String country_code;

	private String country_name;

	public WebResult() {
		new WebResult("", "", "", "", "");
	}

	public WebResult(String ipaddress, String continent_code, String continent_name, String country_code, String country_name) {
		this.ipaddress = ipaddress;
		this.continent_code = continent_code;
		this.continent_name = continent_name;
		this.country_code = country_code;
		this.country_name = country_name;
	}

	@Override
	public String toString() {
		return "WebResult{" +
			"ipaddress='" + ipaddress + '\'' +
			", continent_code='" + continent_code + '\'' +
			", continent_name='" + continent_name + '\'' +
			", country_code='" + country_code + '\'' +
			", country_name='" + country_name + '\'' +
			'}';
	}
}
