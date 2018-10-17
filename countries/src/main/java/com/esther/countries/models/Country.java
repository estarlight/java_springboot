package com.esther.countries.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String continent;
	private String region;
	private Double surfaceArea;
	private int indepYear;
	private int population;
	private Double lifeExpectancy;
	private Double gnp;
	private Double gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private int capital;
	private String code2;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Language> languages;
    
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> cities;
    
    public Country() {
    	
    }
	
    

	
    
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getCode() {
		return code;
	}





	public void setCode(String code) {
		this.code = code;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getContinent() {
		return continent;
	}





	public void setContinent(String continent) {
		this.continent = continent;
	}





	public String getRegion() {
		return region;
	}





	public void setRegion(String region) {
		this.region = region;
	}





	public Double getSurfaceArea() {
		return surfaceArea;
	}





	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}





	public int getIndepYear() {
		return indepYear;
	}





	public void setIndepYear(int indepYear) {
		this.indepYear = indepYear;
	}





	public int getPopulation() {
		return population;
	}





	public void setPopulation(int population) {
		this.population = population;
	}





	public Double getLifeExpectancy() {
		return lifeExpectancy;
	}





	public void setLifeExpectancy(Double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}





	public Double getGnp() {
		return gnp;
	}





	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}





	public Date getCreatedAt() {
		return createdAt;
	}





	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	public Date getUpdatedAt() {
		return updatedAt;
	}





	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}





	public List<Language> getLanguages() {
		return languages;
	}





	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}





	public List<City> getCities() {
		return cities;
	}





	public void setCities(List<City> cities) {
		this.cities = cities;
	}





	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
