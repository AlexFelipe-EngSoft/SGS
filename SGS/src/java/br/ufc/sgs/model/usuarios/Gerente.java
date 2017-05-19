/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.model.usuarios;

import br.ufc.sgs.model.exceptions.DadoInvalidoException;

/**
 *
 * @author alexf
 */
public class Gerente extends Usuario implements Responsavel{
    
    public Gerente(String nome, String email, String senha) throws DadoInvalidoException {
        super(nome, email, senha);
    }
    
}
