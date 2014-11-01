
public class ReadingMusicPlayer {

	public static void PlayBasic(EmotivReading reading) throws Exception
	{
		if (reading.Blink)
			MusicPlayer.playDrum();
		if (reading.WinkLeft)
			MusicPlayer.playBass();
		if (reading.WinkRight)
			MusicPlayer.playBass2();
		if (reading.LookingLeft)
			MusicPlayer.playFlute();
		if (reading.LookingRight)
			MusicPlayer.playGuitar();
		if (reading.Laugh)
			MusicPlayer.playPiano();
		if (reading.SmirkLeft)
			MusicPlayer.playCello();
		if (reading.SmirkRight)
			MusicPlayer.playTriangle();
			
		MusicPlayer.playHarp(reading.EyebrowRaise);
		MusicPlayer.playTrumpet(reading.Smile);
		MusicPlayer.playViolin(reading.Clench);
		MusicPlayer.playHouseBeat(reading.ExcitementShortTerm);
		MusicPlayer.playDrum(reading.ExcitementLongTerm);
		MusicPlayer.playGuitar(reading.EngagementBoredom);
		MusicPlayer.playBass(reading.Frustration);
		MusicPlayer.playBass2(reading.Meditation);
	}
	
}
