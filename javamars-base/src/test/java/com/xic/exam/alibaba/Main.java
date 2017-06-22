package com.xic.exam.alibaba;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

	}
	
	static String[] parseValidateIp(String inputStr) {
		ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        
        if(inputStr.length() <4 || inputStr.length() > 12)
            return (String[])result.toArray();
        
        helper(result, list, inputStr , 0);
        return (String[])result.toArray();
	}
	public static void helper(ArrayList<String> result, ArrayList<String> list, String s, int start){
        if(list.size() == 4){
            if(start != s.length())
                return;
            
            StringBuffer sb = new StringBuffer();
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        
        for(int i=start; i<s.length() && i < start+3; i++){
            String tmp = s.substring(start, i+1);
            if(isvalid(tmp)){
                list.add(tmp);
                helper(result, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    private static boolean isvalid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}
