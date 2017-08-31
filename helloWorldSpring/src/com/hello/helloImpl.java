/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hello;

/**
 *
 * @author K1336511
 */
public class helloImpl implements Hello {
    String name = "That cool guy";
    public void sayHello(String name) {
        System.out.println("Hello world, and " + name);
    }
}
