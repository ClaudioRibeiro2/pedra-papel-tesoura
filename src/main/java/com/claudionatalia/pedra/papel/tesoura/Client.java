/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.claudionatalia.pedra.papel.tesoura;
import java.util.Scanner;
import javax.websocket.*;

/**
 *
 * @author claudioconti
 */
public class Client {
    
    private Session session;
    
    public void comecarJogo(){
        Scanner scanner = new Scanner(System.in);
        String papel = "PAPEL CORTADOR DE CÉUS";
        String pedra = "PEDRA RELÂMPAGO DIVINA";
        String tesoura = "TESOURA DE AÇO CELESTIAL";
        
        System.out.println("Bem vindo ao jogo ATAQUES FURIOSOS!");
        System.out.println("Escolha uma opção:");
        System.out.printf("1. %s!%n",papel);
        System.out.printf("2. %s!%n",pedra);
        System.out.printf("3. %s!%n",tesoura);
        System.out.print("=> ");
        
        int escolhaJogador = scanner.nextInt();
        String escolha;
        
        switch(escolhaJogador){
            case 1 -> escolha = papel;
            case 2 -> escolha = pedra;
            case 3 -> escolha = tesoura;
            default -> {
                System.out.println("Escolha inválida! Tente novamente: ");
                escolha = "";
                comecarJogo();
            }
        }
        
        System.out.println("Você escolheu: " +escolha);
        mensagemEnvia(escolha);
    }
    
    @OnOpen
    public void servAbre(Session session){
        this.session = session;
        System.out.println("Conectado no servidor!");
    }
    
    @OnMessage
    public void servMensagem(String message){
        System.out.println("Mensagem do servidor: "+message);
    }
    
    public void enviarMensagem(String message){
        this.session.getAsyncRemote().sendText(message);
    }
    
    @OnClose
    public void servFechar(Session session){
        System.out.println("Desconectado do servidor!");
    }
}
