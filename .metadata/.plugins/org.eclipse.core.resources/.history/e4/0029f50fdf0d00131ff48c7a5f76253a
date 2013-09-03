package br.com.caelum.cadastro.dao;

import java.util.ArrayList;
import java.util.List;

import br.caelum.cadastro.modelo.Aluno;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDAO extends SQLiteOpenHelper {
	// PARA MAIS DE UMA DAO PESQUISAR O guj DO FELIPE. SOBRE SÓ PODER EXISTIR UM
	// "sQLITEOPENhLPER"
	// GUJ.COM.BR/200-BLA...

	public static final String[] COLUNAS = {"id","nome","telefone","endereco","site","nota","foto"};
	
	public AlunoDAO(Context context) {
		super(context, "CadastroCaelum", null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// para o SQLite Uma coluna criada como Primary key e Numerica, é
		// considerarda como auto_increment
		String sql = "CREATE TABLE FJ57" + "(id INTEGER PRIMARY KEY,"
				+ " nome TEXT UNIQUE NOT NULL," + " telefone TEXT,"
				+ " endereco TEXT," + " site TEXT," + " nota REAL,"
				+ " foto TEXT" + ");";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS FJ57;";
		db.execSQL(sql);
	}

	public void insere(Aluno aluno) {
		ContentValues values = new ContentValues();
		values.put("nome", aluno.getNome());
		values.put("telefone", aluno.getTelefone());
		values.put("endereco", aluno.getEndereco());
		values.put("site", aluno.getSite());
		values.put("nota", aluno.getNota());
		values.put("foto", aluno.getFoto());

		getWritableDatabase().insert("FJ57", null, values);
	}
	
	public List<Aluno> getLista(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		Cursor c = getWritableDatabase().rawQuery("SELECT * FROM FJ57",null);
		
		while(c.moveToNext()){
			Aluno aluno = new Aluno();
			
			aluno.setId(c.getLong(0));
			aluno.setNome(c.getString(1));
			aluno.setTelefone(c.getString(2));
			aluno.setEndereco(c.getString(3));
			aluno.setSite(c.getString(4));
			aluno.setNota(c.getDouble(5));
			aluno.setFoto(c.getString(6));
			
			alunos.add(aluno);
		}
		c.close();
		return alunos;			
	}
	
	public void deletar(Aluno aluno){
		String[] args = {aluno.getId().toString()};
		getWritableDatabase().delete("FJ57", "id=?",args);
	}	
}
