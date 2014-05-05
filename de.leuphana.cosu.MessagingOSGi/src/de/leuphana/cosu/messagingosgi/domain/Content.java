package de.leuphana.cosu.messagingosgi.domain;

public class Content {
	private String title;
	private ContentType contentType;
	
	public Content(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

}