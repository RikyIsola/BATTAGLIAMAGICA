package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;
public class PozioneRossa extends Magia
{
	public int rarita()
	{
		return 1;
	}
	public int immagine()
	{
		return R.drawable.pozionerossa;
	}
	public String nome()
	{
		return"POZIONE ROSSA";
	}
	public int punti()
	{
		return 4;
	}
	public void usa(final Team questo)
	{
		for(Team t:questo.battaglia.giocatori)
		{
			t.mostro.danneggia(5);
			for(PortaMostro p:t.campo)p.danneggia(5);
		}
	}
}
