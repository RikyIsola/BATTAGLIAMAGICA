package com.island.battagliamagica;
import android.os.*;
import com.island.*;
import android.graphics.*;
import android.view.*;
import android.view.View.*;
import com.island.battagliamagica.carte.*;
import android.content.pm.*;
public class MainActivity extends Schermo
{
	public String cartella=Environment.getExternalStorageDirectory().getPath()+"/BATTAGLIA MAGICA/";
	public int orientamento()
	{
		return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
	}
	public Carte carte;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		font(Typeface.SERIF,Typeface.BOLD_ITALIC);
		carte=new Carte();
		Gruppo g=new Gruppo(this,10,12);
		new Testo(g,1,1,9,3,"BATTAGLIA MAGICA").larghezzaX(0.75);
		new Bottone(g,2,4,8,5).scrivi("GIOCA").setOnClickListener(click(1));
		new Bottone(g,2,6,8,7).scrivi("MAZZI").setOnClickListener(click(2));
		new Bottone(g,2,8,8,9).scrivi("VEDI CARTE").setOnClickListener(click(3));
		new Bottone(g,2,10,8,11).scrivi("APRI PACCHETTO").setOnClickListener(click(4));
		g.aggiorna();
    }
	private View.OnClickListener click(final int n)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				if(n==1)new Gioco(schermo());
				else if(n==2)new Mazzi(schermo());
				else if(n==3)new VediCarte(schermo());
				else new Pacchetti(schermo());
			}
		};
	}
	public MainActivity schermo()
	{
		return this;
	}
}
