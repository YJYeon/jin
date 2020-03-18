package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());//생성자를 통해 주입
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {// 세터를 이용해서 의존 객체를 주입
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	/*
	 * 객체를 생성하고 의존 객체를 주입하는 것은 스프링 컨테이너이므로 설정 클래스를 이용해서 컨테이너를 생성해야 한다.
	 * 2장에서 사용한 AnnotationConfigApplicationContext 클래스를 이용해서 스프링 컨테이너를 생성할 수 있다.
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);// 1.설정 정보를 이용해서 빈 객체를 생성한다.
	 * 컨테이너를 생성하면 getBean() 메서드를 이용해서 사용할 객체를 구할 수 있다.
			MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class); // 2.빈 객체를 제공한다.
	 * 스프링 컨테이너 (ctx)로부터 이름이 "memberRegSvc"인 빈 객체를 구한다.
	 * MemberRegisterService 객체는 내부에서 memberDao 빈 객체를 사용한다.
	 */
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	/*
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}*/
}