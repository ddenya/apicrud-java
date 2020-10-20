package com.ml.featureservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="features")
public class Feature {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="JOIN_USER_FEATURE",
	joinColumns= {@JoinColumn(name="userid")},
	inverseJoinColumns={@JoinColumn(name="featureid")})
	Set<User> users = new HashSet<User>();
	
	public long getFeatureId() {
		return id;
	}
	public String getFeatureName() {
		return name;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setFeatureId(long featureId) {
		this.id = featureId;
	}
	public void setFeatureName(String featureName) {
		this.name = featureName;
	}
	
	public void setUsers(HashSet<User> users) {
		this.users = users;
	}
	
	public Feature(String featureName, HashSet<User> users) {
		this.name = featureName;
		this.users = users;
	}
	
	public Feature() {
	}
	
	public Feature createWithName(String featureName) {
		this.name = featureName;
		return this;
	}
	
}