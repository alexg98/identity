package wavy.global.identity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import wavy.global.identity.domain.Client;
import wavy.global.identity.domain.ClientRequest;
import wavy.global.identity.domain.User;
import wavy.global.identity.domain.UserRequest;
import wavy.global.identity.service.ClientService;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {

	@Autowired
	private ClientService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client createClient(@RequestBody ClientRequest request){		
		return service.createClient(request.getClient(), request.getRealmName());
	}
	
	@PostMapping(value = "/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody UserRequest dto){		
		return service.createUser(dto.getRealmName() , dto.getUser());
	}
	
	@PutMapping(value = "/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User updateUser(@RequestBody UserRequest dto){		
		return service.updateUser(dto.getRealmName() , dto.getUser());
	}
	
	@GetMapping(value = "/user")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void activateUser(@RequestParam(value = "realmName") String realmName, @RequestParam(value = "username") String username){		
		service.activateUser(realmName , username);
	}	
	
	@GetMapping(value = "/user/all")
	@ResponseStatus(HttpStatus.CREATED)
	public List<User> findAllUser(@RequestParam(value = "realmName") String realmName){		
		return service.findAllUser(realmName);
	}
}