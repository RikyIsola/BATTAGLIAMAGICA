package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;

public class Banana extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.banana;
	}
	public String nome()
	{
		return"BANANA";
	}
	public int punti()
	{
		return 1;
	}
	public void usa(final Team questo)
	{
		questo.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro p)
			{
				if(p.carta!=null)
				{
					p.attacco++;
					p.difesa++;
					p.t.inizializzaCampo();
					return true;
				}
				else return false;
			}
		};
	}
}
