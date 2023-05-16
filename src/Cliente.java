import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Cliente {
	//Atributos:
	private String nome;
	private String cpf;
	private Calendar dataNascimento;
	private String endereco; //Rua, número, bairro, cidade
	private String telefone;
	private int codigo = -1;
	private float rendaMensal;
	private String empregado;
	
	public boolean setNome(String nome) {
		if(nome.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nome inválido!");
			return false;
		} else {
			this.nome = nome;
			return true;
		}
	}
	
	public boolean setCpf(String cpf) {
		if(cpf.isEmpty()) {
			this.cpf = "Valor inválido!";
			JOptionPane.showMessageDialog(null, "CPF inválido!");
			return false;
		} else if(cpf.length() == 14) {
			this.cpf = cpf;
			return true;
		} else {
			this.cpf = "Valor inválido!";
			JOptionPane.showMessageDialog(null, "CPF inválido!");
			return false;
		}
	}
	
	public boolean setDataNasc(String dataNasc) {
		String array[] = new String[3];
		
		if(dataNasc.matches("\\d{2}/\\d{2}/\\d{4}")) {
			array = dataNasc.split("/");
			Calendar data = Calendar.getInstance();
			
			int dia = Integer.parseInt(array[0]);
			int mes = Integer.parseInt(array[1]);
			int ano = Integer.parseInt(array[2]);
			
			data.set(ano, mes-1, dia);
			
			this.dataNascimento = data;
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Data de nascimento inválido!");
			return false;
		}
	}
	
	public boolean setEndereco(String endereco) {
		if(endereco.isEmpty()) {
			this.endereco = "Valor inválido!";
			JOptionPane.showMessageDialog(null, "Endereço inválido!");
			return false;
		} else if(endereco.length() > 0) {
			this.endereco = endereco;
			return true;
		} else {
			this.endereco = "Valor inválido!";
			JOptionPane.showMessageDialog(null, "Endereço inválido!");
			return false;
		}
	}
	
	public boolean setTelefone(String telefone) {
		if(telefone.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Telefone inválido!");
			return false;
		} else if(telefone.length() >= 16){
			this.telefone = telefone;
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Telefone inválido!");
			return false;
		}
	}
	
	public boolean setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
			return true;
	    } else {
	      this.codigo = 0;
	      return false;
	    }
	}
	
	public boolean setRendaMensal(Float rendaMensal) {
		if(!(rendaMensal > 0)) {
			JOptionPane.showMessageDialog(null, "Renda mensal inválido!");
			return false;
		}
		this.rendaMensal = rendaMensal;
		return true;
	}
	
	public boolean setEmpregado(String empregado) {
		this.empregado = empregado;
		return true;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getDataNasc() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "" + sdf.format(dataNascimento.getTime());
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public float getRendaMensal() {
		return rendaMensal;
	}
	
	public String getEmpregado() {
		return empregado;
	}
}