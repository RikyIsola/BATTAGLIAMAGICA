package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class Cinghiale extends Mostro
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
		return"CINGHIALE";
	}
	public int immagine()
	{
		return R.drawable.cinghiale;
	}
	public int attacco()
	{
		return 1;
	}
	public int difesa()
	{
		return 1;
	}
	public void usa(PortaMostro questo)
	{
		questo.attaccare=true;
		questo.t.inizializzaCampo();
	}
}
