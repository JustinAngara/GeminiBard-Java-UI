package com.bard.main;


import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static String directions;
	private static List<String> userMessages;
	private static List<String> aiMessages;
	public static String execCmd() throws IOException {
        String command = "cd \"path to bard folder" && Node index.js";
		ProcessBuilder builder = new ProcessBuilder(
        		
                "cmd.exe", "/c", command);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            String t="";
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                t+=line;
                System.out.println(line);
            }
			return t.replaceAll("`", "-");
	}
	
	public static void change(String input) {
	    String file = "file to index.js";
	    String newLineContent = ""+input+" "+directions+"";
	    
	    int lineToBeEdited = 9;

	    ChangeLineInFile changeFile = new ChangeLineInFile();
	    changeFile.changeALineInATextFile(file, newLineContent, lineToBeEdited);
	}
	
	public static String askInput() {
		String input;
		Scanner sc = new Scanner(System.in);
		System.out.print("You: ");
		input = sc.nextLine();
		userMessages.add(input);
		return input;
	}
	
	public static String returnList(List<String> t){
		if(t.size()==0) {
			directions ="";
			return "[]";
		}
		String temp = "[";
		
		for(int i = 0; i<t.size();i++) {
			temp += t.get(i)+',';
		}
		// removes last comma
		temp = temp.substring(0,temp.length()-1);
		return temp += ']';
	}
	
	public static void getAiInput() throws IOException {
		if(userMessages.size()>0) {
			directions=". Note: Take this as a friendly reminder that these were our previous messages. The user will be played by me, and you will act as the 'AI' messages array. I want you to pretend like an human being"
						+ "Here are the past messages we sent each other. You may take them into consideration; User(my messages array): "+returnList(userMessages)+", AI(your messages array): "+returnList(aiMessages)+"";
		}
		
		String userInput = askInput();
		if(userInput.equalsIgnoreCase("STOP")) {
			return;
		}
		String message = "Prompt: "+userInput+"";

		change(message);
		aiMessages.add(execCmd());
		
		getAiInput(); // recursive call
	}
	public static void main(String[] args) throws Exception {
		
		userMessages = new ArrayList<String>();
		aiMessages = new ArrayList<String>();
//		userMessages.add("Hello, what is the derivative of e^x?");
//		aiMessages.add("The derivative of e^x is e^x");
		
		getAiInput();


	}
}
