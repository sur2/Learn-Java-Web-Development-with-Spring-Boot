package info.thecodinglive.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * '@Entity'를 사용하여 스키마 정의
 * '@Table'를 사용하여 클래스명과 테이블명이 다르게 매칭
 * '@Id'를 사용하여 멤버면수를 키 대상이 될 칼럼과 매핑
 */
@Entity
@Table(name = "tbl_user")
public class UserEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String uesrName;
	private Integer age;
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUesrName() {
		return uesrName;
	}

	public void setUesrName(String uesrName) {
		this.uesrName = uesrName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
