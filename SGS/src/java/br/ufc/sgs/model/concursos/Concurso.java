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
    
}
