package org.springframework.samples.petclinic.detect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class DetectController {

	private final Tracer mTracer;

	private final IpLookup mLookup;

	private final GSuggestion mSuggestion;

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
		return "/detect?url=www.google.com";
	}

	@GetMapping("/detect")
	@ResponseBody
	public ModelAndView getWebResult(@RequestParam String url) {
		ModelAndView mav = new ModelAndView("detect/webDetails");
		XmlParser parser = new XmlParser();
		String resp = mSuggestion.getSuggestions(url);
		List<String> suggestions = parser.parseXmlGiveSuggestions(resp);
		String ipAddress = mTracer.findIpAddress(url);
		Result result = mLookup.giveDetails(ipAddress);
		WebResult webResult = new WebResult(url, mSuggestion.getDomainName(), result.getIp(), result.getContinent(),
				result.getCountry(), result.getRegion(), result.getCity(), result.getTimezone().getCurrentTime(),
				result.getConnection().getIsp(), result.getConnection().getDomain(), suggestions);
		mav.addObject(webResult);
		System.out.println(suggestions);
		return mav;
	}

	@PostMapping("/detect")
	public ModelAndView urlSubmit(@RequestParam("url") String url) {
		return getWebResult(url);
	}

}
