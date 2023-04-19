package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @NotBlank(message = "Name cannot be blank")
	 private String name;
	 
	 @NotBlank(message = "Quantity cannot be blank")
	 @Pattern(regexp = "^\\d+$", message = "Quantity should be a number")
	 private String quantity;
	 
	 @NotNull(message = "Rate cannot be null")
	 @DecimalMin(value = "0.01", message = "Rate should be greater than or equal to 0.01")
	 private double rate;
	 
	 @NotNull(message = "Amount cannot be null")
	 @DecimalMin(value = "0.01", message = "Amount should be greater than or equal to 0.01")
	 private double amount;

}

