package com.island.battagliamagica;
import android.view.*;
import com.island.*;
import com.island.battagliamagica.carte.*;
import java.util.*;
public class Mazzo extends Finestra
{
	private Carta[]carte;
	private Testo[]testi;
	private Gruppo g1,g2;
	private String cartella;
	private Testo numero;
	Mazzo(Schermo schermo,String cartella)
	{
		super(schermo);
		this.cartella=cartella;
		Gruppo g=new Gruppo(this,10,10);
		g1=new Gruppo(g,5,0,10,9,10,9);
		g2=new Gruppo(g,0,0,5,10,10,30);
		numero=new Testo(g,5,9,10,10,"");
		testi=new Testo[schermo().carte.carte.length];
		for(int a=0;a<schermo().carte.carte.length;a++)
		{
			testi[a]=new Testo(g2,a%4*2+1,a/4*4+3,a%4*2+3,a/4*4+4,"");
			Oggetto o=new Oggetto(g2,a%4*2+1,a/4*4,a%4*2+3,a/4*4+3).immagine(schermo().carte.carte[a].immagine());
			o.setOnClickListener(aggiungi(schermo().carte.carte[a]));
			o.setOnLongClickListener(descrizione(schermo().carte.carte[a]));
		}
		inizializza();
		g.aggiorna();
	}
	public MainActivity schermo()
	{
		return(MainActivity)super.schermo();
	}
	private View.OnClickListener aggiungi(final Carta carta)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				String arrivo=cartella+"CARTE/";
				Memoria.salva(Memoria.casuale(arrivo),carta.nome());
				inizializza();
			}
		};
	}
	private View.OnClickListener rimuovi(final Carta carta,final String file)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				Memoria.cancella(cartella+"CARTE/"+file);
				inizializza();
			}
		};
	}
	private View.OnLongClickListener descrizione(final Carta carta)
	{
		return new View.OnLongClickListener()
		{
			public boolean onLongClick(View p1)
			{
				new Descrizione(schermo(),carta,false);
				return true;
			}
		};
	}
	private void inizializza()
	{
		g1.removeAllViews();
		for(Testo t:testi)t.scrivi("0");
		String[]file=Memoria.file(cartella+"CARTE/");
		carte=new Carta[file.length];
		for(int a=0;a<file.length;a++)
		{
			carte[a]=schermo().carte.trova(Memoria.leggi(cartella+"CARTE/"+file[a]));
			Testo t=testi[carte[a].id()];
			t.scrivi(""+(Integer.valueOf(t.testo())+1));
			Oggetto o=new Oggetto(g1,a%4*2+1,a/4*1,a%4*2+3,a/4*1+1).immagine(carte[a].immagine());
			o.setOnClickListener(rimuovi(carte[a],file[a]));
			o.setOnLongClickListener(descrizione(carte[a]));
		}
		for(int a=0;a<testi.length;a++)testi[a].scrivi(testi[a].testo()+"/"+(4-schermo().carte.carte[a].rarita()));
		numero.scrivi(file.length+"/40");
		g1.aggiorna();
	}
	public static Carta[]casuale(MainActivity schermo,int lunghezza)
	{
		Carta[]ritorno=new Carta[lunghezza];
		Random r=new Random();
		for(int a=0;a<ritorno.length;a++)
		{
			int n;
			do
			{
				n=0;
				ritorno[a]=schermo.carte.carte[r.nextInt(schermo.carte.carte.length)];
				for(int b=0;b<ritorno.length;b++)if(ritorno[a]==ritorno[b])n++;
			}while(n>4-ritorno[a].rarita());
		}
		return ritorno;
	}
	public void sempreGrafico()
	{
		g1.sempre(0.01);
		g2.sempre(0.01);
	}
}
