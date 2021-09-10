package prob2;

public class MusicPhone extends Phone {

	@Override
	public void execute(String function) {
		if(function.equals("음악")) {
			playMusic();
			return;
		}
		super.execute(function);
	}

	private void playMusic() {
		System.out.println("Mp3 Player 에서 재생");
	}
	
	
	

}
