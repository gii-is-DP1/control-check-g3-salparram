package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="recovery_rooms")
public class RecoveryRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
	@NotEmpty
	@Length(min=3, max=50)
	public String name;
    

	@Min(value = (long) 0.)
	public double size;
	
	
	@NotNull
    public boolean secure;
	
    //@Transient
    @ManyToOne(optional=false)
    @JoinColumn(name = "rtype_id")
    @NotEmpty
    public RecoveryRoomType roomType;
    
    /*@AssertTrue
    public boolean getSizeCheck() {
        return this.size >= 0.;
    }*/
}
