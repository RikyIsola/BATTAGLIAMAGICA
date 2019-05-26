package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class Sasso extends Mostro
{
	public int rarita()
	{
		return 0;
	}
	public int punti()
	{
		return 1;
	}
	public String nome()
	{
		return"SASSO";
	}
	public int immagine()
	{
		return R.drawable.sasso;
	}
	public int attacco()
	{
		return 2;
	}
	public int difesa()
	{
		return 1;
	}
}
