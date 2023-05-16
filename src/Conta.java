import javax.swing.JOptionPane;

public class Conta {
	
	private int numero = -1;
	private String digito;
	private double saldo = 0;
	private String senha = "";
	private double limite = 500;
	private String token;
	private int tentativas = 0;
	private Cliente titular;
	
	public String getNumero() {
		return "" + numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getDigito() {
		return digito;
	}
	
	public boolean setDigito(String digito) {
		if(digito.length() == 1 && digito.matches("^[0-9]*$")) {
			this.digito = digito;
			return true;
		} else {
			return false;
		}
	}
	public double getSaldo() {
		return saldo;
	}
	public boolean setSaldo(int escolha, double saldo) {
		if(escolha == 2) {
			if(saldo < 0) {
				JOptionPane.showMessageDialog(null, "Insira um valor válido!");
			} else if(this.saldo >= saldo) {
				this.saldo = this.saldo-saldo;
				return true;
			} else if(this.saldo < saldo && this.saldo+limite>=saldo) {
				limite = limite+(this.saldo - saldo);
				this.saldo = this.saldo-saldo;
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Você não possui saldo suficiente!");
			}
		} else if(escolha == 3) {
			if(saldo > 0) {
				this.saldo = this.saldo + saldo;
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Insira um valor maior que zero!");
			}
		}
		
		return false;
	}
	
	public void setTentativas(int tentativa) {
		this.tentativas = tentativa;
	}
	
	public int getTentativas() {
		return tentativas;
	}
	
	public boolean getSenha(String senha) {
		if(this.senha.matches(senha) && tentativas < 3) {
			JOptionPane.showMessageDialog(null, "\nLogin com sucesso!");
			return true;
		} else {
			tentativas++;
			return false;
		}
	}
	public boolean setSenha(String senha1, String senha2, int operacao) {
			boolean igual = false, forte = false, confirmar = false;
			
			if(senha1.equals(senha2)) {
				igual = true;
			}
			
			if(senha1.matches("(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")) {
				forte = true;
			}
			
			if(senha1.equals(senha)) {
				confirmar = true;
			}
			
			switch(operacao) {
				case 1://Definir a senha pela primeira vez.
					if(igual && forte) {
						senha = senha1;
						return true;
					} else if(!igual) {
						JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
					} else if(!forte) {
						JOptionPane.showMessageDialog(null, "A senha deve ser forte!\n- 1 letra maiúscula\n- 4 letras minúsculas\n- 2 números\n- 1 caractere especial");
					}
				break;
				case 2://Mudar senha.
					if(igual && forte && !confirmar) {
						senha = senha1;
						return true;
					} else if(!igual) {
						JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!");
					} else if(!forte) {
						JOptionPane.showMessageDialog(null, "A senha deve ser forte!\n- 1 letra maiúscula\n- 4 letras minúsculas\n- 2 números\n- 1 caractere especial");
					} else if(confirmar) {
						JOptionPane.showMessageDialog(null, "A senha não pode ser igual a anterior");
					}
				break;
			}
			return false;
		}
	
	public double getLimite() {
		return limite;
	}
	public boolean setLimite(double limite) {
		if(limite > 0) {
			this.limite = limite;
			return true;
		} else {
			return false;
		}
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
}