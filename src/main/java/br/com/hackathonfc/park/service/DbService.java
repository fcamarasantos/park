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
        Perfil perfil1 = new Perfil("ROLE_ADMIN");
        Perfil perfil2 = new Perfil("ROLE_USER");

        perfilRepository.save(perfil1);
        perfilRepository.save(perfil2);

        List<Perfil> perfis = perfilRepository.findAll();

        User user = new User("admin@gmail.com", encode("admin"), perfis);
        User user1 = new User("user@gmail.com", encode("user"), perfis);
        User user2 = new User("henrico@gmail.com", encode("admin"), perfis);

        Estacionamento estacionamento = new Estacionamento("Estacionamento 1", "1234556", "Rua Doutora Ana Costa, 505 - Aparecida, Santos/SP", 123456, 4, 4, 8.50, user);
        Estacionamento estacionamento1 = new Estacionamento("Estacionamento 2", "1234556", "Rua Marechal Mallet, 403 - Embaré, Santos/SP", 123456, 8, 8, 7.80, user1);
        Estacionamento estacionamento2 = new Estacionamento("Estacionamento 3", "1234556", "Rua Itapura, 306 - Mocca, São Paulo/SP", 123456, 5, 5, 9.50, user2);

        Vaga vaga = new Vaga(estacionamento, true, TipoVaga.CARRO, null);
        Vaga vaga2 = new Vaga(estacionamento, true, TipoVaga.MOTO, null);

        Vaga vaga3 = new Vaga(estacionamento1, true, TipoVaga.CARRO, null);
        Vaga vaga4 = new Vaga(estacionamento1, true, TipoVaga.MOTO, null);

        Vaga vaga5 = new Vaga(estacionamento2, true, TipoVaga.CARRO, null);
        Vaga vaga6 = new Vaga(estacionamento2, true, TipoVaga.MOTO, null);

        Veiculo veiculo = new Veiculo("Ford", "Focus", "Preto", "XXXX-4444", TipoVeiculo.CARRO, vaga);
        Veiculo veiculo2 = new Veiculo("BMW", "Tiger", "Preto", "XXXX-5555", TipoVeiculo.MOTO, vaga2);

        Veiculo veiculo3 = new Veiculo("Ford", "Mustang", "Preto", "FORD-4444", TipoVeiculo.CARRO, vaga3);
        Veiculo veiculo4 = new Veiculo("BMW", "S1000RR", "Vermelho", "MALB-6666", TipoVeiculo.MOTO, vaga4);

        Veiculo veiculo5 = new Veiculo("Chevrolet", "Cruze", "Prata", "VVVV-6969", TipoVeiculo.CARRO, vaga5);
        Veiculo veiculo6 = new Veiculo("Harley Davidson", "Fat Boy 2014", "Vermelho", "HARL-1882", TipoVeiculo.CARRO, vaga6);

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);

        estacionamentoRepository.save(estacionamento);
        estacionamentoRepository.save(estacionamento1);
        estacionamentoRepository.save(estacionamento2);

        vagaRepository.save(vaga);
        vagaRepository.save(vaga2);
        vagaRepository.save(vaga3);
        vagaRepository.save(vaga4);
        vagaRepository.save(vaga5);
        vagaRepository.save(vaga6);

        veiculoRepository.save(veiculo);
        veiculoRepository.save(veiculo2);
        veiculoRepository.save(veiculo3);
        veiculoRepository.save(veiculo4);
        veiculoRepository.save(veiculo5);
        veiculoRepository.save(veiculo6);


    }

    public String encode(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
