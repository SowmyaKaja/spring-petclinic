package org.springframework.samples.petclinic.detect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Timezone {

	@JsonProperty("id")
	private String id;

	@JsonProperty("abbr")
	private String abbr;

	@JsonProperty("is_dst")
	private Boolean isDst;

	@JsonProperty("offset")
	private Integer offset;

	@JsonProperty("utc")
	private String utc;

	@JsonProperty("current_time")
	private String currentTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public Boolean getIsDst() {
		return isDst;
	}

	public void setIsDst(Boolean isDst) {
		this.isDst = isDst;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getUtc() {
		return utc;
	}

	public void setUtc(String utc) {
		this.utc = utc;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

}
