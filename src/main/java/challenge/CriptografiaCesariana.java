package challenge;

import java.util.Arrays;

public class CriptografiaCesariana implements Criptografia {

	private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";
	private static final int KEY = 3;

	@Override
	public String criptografar(String texto) {
		return criptografarOuDescriptografar(true, texto);
	}

	@Override
	public String descriptografar(String texto) {
		return criptografarOuDescriptografar(false, texto);
	}

	
	/**
	 * Faz a codificação / decodificação do texto informado.
	 * 
	 * @param isCriptografar verifica se é para criptografar (true) ou descriptografar (false).
	 * @param texto Texto que será processado.
	 * @return retorna o texto criptografado ou descriptografado, de acordo com o que for solicitado.
	 * 
	 */
	private String criptografarOuDescriptografar(boolean isCriptografar, String texto) {
		this.validarTexto(texto);
		texto = texto.toLowerCase();
		StringBuilder resposta = new StringBuilder();
		int index = -1;
		for (String letter : Arrays.asList(texto.split(""))) {
			if (!ALFABETO.contains(letter)) {
				resposta.append(letter);
				continue;
			}
			letter = letter.trim().toLowerCase();
			if (isCriptografar) {
				index = Math.floorMod(ALFABETO.indexOf(letter) + KEY, ALFABETO.trim().length());
			} else {
				index = Math.floorMod(ALFABETO.indexOf(letter) - KEY, ALFABETO.trim().length());
			}
			resposta.append(ALFABETO.charAt(index));
		}
		return resposta.toString();
	}
	
	
	/**
	 * Verifica se o texto passado é válido.
	 * @param texto - O texto a ser verificado.
	 * @throws NullPointerException caso o texto seja nulo.
	 * @throws IllegalArgumentException caso o texto esteja vazio.
	 * 
	 */
	private void validarTexto(String texto) {
		if (texto == null) {
			throw new NullPointerException("Text mut not be null.");
		} else if (texto.isEmpty()) {
			throw new IllegalArgumentException("Text mut not be empty.");
		}
	}
	
}