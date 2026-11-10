package br.com.senaisp.bauru.prjCtrlFinanceiro.models;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.enums.TipoLancamento;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamentos") 
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String descricao;
    
    @Column(nullable = false, precision = 12, scale = 2) 
    private BigDecimal valor;
    
    // O nome no banco é data_lancamento, então precisamos mapear isso
    @Column(name = "data_lancamento", nullable = false)
    private LocalDate dataLancamento;

    @Column(length = 500)
    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    // Relacionamento com Categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false) 
    private Categoria categoria;

    // Relacionamento com Usuário (que também está no seu SQL)
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public TipoLancamento getTipo() { return tipo; }
    public void setTipo(TipoLancamento tipo) { this.tipo = tipo; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}