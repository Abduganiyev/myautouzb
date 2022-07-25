package uz.digitalone.appgmuzbekistan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.digitalone.appgmuzbekistan.entity.AutoShop;
import uz.digitalone.appgmuzbekistan.entity.Region;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 2/1/2022
 * Time: 7:33 PM
 */

@Repository
public interface AutoShopRepository extends JpaRepository<AutoShop, Long> {

    //JPA query
    List<AutoShop> findAutoShopsByCompany_IdAndCompany_Name(Long id, String name);

    //Native query
    @Query(value = "SELECT ashp.* FROM auto_shop ashp INNER JOIN gm ON gm.id = ashp.company_id WHERE gm.id = ?1 and gm.name = ?2",nativeQuery = true)
    List<AutoShop> selectAllByCompanyIdNative(Long companyId, String name);


    //JpQl query
    @Query(value = "SELECT ashp FROM AutoShop ashp WHERE ashp.company.id = ?1 AND ashp.company.name = ?2")
    List<AutoShop> selectAllByCompanyId(Long companyId, String name);
}
