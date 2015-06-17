package com.bryhas.project.mailrutest.data;

public class UrlRepository {
	
	public static enum Urls {
		
		GLOBAL_HOST("https://mail.ru/");
		private String field;

		private Urls(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	
	}
		
}


