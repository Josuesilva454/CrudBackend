package com.spring.demo.SpringBoot3.entity;

import com.spring.demo.SpringBoot3.enuns.TipoMovimentacao;

import javax.persistence.*;
import java.time.LocalDateTime;

/**Classe do tipo Movimentacao.
* @author Josue Silva Rosa
* @version java 11
*/

@Table(name = "movimentacoes")
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime DataHoraInicio;
    private LocalDateTime DataHoraFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDateTime getDataHoraInicio() {
        return DataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        DataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return DataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        DataHoraFim = dataHoraFim;
    }
}
