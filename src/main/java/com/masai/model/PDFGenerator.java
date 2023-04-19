package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PDFGenerator {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		@NotBlank(message = "Seller name cannot be blank")
	 	private String seller;
		
		@NotBlank(message = "Seller GSTIN cannot be blank")
	    private String sellerGstin;
		
		@NotBlank(message = "Seller address cannot be blank")
	    private String sellerAddress;
		
		@NotBlank(message = "Buyer name cannot be blank")
	    private String buyer;
		
		@NotBlank(message = "Buyer GSTIN cannot be blank")
	    private String buyerGstin;
		
		@NotBlank(message = "Buyer address cannot be blank")
	    private String buyerAddress;
	    
		@NotNull(message = "Items list cannot be null")
		@Size(min = 1, message = "At least one item must be present")
		@Valid
	    @ManyToAny 
	    private List<Item> items = new ArrayList<>();

}
