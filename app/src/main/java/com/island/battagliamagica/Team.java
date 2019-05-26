package com.island.battagliamagica;
import android.graphics.*;
import android.view.*;
import com.island.*;
import com.island.battagliamagica.carte.*;
import com.island.battagliamagica.carte.magia.*;
import com.island.battagliamagica.carte.mostri.*;
import java.util.*;
import android.widget.*;
public class Team extends Gruppo
{
	public Carta[]mazzo,mano;
	public PortaMostro[]campo;
	public Testo mazzorimanente,puntirimanenti;
	public int team,scartato,punti,puntimax,delayai;
	public boolean invertito,nonprimo;
	private Gruppo gcampo;
	private Gruppo gmano;
	public Battaglia battaglia;
	public PortaMostro mostro;
	private boolean turno,primo,ai,input;
	Team(Battaglia battaglia,double x,double y,boolean invertito,Carta[]ma,int team,boolean primo,boolean ai,boolean input)
	{
		super(battaglia.g,x,y,x+1,y+1,7,2);
		this.ai=ai;
		this.input=input;
		mostro=new PortaMostro(this,null,team)
		{
			public void danneggia(int danno)
			{
				Team.this.danneggia(danno);
			}
		};
		this.battaglia=battaglia;
		this.invertito=invertito;
		this.primo=primo;
		mazzo=ma;
		mescola();
		mano=new Carta[0];
		campo=new PortaMostro[0];
		this.team=team;
		final int n;
		if(primo)n=3;
		else n=4;
		mano=new Carta[n];
		for(int a=0;a<mano.length;a++)
		{
			mano[a]=mazzo[0];
			mazzo=Lista.rimuovi(mazzo,mazzo[0]);
		}
		if(invertito)y=1;
		else y=0;
		gcampo=new Gruppo(this,1,y%2,6,y%2+1,5,5);
		gmano=new Gruppo(this,1,(y+1)%2,6,(y+1)%2+1,5,5);
		inizializzaMano();
		inizializzaCampo();
		mazzorimanente=new Testo(this,0,(y+1)%2,1,(y+1)%2+1,""+mazzo.length,Color.WHITE,Color.TRANSPARENT);
		mazzorimanente.immagine(R.drawable.retro).setOnClickListener(pescata());
		puntirimanenti=new Testo(this,6,(y+1)%2,7,(y+1)%2+1,"0/0",Color.WHITE,Color.BLUE).carattere(0.8);
		new Bottone(this,6,(y)%2,7,(y)%2+1).setOnClickListener(fine());
		if(invertito)
		{
			mazzorimanente.rotazione(180);
			puntirimanenti.rotazione(180);
		}
		if(primo)inizioTurno();
		aggiorna();
	}
	private void mescola()
	{
		Random r=new Random();
		Carta[]copia=mazzo.clone();
		for(int a=0;a<mazzo.length;a++)
		{
			int n=r.nextInt(copia.length);
			mazzo[a]=copia[n];
			copia=Lista.rimuovi(copia,copia[n]);
		}
	}
	public void pesca()
	{
		if(mazzo.length>0)
		{
			mano=Lista.aggiungi(mano,mazzo[0]);
			mazzo=Lista.rimuovi(mazzo,mazzo[0]);
			mazzo();
			inizializzaMano();
		}
		else battaglia.rimuovi(this);
	}
	public void inizioTurno()
	{
		battaglia.rotea(invertito);
		turno=true;
		if(scartato>0)
		{
			for(int a=0;a<scartato;a++)pesca();
			scartato=0;
		}
		if(nonprimo)
		{
			if(puntimax<10)puntimax++;
			punti=puntimax;
			punti();
			pesca();
		}
		else inizializzaMano();
	}
	public void danneggia(int danno)
	{
		for(int a=0;a<danno;a++)
		{
			if(mazzo.length>0)mazzo=Lista.rimuovi(mazzo,mazzo[0]);
			else
			{
				battaglia.rimuovi(this);
				break;
			}
		}
		mazzo();
	}
	public void inizializzaMano()
	{
		gmano.removeAllViews();
		gmano.colore(Color.GREEN);
		for(int a=0;a<mano.length;a++)
		{
			int y;
			if(invertito)y=0;
			else y=1;
			Oggetto o=new Oggetto(gmano,a,y,a+1,y+4);
			o.setOnClickListener(gioca(mano[a]));
			if(turno)o.immagine(mano[a].immagine());
			else o.immagine(R.drawable.retro);
			o.setOnLongClickListener(descrizione(mano[a]));
			if(invertito)o.rotazione(180);
		}
		gmano.aggiorna();
	}
	public void inizializzaCampo()
	{
		gcampo.removeAllViews();
		for(int a=0;a<campo.length;a++)
		{
			int y;
			if(invertito)y=0;
			else y=1;
			Testo o=new Testo(gcampo,a,y,a+1,4+y,"",Color.BLACK,Color.TRANSPARENT).carattere(0.5).larghezzaX(0.5);
			if(campo[a].attacco!=campo[a].carta.attacco()||campo[a].difesa!=campo[a].carta.difesa()||campo[a].danni>0)o.scrivi(campo[a].attacco+"/"+(campo[a].difesa-campo[a].danni));
			o.immagine(campo[a].carta.immagine()).setOnClickListener(attacca(campo[a]));
			o.setOnLongClickListener(descrizione(campo[a].carta));
			int rotazione=0;
			if(invertito)rotazione+=180;
			if(!campo[a].attaccare)rotazione+=90;
			o.rotazione(rotazione);
		}
		gcampo.aggiorna();
	}
	public void punti()
	{
		puntirimanenti.scrivi(punti+"/"+puntimax);
	}
	private void mazzo()
	{
		mazzorimanente.scrivi(""+mazzo.length);
	}
	private View.OnClickListener gioca(final Carta carta)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				if(turno&&!nonprimo&&(input||p1==null))
				{
					mano=Lista.rimuovi(mano,carta);
					mazzo=Lista.aggiungi(mazzo,carta);
					inizializzaMano();
					mazzo();
					scartato++;
				}
				else
				{
					if(turno&&battaglia.selezione==null&&(input||p1==null))
					{
						if(punti>=carta.punti())
						{
							mano=Lista.rimuovi(mano,carta);
							inizializzaMano();
							punti-=carta.punti();
							punti();
							if(carta instanceof Mostro)evoca(carta);
							else((Magia)carta).usa(Team.this);
						}
					}
				}
			}
		};
	}
	public void evoca(Carta carta)
	{
		PortaMostro p=new PortaMostro(Team.this,carta,team);
		campo=Lista.aggiungi(campo,p);
		for(Team t:battaglia.giocatori)for(PortaMostro po:t.campo)po.carta.evocato(po,p);
		((Mostro)carta).usa(p);
		inizializzaCampo();
	}
	private View.OnClickListener attacca(final PortaMostro carta)
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				if(battaglia.selezione==null)
				{
					if(turno&&carta.attaccare&&(input||p1==null))
					{
						battaglia.selezione=new Selezione()
						{
							public boolean selezionato(PortaMostro mostro)
							{
								if(mostro.team!=carta.team)
								{
									boolean libero=true;
									for(PortaMostro p:campo)if(!p.carta.trasparente())libero=false;
									if((mostro.carta!=null||libero)&&((mostro.carta!=null&&mostro.carta.guardia())||mostro.t.nonguardia()))
									{
										carta.carta.inizioAttacco(carta,mostro);
										if(mostro.carta!=null)carta.danneggia(mostro.attacco);
										mostro.danneggia(carta.attacco);
										carta.carta.fineAttacco(carta,mostro);
										inizializzaCampo();
										return true;
									}
								}
								return false;
							}
						};
						carta.attaccare=false;
					}
				}
				else
				{
					if(battaglia.selezione.selezionato(carta))battaglia.selezione=null;
				}
			}
		};
	}
	private View.OnClickListener pescata()
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				if(battaglia.selezione!=null)if(battaglia.selezione.selezionato(mostro))battaglia.selezione=null;
			}
		};
	}
	private View.OnClickListener fine()
	{
		return new View.OnClickListener()
		{
			public void onClick(View p1)
			{
				if(turno&&(input||p1==null))
				{
					if(!nonprimo)
					{
						nonprimo=true;
						if(!primo)mano=Lista.aggiungi(mano,schermo().carte.Moneta);
					}
					turno=false;
					battaglia.prossimo();
				}
			}
		};
	}
	public MainActivity schermo()
	{
		return(MainActivity)super.schermo();
	}
	private View.OnLongClickListener descrizione(final Carta c)
	{
		return new View.OnLongClickListener()
		{
			public boolean onLongClick(View p1)
			{
				new Descrizione(schermo(),c,battaglia.rotea());
				return true;
			}
		};
	}
	private boolean nonguardia()
	{
		for(PortaMostro p:campo)if(p.carta.guardia())return false;
		return true;
	}
	public void sempre()
	{
		if(turno&&ai)
		{
			if(delayai>20)
			{
				delayai=0;
				if(nonprimo)
				{
					if(battaglia.selezione!=null)
					{
						for(int a=0;a<campo.length;a++)if(battaglia.selezione.selezionato(campo[a]))
							{
								battaglia.selezione=null;
								return;
							}
						for(Team t:battaglia.giocatori)for(int a=0;a<t.campo.length;a++)if(battaglia.selezione.selezionato(t.campo[a]))
								{
									battaglia.selezione=null;
									return;
								}
						if(battaglia.selezione.selezionato(mostro))
						{
							battaglia.selezione=null;
							return;
						}
						for(Team t:battaglia.giocatori)if(battaglia.selezione.selezionato(t.mostro))
							{
								battaglia.selezione=null;
								return;
							}
					}
					else
					{
						for(int a=0;a<mano.length;a++)if(punti>=mano[a].punti())
							{
								gioca(mano[a]).onClick(null);
								return;
							}
						for(PortaMostro p:campo)if(p.attaccare)
							{
								attacca(p).onClick(null);
								return;
							}
					}
				}
				fine().onClick(null);
			}
			else delayai++;
		}
	}
}
