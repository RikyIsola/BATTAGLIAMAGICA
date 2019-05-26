package com.island.battagliamagica;
import android.view.*;
import com.island.*;
import com.island.battagliamagica.carte.*;
import java.util.*;
public class Pacchetti extends Finestra
{
	private Oggetto[]oggetti=new Oggetto[5];
	private Carta[]carte=new Carta[5];
	private Gruppo g;
	Pacchetti(Schermo schermo)
	{
		super(schermo);
		g=new Gruppo(this,10,10);
		g.setOnTouchListener(touch());
		inizializza();
	}
	private View.OnClickListener click(final int n)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				((Oggetto)p1).immagine(carte[n].immagine());
			}
		};
	}
	private View.OnLongClickListener lungoclick(final int n)
	{
		return new View.OnLongClickListener()
		{
			public boolean onLongClick(View p1)
			{
				Oggetto o=(Oggetto)p1;
				if(o.immagine()!=R.drawable.retro)new Descrizione(schermo(),carte[n],false);
				return true;
			}
		};
	}
	private View.OnTouchListener touch()
	{
		return new View.OnTouchListener()
		{
			public boolean onTouch(View p1,MotionEvent p2)
			{
				if(p2.getAction()==MotionEvent.ACTION_UP)
				{
					boolean ok=true;
					for(Oggetto o:oggetti)if(o.immagine()==R.drawable.retro)ok=false;
					if(ok)inizializza();
				}
				return true;
			}
		};
	}
	public MainActivity schermo()
	{
		return(MainActivity)super.schermo();
	}
	private void inizializza()
	{
		g.removeAllViews();
		Random r=new Random();
		for(int a=0;a<carte.length;a++)carte[a]=schermo().carte.rarita[r.nextInt(schermo().carte.rarita.length)];
		oggetti[0]=new Oggetto(g,4,1,6,3).immagine(R.drawable.retro);
		oggetti[1]=new Oggetto(g,1,4,3,6).immagine(R.drawable.retro);
		oggetti[2]=new Oggetto(g,7,4,9,6).immagine(R.drawable.retro);
		oggetti[3]=new Oggetto(g,1,7,3,9).immagine(R.drawable.retro);
		oggetti[4]=new Oggetto(g,7,7,9,9).immagine(R.drawable.retro);
		for(int a=0;a<oggetti.length;a++)
		{
			oggetti[a].setOnClickListener(click(a));
			oggetti[a].setOnLongClickListener(lungoclick(a));
		}
		g.aggiorna();
	}
}
