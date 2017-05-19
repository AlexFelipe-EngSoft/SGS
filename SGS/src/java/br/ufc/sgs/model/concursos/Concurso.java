/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.model.concursos;

import java.io.File;
import java.util.Collection;

/**
 *
 * @author alexf
 */
public class Concurso {
    private String titulo;
    private String descricao;
    private File edital;
    private String preRequisitos;
    private String maisInformacoes;
    private Collection<File> documentos;
    private Collection<Fase> fases;
    private Collection<Selecao> selecoes;

    public Concurso(String titulo, String descricao, File edital, String preRequisitos, String maisInformacoes, Collection<File> documentos, Collection<Fase> fases, Collection<Selecao> selecoes) {
        setTitulo(titulo);
        setDescricao(descricao);
        setEdital(edital);
        setPreRequisitos(preRequisitos);
        setMaisInformacoes(maisInformacoes);
        setDocumentos(documentos);
        setFases(fases);
        setSelecoes(selecoes);
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

    public File getEdital() {
        return edital;
    }

    public void setEdital(File edital) {
        this.edital = edital;
    }

    public String getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(String preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public String getMaisInformacoes() {
        return maisInformacoes;
    }

    public void setMaisInformacoes(String maisInformacoes) {
        this.maisInformacoes = maisInformacoes;
    }

    public Collection<File> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Collection<File> documentos) {
        this.documentos = documentos;
    }

    public Collection<Fase> getFases() {
        return fases;
    }

    public void setFases(Collection<Fase> fases) {
        this.fases = fases;
    }

    public Collection<Selecao> getSelecoes() {
        return selecoes;
    }

    public void setSelecoes(Collection<Selecao> selecoes) {
        this.selecoes = selecoes;
    }

    @Override
    public String toString() {
        return "Concurso{" + "titulo=" + titulo + ", descricao=" + descricao + ", edital=" + edital + ", preRequisitos=" + preRequisitos + ", maisInformacoes=" + maisInformacoes + ", documentos=" + documentos + ", fases=" + fases + ", selecoes=" + selecoes + '}';
    }
    
    
}
