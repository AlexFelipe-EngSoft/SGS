/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.model.concursos;

import br.ufc.sgs.model.usuarios.Usuario;
import java.util.Collection;

/**
 *
 * @author alexf
 */
public class Selecao {
    private String titulo;
    private String descricao;
    private Usuario responsavel;
    private int vagasRemuneradas;
    private int vagasVoluntarias;
    private Collection<FaseDaSelecao> fase;

    public Selecao(String titulo, String descricao, Usuario responsavel, int vagasRemuneradas, int vagasVoluntarias, Collection<FaseDaSelecao> fase) {
        setTitulo(titulo);
        setDescricao(descricao);
        setResponsavel(responsavel);
        setVagasRemuneradas(vagasRemuneradas);
        setVagasVoluntarias(vagasVoluntarias);
        setFase(fase);
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public int getVagasRemuneradas() {
        return vagasRemuneradas;
    }

    public void setVagasRemuneradas(int vagasRemuneradas) {
        this.vagasRemuneradas = vagasRemuneradas;
    }

    public int getVagasVoluntarias() {
        return vagasVoluntarias;
    }

    public void setVagasVoluntarias(int vagasVoluntarias) {
        this.vagasVoluntarias = vagasVoluntarias;
    }

    public Collection<FaseDaSelecao> getFase() {
        return fase;
    }

    public void setFase(Collection<FaseDaSelecao> fase) {
        this.fase = fase;
    }
    
}
