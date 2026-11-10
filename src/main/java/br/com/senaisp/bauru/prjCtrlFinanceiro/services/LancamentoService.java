package br.com.senaisp.bauru.prjCtrlFinanceiro.services;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public List<Lancamento> findAll() {
        return repository.findAll();
    }

    public Lancamento save(Lancamento lancamento) {
        return repository.save(lancamento);
    }
}