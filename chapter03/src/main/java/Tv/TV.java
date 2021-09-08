package Tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;

	public TV() {
		super();
	}

	public TV(int channel, int volume, boolean power) {
		super();
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		this.power = on;

	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	public void status() {
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}

	void channel(int channel) {
		if (channel <= 1 || channel >= 255) {
			wrong();
			return;
		}

		this.channel = channel;
	}

	void channel(boolean up) {
		if (channel <= 1 || channel >= 255) {
			wrong();
			return;
		} else if (up) {
			this.channel++;
		} else {
			this.channel--;
		}
	}

	void volume(int volume) {
		if (volume <= 0 || volume >= 100) {
			wrong();
			return;
		}

		this.volume = volume;
	}

	private void wrong() {
		System.out.println("잘못된 설정 입니다.");
	}

	void volume(boolean up) {
		if (volume <= 0 || volume >= 100) {
			wrong();
			return;
		} else if (up) {
			this.volume++;
		} else {
			this.volume--;

		}

	}
}
