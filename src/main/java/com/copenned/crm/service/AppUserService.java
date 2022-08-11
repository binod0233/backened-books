package com.copenned.crm.service;

import com.copenned.crm.dto.ListResponse.AppUsersListResponse;
import com.copenned.crm.dto.SingleResponse.AppUserResponse;
import com.copenned.crm.model.AppUser;
//import com.copenned.crm.model.CustomAppUserDetails;
import com.copenned.crm.repository.AppUserRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService{
    @Autowired
    private AppUserRepo repository;
    @Autowired
    private Converter converter;



    public AppUserResponse saveAppUser(AppUser appUser){
        return converter.convertAppUser(repository.save(appUser));

    }

    public AppUsersListResponse getAppUsers(){
        return converter.convertToAppUsersList(repository.findAll());
    }

    public AppUserResponse getAppUserById(int id){
        return converter.convertAppUser(repository.findById(id).orElse(null));
    }
    public AppUserResponse getAppUserByName(String name){
        return converter.convertAppUser(repository.findByUserName(name));
    }


    public String deleteAppUser(int id){
        repository.deleteById(id);
        return "App User removed"+id;
    }
    public AppUserResponse updateAppUser(AppUser appUser){
        AppUser existingProduct = repository.findById(appUser.getId()).orElse(null);
        existingProduct.setUserName(appUser.getUserName());
        return converter.convertAppUser(repository.save(existingProduct));
    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        AppUser appUser = repository.findByUserName(userName);
//        if(appUser == null){
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomAppUserDetails(appUser);
//    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//       Optional<AppUser> appUser =  AppUserRepo.findByUserName(userName);
//       appUser.orElseThrow(()->new UsernameNotFoundException(("Not Found "+ userName)));
//
//       return (UserDetails) appUser.map(AppUser::new).get();
//
//    }
}
