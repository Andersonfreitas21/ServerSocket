/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Programador-03
 */
public class ServidorSocket {
    
    
  public static void main(String[] args) {
    try {
      // Instancia o ServerSocket ouvindo a porta 12345
      ServerSocket servidor = new ServerSocket(54391);
      System.out.println("Servidor ouvindo a porta 54391");
      
      while(true) {
          try ( // o método accept() bloqueia a execução até que
          // o servidor receba um pedido de conexão
                  Socket cliente = servidor.accept()) {
              System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
              try (ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream())) {
                  saida.flush();
                  saida.writeObject(new Date());
              }
          }
      }  
    }   
    catch(IOException e) {
       System.out.println("Erro: " + e.getMessage());
    }
    finally {
    
    }  
  }     

    
}
