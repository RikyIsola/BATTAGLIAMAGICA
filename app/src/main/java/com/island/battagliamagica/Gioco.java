package com.island.battagliamagica;
import android.view.*;
import com.island.*;
import com.island.battagliamagica.carte.*;
import android.graphics.*;
public class Gioco extends Finestra
{
	private Gruppo mazzo1,mazzo2,impostazioni,g;
	private Carta[]ma1,ma2;
	private Testo nome;
	private int n;
	private Bottone selezionato1,selezionato2;
	Gioco(Schermo schermo)
	{
		super(schermo);
		g=new Gruppo(this,10,10);
		mazzo1=new Gruppo(g,0,1,10,9,10,10);
		mazzo2=new Gruppo(g,0,1,10,9,10,10);
		mazzo2.setVisibility(View.INVISIBLE);
		nome=new Testo(g,0,0,10,1,"MAZZO 1");
		inizializza(mazzo1);
		inizializza(mazzo2);
		impostazioni=new Gruppo(g,0,1,10,9,5,9);
		impostazioni.setVisibility(View.INVISIBLE);
		new Testo(impostazioni,0,1,5,2,"GIOCATORE 1");
		selezionato1=new Bottone(impostazioni,1,2,2,3,Color.DKGRAY,Color.LTGRAY);
		selezionato1.scrivi("GIOCATORE").carattere(0.5).larghezzaX(0.5).setOnClickListener(seleziona1());
		new Bottone(impostazioni,3,2,4,3).scrivi("AI").setOnClickListener(seleziona1());
		new Testo(impostazioni,0,4,5,5,"GIOCATORE 2");
		selezionato2=new Bottone(impostazioni,1,5,2,6,Color.DKGRAY,Color.LTGRAY);
		selezionato2.scrivi("GIOCATORE").carattere(0.5).larghezzaX(0.5).setOnClickListener(seleziona2());
		new Bottone(impostazioni,3,5,4,6).scrivi("AI").setOnClickListener(seleziona2());
		new Bottone(impostazioni,1,7,4,8).scrivi("INIZIO").setOnClickListener(inizio());
		g.aggiorna();
	}
	private void inizializza(Gruppo g)
	{
		String[]file=Memoria.file(schermo().cartella+"MAZZI/");
		new Bottone(g,1,0,9,1).scrivi("CASUALE").setOnClickListener(casuale());
		for(int a=0;a<file.length;a++)
		{
			String cartella=schermo().cartella+"MAZZI/"+file[a]+"/";
			new Bottone(g,1,a+1,9,a+2).scrivi(Memoria.leggi(cartella+"NOME")).setOnClickListener(avanti(cartella));
		}
		g.aggiorna();
	}
	private View.OnClickListener avanti(final String cartella)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				String[]file=Memoria.file(cartella+"CARTE/");
				Carta[]carte=new Carta[file.length];
				for(int a=0;a<file.length;a++)carte[a]=schermo().carte.trova(Memoria.leggi(cartella+"CARTE/"+file[a]));
				avanti(carte);
			}
		};
	}
	private void avanti(Carta[]carte)
	{
		if(carte.length>=4)
		{
			if(n==0)ma1=carte;
			else ma2=carte;
			if(n==1)
			{
				impostazioni.setVisibility(View.VISIBLE);
				mazzo2.setVisibility(View.INVISIBLE);
				nome.scrivi("IMPOSTAZIONI");
				g.aggiorna();
			}
			n++;
			if(n==1)
			{
				mazzo2.setVisibility(View.VISIBLE);
				mazzo1.setVisibility(View.INVISIBLE);
				nome.scrivi("MAZZO 2");
				g.aggiorna();
			}
		}
	}
	private View.OnClickListener casuale()
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				Carta[]carte=Mazzo.casuale(schermo(),40);
				avanti(carte);
			}
		};
	}
	public MainActivity schermo()
	{
		return(MainActivity)super.schermo();
	}
	public void onBackPressed()
	{
		n--;
		if(n==1)
		{
			mazzo2.setVisibility(View.VISIBLE);
			impostazioni.setVisibility(View.INVISIBLE);
			nome.scrivi("MAZZO 2");
			g.aggiorna();
		}
		else if(n==0)
		{
			mazzo1.setVisibility(View.VISIBLE);
			mazzo2.setVisibility(View.INVISIBLE);
			nome.scrivi("MAZZO 1");
			g.aggiorna();
		}
		else super.onBackPressed();
	}
	private View.OnClickListener seleziona1()
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				selezionato1.colore(Color.LTGRAY,Color.DKGRAY);
				selezionato1=(Bottone)p1;
				selezionato1.colore(Color.DKGRAY,Color.LTGRAY);
			}
		};
	}
	private View.OnClickListener seleziona2()
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				selezionato2.colore(Color.LTGRAY,Color.DKGRAY);
				selezionato2=(Bottone)p1;
				selezionato2.colore(Color.DKGRAY,Color.LTGRAY);
			}
		};
	}
	private View.OnClickListener inizio()
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				new Battaglia(schermo(),ma1,ma2,selezionato1.testo().equals("AI"),selezionato2.testo().equals("AI"));
			}
		};
	}
	public void sempreGrafico()
	{
		mazzo1.sempre(0.01);
		mazzo2.sempre(0.01);
	}
}
