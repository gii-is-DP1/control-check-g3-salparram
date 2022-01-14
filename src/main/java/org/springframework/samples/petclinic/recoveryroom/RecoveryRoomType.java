package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="recovery_room_types")
public class RecoveryRoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
	@Column(unique=true)
	@Length(min=5, max=50)
	@NotEmpty
	public String name;
}
