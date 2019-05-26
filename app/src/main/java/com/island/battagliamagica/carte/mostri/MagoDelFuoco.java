package com.island.battagliamagica.carte.mostri;
import com.island.battagliamagica.*;
public class MagoDelFuoco extends Mostro
{
	public int rarita()
	{
		return 1;
	}
	public int punti()
	{
		return 3;
	}
	public String nome()
	{
		return"MAGO DEL FUOCO";
	}
	public int immagine()
	{
		return R.drawable.magodelfuoco;
	}
	public int attacco()
	{
		return 4;
	}
	public int difesa()
	{
		return 2;
	}
	public void usa(final PortaMostro questo)
	{
		questo.t.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro selezionato)
			{
				if(selezionato!=questo)
				{
					selezionato.danneggia(1);
					return true;
				}
				else return false;
			}
		};
	}
	public String tipo()
	{
		return"MAGO";
	}
}
