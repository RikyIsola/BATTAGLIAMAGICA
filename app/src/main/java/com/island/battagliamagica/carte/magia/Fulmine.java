package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;

public class Fulmine extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.fulmine;
	}
	public String nome()
	{
		return"FULMINE";
	}
	public int punti()
	{
		return 3;
	}
	public void usa(final Team questo)
	{
		questo.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro p)
			{
				p.danneggia(4);
				return true;
			}
		};
	}
}
