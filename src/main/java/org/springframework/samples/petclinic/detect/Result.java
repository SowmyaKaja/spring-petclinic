package org.springframework.samples.petclinic.detect;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"ip",
	"success",
	"continent",
	"continent_code",
	"country",
	"country_code",
	"region",
	"region_code",
	"city",
	"latitude",
	"longitude",
	"postal"
})
@Generated("jsonschema2pojo")
public class Result {

	@JsonProperty("ip")
	private String ip;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("continent")
	private String continent;
	@JsonProperty("continent_code")
	private String continentCode;
	@JsonProperty("country")
	private String country;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("region")
	private String region;
	@JsonProperty("region_code")
	private String regionCode;
	@JsonProperty("city")
	private String city;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("postal")
	private String postal;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ip")
	public String getIp() {
		return ip;
	}

	@JsonProperty("ip")
	public void setIp(String ip) {
		this.ip = ip;
	}

	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}

	@JsonProperty("success")
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@JsonProperty("continent")
	public String getContinent() {
		return continent;
	}

	@JsonProperty("continent")
	public void setContinent(String continent) {
		this.continent = continent;
	}

	@JsonProperty("continent_code")
	public String getContinentCode() {
		return continentCode;
	}

	@JsonProperty("continent_code")
	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}

	@JsonProperty("country_code")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("region_code")
	public String getRegionCode() {
		return regionCode;
	}

	@JsonProperty("region_code")
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("postal")
	public String getPostal() {
		return postal;
	}

	@JsonProperty("postal")
	public void setPostal(String postal) {
		this.postal = postal;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "Result{" +
			"ip='" + ip + '\'' +
			", success=" + success +
			", continent='" + continent + '\'' +
			", continentCode='" + continentCode + '\'' +
			", country='" + country + '\'' +
			", countryCode='" + countryCode + '\'' +
			", region='" + region + '\'' +
			", regionCode='" + regionCode + '\'' +
			", city='" + city + '\'' +
			", latitude=" + latitude +
			", longitude=" + longitude +
			", postal='" + postal + '\'' +
			", additionalProperties=" + additionalProperties +
			'}';
	}
}
