package com.example.models;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Role {

  private @Id
  @GeneratedValue Long id;

  private String roleName;

  @ManyToMany(mappedBy = "roles")
  @JsonIgnore
  private Set<User> users;

  public Role() {}

  public Role(String roleName) {
    this.roleName = roleName;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Set<User> getUsers() {
    return this.users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Role))
      return false;
    Role role = (Role) o;
    return Objects.equals(this.id, role.id) && 
           Objects.equals(this.roleName, role.roleName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.roleName);
  }

  @Override
  public String toString() {
    return "User{" + "id=" + this.id + ", " + 
           "role='" + this.roleName + '\'' + 
           '}';
  }
}