package com.as.blog.bean;

public class ImageParagraph {

	private String imageName;
	private byte paragraph;
	
	public ImageParagraph() {}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public byte getParagraph() {
		return paragraph;
	}
	public void setParagraph(byte paragraph) {
		this.paragraph = paragraph;
	}

	@Override
	public String toString() {
		return "ImageParagraph [imageName=" + imageName + ", paragraph="
				+ paragraph + "]";
	}
	
}
