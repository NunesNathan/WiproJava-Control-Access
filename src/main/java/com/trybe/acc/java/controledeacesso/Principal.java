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
        short age = scan.nextShort();
        ages.add(age);
        System.out.println(verifyAge(age));
      } else if (option == 2) {
        break;
      } else {
        System.out.println("Entre com uma opção válida");
      }
    } while (option != 2);
    
    if (ages.size() != 0) {
      finalReport(ages);
    }
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
    int under = 0;
    int adult = 0;
    int over = 0;
    int total = ages.size();

    for (short age : ages) {      
      if (age < 18) {
        under += 1;
      } else if (age < 50) {
        adult += 1;
      } else {
        over += 1;
      }
    }
    
    double underPer = (1000 * under / total / 10.0);
    double adultPer = (1000 * adult / total / 10.0);
    double overPer = (1000 * over / total / 10.0);

    System.out.println("----- Quantidade -----\n"
        + "menores: " + under + "\n"
        + "adultas: " + adult + "\n"
        + "a partir de 50: " + over + "\n"
        + "\n"
        + "----- Percentual -----\n"
        + "menores: " + underPer + "%\n"
        + "adultas: " + adultPer + "%\n"
        + "a partir de 50: " + overPer + "%\n"
        + "\n"
        + "TOTAL: " + total);
  }

}
