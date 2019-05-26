package com.island.battagliamagica;
import android.graphics.*;
import android.view.*;
import com.island.*;
import java.io.*;
import java.util.*;
public class Mazzi extends Finestra
{
	private Gruppo g;
	Mazzi(Schermo schermo)
	{
		super(schermo);
		g=new Gruppo(this,10,10);
		inizializza();
	}
	void reinizializza()
	{
		g.removeAllViews();
		inizializza();
	}
	void inizializza()
	{
		String[]file=Memoria.file(schermo().cartella+"MAZZI/");
		new Bottone(g,1,0,9,1).scrivi("NUOVO").setOnClickListener(nuovo());
		for(int a=0;a<file.length;a++)
		{
			String cartella=schermo().cartella+"MAZZI/"+file[a]+"/";
			new Bottone(g,1,a+1,8,a+2).scrivi(Memoria.leggi(cartella+"NOME")).setOnClickListener(apri(cartella));
			new Bottone(g,8,a+1,9,a+2).scrivi("X").setOnClickListener(cancella(cartella));
		}
		g.aggiorna();
	}
	public MainActivity schermo()
	{
		return(MainActivity)super.schermo();
	}
	private View.OnClickListener nuovo()
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				new Tastiera(schermo(),Color.GREEN,Color.BLACK,Color.LTGRAY,Color.DKGRAY,"")
				{
					public void conferma(String testo)
					{
						String arrivo=Mazzi.this.schermo().cartella+"MAZZI/";
						arrivo=Memoria.casuale(arrivo)+"/";
						Memoria.salva(arrivo+"NOME",testo);
						reinizializza();
					}
				};
			}
		};
	}
	private View.OnClickListener cancella(final String cartella)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				Memoria.cancella(cartella);
				reinizializza();
			}
		};
	}
	private View.OnClickListener apri(final String cartella)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				new Mazzo(schermo(),cartella);
			}
		};
	}
	public void sempreGrafico()
	{
		g.sempre(0.01);
	}
}
