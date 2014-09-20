package edu.asu.dynamic.arxiv;

public class Paper {
		public String originID;
		public Integer newID;
		public Integer publishDate;
		
		public Paper(){
			originID = null;
			newID = 0;
			publishDate = 0;
		}
		
		public Paper(String originID, String publishDate){
			this.originID = originID;
			this.newID = 0;
			setPublishDate(publishDate);
		}
		
		public void setOriginID(String originID){
			this.originID = originID;
		}
		public void setNewID(Integer newID){
			this.newID = newID;
		}
		public Integer setPublishDate(String date){
			String[] datesStrings = date.split("-");
			if(datesStrings.length != 3){
				System.out.println("Date format error for " + this.originID);
				return -1;
			}
			else{
				Integer year = Integer.valueOf(datesStrings[0]);
				Integer month = Integer.valueOf(datesStrings[1]);
				Integer day = Integer.valueOf(datesStrings[2]);
				this.publishDate = year*10000+month*100+day;
				return this.publishDate;
			}
		}
		
		public String toString(){
			return "Paper: [originID=" + this.originID + " newID=" + String.valueOf(this.newID) +
					" publishDate=" + String.valueOf(this.publishDate) + "]"; 
		}

		
		public int compareTo(Paper p){
			return this.publishDate.compareTo(p.publishDate);
		}
		
		public static void main(String[] args){
			Paper paper = new Paper();
			System.out.println(paper);
			paper.setOriginID("12334s");
			System.out.println(paper);
			paper.setNewID(1);
			System.out.println(paper);
			paper.setPublishDate("2000-02-02");
			Paper paper2 = new Paper("234ty","2000-02-02");
			System.out.println(paper);
			System.out.println(paper2);
			System.out.println(paper.publishDate);
			System.out.println(paper2.publishDate);
			System.out.println(paper.publishDate.compareTo(paper2.publishDate));
		}
		
		
}
