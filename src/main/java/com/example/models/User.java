package com.example.models;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

  private @Id
  @GeneratedValue Long id;
  private String firstName;
  private String lastName;

  @ManyToMany
  @JoinTable(
    name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles;

  public User() {}

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Role> getRoles() {
    return this.roles;
  }

  public void setRole(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof User))
      return false;
    User user = (User) o;
    return Objects.equals(this.id, user.id) && 
           Objects.equals(this.firstName, user.firstName) &&
           Objects.equals(this.lastName, user.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstName, this.lastName);
  }

  @Override
  public String toString() {
    return "User{" + "id=" + this.id + ", " + 
           "firstName='" + this.firstName + "\'', " + 
           "lastName='" + this.lastName + '\'' + 
           '}';
  }
}