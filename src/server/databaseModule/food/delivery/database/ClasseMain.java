package food.delivery.database;

import java.util.List;

public class ClasseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReviewDatabase rdb = new ReviewDatabase ();
		List <Review> Lista = rdb.getReview();
		System.out.println (Lista);
		Lista.forEach(System.out::println);
		System.out.println ("\n \n \n");
		
		Review r = rdb.getFromId(5);
		System.out.println (r);

	}

}
