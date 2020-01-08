package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.enums.TipoVaga;
import br.com.hackathonfc.park.enums.TipoVeiculo;
import br.com.hackathonfc.park.model.*;
import br.com.hackathonfc.park.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    public void instantiateTestDatabase(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento Instânciado", "1234556", "Rua Doutor Fulano, 505 - Aparecida, Santos/SP", 123456, 4, 4, 8.50);

        Perfil perfil1 = new Perfil("ROLE_ADMIN");
        Perfil perfil2 = new Perfil("ROLE_USER");

        Vaga vaga = new Vaga(estacionamento, true, TipoVaga.CARRO, null);
        Vaga vaga2 = new Vaga(estacionamento, true, TipoVaga.MOTO, null);

        Veiculo veiculo = new Veiculo("Ford", "Focus", "Preto", "XXXX-4444", TipoVeiculo.CARRO, vaga);
        Veiculo veiculo2 = new Veiculo("BMW", "Tiger", "Preto", "XXXX-5555", TipoVeiculo.MOTO, vaga2);

        List<Perfil> perfis = perfilRepository.findAll();
        User user = new User("admin@gmail.com", encode("admin"), perfis);

        estacionamentoRepository.save(estacionamento);
        perfilRepository.save(perfil1);
        perfilRepository.save(perfil2);
        vagaRepository.save(vaga);
        vagaRepository.save(vaga2);
        veiculoRepository.save(veiculo);
        veiculoRepository.save(veiculo2);
        userRepository.save(user);
    }

    public String encode(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
