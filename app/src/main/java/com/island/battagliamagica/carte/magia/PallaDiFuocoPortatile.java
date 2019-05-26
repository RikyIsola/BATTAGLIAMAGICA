package com.island.battagliamagica.carte.magia;
import com.island.*;
import com.island.battagliamagica.*;
import com.island.battagliamagica.carte.*;
public class PallaDiFuocoPortatile extends Magia
{
	public int rarita()
	{
		return 3;
	}
	public int immagine()
	{
		return R.drawable.palladifuocoportatile;
	}
	public String nome()
	{
		return"PALLA DI FUOCO PORTATILE";
	}
	public int punti()
	{
		return 3;
	}
	public void usa(final Team questo)
	{
		questo.mano=Lista.aggiungi(questo.mano,this);
		questo.inizializzaMano();
		questo.battaglia.selezione=new Selezione()
		{
			public boolean selezionato(PortaMostro p)
			{
				p.danneggia(1);
				return true;
			}
		};
	}
}
