package basic;

import java.util.StringTokenizer;

public class Calculation {  
  	
	// input: {2, 9, 6}, output: 9   // test_elmayorEstaEnMedio()
	// input: {2, 6, 9}, output: 9   // test_elmayorEsElUltimo()
	// input: {9, 6, 2}, output: 9   // test_elmayorEsElPrimero()
	// input: {}, output: 0          // test_elmayorEsElPrimero()
	// input: {7}, output: 7          // test_elmayorEsElPrimero()
	// input: {-4, 2, -5}, output: 2   // test_mezclaNegativosPositivos()
	// input: {9, 6, 9, 5, 8}, output: 9   // test_elmayorEstaDuplicado()
	// input: {-5, -6, -2}, output: -2 // test_todosNegativos()
    public static int findMax(int[] arr){  
        int max = 0;
        for(int i=0;i<arr.length;++i){  
            if(max<arr[i])  
                max=arr[i];  
        }  
        return max;  
    }   
     
    // input: "Hola qué tal", output: "aloH éuq lat"
    public static String reverseWord(String str){  
  
        StringBuilder result=new StringBuilder();  
        StringTokenizer tokenizer=new StringTokenizer(str," ");  
  
        while(tokenizer.hasMoreTokens()){  
	        StringBuilder sb=new StringBuilder();  
	        sb.append(tokenizer.nextToken());  
	        sb.reverse();  
	  
	        result.append(sb);  
	        result.append(" ");  
        }
        
        return result.toString().trim();  
    }    
}  



