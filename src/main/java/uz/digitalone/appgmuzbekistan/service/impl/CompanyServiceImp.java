package uz.digitalone.appgmuzbekistan.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalone.appgmuzbekistan.dto.CompanyDto;
import uz.digitalone.appgmuzbekistan.dto.UserDto;
import uz.digitalone.appgmuzbekistan.entity.Address;
import uz.digitalone.appgmuzbekistan.entity.GM;
import uz.digitalone.appgmuzbekistan.entity.Role;
import uz.digitalone.appgmuzbekistan.entity.User;
import uz.digitalone.appgmuzbekistan.repository.AddressRepository;
import uz.digitalone.appgmuzbekistan.repository.CompanyRepository;
import uz.digitalone.appgmuzbekistan.repository.UserRepository;
import uz.digitalone.appgmuzbekistan.service.CompanyService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CompanyServiceImp implements CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    @Override
    public List<GM> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<GM> saveAll(List<CompanyDto> dto) {
        List<GM> companies = new ArrayList<>();
        for (CompanyDto companyDto : dto) {
            // CHECK ADDRESS
            if (!addressRepository.existsById(companyDto.getAddressId()))
                throw new RuntimeException("Address Not Found");
            Optional<Address> address = addressRepository.findById(companyDto.getAddressId());

            //  CHECK DIRECTOR
            if (!userRepository.existsById(companyDto.getDirectorId()))
                throw new RuntimeException("User Not Found");
            Optional<User> user = userRepository.findById(companyDto.getDirectorId());

            //  CHECK PARENT COMPANY
            if (companyDto.getParentId() != 0) {
                if (!companyRepository.existsById(companyDto.getParentId()))
                    throw new RuntimeException("Company Not Found");
                Optional<GM> parentCompany = companyRepository.findById(companyDto.getParentId());

                companies.add(new GM(companyDto.getName(), address.get(), user.get(), parentCompany.get()));
            }
            else {
                companies.add(new GM(companyDto.getName(), address.get(), user.get(), null));
            }
        }
        return companyRepository.saveAll(companies);
    }

    @Override
    public GM updateCompany(Long gmId, CompanyDto dto) {
        if (!addressRepository.existsById(dto.getAddressId()))
            throw new RuntimeException("Address Not Found");
        Optional<Address> address = addressRepository.findById(dto.getAddressId());

        //  CHECK DIRECTOR
        if (!userRepository.existsById(dto.getDirectorId()))
            throw new RuntimeException("User Not Found");
        Optional<User> user = userRepository.findById(dto.getDirectorId());

        //  CHECK PARENT COMPANY
        if (dto.getParentId() != 0) {
            if (!companyRepository.existsById(dto.getParentId()))
                throw new RuntimeException("Company Not Found");
            Optional<GM> parentCompany = companyRepository.findById(dto.getParentId());

            GM gm = new GM(dto.getName(), address.get(), user.get(), parentCompany.get());
            return companyRepository.save(gm);
        }
        else {
            GM gm = new GM(dto.getName(), address.get(), user.get(), null);
            return companyRepository.save(gm);
        }

    }

    @Override
    public String delete(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return "Successfully deleted";
        }
        throw new RuntimeException("Company Not Found");
    }
}
