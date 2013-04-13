package cn.cdu.fang.web.utill;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	/**
	 * 获取文件后缀
	 * 
	 * @param f
	 * @return
	 */
	public static String getExtension(File f) {
		return (f != null) ? getExtension(f.getName()) : "";
	}

	/**
	 * 根据名称获取后缀【文件类型】
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtension(String filename) {
		return getExtension(filename, "");
	}

	private static String getExtension(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return defExt;
	}

	@SuppressWarnings("unused")
	private static String trimExtension(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');
			if ((i > -1) && (i < (filename.length()))) {
				return filename.substring(0, i);
			}
		}
		return filename;
	}

	/**
	 * 保存图片【成功保存返回true,保存成文件路径为destImagePath】
	 * 
	 * @param srcImage			图片源文件
	 * @param destImagePath		目标图片存放完全路径
	 * @param x					目标切片起点x坐标			
	 * @param y					目标切片起点y坐标
	 * @param width				目标切片宽度 
	 * @param height			目标切片高度 	
	 * @return
	 * @throws IOException
	 */
	public static boolean saveImage(File srcImage, String destImagePath,
			int x, int y, int width, int height) throws IOException {
		
		File fileDest = new File(destImagePath);
		if (!fileDest.getParentFile().exists())
			fileDest.getParentFile().mkdirs();

		String ext = getExtension(destImagePath).toLowerCase();

		BufferedImage bi = (BufferedImage) ImageIO.read(srcImage);
		height = Math.min(height, bi.getHeight());
		width = Math.min(width, bi.getWidth());
		
		if (height <= 0)
			height = bi.getHeight();
		if (width <= 0)
			width = bi.getWidth();
		
		x = Math.min(Math.max(0, x), bi.getHeight() - height);
		y = Math.min(Math.max(0, y), bi.getWidth() - width);

		BufferedImage bi_cropper = bi.getSubimage(y, x, width, height);
		return ImageIO.write(bi_cropper, ext.equals("png")?"png":"jpeg", fileDest); 
	}

}
