package com.demo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class UploadImg {
	static final ClassLoader loader = UploadImg.class.getClassLoader();

	public static String Upload(MultipartFile file, String url) {
		try {
			String fileName = GenerateFileName(file.getOriginalFilename());
			byte[] bytes = file.getBytes();
			String fileLocation = new File("src\\main\\resources\\img\\" + url + "\\" + fileName).getAbsolutePath();
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			return fileName;
		} catch (Exception e) {
			return null;
		}
	}

	private static String GenerateFileName(String fileName) {
		String uuid = UUID.randomUUID().toString();
		int index = fileName.lastIndexOf(".");
		String ext = fileName.substring(index);
		return uuid + ext;
	}

	public static void DelFile(String fileName, String url) {
		if (fileName.equals("default.png")) {
			return;
		}
		File file = new File("src\\main\\resources\\img\\" + url + "\\" + fileName);
		file.delete();
	}

	public static byte[] DisplayImg(String fileName, String url) {
		try {
			File img = new File("src\\main\\resources\\img\\" + url + "\\" + fileName);
			if (!img.exists() && !img.isDirectory())
				return null;
			return Files.readAllBytes(img.toPath());
		} catch (IOException e) {
			return null;
		}
	}
}
