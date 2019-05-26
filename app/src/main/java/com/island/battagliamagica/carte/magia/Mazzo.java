package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;
public class Mazzo extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.mazzo;
	}
	public String nome()
	{
		return"MAZZO";
	}
	public int punti()
	{
		return 2;
	}
	public void usa(Team questo)
	{
		questo.pesca();
		questo.pesca();
	}
}
