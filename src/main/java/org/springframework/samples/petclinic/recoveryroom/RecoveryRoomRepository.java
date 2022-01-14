package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    
    @Query("SELECT rtype FROM RecoveryRoomType rtype")
    List<RecoveryRoomType> findAllRecoveryRoomTypes() throws DataAccessException;
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT DISTINCT rtype FROM RecoveryRoomType rtype WHERE rtype.name =:name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name) throws DataAccessException;
    
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size >:size")
    List<RecoveryRoom> findBySizeMoreThan(@Param("size") double size) throws DataAccessException;
}
