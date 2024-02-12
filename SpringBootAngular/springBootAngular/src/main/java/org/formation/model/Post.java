package org.formation.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {


	    private String id;
	 	
	    private String title;
	    
	    private String content;
	    
	    
	    
		
		public Post(String title, String content) {
			super();
			this.title = title;
			this.content = content;
		}

		public Post() {
			super();
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Post [title=" + title + ", content=" + content + "]";
		}
	    
	    
}
