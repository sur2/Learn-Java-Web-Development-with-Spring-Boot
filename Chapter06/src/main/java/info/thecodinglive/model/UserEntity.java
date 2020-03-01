package info.thecodinglive.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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
	
	/**
	 * '@Column'의 name으로 필드명과 매핑
	 * '@Enumerated(EnumType.ORDINAL)'은 값이 int로 할당
	 * '@Enumerated(EnumType.STRING)'은 값이 String으로 할당
	 */
	@Column(name = "role")
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	
	/**
	 * '@PrePersist'
	 * 매핑 시에 값 참조를 위해 미리 인스턴스가 생성되어야한다면
	 * JPA에서 제공하는 콜백 메서드를 사용해서 값을 세팅할 수 있다. 
	 */
	@PrePersist
	public void beforeCreate() {
		createdAt = new Date();
	}
	
	public UserEntity() {
		super();
	}

	public UserEntity(String uesrName, Integer age, UserRole role) {
		super();
		this.uesrName = uesrName;
		this.age = age;
		this.role = role;
	}

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
