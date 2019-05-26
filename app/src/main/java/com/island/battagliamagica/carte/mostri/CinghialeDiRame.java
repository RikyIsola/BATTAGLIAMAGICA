package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class CinghialeDiRame extends Mostro
{
	public int rarita()
	{
		return 2;
	}
	public int punti()
	{
		return 1;
	}
	public String nome()
	{
		return"CINGHIALE DI RAME";
	}
	public int immagine()
	{
		return R.drawable.cinghialedirame;
	}
	public int attacco()
	{
		return 3;
	}
	public int difesa()
	{
		return 0;
	}
	public void usa(PortaMostro questo)
	{
		questo.attaccare=true;
		questo.t.inizializzaCampo();
	}
}
