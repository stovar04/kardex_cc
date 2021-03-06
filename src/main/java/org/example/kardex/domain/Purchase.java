package org.example.kardex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "purchases")
public class Purchase {
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime date;
	private Double total;

	@ManyToOne
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase")
	private List<PurchaseDetail> purchaseDetailList;

	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
