package de.leuphana.cosu.messagingosgi.domain.message;

import de.leuphana.cosu.messagingosgi.domain.Content;

public class Body {

	private Content content;

	public void setContent(Content content) {
		this.content = content;
	}

	public Content getContent() {
		return content;
	}

}