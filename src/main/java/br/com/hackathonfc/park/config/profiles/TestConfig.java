package br.com.hackathonfc.park.config.profiles;

import br.com.hackathonfc.park.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public boolean instantiateDatebase(){
        dbService.instantiateTestDatabase();

        return true;
    }
}
