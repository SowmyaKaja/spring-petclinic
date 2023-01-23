package org.springframework.samples.petclinic.detect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DetectController {

	private Tracer mTracer;

	private IpLookup mLookup;

	private GSuggestion mSuggestion;

	public DetectController() {
		this(new Tracer(), new IpLookup(), new GSuggestion());
	}

	public DetectController(Tracer tracer, IpLookup lkup, GSuggestion suggestion) {
		this.mTracer = tracer;
		mLookup = lkup;
		mSuggestion = suggestion;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping("/detect/")
	public String initFindForm(Map<String, Object> model) {
		model.put("webResult", new WebResult());
		return "detect/";
	}

	@GetMapping("/detect")
	@ResponseBody
	public Result getWebResult(@RequestParam String url) {
		XmlParser parser = new XmlParser();
		String resp = mSuggestion.getSuggestions(url);
		List<String> suggestions = parser.parseXmlGiveSuggestions(resp);
		String ipAddress = mTracer.findIpAddress(url);
		Result result = mLookup.giveDetails(ipAddress);
		System.out.println(suggestions);
		return result;
	}
}
