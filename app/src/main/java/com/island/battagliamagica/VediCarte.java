package com.island.battagliamagica;
import com.island.*;
import android.view.*;
import android.graphics.*;
public class VediCarte extends Finestra
{
	private Gruppo g;
	VediCarte(Schermo schermo)
	{
		super(schermo);
		g=new Gruppo(this,10,10);
		for(int a=0;a<schermo().carte.carte.length;a++)new Oggetto(g,a%4*2+1,a/4*2,a%4*2+3,a/4*2+2).immagine(schermo().carte.carte[a].immagine()).setOnClickListener(click(a));
		g.aggiorna();
	}
	public MainActivity schermo()
	{
		return(MainActivity)super.schermo();
	}
	private View.OnClickListener click(final int a)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				new Descrizione(schermo(),schermo().carte.carte[a],false);
			}
		};
	}
	public void sempreGrafico()
	{
		g.sempre(0.01);
	}
	public void onStop()
	{
		g=null;
		super.onStop();
	}
}
