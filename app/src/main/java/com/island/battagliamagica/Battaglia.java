package com.island.battagliamagica;
import android.graphics.*;
import android.view.*;
import com.island.*;
import com.island.battagliamagica.carte.*;
import com.island.battagliamagica.carte.mostri.*;
import java.util.*;
import android.widget.*;
public class Battaglia extends Finestra
{
	public Selezione selezione;
	public Gruppo g;
	private Testo suggerimento;
	public Team[]giocatori;
	private int turno;
	Battaglia(Schermo schermo,Carta[]ma1,Carta[]ma2,boolean ai1,boolean ai2)
	{
		super(schermo);
		g=new Gruppo(this,1,2);
		suggerimento=new Testo(g,0,0.9,0.85,1.1,"TOCCA A TE");
		giocatori=new Team[2];
		turno=new Random().nextInt(giocatori.length);
		giocatori[0]=new Team(this,0,1,false,ma1,0,turno==0,ai1,!ai1);
		giocatori[1]=new Team(this,0,0,true,ma2,1,turno==1,ai2,!ai2);
		g.aggiorna();
	}
	public void sempreGrafico()
	{
		super.sempreGrafico();
		if(libero())
		{
			if(selezione!=null)suggerimento.scrivi("SELEZIONA");
			else if(!giocatori[turno].nonprimo)suggerimento.scrivi("CAMBIA CARTE");
			else suggerimento.scrivi("TOCCA A TE");
			for(Team t:giocatori)t.sempre();
		}
	}
	public void rotea(boolean inverso)
	{
		if(inverso)suggerimento.rotazione(180);
		else suggerimento.rotazione(0);
	}
	public boolean rotea()
	{
		if(suggerimento.rotazione()==180)return true;
		else return false;
	}
	public void prossimo()
	{
		selezione=null;
		turno++;
		if(turno>=giocatori.length)turno=0;
		for(Team t:giocatori)
		{
			for(PortaMostro p:t.campo)
			{
				p.danni=0;
				p.attaccare=true;
			}
			t.inizializzaMano();
			t.inizializzaCampo();
		}
		giocatori[turno].inizioTurno();
	}
	public void rimuovi(Team team)
	{
		boolean ok=false;
		for(Team t:giocatori)if(t==team)ok=true;
		if(ok)
		{
			boolean cambio;
			if(turno<giocatori.length)cambio=giocatori[turno]==team;
			else cambio=false;
			giocatori=Lista.rimuovi(giocatori,team);
			if(stessoTeam())
			{
				boolean[]vin=new boolean[2];
				int n;
				if(team.invertito)n=0;
				else n=1;
				vin[n]=true;
				new Vittoria(schermo(),this,vin);
			}
			else 
			{
				g.removeView(team);
				if(cambio)
				{
					for(Team t:giocatori)
					{
						for(PortaMostro p:t.campo)
						{
							p.danni=0;
							p.attaccare=true;
						}
						t.inizializzaMano();
						t.inizializzaCampo();
					}
					giocatori[turno].inizioTurno();
				}
			}
		}
	}
	private boolean stessoTeam()
	{
		if(giocatori.length>0)
		{
			int team=giocatori[0].team;
			for(Team t:giocatori)if(team!=t.team)return false;
		}
		return true;
	}
}
