package food.delivery.database;


public class Review {


		private int idReview;
		
		private String testoReview;
			
		private int ordine;
		
		
		
		@Override
		public String toString() {
			return "Review [idReview=" + idReview + ", testoReview=" + testoReview + ", ordine=" + ordine + "]";
		}



		public Review (int idReview, String testoReview, int ordine)
		                    
			{
			   this.idReview = idReview;
			     
				this.testoReview = testoReview;
				
				this.ordine = ordine;
			}
			
		
	}

