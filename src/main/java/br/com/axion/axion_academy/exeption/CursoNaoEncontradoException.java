package br.com.axion.axion_academy.exeption;

public class CursoNaoEncontradoException  extends RuntimeException{
    public CursoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
