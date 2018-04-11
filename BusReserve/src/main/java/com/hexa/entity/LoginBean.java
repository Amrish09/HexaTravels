package com.hexa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		This class is for loginBean
 *         </p>
 */
@Entity
@Table(name = "login_details")
public class LoginBean {
	@Override
	public String toString() {
		return "LoginBean [loginId=" + loginId + ", userName=" + userName + ", password=" + password + ", email="
				+ email + "]";
	}

	@Id
	@Column(name = "login_id")
	private int loginId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_pwd")
	private String password;
	@Column(name = "user_mail")
	private String email;

	@OneToMany(mappedBy = "login", fetch = FetchType.LAZY)
	private Set<BookingDetailsBean> loglist;

	public Set<BookingDetailsBean> getLoglist() {
		return loglist;
	}

	public void setLoglist(Set<BookingDetailsBean> loglist) {
		this.loglist = loglist;
	}

	public LoginBean() {

	}

	public LoginBean(int loginId, String userName, String password, String email) {

		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
