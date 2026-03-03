import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String bomb = br.readLine();
		int n = word.length();
		int m = bomb.length();
		char[] b = bomb.toCharArray();
		
		char[] stack = new char[n];
		int top=0;
		
		for(int i=0;i<n;i++) {
			stack[top++]=word.charAt(i);
			
			if(top>=m && stack[top-1] == b[m-1]) {
				boolean ok = true;
				
				for(int j=0;j<m;j++) {
					if(stack[top-m+j] != b[j]) {
						ok = false;
						break;
					}
				}
				if(ok) top-=m;
			}
		}
		
		if (top == 0) {
            System.out.print("FRULA");
        } else {
            System.out.print(new String(stack, 0, top));
        }

		
	}
}
