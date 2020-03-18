package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext; 

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);// 1.설정 정보를 이용해서 빈 객체를 생성한다.
		Greeter g =ctx.getBean("greeter", Greeter.class); // 2.빈 객체를 제공한다.
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
/*
 * 3 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리한다.
 * 
 * 8 AnnotationConfigApplicationContext 객체를 생성할 때 앞서 작성한 AppContext클래스를 생성자파라미터로 전달한다. 
 * 	AnnotationConfigApplicationContext는 AppContext에 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화 한다.
 * 
 * 9 getBean()메서드는 AnnotationConfigApplicationContext 가 자바 설정을 읽어와 생성한 빈(Bean)객체를 검색할 때 사용된다.
 * 	getBean()메서드의 첫 번째 파라미터는 @Bean 애노테이션의 메서드 이름인 빈 객체의 이름이며, 두 번째 파라미터는 검색할 빈 객체의 타입이다. 
 *  10행의 getBean()메서드는 greet()메서드가 생성한  Greeter객체를 리턴한다.
 * 
 * 10 Greeter 객체의 greet() 메서드를 실행하고 있다. Greeter.java코드를 보면 greet() 메서드는 
 */
 
