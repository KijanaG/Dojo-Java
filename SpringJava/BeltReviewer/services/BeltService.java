package com.garrett.belt.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.garrett.belt.models.Event;
import com.garrett.belt.models.Message;
import com.garrett.belt.models.User;
import com.garrett.belt.repositories.EventRepository;
import com.garrett.belt.repositories.MessageRepository;
import com.garrett.belt.repositories.UserRepository;

@Service
public class BeltService {
	private final UserRepository userRepo;
	private final EventRepository eventRepo;
	private final MessageRepository messageRepo;
	
	public BeltService(UserRepository userRepo, EventRepository eventRepo, MessageRepository messageRepo) {
		this.userRepo = userRepo;
		this.eventRepo = eventRepo;
		this.messageRepo = messageRepo;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	public boolean authenticationUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Event getEvent(Long id) {
		Optional<Event> e = eventRepo.findById(id);
		if(e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public HashMap<Event, Integer> inStateEvents(Long id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			HashMap<Event, Integer> inState = new HashMap<Event, Integer>();
			User user = u.get();
			List<Event> events = eventRepo.findAll();
			for(Event event : events) {
				if(event.getState().equals(user.getState())) {
					if(event.getCreator().equals(user)) {
						inState.put(event, 0);
					} else if(event.getAttendees().contains(user)) {
						inState.put(event, 1);
					} else {
						inState.put(event, 2);
					}
				}
			}
			return inState;
		} else {
			return null;
		}
	}
	
	public HashMap<Event, Integer> outOfStateEvents(Long id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			HashMap<Event, Integer> outOfState = new HashMap<Event, Integer>();
			User user = u.get();
			List<Event> events = eventRepo.findAll();
			for(Event event : events) {
				if(!event.getState().equals(user.getState())) {
					if(event.getCreator().equals(user)) {
						outOfState.put(event, 0);
					} else if(event.getAttendees().contains(user)) {
						outOfState.put(event, 1);
					} else {
						outOfState.put(event, 2);
					}
				}
			}
			return outOfState;
		} else {
			return null;
		}
	}
	
	public void createMessage(Message message) {
		messageRepo.save(message);
	}
	
	public List<Message> allMessages(Long id){
		Optional<Event> e = eventRepo.findById(id);
		List<Message> messages = messageRepo.findAll();
		if(e.isPresent()) {
			Event event = e.get();
			List<Message> eventSpecific = new ArrayList<Message>();
			for(Message message : messages) {
				if(message.getEvent().equals(event)) {
					eventSpecific.add(message);
				}
			}
			return eventSpecific;
		} else {
			return messages;
		}
	}
	
	public Event updateEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
	public void joinEvent(User user, Long id) {
		Optional<Event> e = eventRepo.findById(id);
		if(e.isPresent()) {
			Event event = e.get();
			List<User> listed = event.getAttendees();
			listed.add(user);
			eventRepo.save(event);
		}
	}
	
	public void unJoinEvent(User user, Long id) {
		Optional<Event> e = eventRepo.findById(id);
		if(e.isPresent()) {
			Event event = e.get();
			List<User> listed = event.getAttendees();
			if(listed.contains(user)) {
				listed.remove(user);
			}
			eventRepo.save(event);
		}
	}
}
