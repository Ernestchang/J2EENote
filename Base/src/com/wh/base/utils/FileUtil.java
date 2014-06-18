package com.wh.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class FileUtil {

	public static String getExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf('.')+1).toLowerCase();
	}
	public static File saveFile(File savedir, String fileName, File inputFile) throws Exception{
		//如果目录不存在就创建
		if(!savedir.exists()) {
			savedir.mkdirs();
		}
		FileInputStream fis = new FileInputStream(inputFile);
		File outputFile = new File(savedir, fileName);
		FileOutputStream fos = new FileOutputStream(outputFile);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, len);
		}
		fos.close();
		fis.close();
		return outputFile;
	}
	public static void saveImageFile(File picture, String fileName, String username) throws Exception{
		//构建文件保存的目录
		String pathdir = "/file/picture/"+ username + "/prototype";
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);
		File savedir = new File(realpathdir);
		File file = saveFile(savedir, fileName, picture);
		System.out.println("真是文件路径：" + file.getAbsolutePath());
		//140宽度的图片保存目录
		String pathdir140 = "/file/picture/"+ username + "/140x";
		String realpathdir140 = ServletActionContext.getServletContext().getRealPath(pathdir140);
		File savedir140 = new File(realpathdir140);
		if(!savedir140.exists()) {
			savedir140.mkdirs();
		}
		File file140 = new File(realpathdir140, fileName);
		ImageSizer.resize(file, file140, 140, getExt(fileName));
	}
	public static boolean validateImageFileType(String contentType, String ext){
		List<String> arrowType = Arrays.asList("image/bmp","image/png","image/gif","image/jpg","image/jpeg","image/pjpeg");
		List<String> arrowExtension = Arrays.asList("gif","jpg","bmp","png");
		return arrowType.contains(contentType.toLowerCase()) && arrowExtension.contains(ext);
	}

}
