package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;
public class Moneta extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.moneta;
	}
	public String nome()
	{
		return"MONETA";
	}
	public int punti()
	{
		return 0;
	}
	public void usa(final Team questo)
	{
		questo.punti++;
		questo.punti();
	}
}
