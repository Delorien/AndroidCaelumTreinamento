package br.com.cadastrocaelum;

import java.util.ArrayList;
import java.util.List;

import br.caelum.cadastro.modelo.Aluno;
import br.com.caelum.cadastro.dao.AlunoDAO;
import android.R.anim;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunos extends Activity {

	private ListView lista;
	private Aluno alunoSelecionado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_alunos);

		lista = (ListView) findViewById(R.id.lista);
		registerForContextMenu(lista);

		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				Toast.makeText(ListaAlunos.this, "Posicao " + pos,
						Toast.LENGTH_SHORT).show();

			}
		});

		lista.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View arg1,
					int posicao, long id) {
				// Toast.makeText(ListaAlunos.this, "Clique Longo" +
				// pos,Toast.LENGTH_SHORT).show();

				alunoSelecionado = (Aluno) adapter.getItemAtPosition(posicao);
				return false; // controla se libera ou nao o evento para os
								// outros
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();
		carregaLista();
	}

	public void carregaLista() {
		AlunoDAO dao = new AlunoDAO(this);
		List<Aluno> alunos = dao.getLista();
		dao.close();

		ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(ListaAlunos.this,
				android.R.layout.simple_list_item_1, alunos);

		lista.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);

		// http://s3.amazonaws.com/caelum-online-public/FJ-57/imagens.zip
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_novo) {
			Toast.makeText(this, "Adicionar Aluno", Toast.LENGTH_SHORT).show();
			Intent i = new Intent(this, FormularioActivity.class);
			startActivity(i);

		}

		return false;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// Daria para definir o menu de contexto por um xml de menu. Mas nao é
		// necessario nesse caso.
		// Por tanto vamos criar o menu com código java mesm.

		MenuItem ligar = menu.add("Ligar");
		MenuItem enviarSMS = menu.add("Enviar SMS");
		MenuItem acharNoMapa = menu.add("Achar no Mapa");
		MenuItem navegarNoSite = menu.add("Navegar no Site");
		MenuItem deletar = menu.add("Deletar");
		MenuItem enviarEMail = menu.add("Enviar Email");

		deletar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				
				new AlertDialog.Builder(ListaAlunos.this)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle("Deletar")
				.setMessage("Deseja mesmo deletar?")
				.setPositiveButton("Quero", 
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								AlunoDAO dao = new AlunoDAO(ListaAlunos.this);
								dao.deletar(alunoSelecionado);
								dao.close();
								carregaLista();								
							}
						}).setNegativeButton("Nao", null).show();
						
				return false;
			}
		});

	}
}
