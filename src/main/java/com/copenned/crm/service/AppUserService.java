package com.copenned.crm.service;

import com.copenned.crm.dto.ListResponse.AppUsersListResponse;
import com.copenned.crm.dto.SingleResponse.AppUserResponse;
import com.copenned.crm.dto.SingleResponse.TeamLeadResponse;
import com.copenned.crm.dto.request.AppUserRequest;
import com.copenned.crm.model.AppUser;
//import com.copenned.crm.model.CustomAppUserDetails;
import com.copenned.crm.model.SalesMan;
import com.copenned.crm.model.TeamLead;
import com.copenned.crm.repository.AppUserRepo;
import com.copenned.crm.repository.SalesManRepo;
import com.copenned.crm.repository.TeamLeadRepo;
import com.copenned.crm.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppUserService{
    @Autowired
    private AppUserRepo repository;
    @Autowired
    private Converter converter;
    @Autowired
    private TeamLeadRepo leadrepo;
    @Autowired
    private SalesManRepo slaesManRepo;



    public AppUserResponse saveAppUser(AppUserRequest request) {
        AppUser user = repository.save(request.getUser());

        if (Objects.nonNull(user)) {
            if (request.getUser().getRole().equalsIgnoreCase("teamlead")) {
                TeamLead teamLead = new TeamLead();
                teamLead.setUserId(user.getId());
                teamLead.setTeamName("Default");
                leadrepo.save(teamLead);
                user.setRoleId(teamLead.getId());


            }
            else if (request.getUser().getRole().equalsIgnoreCase("clientmanager"))
            {
                SalesMan salesMan = new SalesMan();
                salesMan.setUserId(user.getId());
                salesMan.setTeamLead(request.getLeadName());

                slaesManRepo.save(salesMan);
                user.setRoleId(salesMan.getId());

            }
            else {
                return null;
            }
            AppUser tempUser = repository.findByEmail(user.getEmail());
            tempUser.setRoleId(user.getRoleId());
            repository.save(tempUser);

//        return converter.convertAppUser(repository.save(appUser));

        }
        return converter.convertAppUser(user);
    }

    public AppUsersListResponse getAppUsers(){
        return converter.convertToAppUsersList(repository.findAll());
    }

    public AppUserResponse getAppUserById(int id){
        return converter.convertAppUser(repository.findById(id).orElse(null));
    }
    public AppUserResponse appUserLogin(String email){
        return converter.convertAppUser(repository.findByEmail(email));
    }

    public AppUsersListResponse appUserByTeamLead(){
        String teamLead = "teamlead";
        return converter.convertToAppUsersList(repository.findAllByRole( teamLead));
    }

    public AppUsersListResponse appUserByClientManager(){
        String clientManager = "clientmanager";
        return converter.convertToAppUsersList(repository.findAllByRole( clientManager));
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
