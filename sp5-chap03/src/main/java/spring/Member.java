package spring;
/*
 * 회원 데이터를 표현하기 위해 이 클래스를 사용한다.
 * */

import java.time.LocalDateTime;

public class Member {

		private Long id;
		private String email;
		private String password;
		private String name;
		private LocalDateTime registerDateTime;
		
		public Member(String email, String password, String name, LocalDateTime regDateTime) {
			this.email = email;
			this.password = password;
			this.name = name;
			this.registerDateTime = regDateTime;
		}

		public Long getId() {
			return id;
		}

		void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public String getName() {
			return name;
		}

		public LocalDateTime getRegisterDateTime() {
			return registerDateTime;
		}

		public void changePassword(String oldPassword, String newPassword) throws WrongIdPasswordException {
			if(!password.equals(oldPassword))
				throw new WrongIdPasswordException();
			this.password = newPassword;
		}
}
