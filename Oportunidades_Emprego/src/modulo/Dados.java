package modulo;

/**
 * Classe Dados simula o pré cadastro de Empresa e das vagas disponiveis.
 * @author Felipe Motta ,Giovana Barbosa 
 * @since 2023
 * @version 1.0
 * @see Empresa			Vetor que cria 50 empresas.
 * @see qtdEmpresas		Inteiro que monstra a quantidade de empresa
 */
public class Dados {
	//cria um vetor que pode ter 50 empresas.
	
	private Empresa[] empresas = new Empresa[50];
    int qtdEmpresas = 0;
    
    /**
     * Método que cria empresa e suas vagas experientes e inexperientes.
     * @see VagaExperiente		Cria as vagas experiente da empresa
     * @see VagaInexperiente	Cria as vagas inexperientes da empresa
     */
    
    public void fillWithSomeData() {
        for (int i = 0; i < 5; i++) {
        	
            Telefone tel = new Telefone((i+1)*100, (i+1)*1000000);
            empresas[i] = new Empresa((i+1)*12345678912345L, "Empresa "+(i+1), tel, i+2, i+2);
            
            for (int j = 0; j < i+2; j++) {
            	
                VagaExperiente Vexp = new VagaExperiente(""+(j+1), (j+1)*10, j+1, (j+1)*1000, j*3, "A ser definido");
                VagaInexperiente Vinxp = new VagaInexperiente(""+(j+2), (j+2)*10, j+2, (j+2)*1000, false, true);
                
                empresas[i].setVagaExp(Vexp, j);
                empresas[i].setVagaInxp(Vinxp, j);
                
            }
            
            qtdEmpresas++;
            
        }
        
    }

    public Empresa[] getEmpresas() {
        return empresas;
    }
    
    public Empresa getEmpresa(int empresa) {
        return empresas[empresa];
    }
    
    public void setEmpresas(Empresa[] empresas) {
        this.empresas = empresas;
    }

    public int getQtdEmpresas() {
        return qtdEmpresas;
    }
    
    public void setQtdEmpresas(int a) {
        qtdEmpresas = a;
    }
    
    //get para salvar a quantidade de Vagas Experientes
    
    public VagaExperiente[] getVagasExp() {
    	int qtdVgs = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) qtdVgs += getEmpresa(i).getQtdVagaExp();
    	
    	VagaExperiente[] vgs = new VagaExperiente[qtdVgs];
    	int x = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) {
    		
    		for (int j = 0; j < getEmpresa(i).getQtdVagaExp(); j++) {
    			
    			vgs[x] = getEmpresa(i).getVagaExp(j);
    			x++;
    			
    		}
    		
    	}
    	
    	return vgs;
    }
    
    //get para salvar a quantidade de Vagas Inexperientes.
    
    public VagaInexperiente[] getVagasInxp() {
    	int qtdVgs = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) qtdVgs += getEmpresa(i).getQtdVagaInxp();
    	
    	VagaInexperiente[] vgs = new VagaInexperiente[qtdVgs];
    	int x = 0;
    	
    	for (int i = 0; i < getQtdEmpresas(); i++) {
    		
    		for (int j = 0; j < getEmpresa(i).getQtdVagaInxp(); j++) {
    			
    			vgs[x] = getEmpresa(i).getVagaInxp(j);
    			x++;
    		}
    		
    	}
    	
    	return vgs;
    }
    
    //get para salvar a quantidade de Vagas Experientes de acordo com sua posição.
    
    public VagaExperiente[] getVagasExp(int pos) {
    	VagaExperiente[] vgs = new VagaExperiente[50];
    	
    	int x = 0;
    	
    	for (int j = 0; j < getEmpresa(pos).getQtdVagaExp(); j++) {
    		
			vgs[x] = getEmpresa(pos).getVagaExp(j);
			x++;
			
		}
    	
    	return vgs;
    }
    
    //get para salvar a quantidade de Vagas Inexperientes de acordo com sua posição.
    
    public VagaInexperiente[] getVagasInxp(int pos) {
    	VagaInexperiente[] vgs = new VagaInexperiente[50];
    	
    	int x = 0;

		for (int j = 0; j < getEmpresa(pos).getQtdVagaInxp(); j++) {
			
			vgs[x] = getEmpresa(pos).getVagaInxp(j);
			x++;
			
		}
		
    	return vgs;
    }
    
    /**
     * Método que edita uma empresa.
     * @param pos  posição da empresa
     * @param emp  qual empresa estamos editando
     */
    
    public void inserirEditarEmpresa(int pos, Empresa emp) {
    	
    	if (pos == qtdEmpresas) qtdEmpresas++;
    }
    
    /**
     * Método que edita Vaga Experiente.
     * @param posVaga	posição da vaga experiente
     * @param posEmp	posição da empresa
     * @param vg		vaga nova editada
     */
    
    public void inserirEditarVagaExp(int posVaga, int posEmp, VagaExperiente vg) {
    	empresas[posEmp].setVagaExp(vg, posVaga);
    	
    	if (posVaga == empresas[posEmp].getQtdVagaExp()) empresas[posEmp].setQtdVagaExp(posVaga+1);
    }
    
    /**
     * Método que edita Vaga Inexperiente.
     * @param posVaga		posição da vaga inexperiente
     * @param posEmp		posição da empresa
     * @param vg			vaga nova editada
     */
    public void inserirEditarVagaInxp(int posVaga, int posEmp, VagaInexperiente vg) {
    	empresas[posEmp].setVagaInxp(vg, posVaga);
    	
    	if (posVaga == empresas[posEmp].getQtdVagaInxp()) empresas[posEmp].setQtdVagaInxp(posVaga+1);
    }
}
    

