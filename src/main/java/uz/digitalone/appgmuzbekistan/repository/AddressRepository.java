package uz.digitalone.appgmuzbekistan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.appgmuzbekistan.entity.Address;
import uz.digitalone.appgmuzbekistan.entity.Region;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:33 PM
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    boolean existsByStreetAndHome(String street, String home);
}
