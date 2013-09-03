package br.com.cadastrocaelum;

<<<<<<< HEAD
import java.io.File;

import br.caelum.cadastro.modelo.Aluno;
import br.com.caelum.cadastro.dao.AlunoDAO;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
=======
import br.caelum.cadastro.modelo.Aluno;
import br.com.caelum.cadastro.dao.AlunoDAO;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
>>>>>>> bf08452c5312b2f17b416e5f2659b96583d88ef8
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
import android.widget.ImageButton;
import android.widget.ImageView;
=======
>>>>>>> bf08452c5312b2f17b416e5f2659b96583d88ef8
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FormularioActivity extends Activity {
<<<<<<< HEAD

	private FormularioHelper helper;
	private String localArquivoFoto;
	private static final int TIRA_FOTO = 123;
	private Aluno alunoParaSerAlterado;
	private AlunoDAO dao;
=======
	
	private FormularioHelper helper;
>>>>>>> bf08452c5312b2f17b416e5f2659b96583d88ef8

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		this.helper = new FormularioHelper(this);
<<<<<<< HEAD

		Button button = (Button) findViewById(R.id.botaoInserir);

		alunoParaSerAlterado = (Aluno) getIntent()
				.getSerializableExtra("aluno");

		if (alunoParaSerAlterado != null) {
			EditText campoNome = (EditText) findViewById(R.id.nome);
			campoNome.setText(alunoParaSerAlterado.getNome());
			button.setText("Alterar");
			helper.colocaNoFormulario(alunoParaSerAlterado);
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Aluno alterado = helper.pegaAlunoDoFormulario();
					dao = new AlunoDAO(FormularioActivity.this);
					dao.altera(alterado);
					dao.close();
					finish();
				}
			});
		} else {
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Aluno aluno = helper.pegaAlunoDoFormulario();
					dao = new AlunoDAO(FormularioActivity.this);
					dao.altera(aluno);
					dao.close();
					finish();

				}
			});
		}

		/*
		 * if (alunoParaSerAlterado != null) { button.setText("Alterar");
		 * helper.colocaNoFormulario(alunoParaSerAlterado); }
		 */

		ImageButton foto = helper.getBotaoImagem();
		foto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				localArquivoFoto = Environment.getExternalStorageDirectory() + "/"
						+ System.currentTimeMillis() + ".jpg";
				File arquivo = new File(localArquivoFoto);
				Uri localFoto = Uri.fromFile(arquivo);

				Intent irParaCamera = new Intent(
						MediaStore.ACTION_IMAGE_CAPTURE);
				irParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, localFoto);
				startActivityForResult(irParaCamera, TIRA_FOTO); // Numero de
																	// protocolo
																	// pra
																	// recuperar

			}
		});

		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(FormularioActivity.this, "Inserindo! ",
						Toast.LENGTH_SHORT).show();

				Aluno aluno = helper.pegaAlunoDoFormulario();

				AlunoDAO dao = new AlunoDAO(FormularioActivity.this);
				if (alunoParaSerAlterado == null) {
					dao.insere(aluno);
				} else {
					dao.altera(aluno);
				}

				dao.close();

				FormularioActivity.this.finish();
			}

		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == TIRA_FOTO) {
			if (resultCode == Activity.RESULT_OK) {
				helper.carregaImagem(this.localArquivoFoto);
			} else {
				this.localArquivoFoto = null;
			}
		}
=======
		
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
>>>>>>> bf08452c5312b2f17b416e5f2659b96583d88ef8
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.formulario, menu);
		return true;
	}

}
