package com.dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author chennaposham
 *
 */
public class DiceGame {
	public static HashMap<String, Integer> valuesMap;
	public static HashMap<Integer, Integer> repeatedRolls;
	public static HashSet<Integer> uniqueRolls;
	public static List<Integer> inputRolls;
	public static final String ONES = "1000";
	public static final String TWOS = "200";
	public static final String THREES = "300";
	public static final String FOURS = "400";
	public static final String FIVES = "500";
	public static final String SIXS = "600";
	public static final String ONE = "100";
	public static final String FOUR = "40";
	
	public DiceGame(String[] args){
		
		if(null != args && args.length == 5){
			valuesMap = new HashMap<String, Integer>(8);
			uniqueRolls = new HashSet<Integer>();
			inputRolls = new ArrayList<Integer>(args.length);
			valuesMap.put("1s", 1000);
			valuesMap.put("2s", 200);
			valuesMap.put("3s", 300);
			valuesMap.put("4s", 400);
			valuesMap.put("5s", 500);
			valuesMap.put("6s", 600);
			valuesMap.put("1", 100);
			valuesMap.put("2", 0);
			valuesMap.put("3", 0);
			valuesMap.put("4", 40);
			valuesMap.put("5", 0);
			valuesMap.put("6", 0);
			
			//System.out.println("Input Values -> "+args.toString());
			for(String input : args){
				try{
					if(Integer.parseInt(input) <= 6){
						inputRolls.add(Integer.parseInt(input));
					}else{
						System.out.println("Each roll value should not be greater than 6");
						return;
					}
				}catch(NumberFormatException nfe){
					System.out.println("Please enter only neumeric values");
					return;
				}
			}
			uniqueRolls.addAll(inputRolls);
			System.out.println("Unique Rolls -> "+uniqueRolls);
			Collections.sort(inputRolls);
			//calculateTotal();
		}else{
			System.out.println("Enter only 5 rolls");
		}
	}
	
	public  void calculateTotal(){
		int total = 0;
		if(uniqueRolls.size() > 1){
			repeatedRolls = new HashMap<Integer, Integer>(uniqueRolls.size());
			for(int i=0; i<inputRolls.size()-1; i++){
				int counter = 1;
				for(int j=i+1; j<inputRolls.size(); j++){
					if(inputRolls.get(i) == inputRolls.get(j)){
						counter++;
						if(j == inputRolls.size()-1){
							repeatedRolls.put(inputRolls.get(j), counter);
							System.out.println("Adding Repeated Rolls Key -> "+inputRolls.get(j)+ "Value -> "+counter);
						}
					}else{
						if(null != repeatedRolls.get(inputRolls.get(i))){
							System.out.println("Adding Repeated Rolls Key -> "+inputRolls.get(i)+ " Value -> " +(repeatedRolls.get(inputRolls.get(i))+counter));
							repeatedRolls.put(inputRolls.get(i), repeatedRolls.get(inputRolls.get(i))+counter);
						}else{
							repeatedRolls.put(inputRolls.get(i), counter);
							System.out.println("Adding Repeated Rolls Key -> "+inputRolls.get(i)+ "Value -> "+counter);
						}
						if(j == inputRolls.size()-1){
							repeatedRolls.put(inputRolls.get(j), 1);
							System.out.println("Adding Repeated Rolls Key -> "+inputRolls.get(j)+ "Value -> "+counter);
						}
						i=j-1;
						break;
					}
					if(counter == 3){
						repeatedRolls.put(inputRolls.get(i), counter);
						System.out.println("Adding Repeated Rolls Key -> "+inputRolls.get(i)+ "Value -> "+counter);
						System.out.println("j+1 == inputRolls.size()-1 ==> "+(j+1)+ " == "+(inputRolls.size()-1));
						if(j+1 == inputRolls.size()-1){
							System.out.println("repeatedRolls.get(j+1) ==> "+repeatedRolls.get(j+1));
							System.out.println("inputRolls.get(i) ==> "+inputRolls.get(i)+" inputRolls.get(j+1) ==> "+inputRolls.get(j+1) );
							if(null != repeatedRolls.get(inputRolls.get(j+1))){
								repeatedRolls.put(inputRolls.get(j+1), (counter+1));
								System.out.println("Adding Repeated Rolls Key -> "+inputRolls.get(i)+ "Value -> " +(counter+1));
							}else{
								repeatedRolls.put(inputRolls.get(j+1), 1);
								System.out.println("Adding Repeated Rolls Key -> "+inputRolls.get(i)+ "Value -> 1");
							}
							
						}
						i=j;
						break;
					}
				}
			}
			Iterator iter = uniqueRolls.iterator();
			
			while(iter.hasNext()){
				Integer rollValue = (Integer) iter.next();
				if(null != repeatedRolls.get(rollValue)){
					if(repeatedRolls.get(rollValue) >= 3){
						total = total + valuesMap.get(rollValue.toString()+"s") + (valuesMap.get(rollValue.toString())*(repeatedRolls.get(rollValue)-3));
					}else{
						total = total + (valuesMap.get(rollValue.toString())*(repeatedRolls.get(rollValue)));
					}
				}
			}
		}else{
			total = total + valuesMap.get(inputRolls.get(0).toString()+"s") + (valuesMap.get(inputRolls.get(0).toString())*2);
		}
		System.out.println("Total rolls count -> " +total);
	}

}
