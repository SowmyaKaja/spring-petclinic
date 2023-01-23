package org.springframework.samples.petclinic.detect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tracer {

	private static final String HOST_NOT_FOUND = "Unable to resolve target system name";

	private final String os = System.getProperty("os.name").toLowerCase();

	public String findIpAddress(String url) {
		String route = "";
		try {
//			Process traceRt;
			String command;
			if (os.contains("win")) {
				command = "tracert " + url;
			} else {
				command = "traceroute " + url;
			}
//			traceRt = Runtime.getRuntime().exec(command);
			ProcessBuilder ps = new ProcessBuilder("cmd.exe", "/c", command);
			ps.redirectErrorStream(false);
			Process pr = ps.start();
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			int numberOfLines = 0;
			while ((route = in.readLine()) != null) {
				System.out.println(route + "#####Line: " + numberOfLines);
				numberOfLines++;
				if (numberOfLines == 2)
					break;
			}

			pr.destroy();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		assert route != null;
		// If trace route gave output containing "Unable to resolve target system name" then no IP address exists.
		// Then Website is fake and no longer active
		if (route.contains(HOST_NOT_FOUND)) {
			return "No IP address found";
		}
		String temp = Arrays.stream(route.split("\\[")).filter(line -> line.contains("]")).findFirst().orElse("");
		if (!temp.isBlank())
			return temp.substring(0, temp.length() - 1);
		else
			return "No IP address found";
	}
}
