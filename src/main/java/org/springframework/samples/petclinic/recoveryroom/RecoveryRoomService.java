package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetRepository;
import org.springframework.samples.petclinic.pet.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository rRepo;
	
	//private VisitRepository visitRepository;
	

	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository rRepo) {
		this.rRepo=rRepo;
	}
	
	@Transactional(readOnly = true)
    public List<RecoveryRoom> getAll(){
        return rRepo.findAll();
    }

	@Transactional(readOnly = true)
    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return rRepo.findAllRecoveryRoomTypes();
    }
	
	@Transactional(readOnly = true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return rRepo.getRecoveryRoomType(typeName);
    }
	
	@Transactional(readOnly = true)
    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return rRepo.findBySizeMoreThan(size);
    }

	@Transactional
    public RecoveryRoom save(RecoveryRoom p) {
        return rRepo.save(p);       
    }

    
}
