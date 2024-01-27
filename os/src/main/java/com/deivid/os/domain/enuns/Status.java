package com.deivid.os.domain.enuns;

public enum Status {

	//Enum já com valores setados
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

	//Atributos
	private Integer cod;
	private String descricao;

	//Construtor
	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	//Métodos Get
	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	//Método toEnum - Verifica se o valor informado se é nulo, valido ou inválido.
	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null; //Se o valor informado for nulo, retorna nulo
		}
		
		for (Status x : Status.values()) {
			if(cod.equals(x.getCod())) {
				return x; //Se o valor informado estiver no Enum, retorna o valor
			}
		}
		
		throw new IllegalArgumentException("Status inválido "+cod); //Lança excessão por não encontrar o valor informado

	}

}
