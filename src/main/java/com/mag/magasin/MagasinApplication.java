package com.mag.magasin;

import com.mag.magasin.dao.EnseigneRepostory;
import com.mag.magasin.dao.MagasinRepository;
import com.mag.magasin.dao.UserRepository;
import com.mag.magasin.dao.UserRoleRepository;
import com.mag.magasin.entities.Enseigne;
import com.mag.magasin.entities.Magasin;
import com.mag.magasin.entities.User;
import com.mag.magasin.entities.UserRole;
import com.mag.magasin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class MagasinApplication implements CommandLineRunner {

    @Autowired
    private EnseigneRepostory enseigneRepostory;

    @Autowired
    private MagasinRepository magasinRepository;


    @Autowired
    private AccountService accountService;



    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(MagasinApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Enseigne.class, Magasin.class, User.class, UserRole.class);

        accountService.save(new UserRole(null, "nonAdmin"));
        accountService.save(new UserRole(null, "admin"));
        Stream.of("user1","user2","user3","admin").forEach(un->{
            accountService.saveUser(un, "1234", "1234");
        });
        accountService.addRoleToUser("admin", "admin");


    }


}
