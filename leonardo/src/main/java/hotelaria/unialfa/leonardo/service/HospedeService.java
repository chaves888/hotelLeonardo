package hotelaria.unialfa.leonardo.service;

import hotelaria.unialfa.leonardo.model.Hospede;
import hotelaria.unialfa.leonardo.repository.HospedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospedeService {

    private final HospedeRepository repository;

    public HospedeService(HospedeRepository repository) {
        this.repository = repository;
    }

    public List<Hospede> listarTodos() {
        return repository.findAll();
    }

    public void salvar(Hospede hospede) {
        repository.save(hospede);
    }

    public Hospede buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
