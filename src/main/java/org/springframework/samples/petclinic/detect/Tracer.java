package org.springframework.samples.petclinic.detect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Tracer {

	private final String os = System.getProperty("os.name").toLowerCase();

	public String findIpAddress(String url) {
		String route = "";
		try {
			Process traceRt;
			if (os.contains("win"))
				traceRt = Runtime.getRuntime().exec("tracert " + url);
			else
				traceRt = Runtime.getRuntime().exec("traceroute " + url);

			// read the output from the command
			route = convertStreamToString(traceRt.getInputStream());

			// read any errors from the attempted command
			String errors = convertStreamToString(traceRt.getErrorStream());
			if(errors != "") System.out.println(errors);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return route;
	}

	private String convertStreamToString(InputStream inputStream) {
		return new BufferedReader(new InputStreamReader(inputStream))
			.lines().collect(Collectors.joining("\n"));
	}
}
