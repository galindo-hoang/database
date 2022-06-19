package ptq.estore.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface MailService {
	void send(Mail mail);
	void queue(Mail mail);
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public static class Mail{
		String from;
		String to;
		String subject;
		String text;
		String cc;
		String bcc;
		String attachments;
		
		public Mail(String to, String subject, String text) {
			this.from="Phạm Quân <phamtienquan2001@gmail.com>";
			this.to=to;
			this.subject=subject;
			this.text=text;
		}
	}
	
	default void sendProduct(String email, Integer id) {
		String url="http://localhost:8080/product/detail/"+id;
		String subject="Thông tin sản phẩm";
		String text="<a href='"+url+"'>Xem chi tiết </a>";
		Mail mail=new Mail(email,subject,text);
		this.queue(mail);
	}
}
