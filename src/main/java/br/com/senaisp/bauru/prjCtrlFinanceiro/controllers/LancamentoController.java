package br.com.senaisp.bauru.prjCtrlFinanceiro.controllers;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService service; // Mudou aqui: agora chama o Service

    @GetMapping
    public List<Lancamento> listar() {
        return service.findAll(); // Chama o método do Service
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@RequestBody Lancamento lancamento) {
        Lancamento novoLancamento = service.save(lancamento); // Chama o método do Service
        return ResponseEntity.ok(novoLancamento);
    }
}