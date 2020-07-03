package com.song.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "Category")
public class CategoryEntity 
{
	@Id 
	@Column(name = "category_seq")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int category_seq;
	
	@Column(name = "registor_id", nullable = false)
	private String registor_id;
	
	@Column(name = "category_nm", nullable = false)
	private String category_nm;
	
	@OneToMany( cascade = CascadeType.REMOVE, fetch = FetchType.LAZY )
	@JoinTable( name = "product", joinColumns = @JoinColumn( name = "category_seq" ))
	private List<ProductEntity> products = new ArrayList<ProductEntity>();
		
	@Builder
	public CategoryEntity(int category_seq, String registor_id, String category_nm)
	{
		this.category_seq = category_seq;
		this.registor_id = registor_id;
		this.category_nm = category_nm;
	}
}

