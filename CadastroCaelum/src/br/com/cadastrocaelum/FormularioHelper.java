package br.com.cadastrocaelum;

import br.caelum.cadastro.modelo.Aluno;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

public class FormularioHelper {
	private EditText nome;
	private EditText telefone;
	private EditText site;
	private SeekBar nota;
	private EditText endereco;
	private ImageButton botaoImagem;
	private Aluno aluno;

	
	public FormularioHelper(FormularioActivity activity){
		nome = (EditText) activity.findViewById(R.id.nome);
		telefone = (EditText) activity.findViewById(R.id.telefone);
		site = (EditText) activity.findViewById(R.id.site);
		nota = (SeekBar) activity.findViewById(R.id.nota);
		endereco = (EditText) activity.findViewById(R.id.endereco);
		botaoImagem = (ImageButton) activity.findViewById(R.id.foto);
		
		aluno = new Aluno();
	}

	public void colocaNoFormulario(Aluno aluno){
		nome.setText(aluno.getNome());
		telefone.setText(aluno.getTelefone());
		site.setText(aluno.getSite());
		nota.setProgress((int) aluno.getNota());
		endereco.setText(aluno.getEndereco());
		

		
		if(aluno.getFoto()  != null){
			this.carregaImagem(aluno.getFoto());
		}
		this.aluno = aluno;
	
	}

	public Aluno pegaAlunoDoFormulario(){
		
		aluno.setNome(nome.getEditableText().toString());
		aluno.setEndereco(endereco.getEditableText().toString());
		aluno.setSite(site.getEditableText().toString());
		aluno.setTelefone(telefone.getEditableText().toString());
		aluno.setNota(Double.valueOf(nota.getProgress()));
		
		return aluno;
	}

	public ImageButton getBotaoImagem() {
		return botaoImagem;
	}

	public void carregaImagem(String localArquivoFoto){
		Bitmap imagemFoto = BitmapFactory.decodeFile(localArquivoFoto); 
		Bitmap imagemFotoReduzida = 
				Bitmap.createScaledBitmap(imagemFoto, 100, 100, true);
		aluno.setFoto(localArquivoFoto);
		Log.i("BLA", localArquivoFoto);
		botaoImagem.setImageBitmap(imagemFotoReduzida);
	}
	
	
}
