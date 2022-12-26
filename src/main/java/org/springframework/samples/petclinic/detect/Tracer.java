package org.springframework.samples.petclinic.detect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Tracer {

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
		String temp = Arrays.stream(route.split("\\[")).filter(line -> line.contains("]")).findFirst().orElse("");
		if (!temp.isBlank())
			return temp.substring(0, temp.length()-1);
		else
			return "No IP address found";
	}
}
