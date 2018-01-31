/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayList;

/**
 *
 * @author lukas
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList names = new ArrayList();
           names.add("Sam");
names.add("Martha");

for (int i = 1; i < names.size(); i++) {
    names.add(i, "+");
}
System.out.println(names);
    }
    
}
