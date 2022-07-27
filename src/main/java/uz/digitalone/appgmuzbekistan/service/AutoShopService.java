package uz.digitalone.appgmuzbekistan.service;

import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.AutoShopDto;
import uz.digitalone.appgmuzbekistan.entity.AutoShop;

import java.util.List;

@Service
public interface AutoShopService {
    List<AutoShop> findAutoShopsByCompany_IdAndCompany_Name(Long id, String name);

    List<AutoShop> selectAllByCompanyIdNative(Long companyId, String name);
    List<AutoShop> selectAllByCompanyId(Long companyId, String name);

    List<AutoShop> findAll();

    List<AutoShop> saveAll(List<AutoShopDto> dto);
}
