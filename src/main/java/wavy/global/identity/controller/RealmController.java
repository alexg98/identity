package wavy.global.identity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import wavy.global.identity.domain.RealmDTO;
import wavy.global.identity.service.RealmService;

@RestController
@RequestMapping(value = "/api/realms")
public class RealmController {
	
	@Autowired
	private RealmService service;
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addPoliciesToRealm(@RequestBody RealmDTO realm) {
		service.updatePolicies(realm);
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody RealmDTO realm){
		service.createRealm(realm);		
	}
	
	@DeleteMapping
	public void remove(@RequestParam(value = "realmName") String realmName){	
		service.remove(realmName);	
	}
}