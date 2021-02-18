package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbem {

	public static void main(String[] args) {
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		
		int[] plays =  {500, 600, 150, 800, 2500};

		int[] albumSequence = solution(genres, plays);
		
		for(int albumI = 0; albumI < albumSequence.length; albumI++) {
			System.out.print(albumSequence[albumI] + " ");
		}
		
//		System.out.println(testMap.get("test").get(1));
		

	}
	
	    public static int[] solution(String[] genres, int[] plays) {
	        
	        Map<String, List<int[]>> genreToPlay = new HashMap<>();
	        
	        for(int genresI = 0; genresI < genres.length; genresI++) {
	            String genre = genres[genresI];
	            int numPlay = plays[genresI];
	            
	            if(genreToPlay.containsKey(genre)) {
	                int[] song = {genresI, numPlay};
	                genreToPlay.get(genre).add(song);
	            } else {
	                
	                List<int[]> songs = new ArrayList<>();
	                int[] song = {genresI, numPlay};
	                
	                songs.add(song);
	                
	                genreToPlay.put(genre, songs);
	            }
	        }
	        
	        int albumLength = 0;
	        Iterator<Entry<String, List<int[]>>> entryIter = genreToPlay.entrySet().iterator();
	        List<Genre> sumPlaysOfGenre = new ArrayList<>();
	        while(entryIter.hasNext()) {
	            
	            Entry<String, List<int[]>> genreAndPlay = (Entry<String, List<int[]>>)entryIter.next();
	            
	            String genre = genreAndPlay.getKey();
	            List<int[]> songs = genreAndPlay.getValue();
	            
	            if(songs.size() > 1) albumLength += 2;
	            else albumLength += 1;
	            
	            int sumPlay = 0;
	            
	            for(int songsI = 0; songsI < songs.size(); songsI++) {
	                
	                sumPlay += songs.get(songsI)[1];

	            }
	            sumPlaysOfGenre.add(new Genre(genre, sumPlay));
	        }
	        
	        Collections.sort(sumPlaysOfGenre, new Comparator<Genre>(){
	           
	            @Override
	            public int compare(Genre o1, Genre o2) {
	                
	                return Integer.compare(o2.getSumPlays(), o1.getSumPlays());
	                
	            }
	        });
	        
	        int[] albumSequence = new int[albumLength];
	        
	        int albumSequenceI = 0;
	        
	        for(int sumPlaysI = 0; sumPlaysI < sumPlaysOfGenre.size(); sumPlaysI++) {
	            
	            
	            List<int[]> songs = genreToPlay.get(sumPlaysOfGenre.get(sumPlaysI).getName());
	            
	            Collections.sort(songs, new Comparator<int[]>() {
	               
	                @Override
	                public int compare(int[] o1, int[] o2) {
	                    if(o1[1]==o2[1])
	                        return Integer.compare(o1[0], o2[0]);
	                    else
	                        return Integer.compare(o2[1], o1[1]);
	                }
	                
	            });
	            
	             albumSequence[albumSequenceI++] = songs.get(0)[0];
	             if(songs.size() > 1)
	            	 albumSequence[albumSequenceI++] = songs.get(1)[0];

	        }
	        
	        return albumSequence;
	    }
	}
	

class Genre{
    
    private String name;
    private int sumPlays;
    
    public Genre(){
        
    }
    
    public Genre(String name, int sumPlays) {
        this.name = name;
        this.sumPlays = sumPlays;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSumPlays() {
		return sumPlays;
	}

	public void setSumPlays(int sumPlays) {
		this.sumPlays = sumPlays;
	}
    
}


