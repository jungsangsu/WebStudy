package sample03;

public class MessageBeanEn implements MessageBean {

	public MessageBeanEn() {
		System.out.println("MessageBeanEn 기본생성자");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name+"!!");
		
	}
}
