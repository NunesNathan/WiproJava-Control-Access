package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;

import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Short> ages = new ArrayList<Short>();
    byte option;
    
    do {      
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n"
          + "2 - Finalizar sistema e mostrar relatório");
      option = scan.nextByte();
      if (option == 1) {
        System.out.println("Entre com a idade:");
        short age = scan.nextByte();
        ages.add(age);
        System.out.println(verifyAge(age));
      } else if (option == 2) {
        break;
      } else {
        System.out.println("Entre com uma opção válida");
      }
    } while (option != 2);
    
    finalReport(ages);
    scan.close();    
  }
  
  /**
   * Método de verificação da idade.
   */
  public static String verifyAge(Short age) {
    if (age < 18) {
      return "Pessoa cliente menor de idade, catraca liberada!";
    } else if (age < 50) {
      return "Pessoa adulta, catraca liberada!";
    } else {
      return "Pessoa adulta a partir de 50, catraca liberada!";
    }
  }

  /**
   * Método de relatório.
   */
  public static void finalReport(ArrayList<Short> ages) {
    System.out.print(ages.size());
  }

}
