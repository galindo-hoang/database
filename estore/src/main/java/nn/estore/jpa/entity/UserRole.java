package nn.estore.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "Userroles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@ManyToOne
	@JoinColumn(name = "Roleid")
	Role role;
	
	@ManyToOne
	@JoinColumn(name = "Username")
	User user;


	public UserRole(Role role, User user) {
		this.role = role;
		this.user = user;
	}

/*	UserRole(Integer id){
		this.id=id;
		role=null;
		user=null;
	}
	 UserRole(Integer id,Role role,User user){
		this.id=id;
		this.role=role;
		this.user=user;
	}
	 UserRole(Role role,User user){
		this.role=role;
		this.user=user;
	}*/
}
