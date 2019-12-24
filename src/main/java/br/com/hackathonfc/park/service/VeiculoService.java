package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;



}
