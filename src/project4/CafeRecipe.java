package project4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class CafeRecipe {
 	// 멤버 변수 초기화
	String menuName;
	int price;
	ArrayList<String> ingredients = new ArrayList<>();
	
	// 기본 생성자 (1)
	public CafeRecipe() {}
	
	// 기본 생성자 (2) - 가변인자 생성자 
	public CafeRecipe(String menuName,int price, String... ingredient) {
		this.menuName = menuName;
		this.price = price;
		this.ingredients.addAll(Arrays.asList(ingredient));
	}

	// 기본 생성자 (3)
 	// 향상된 for 문을 사용하여 추가 
	public CafeRecipe(String menuName, int price, ArrayList<String> ingredient) {
	 	this.menuName = menuName;
	 	this.price = price;
	 	
    for (String m : ingredients) {
         this.ingredients.add(m);
    }
	}
	
//	// 기본 생성자 (4) - 가변인자 생성자 
//	public CafeRecipe(String menuName,int price) {
//		this.menuName = menuName;
//		this.price = price;
//	}

	// hashCode() and equals()...
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CafeRecipe other = (CafeRecipe) obj;
		return Objects.equals(ingredients, other.ingredients);
	}
 
	
	
}
