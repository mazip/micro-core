package com.microframework.executor.test;

import java.util.List;
import java.util.Map;

public class Bubble {

	
	public static void main(String[] args) {
		
//		int[] s= new int[]{1,4,8,65,3,44,90};
//		
//		bubbleSort(s);
//		
//		for(int i=0;i<s.length;i++){
//			System.out.print(s[i]+" ");
//		}
		
		Bubble b = new Bubble();
		b.test();
		
	}
	
	
	public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
    	
  
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
	
	
	public static void bubbleSort(int[] s){
		int temp=0;
		for(int m=s.length-1;m>0;m--){
			for(int n=0;n<s.length-1;n++){
				if(s[n+1]<s[n]){
					temp=s[n];
					s[n]=s[n+1];
					s[n+1]=temp;
				}
				
			}
			
		}
		
		
	}
	
	
}
