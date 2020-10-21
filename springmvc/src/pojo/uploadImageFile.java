package pojo;

import org.springframework.web.multipart.MultipartFile;

public class uploadImageFile {

	MultipartFile image; //与 xml中 input中的name属性一致

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
