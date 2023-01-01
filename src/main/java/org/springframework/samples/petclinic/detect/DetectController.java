package org.springframework.samples.petclinic.detect;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.Map;

@Controller
public class DetectController {

	private Tracer mTracer;

	private IpLookup mLookup;

	public DetectController() {
		this(new Tracer(), new IpLookup());
	}

	public DetectController(Tracer tracer, IpLookup lkup) {
		this.mTracer = tracer;
		mLookup = lkup;
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

//	@GetMapping("/detect")
//	@ResponseBody
//	public WebResult getWebResult(@RequestParam String url) {
//		String ipAddress = mTracer.findIpAddress(url);
//		WebResult result = mLookup.giveDetails(ipAddress);
//		return result;
//	}

	@GetMapping("/detect")
	@ResponseBody
	public Result getWebResult(@RequestParam String url) {
		File file = new File("C:\\Users\\kajas\\Downloads\\zytr.xml");
		XmlParser parser = new XmlParser();
		parser.parseXmlGiveSuggestions(file);
		String ipAddress = mTracer.findIpAddress(url);
		Result result = mLookup.giveDetails(ipAddress);
		return result;
	}
}
