package hotelaria.unialfa.leonardo.service;

import hotelaria.unialfa.leonardo.model.Suite;
import hotelaria.unialfa.leonardo.repository.SuiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuiteService {

    private final SuiteRepository repository;

    public SuiteService(SuiteRepository repository) {
        this.repository = repository;
    }

    public List<Suite> listarTodos() {
        return repository.findAll();
    }

    public void salvar(Suite suite) {
        repository.save(suite);
    }

    public Suite buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
