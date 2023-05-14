package test;

import java.util.Iterator;

public class PlayListIterator implements Iterator {
	int cur=0;
	private Item[] songs;
	public PlayListIterator(PlayList pl) {
		songs=pl.getItems();
	}
	public boolean hasNext() {
		if(cur<songs.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String next() {
		if(hasNext())
		{
			if(songs[cur].getClass().getSimpleName().equals("PlayList"))
			{
				PlayList pl=(PlayList) songs[cur++];
				StringBuilder sb=new StringBuilder();
				pl.forEach(name->sb.append(name));
				return sb.toString();
			}
			else
			{
				return songs[cur++].name;
			}
		}	
		return null;
	}
}
