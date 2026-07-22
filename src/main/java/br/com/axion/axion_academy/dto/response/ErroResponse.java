package br.com.axion.axion_academy.dto.response;
import java.time.LocalDateTime;
public class ErroResponse {
    private int status;
    private String mensagem;
    private LocalDateTime momento;

    public ErroResponse(int status, String mensagem, LocalDateTime momento) {
        this.status = status;
        this.mensagem = mensagem;
        this.momento = momento;
    }

    public int getStatus() {return status;}
    public void setStatus(int status) {this.status = status;}
    public String getMensagem() {return mensagem;}
    public LocalDateTime getMomento() {return momento;}

}
