/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.model.concursos;

import br.ufc.sgs.model.usuarios.Avaliador;
import java.time.LocalDate;
import java.util.Collection;

/**
 *
 * @author alexf
 */
public class FaseDaSelecao extends Fase{
    private int id_fase;
    private Collection<Avaliador> avaliadores;

    public FaseDaSelecao(String titulo, String descricao, LocalDate dataInicio, LocalDate dataTermino, CriterioDeSelecao criterioDeSelecao, Collection<Avaliador> avaliadores) {
        super(titulo, descricao, dataInicio, dataTermino, criterioDeSelecao);
        setAvaliadores(avaliadores);
    }
    
    public int getId_fase() {
        return id_fase;
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
    }

    public Collection<Avaliador> getAvaliadores() {
        return avaliadores;
    }

    public void setAvaliadores(Collection<Avaliador> avaliadores) {
        this.avaliadores = avaliadores;
    }
    
}
