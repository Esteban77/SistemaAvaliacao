package util;

public class GeradorLetrasNumeros {
	
	public static String geradorLetrasNumeros(int numeroDeDigitos){
		String senha = "";
		String[] alfanumericos = {"0","1","2","3","4","5","6","7","8","9",
	            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
	            "p","q","r","s","t","u","v","w","x","y","z","A","B","C","D",
	            "E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",
	            "T","U","V","W","X","Y","Z"};
		int tamanho = alfanumericos.length;
		int caracter;
		for(int i =0; i<numeroDeDigitos;i++){
			caracter = (int) (Math.random() * tamanho);
			senha+=alfanumericos[caracter];
		}
		
		return senha;
	}
	
	public static String geradorCPF(){
		String cpf = "";
		String[] alfanumericos = {"0","1","2","3","4","5","6","7","8","9"};
		int tamanho = alfanumericos.length;
		int caracter;
		
		int pontos=0;
		for(int i =0; i<11;i++){
			pontos++;
			caracter = (int) (Math.random() * tamanho);
			cpf+=alfanumericos[caracter];
			if(pontos==3 || pontos ==6){
				cpf+=".";				
			}
			if(pontos == 9){
				cpf+="-";
			}
			
		}		
		return cpf;
	}
	
	public static String geradorTelefone(){
		String telefone = "";
		String[] alfanumericos = {"0","1","2","3","4","5","6","7","8","9"};
		int tamanho = alfanumericos.length;
		int caracter;
		
		int pontos=0;
		for(int i =0; i<10;i++){
			pontos++;
			if(pontos==1){
				telefone+="(";
			}
			if(pontos==3){
				telefone+=")";
			}
			caracter = (int) (Math.random() * tamanho);
			telefone+=alfanumericos[caracter];
			if(pontos==6 ){
				telefone+="-";				
			}		
			
		}		
		return telefone;
	}
	
	 
    public static void main(String[] args) {
        String valor = GeradorLetrasNumeros.geradorLetrasNumeros(10);
        String cpf = GeradorLetrasNumeros.geradorCPF();
        String telefone = GeradorLetrasNumeros.geradorTelefone();
        System.out.println(valor);
        System.out.println(cpf);
        System.out.println(telefone);
    }
}
