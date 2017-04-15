package pjatk.restaurant.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class UserEntity {

	@Id
	@NotNull
	@Size(min=3, max=25)
	@Column(name = "USER_ID")
	private String userId;
	
	@NotNull
	@Size(min=4, max=12)
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@NotNull
	@Size(min=4, max=25)
	@Column(name = "USER_REAL_NAME")
	private String userRealName;
	
	@NotNull
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
