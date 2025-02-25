package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class PetStore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerFirstName;
	private String customerLastName;
	
	@Column(unique = true)
	private String customerEmail;
	
	@EqualsAndHashCode.Exclude
	@JoinTable(name = "pet_store_customer", joinColumns =
	@JoinColumn(name = "pet_store_id"), inverseJoinColumns = 
	@JoinColumn(name = "customer_id"))
	@ManyToMany(cascade = CascadeType.PERSIST)
	private Set<Customer> customers = new HashSet<>();
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();
	


}
