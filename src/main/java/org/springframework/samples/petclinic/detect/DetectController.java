package org.springframework.samples.petclinic.detect;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DetectController {

	private Tracer mTracer;

	public DetectController() {
		this(new Tracer());
	}

	public DetectController(Tracer tracer) {
		this.mTracer = tracer;
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
	public String getWebResult(@RequestParam String url) {
		String ipAddress = mTracer.findIpAddress(url);

		return ipAddress;
	}
}
