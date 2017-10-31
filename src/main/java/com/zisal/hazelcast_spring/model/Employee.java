package com.zisal.hazelcast_spring.model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

@Entity
@Table(name = "Employee")
public class Employee implements DataSerializable{

	private Long id;
	private String name;
	private String role;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public void readData(ObjectDataInput odi) throws IOException {
		id = odi.readLong();
		name = odi.readUTF();
		role = odi.readUTF();
	}
	public void writeData(ObjectDataOutput odo) throws IOException {
		odo.writeLong(id);
		odo.writeUTF(name);
		odo.writeUTF(role);		
	}
	
	
}
