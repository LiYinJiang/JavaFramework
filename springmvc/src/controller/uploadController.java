package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.uploadImageFile;

@Controller
public class uploadController {

	@RequestMapping("/upload")
	public ModelAndView upload(HttpServletRequest request, uploadImageFile file)
			throws IllegalStateException, IOException {
		File imageFile = new File(request.getServletContext().getRealPath("/image"),
				file.getImage().getOriginalFilename()); // 上传后存储的位置
		System.out.println("path" + imageFile.getAbsolutePath());
		imageFile.getParentFile().mkdirs();
		file.getImage().transferTo(imageFile);
		ModelAndView mav = new ModelAndView("showUploadImage");
		mav.addObject("imageName", imageFile.getName());
		return mav;
	}
}
