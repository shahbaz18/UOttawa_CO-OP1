import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class TestTwitter {
	
	public static void main(String[] args) {
		
		String csvFile = "";
        BufferedReader br = null;	
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Integer> count = new  ArrayList<Integer>();
        String [] username = null;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	
            		username = line.split(cvsSplitBy);
            	}

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(String s : username) {
        		count.add(fetchUsers(s));
        }
        
        
        
		
	}
	
public static int fetchUsers(String username) {
		
		TwitterFactory factory = new TwitterFactory();
		Twitter twitter = factory.getInstance();
		
		try {
			User twitUser = twitter.showUser(username);
			int count = twitUser.getFollowersCount();
			return count;
		
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return 0;
	}


public ArrayList<ArrayList<String>> sortList(ArrayList<ArrayList<String>> list){
	ArrayList<ArrayList<String>> myList = list;
	  
	  Comparator<ArrayList<String>> sortor =  new Comparator<ArrayList<String>>() {

		@Override
		public int compare(ArrayList<String> list1, ArrayList<String> list2) {	
			return Integer.valueOf(list1.get(2)).compareTo(Integer.valueOf(list2.get(2)));
		}
		  
	  }; 
	  Collections.sort(myList, sortor);
	  return myList;
}

}
