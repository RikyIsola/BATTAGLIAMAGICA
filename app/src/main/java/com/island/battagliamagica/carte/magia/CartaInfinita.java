package com.island.battagliamagica.carte.magia;
import com.island.*;
import com.island.battagliamagica.*;

public class CartaInfinita extends Magia
{
	public int rarita()
	{
		return 3;
	}
	public int immagine()
	{
		return R.drawable.cartainfinita;
	}
	public String nome()
	{
		return"CARTA INFINITA";
	}
	public int punti()
	{
		return 3;
	}
	public void usa(final Team questo)
	{
		questo.pesca();
		questo.mano=Lista.aggiungi(questo.mano,this);
		questo.inizializzaMano();
	}
}
