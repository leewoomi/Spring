package com.lee.mybatis.domain;

public class BooksVO {

		private String	code ;
		private String 	subject;
		private int	price ;
		private String	description ;
		
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "Books [code=" + code + ", subject=" + subject + ", price=" + price + ", description=" + description
					+ "]";
		}
		
		
		
		
}
