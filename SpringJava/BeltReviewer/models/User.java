package com.garrett.belt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, message="First name must be at least 2 characters")
	private String firstName;
	@Size(min=2, message="Last name must be at least 2 characters")
	private String lastName;
	@Size(min=2, message="Location must be at least 2 characters")
	private String location;
	private String state;
	@Email(message="Must be a valid email")
	private String email;
	@Size(min=5, message="Password must be greater than 5 characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;    
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
		name="attendees",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="event_id")
    )
	List<Event> eventsAttending;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="messages",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="event_id")
	)
	List<Message> messages;
	
	
    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<Event> events;

    
	
	public User() {
	}
	
	public User(@Size(min = 2, message = "First name must be at least 2 characters") String firstName,
			@Size(min = 2, message = "Last name must be at least 2 characters") String lastName, String location,
			String state, @Email(message = "Must be a valid email") String email,
			@Size(min = 5, message = "Password must be greater than 5 characters") String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.state = state;
		this.email = email;
		this.password = password;
	}

	
	
	public List<Event> getEventsAttending() {
		return eventsAttending;
	}

	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdat() {;
		this.setUpdatedAt(new Date());
	}

}