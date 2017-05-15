/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.sgs.dao;

import java.sql.Connection;

/**
 *
 * @author alexf
 */
public class AvaliadorDAO extends ExecutaSQL{
    
    public AvaliadorDAO(Connection conexao) {
        super(conexao);
    }
    
}
