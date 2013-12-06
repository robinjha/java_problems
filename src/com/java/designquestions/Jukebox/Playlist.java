package com.java.designquestions.Jukebox;

import java.util.Queue;

public class Playlist {
	
	private Songs song;
	Queue<Songs> pList;
	
	public Playlist(Songs song, Queue<Songs> pL){
		this.song = song;
		this.pList = pL;
	}
	
	public Songs getNextSong(){
		return pList.peek();
	}
	
	public void addSongInQueue(Songs song){
		pList.add(song);
	}
	

}
