package tast0001;

import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
		System.out.println("-------▶1차◀-------");
		int[] num = new int[6];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*45) + 1;
			for (int j = 0; j < i; j++) {
				if(num[i] ==num[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		System.out.println("------▼번호정렬▼------");
		for (int i = 0; i < num.length-1; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i] > num[j]) {
					int tmp = num[j];
					num[j] = num[i];
					num[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		
		int bonus;
        do {
            bonus = (int)(Math.random() * 45) + 1;
            boolean isDuplicate = false;
            for (int i = 0; i < num.length; i++) {
                if (num[i] == bonus) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                bonus = 0;
            }
        } while (bonus == 0); 

        System.out.println("보너스 : [" + bonus + "]");
        System.out.println();
		
		System.out.println("-------▶2차◀-------");
		int[] num1 = new int[6];
		for (int i = 0; i < num1.length; i++) {
			num1[i] = (int)(Math.random()*45) + 1;
			for (int j = 0; j < i; j++) {
				if(num1[i] ==num1[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(num1));
		System.out.println("------▼번호정렬▼------");
		for (int i = 0; i < num1.length-1; i++) {
			for (int j = i+1; j < num1.length; j++) {
				if(num1[i] > num1[j]) {
					int tmp = num1[j];
					num1[j] = num1[i];
					num1[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(num1));
		
		int bonus1;
        do {
            bonus1 = (int)(Math.random() * 45) + 1;
            boolean isDuplicate = false;
            for (int i = 0; i < num.length; i++) {
                if (num1[i] == bonus1) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                bonus1 = 0;
            }
        } while (bonus1 == 0); 

        System.out.println("보너스 : [" + bonus1 + "]");
		System.out.println();
		
		System.out.println("-------▶3차◀-------");
		int[] num2 = new int[6];
		for (int i = 0; i < num2.length; i++) {
			num2[i] = (int)(Math.random()*45) + 1;
			for (int j = 0; j < i; j++) {
				if(num2[i] ==num2[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(num2));
		System.out.println("------▼번호정렬▼------");
		for (int i = 0; i < num2.length-1; i++) {
			for (int j = i+1; j < num2.length; j++) {
				if(num2[i] > num2[j]) {
					int tmp = num2[j];
					num2[j] = num2[i];
					num2[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(num2));
		
		int bonus2;
        do {
            bonus2 = (int)(Math.random() * 45) + 1;
            boolean isDuplicate = false;
            for (int i = 0; i < num2.length; i++) {
                if (num2[i] == bonus2) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                bonus2 = 0;
            }
        } while (bonus2 == 0); 
        System.out.println("보너스 : [" + bonus2 + "]");
		System.out.println();
		
		System.out.println("-------▶4차◀-------");
		int[] num3 = new int[6];
		for (int i = 0; i < num3.length; i++) {
			num3[i] = (int)(Math.random()*45) + 1;
			for (int j = 0; j < i; j++) {
				if(num3[i] ==num3[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(num3));
		System.out.println("------▼번호정렬▼------");
		for (int i = 0; i < num3.length-1; i++) {
			for (int j = i+1; j < num3.length; j++) {
				if(num3[i] > num3[j]) {
					int tmp = num3[j];
					num3[j] = num3[i];
					num3[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(num3));
		
		int bonus3;
        do {
            bonus3 = (int)(Math.random() * 45) + 1;
            boolean isDuplicate = false;
            for (int i = 0; i < num3.length; i++) {
                if (num3[i] == bonus3) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                bonus3 = 0;
            }
        } while (bonus3 == 0); 
        System.out.println("보너스 : [" + bonus3 +"]");
		
		System.out.println();
		
		System.out.println("-------▶5차◀-------");
		int[] num4 = new int[6];
		for (int i = 0; i < num4.length; i++) {
			num4[i] = (int)(Math.random()*45) + 1;
			for (int j = 0; j < i; j++) {
				if(num4[i] ==num4[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(num4));
		System.out.println("------▼번호정렬▼------");
		for (int i = 0; i < num4.length-1; i++) {
			for (int j = i+1; j < num4.length; j++) {
				if(num4[i] > num4[j]) {
					int tmp = num4[j];
					num4[j] = num4[i];
					num4[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(num4));
		
		int bonus4;
        do {
            bonus4 = (int)(Math.random() * 45) + 1;
            boolean isDuplicate = false;
            for (int i = 0; i < num4.length; i++) {
                if (num4[i] == bonus4) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                bonus4 = 0;
            }
        } while (bonus4 == 0); 
        System.out.println("보너스 : [" + bonus4 + "]");
		System.out.println();

	}

}
