package uz.digitalone.appgmuzbekistan.service.impl;

import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.entity.AutoShop;
import uz.digitalone.appgmuzbekistan.repository.AutoShopRepository;
import uz.digitalone.appgmuzbekistan.service.AutoShopService;

import java.util.List;

@Service
public class AutoShopServiceImp implements AutoShopService {

    private final AutoShopRepository autoShopRepository;

    public AutoShopServiceImp(AutoShopRepository autoShopRepository) {
        this.autoShopRepository = autoShopRepository;
    }

    @Override
    public List<AutoShop> findAutoShopsByCompany_IdAndCompany_Name(Long id, String name) {
        return autoShopRepository.findAutoShopsByCompany_IdAndCompany_Name(id,name);
    }

    @Override
    public List<AutoShop> selectAllByCompanyIdNative(Long companyId, String name) {
        return autoShopRepository.selectAllByCompanyIdNative(companyId,name);
    }

    @Override
    public List<AutoShop> selectAllByCompanyId(Long companyId, String name) {
        return autoShopRepository.selectAllByCompanyId(companyId,name);
    }
}
