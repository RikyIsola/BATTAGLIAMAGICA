package com.island.battagliamagica.carte.magia;
import com.island.battagliamagica.*;

public class BacchettaMagica extends Magia
{
	public int rarita()
	{
		return 0;
	}
	public int immagine()
	{
		return R.drawable.bacchettamagica;
	}
	public String nome()
	{
		return"BACCHETTA MAGICA";
	}
	public int punti()
	{
		return 2;
	}
	public void usa(Team questo)
	{
		questo.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro p)
			{
				if(p.carta!=null)
				{
					if("MAGO".equals(p.carta.tipo()))p.attacco+=3;
					else p.attacco++;
					p.t.inizializzaCampo();
					return true;
				}
				else return false;
			}
		};
	}
}
