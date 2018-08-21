package com.cooksys.controllers_and_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.controllers_and_rest.dto.PenguinDto;
import com.cooksys.controllers_and_rest.entity.Penguin;

@RestController()
@RequestMapping(value="penguin")
public class PenguinController {
	
	List<Penguin> penguins = new ArrayList<Penguin>();
	
	public PenguinController () {
		Penguin p1 = new Penguin(1, "Donny", 7);
		Penguin p2 = new Penguin(2, "Jamil", 7);
		Penguin p3 = new Penguin(3, "Jacob", 7);
		Penguin p4 = new Penguin(4, "Alex", 7);
		Penguin p5 = new Penguin(5, "Caz", 7);
		
		penguins.add(p1);
		penguins.add(p2);
		penguins.add(p3);
		penguins.add(p4);
		penguins.add(p5);
	}
	
	@GetMapping
	public List<Penguin> getPenguins () {
		return this.penguins;
	}
	
	@GetMapping(path="/{id}")
	public PenguinDto readPenguin (@PathVariable(name="id") int id, @RequestParam(value="name", required=false) String name) {
		Penguin p = this.penguins.get(id - 1);
		if (name == null) {
			return new PenguinDto(p.getId(), p.getName(), p.getAge(), p.getFriends());
		}
		if (p.getName().equals(name)) {
			return new PenguinDto(p.getId(), p.getName(), p.getAge(), p.getFriends());
		}
		return null;
	}
	
	@PostMapping
	public Penguin createPenguin (@RequestBody Penguin penguin) {
		penguin.setId(penguins.size() + 1);
		penguins.add(penguin);
		return penguin;
	}
	
	@PostMapping(path="/{penguinId}/{friendId}")
	public PenguinDto addFriend (@PathVariable(name="penguinId") int penguinId, @PathVariable(name="friendId") int friendId) {
		Penguin friend = this.penguins.get(friendId - 1);
		Penguin penguin = this.penguins.get(penguinId - 1);
		List<Penguin> friends = new ArrayList<Penguin>();
		friends.add(friend);
		penguin.setFriends(friends);
		PenguinDto returnPenguin = new PenguinDto(penguin.getId(), penguin.getName(), penguin.getAge(), penguin.getFriends());
		return returnPenguin;
	}
	
	@PutMapping(path="/{id}")
	public Penguin updatePenguin (@PathVariable(name="id") int id, @RequestBody Penguin updatedPenguin) {
		updatedPenguin.setId(id);
		penguins.set(id - 1, updatedPenguin);
		return updatedPenguin;
	}
	
	@DeleteMapping(path="/{id}")
	public Penguin deletePenguin (@PathVariable(name="id") int id) {
		Penguin p = this.penguins.get(id - 1);
		this.penguins.remove(id - 1);
		return p;
	}

}
