package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;
public class PallaDiFuoco extends Magia
{
	public int rarita()
	{
		return 1;
	}
	public int immagine()
	{
		return R.drawable.palladifuoco;
	}
	public String nome()
	{
		return"PALLA DI FUOCO";
	}
	public int punti()
	{
		return 4;
	}
	public void usa(final Team questo)
	{
		questo.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro p)
			{
				p.danneggia(6);
				return true;
			}
		};
	}
}
