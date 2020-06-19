package challenge;

import java.util.Arrays;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

	private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";
	private static final List<String> ALFABETO_LIST = Arrays.asList(ALFABETO.split(""));
	private static final int KEY = 3;

	@Override
	public String criptografar(String texto) {
		return criptografarOuDescriptografar(true, texto);
	}

	@Override
	public String descriptografar(String texto) {
		return criptografarOuDescriptografar(false, texto);
	}

	private String criptografarOuDescriptografar(boolean isCriptografar, String texto) throws IllegalArgumentException {
		if (texto == null) {
			throw new NullPointerException("Text mut not be null.");
		} else if (texto.isEmpty()) {
			throw new IllegalArgumentException("Text mut not be empty.");
		}
		texto = texto.toLowerCase();
		List<String> textoAsList = Arrays.asList(texto.split(""));
		StringBuilder resposta = new StringBuilder();
		int index = -1;
		for (String letter : textoAsList) {
			if (!ALFABETO_LIST.contains(letter)) {
				resposta.append(letter);
				continue;
			}
			letter = letter.trim().toLowerCase();
			if (isCriptografar) {
				index = Math.floorMod(ALFABETO_LIST.indexOf(letter) + KEY, ALFABETO.trim().length());
			} else {
				index = Math.floorMod(ALFABETO_LIST.indexOf(letter) - KEY, ALFABETO.trim().length());
			}
			resposta.append(ALFABETO_LIST.get(index));
		}
		return resposta.toString();
	}
}