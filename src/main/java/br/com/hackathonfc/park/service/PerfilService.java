package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.model.Perfil;
import br.com.hackathonfc.park.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil detalhar(Long id){
        return perfilRepository.findById(id).get();
    }
}
