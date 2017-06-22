package io.github.richardmars.exam.jd;

import org.junit.Test;

public class Main2 {
	public static void main(String[] args) {

		
		
	}
	
	
	
	public static void sort(int[] data) {
        for (int index = 1; index <= data.length - 1; index++) {
            int temp = data[index];
            int j = index - 1;
            for (; j >= 0 && temp < data[j]; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = temp;
        }
    }
	
	@Test
	public void testSort() {
		int[] datas = new int[]{21, 4, 7, 48};
		sort(datas);
		for (int data : datas) {
			System.out.println(data);
		}
		
	}
	
	/*public static void sort(int[] datas) {
		int j, p;
		
		int tmp;
		for(p = 1; p < datas.length; p++) {
			tmp = datas[p];
			for(j = p - 1; j > 0 && datas[j] > tmp; j--) {
				datas[j+1] = datas[j];
			}
			datas[j+1] = tmp;
		}
	}*/
}
