package br.com.cadastrocaelum;

import br.caelum.cadastro.modelo.Aluno;
import br.com.caelum.cadastro.dao.AlunoDAO;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FormularioActivity extends Activity {
	
	private FormularioHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		this.helper = new FormularioHelper(this);
		
		Button button = (Button) findViewById(R.id.botaoInserir);
		
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(FormularioActivity.this, "Inserindo! ",Toast.LENGTH_SHORT).show();
								
				Aluno aluno = helper.pegaAlunoDoFormulario();
				
				AlunoDAO dao = new AlunoDAO(FormularioActivity.this);
				dao.insere(aluno);
				dao.close();
				
				FormularioActivity.this.finish();
			}

		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.formulario, menu);
		return true;
	}

}
