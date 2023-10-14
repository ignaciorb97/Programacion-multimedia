package com.ignaciorodriguez.Ahorcado;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Principal {

	public static void main(String[] args) {
		//TODO cambiar las palabras añadir mas, opcion de adivinar la palabra del tiron, mejorar funciones
		Scanner sc = new Scanner(System.in);
		String[] palabras = { "java", "gato", "perro", "mundo" };
		Random r = new Random();
		String palabraCorrecta = palabras[r.nextInt(palabras.length)];
		byte intentos = 6;
		boolean juegoTerminado = false;
		char[] letrasAdivinadas = new char[palabraCorrecta.length()];

		for (byte i = 0; i < letrasAdivinadas.length; i++) {
			letrasAdivinadas[i] = '_';
		}

		JOptionPane.showMessageDialog(null, "Vamos a jugar al ahorcado, intenta adivinar la palabra");

		do {
			String palabraActual = new String(letrasAdivinadas);
			String mensaje = "Palabra secreta: " + palabraActual + "\nIntentos restantes: " + intentos
					+ "\nIngresa una letra:";
			char letra = Character.toLowerCase(Funciones.obtenerLetra(mensaje));
			boolean letraAdivinada = false;

			for (byte i = 0; i < palabraCorrecta.length(); i++) {
				if (palabraCorrecta.charAt(i) == letra) {
					letrasAdivinadas[i] = letra;
					letraAdivinada = true;
				}
			}

			if (!letraAdivinada) {
				intentos--;
				JOptionPane.showMessageDialog(null, "¡Letra incorrecta!" + "\n" + Funciones.dibujarAhorcado(intentos));

			}

			juegoTerminado = intentos == 0 || Funciones.palabraAdivinada(letrasAdivinadas);

			if (juegoTerminado) {
				if (Funciones.palabraAdivinada(letrasAdivinadas)) {
					JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado la palabra: " + palabraCorrecta);
				} else {
					JOptionPane.showMessageDialog(null, "¡Perdiste! La palabra secreta era: " + palabraCorrecta);
				}
			}

		} while (!juegoTerminado);

	}

}
