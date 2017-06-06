/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.model.concurso;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author alexf
 */
public class Concurso {
    private int id;
    private String titulo;
    private String descricao;
    private Documento edital;
    private String preRequisitos;
    private String maisInformacoes;
    private boolean isDivulgado;
    private Collection<Documento> documentos;
    private Collection<Selecao> selecoes;
    private Collection<Fase> fases;
  

    public static void main(String[] args) {
        Collection<Fase> ateste = new ArrayList<Fase>();
        ateste.add(new Fase(0, "titulo", "descricao", LocalDate.of(2016, 12, 12), LocalDate.of(2017, 4, 3), null, null, null, null));
        ateste.add(new Fase(0, "titulo", "descricao", LocalDate.of(2017, 5, 3), LocalDate.of(2017, 6, 17), null, null, null, null));
        Concurso c = new Concurso("titulo", "descricao", null, "preRequisitos", "maisInformacoes", true, null, null, ateste);
        if(c.isEncerrada()){
            System.out.println("Deu errado");
        }
        else{
            System.out.println("Deu certo");
        }
    }
    
    public Concurso(String titulo, String descricao, Documento edital, String preRequisitos, String maisInformacoes, boolean isDivulgado, Collection<Documento> documentos, Collection<Selecao> selecoes,Collection<Fase> fases) {
        setTitulo(titulo);
        setDescricao(descricao);
        setEdital(edital);
        setPreRequisitos(preRequisitos);
        setMaisInformacoes(maisInformacoes);
        setIsDivulgado(isDivulgado);
        setDocumentos(documentos);
        setSelecoes(selecoes);
        setFases(fases);
    }
    public Concurso(int id, String titulo, String descricao, Documento edital, String preRequisitos, String maisInformacoes, boolean isDivulgado, Collection<Documento> documentos, Collection<Selecao> selecoes, Collection<Fase> fases ) {
        this.id = id;
        setTitulo(titulo);
        setDescricao(descricao);
        setEdital(edital);
        setPreRequisitos(preRequisitos);
        setMaisInformacoes(maisInformacoes);
        setDocumentos(documentos);
        setSelecoes(selecoes);
        setFases(fases);
    } 

    public int getId() {
        return id;
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

    public Documento getEdital() {
        return edital;
    }

    public void setEdital(Documento edital) {
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

    public boolean isIsDivulgado() {
        return isDivulgado;
    }

    public void setIsDivulgado(boolean isDivulgado) {
        this.isDivulgado = isDivulgado;
    }
   
    public Collection<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Collection<Documento> documentos) {
        this.documentos = documentos;
    }

    public Collection<Selecao> getSelecoes() {
        return selecoes;
    }

    public void setSelecoes(Collection<Selecao> selecoes) {
        this.selecoes = selecoes;
    }

    public Collection<Fase> getFases() {
        return fases;
    }
    
    public void setFases(Collection<Fase> fases) {
        this.fases = fases;
    }
    
   public boolean isInscricoesAbertas(){
        if(getFases() != null && !getFases().isEmpty() && isIsDivulgado()){ 
        ArrayList<Fase> fases = new ArrayList(getFases());
         Fase ultima = fases.get(0);
         if(ultima == null){
             return false;
         }
         for(Fase fase : fases){
             if(fase.getDataTermino().isBefore(ultima.getDataTermino())){//A primeira fase é a fase de inscrição, então buscamos a fase que vier primeiro. 
                 ultima = fase;
             }
         }
         LocalDate atual = LocalDate.now();
         return (atual.isAfter(ultima.getDataInicio())&& atual.isBefore(ultima.getDataTermino()));
         //Retorna verdade se a data atual estiver antes do término e depois do início da primeira fase.
        }
        return false;
    }
    public boolean isEncerrada(){
       if(getFases() != null && !getFases().isEmpty() && isIsDivulgado()){
            ArrayList<Fase> fases = new ArrayList(getFases());
            Fase ultima = fases.get(0);
            if(ultima == null){
                return false;
            }
            for(Fase fase : fases){
                if(fase.getDataTermino().isAfter(ultima.getDataTermino())){//Se a fase terminar depois, ela é uma fase posterior. 
                    ultima = fase;
                }
            }
            LocalDate atual = LocalDate.now();
            return atual.isAfter(ultima.getDataTermino());//Retorna verdade se a data atual for depois da data da última fase.
        }
       return true;
    }    
    
    public Fase getFaseAtual(){
        if(getFases() != null && !getFases().isEmpty() && isIsDivulgado()){ 
        ArrayList<Fase> fases = new ArrayList(getFases());
        for(Fase fase : fases){
            LocalDate atual = LocalDate.now();
            if(atual.isAfter(fase.getDataInicio())&& atual.isBefore(fase.getDataTermino())){//Verificas
                return fase;
            }
        }
        return null;
        }
        return null; 
    }
    
    public LocalDate getDataTermino(){
        if(getFases() != null && !getFases().isEmpty() && isIsDivulgado()){
            ArrayList<Fase> fases = new ArrayList(getFases());
            Fase ultima = fases.get(0);
            if(ultima == null){
                return null;//Se não existir nenhuma fase cadastrada
            }
            for(Fase fase : fases){
                if(fase.getDataTermino().isAfter(ultima.getDataTermino())){//Se a fase terminar depois, ela é uma fase posterior. 
                    ultima = fase;
                }
            }
            return ultima.getDataTermino();
        }return null;
    }

    public Fase faseInscricao(){
       if(getFases() != null && !getFases().isEmpty() && isIsDivulgado()){
           ArrayList<Fase> fases = new ArrayList<>(getFases());
           Fase minima = fases.get(0);
           for(Fase fase: fases){
               if(fase.getDataInicio().compareTo(minima.getDataInicio()) < 0) minima = fase;
           }
           return minima;
       }
       return null;
    }
    public Fase faseFinal(){
        if(getFases() != null && !getFases().isEmpty() && isIsDivulgado()){
           ArrayList<Fase> fases = new ArrayList<>(getFases());
           Fase maximo = fases.get(0);
           for(Fase fase: fases){
               if(fase.getDataInicio().compareTo(maximo.getDataInicio()) > 0) maximo = fase;
           }
           return maximo;
       }
       return null;
    }

}
