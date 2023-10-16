package com.ignaciorodriguez.Ahorcado;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String[] palabras = { "agua", "calco", "mastodonte", "gimnasio", "fuerte", "tremendo", "mundo" };
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		byte intentos = 6;
		String palabraCorrecta = palabras[r.nextInt(palabras.length)];

		boolean juegoTerminado = false;
		char[] letrasAdivinadas = new char[palabraCorrecta.length()];

		for (byte i = 0; i < letrasAdivinadas.length; i++) {
			letrasAdivinadas[i] = '_';
		}

		JOptionPane.showMessageDialog(null, "Vamos a jugar al ahorcado, intenta adivinar la palabra");
 
		do {
			String palabraActual = new String(letrasAdivinadas);
			String mensaje = "La palabra: " + palabraActual + "\nVidas: " + intentos + "\nTu letra:";
			char letra = Character.toLowerCase(Funciones.obtenerLetra(mensaje));
			boolean letraAdivinada = false;

			for (byte i = 0; i < palabraCorrecta.length(); i++) {
				if (palabraCorrecta.charAt(i) == letra) {
					letrasAdivinadas[i] = letra;
					letraAdivinada = true;
				}
			}

			if (letraAdivinada == false) {
				intentos--;
				JOptionPane.showMessageDialog(null, "¡Letra incorrecta!" + "\n" + Funciones.dibujarAhorcado(intentos));

			}

			juegoTerminado = intentos == 0 || Funciones.palabraAdivinada(letrasAdivinadas);

			if (juegoTerminado) {
				if (Funciones.palabraAdivinada(letrasAdivinadas)) {
					JOptionPane.showMessageDialog(null, "¡Tremendo crack, has ganado¡ " + palabraCorrecta);
				} else {
					JOptionPane.showMessageDialog(null, "Una lastima, te has ahorcado owo " + palabraCorrecta);
				}
			}

		} while (!juegoTerminado);

	}

}
