package nl.framework.applicatie.domein;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShoppingCart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@JsonIgnore
	@OneToOne(optional = false, orphanRemoval = true)
	private Account account;

	@Column(nullable = false)
	private ZonedDateTime created;
	
	@OneToMany(mappedBy = "shoppingCart")
	private List<ShoppingCartEntry> entries;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ZonedDateTime getCreated() {
		return created;
	}

	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}

	public List<ShoppingCartEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ShoppingCartEntry> entries) {
		this.entries = entries;
	}
	
}
