package com.gilbertopapa.shareimage.util;

import java.util.HashMap;

/**
 * Created by GilbertoPapa on 20/08/2018.
 */

public class ParseError {
    private HashMap<Integer,String> hashMapErros;

    public ParseError() {
        this.hashMapErros = new HashMap<>();
        this.hashMapErros.put(201,"Senha não preenchida!");
        this.hashMapErros.put(202,"Usuário já está cadastrado!");
    }

    public String getError(int codError){
        return this.hashMapErros.get(codError);
    }
}
