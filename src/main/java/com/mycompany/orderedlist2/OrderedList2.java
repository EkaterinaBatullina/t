/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.orderedlist2;

/**
 *
 * @author ekaterina
 */
import java.util.Scanner;
public class OrderedList2 {
    Node head;

    public static void main(String[] args) {
        OrderedList2 list = new OrderedList2();
        list.input();
        list.sort();
        list.output();          
    }
    
    public void input(){
        Scanner in = new Scanner (System.in);
        while (true){
            Node n =new Node();
            if (in.hasNextInt()){
                n.value = in.nextInt();
            }
            else{
                return;
            }
            add(n);
        }
    }
    
    public void add(Node n){
        if (head == null){
            head = n;
        }
        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = n;
            n.previous = current;
        }
    }
    
    public void sort(){
        Node current =head;
        while (current.next != null){
            if (current.value - current.next.value > 0){
                swap(current, current.next);
                current = head;
            }
            else{
                current = current.next;
            }
        } 
    }
    
    public void swap(Node e1, Node e2){
        if (e1 == head){
            head = e2;
            e2.previous = null;
        }
        else{
            Node current = head;
            while (current.next != e1){
                current = current.next;
            }
            current.next = e2;
            e2.previous = current.next;
        }
        e1.next = e2.next;
        e1.previous = e2;
        e2.next = e1;
    }
    
    public void output(){
        Node current = head;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    
    }
    
}
