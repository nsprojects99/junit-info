package com.erpbackend.production;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Long version;
    private String name;
    private String description;
    public Widget() {
    }
    public Widget(Long version, String name, String description, int id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.version=version;
    }
    public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}   
