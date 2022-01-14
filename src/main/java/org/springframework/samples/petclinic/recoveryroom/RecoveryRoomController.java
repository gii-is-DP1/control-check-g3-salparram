package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	private final RecoveryRoomService rService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService rService) {
		this.rService = rService;
	}
	
	@GetMapping(path = "/create")
	public String initCreationForm(Owner owner, ModelMap model) {
		RecoveryRoom room = new RecoveryRoom();
		model.addAttribute("recoveryRoom", room);
		List<RecoveryRoomType> rTypes = this.rService.getAllRecoveryRoomTypes();
		model.addAttribute("types", rTypes);
		return "recoveryroom/createOrUpdateRecoveryRoomForm";
	}

	@PostMapping(path = "/create")
	public String processCreationForm(@Valid RecoveryRoom room, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("recoveryRoom", room);
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		}
		else {
			this.rService.save(room);
			return "redirect:/welcome";
		}
	}
}
