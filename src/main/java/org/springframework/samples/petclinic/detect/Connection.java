package org.springframework.samples.petclinic.detect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Connection {
	@JsonProperty("asn")
	private Integer asn;
	@JsonProperty("org")
	private String org;
	@JsonProperty("isp")
	private String isp;
	@JsonProperty("domain")
	private String domain;

	public Integer getAsn() {
		return asn;
	}
	public void setAsn(Integer asn) {
		this.asn = asn;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
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
}
