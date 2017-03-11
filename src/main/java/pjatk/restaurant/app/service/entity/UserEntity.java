package pjatk.restaurant.app.service.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {

	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_NAME")
	private String name;

	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "USER_REAL_NAME")
	private String userRealName;
	
	@Column(name = "USER_POSITION")
	private String userPosition;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "IS_ENABLED")
	private Boolean isEnabled;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
}
