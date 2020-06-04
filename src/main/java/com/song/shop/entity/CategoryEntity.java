package com.song.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@Column(name = "cateory_nm", nullable = false)
	private String cateory_nm;
	
	@OneToMany( cascade = CascadeType.REMOVE )
	@JoinTable( name = "product", joinColumns = @JoinColumn( name = "category_seq" ) )
	private List<ProductEntity> products = new ArrayList<ProductEntity>();
	
}

