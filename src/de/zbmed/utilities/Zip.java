package de.zbmed.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

public class Zip {
	public static final String fs = System.getProperty("file.separator");

	public static void main(String[] args) throws Exception {
		unzip("2025_09_04_2e6185dc-1fcd-4253-bcb7-499abf005db0.zip");
		System.out.println("Zip Ende");
	}

	static void unzip(String zipFileString) throws Exception {
		if (!zipFileString.endsWith(".zip")) {
			throw new Exception("Muss eine zip Datei sein");
		}
		String output = zipFileString.substring(0, zipFileString.length() - 4);
		ZipFile zipFile = new ZipFile(zipFileString);

		zipFile.stream().forEach(entry -> {
			try (InputStream is = zipFile.getInputStream(entry)) {
				File outFile = new File(output + fs + entry.getName());
				outFile.getParentFile().mkdirs();
				try (FileOutputStream fos = new FileOutputStream(outFile)) {
					byte[] buffer = new byte[1024];
					int len;
					while ((len = is.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		zipFile.close();
	}
}
