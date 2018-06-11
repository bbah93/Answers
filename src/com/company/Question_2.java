package com.company;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Stack;

public class Question_2 {

    /**
     *
     *decodeString(s): Given an encoded string, return its corresponding decoded string.

     The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times.
     Note: k is guaranteed to be a positive integer.

     For s = "4[ab]", the output should be decodeString(s) = "abababab"
     For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
     */


    public static void main(String[] args) {
        System.out.println(decodeString("4[ab]"));
    }


    public static String decodeString(String s){

        Stack<Node> nodeStack = new Stack<Node>();
        String numberHolder = "";
        nodeStack.push(new Node(1));

       for(int i = 0; i < s.length(); i++ ){
            char characterHolder = s.charAt(i);

            if (characterHolder >= '0' && characterHolder <= '9') {
                numberHolder += characterHolder;
            } else if(characterHolder == '['){
                if(numberHolder.length() > 0){
                    int n = Integer.parseInt(numberHolder);
                    //each Node instance will hold a number value found in our encoded string
                    nodeStack.push(new Node(n));
                    numberHolder = "";
                }
            } else if(characterHolder == ']'){
                Node topNode = nodeStack.pop();
                if(nodeStack.isEmpty()){
                    //we can conclude that are encodedString has an empty bracket here
                    return "";
                } else {
                    nodeStack.peek().nodeList.add(topNode);
                }
            } else {
                //if we go through all of these checks then this means we found a letter character
                //then we add the character to our ArrayList inside our most recent node
                nodeStack.peek().nodeList.add(new Node(characterHolder));
            }
        }
        return createDecodedString(nodeStack.peek());

    }

    public static String createDecodedString(Node node) {
        String strDecoder = "";
        //if the node has an empty character value than we need to...
        //go into our nodeList and iterate through their Node objects
        if(node.isCharacterNull){
            for(int i = 0; i < node.number; i++){
                for(Node tempNode: node.nodeList){
                    strDecoder += createDecodedString(tempNode);
                }
            }
        } else{
            // if we have found a character to be copied in our node then store it in our strDecoder
            strDecoder += node.character;
        }
        return strDecoder;
    }


    //create inner class object to hold unique properties as we iterate through string
    static class Node{

    ArrayList<Node> nodeList;
    char character;
    int number;
    boolean isCharacterNull = true;

    //this Node object will be instantiated when we don't find a valid char in our string
        //valid chars are letter Aa-Zz
    public Node(int x){
        number = x;
        nodeList = new ArrayList<>();
    }

    //when we iterate through encoded string and find a char we will store the char in a node object
    public Node(char c){
        character = c;
        isCharacterNull = false;
    }
    }
}
