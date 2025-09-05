package de.zbmed.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

public class Zip {
	public static void main(String[] args) throws Exception {
		unzip("beispiel.zip");
	}

	static void unzip(String zipFileString) throws Exception {
		ZipFile zipFile = new ZipFile(zipFileString);

		zipFile.stream().forEach(entry -> {
			try (InputStream is = zipFile.getInputStream(entry)) {
				File outFile = new File("output/" + entry.getName());
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
