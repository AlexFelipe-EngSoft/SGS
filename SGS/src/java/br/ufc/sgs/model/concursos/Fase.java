/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.model.concursos;

import java.time.LocalDate;

/**
 *
 * @author alexf
 */
public class Fase {
    private String titulo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private CriterioDeSelecao criterioDeSelecao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo != null)
            this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao != null)
            this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        if(dataInicio != null && dataInicio.isBefore(dataTermino))
            this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        if(dataTermino != null && dataTermino.isAfter(dataInicio))
            this.dataTermino = dataTermino;
        
    }

    public CriterioDeSelecao getCriterioDeSelecao() {
        return criterioDeSelecao;
    }

    public void setCriterioDeSelecao(CriterioDeSelecao criterioDeSelecao) {
        this.criterioDeSelecao = criterioDeSelecao;
    }
    
}
