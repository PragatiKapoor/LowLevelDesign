package Model;

public class Player {
	String name;
	PlayingPiece pp;
	
	public Player(String name,PlayingPiece pp) {
		this.name=name;
		this.pp=pp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayingPiece getPp() {
		return pp;
	}

	public void setPp(PlayingPiece pp) {
		this.pp = pp;
	}
	
}
