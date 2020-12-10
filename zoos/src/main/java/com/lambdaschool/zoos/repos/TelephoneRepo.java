package com.lambdaschool.zoos.repos;


import com.lambdaschool.zoos.models.Telephone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface TelephoneRepo
		extends CrudRepository<Telephone, Long> {
//	@Transactional
//	@Modifying
//	@Query(value = "UPDATE telephones SET phonenumber=:phoneid, phonetype=:phonetype, " +
//	               "last_modified_by=:username,  last_modified_date=CURRENT_TIMESTAMP WHERE phoneid=:phoneid ",
//	       nativeQuery = true)
//	void updatePhone(
//			@Param("phoneid")
//					long phoneid,
//			@Param("phonenumber")
//					String phonenumber,
//			@Param("phonetype")
//					String phonetype,
//			@Param("username")
//					String username
//	);


}
