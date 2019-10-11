package sample;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean messageBean;
		//messageBean = new MessageBeanKo();
		messageBean = new MessageBeanEn();
		messageBean.sayHello("Spring");
		

	}

}
