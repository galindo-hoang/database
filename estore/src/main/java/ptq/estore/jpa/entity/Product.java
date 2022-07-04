package ptq.estore.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ptq.estore.exception.InvalidQuantityException;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String image;
	@Column(name = "unitprice")
	Double unitPrice;
	Integer quantity;
	@ManyToOne
	@JoinColumn(name = "categoryid")
	Category category;
	Double discount;
	@Column(name = "likecount")
	Integer likeCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "createdate")
	Date createDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
	public Product(Integer id,Integer quantityItems) throws InvalidQuantityException {
		if (quantityItems<0) throw new InvalidQuantityException("Quantity must be greater than 0");
		else {
			this.quantity = quantityItems;
			this.id=id;
		}
	}
}
