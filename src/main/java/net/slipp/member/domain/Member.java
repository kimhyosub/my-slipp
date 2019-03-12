package net.slipp.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.slipp.common.domain.AbstractEntity;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Member extends AbstractEntity {
	
	@Column(nullable=false, length=20)
	@JsonProperty
	private String memberId;
	
	@JsonIgnore
	private String memberPassword;
	
	@JsonProperty
	private String memberName;
	
	public boolean matchId(Long newId) {
		if(newId == null) {
			return false;
		}
		return newId.equals(getId());
	}
	
	public boolean matchPassword(String newPassword) {
		if(newPassword == null) {
			return false;
		}
		return newPassword.equals(memberPassword);
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Member [" + super.toString() + "memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ "]";
	}
}
