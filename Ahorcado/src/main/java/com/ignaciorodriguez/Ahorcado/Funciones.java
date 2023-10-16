package com.ignaciorodriguez.Ahorcado;

import javax.swing.JOptionPane;

public class Funciones {
	
	public static char obtenerLetra(String mensaje) {

        String entrada = JOptionPane.showInputDialog(mensaje);
        if (entrada == null || entrada.length() == 0) {
            return obtenerLetra(mensaje);
        }
        return entrada.charAt(0);
    }
	public static String dibujarAhorcado(byte intentos) {
		String dibujo = "";
		switch (intentos) {
		case 6:
			dibujo=" ________"+"\n"+"|       |"+"\n"+"|"+"\n"+"|"+"\n"+"|"+"\n"+"|"+"\n"+"|________";

			break;
		case 5:
			dibujo=" ________"+"\n"+"|       |"+"\n"+"|       O"+"\n"+"|"+"\n"+"|"+"\n"+"|"+"\n"+"|________";

			break;
		case 4:
			dibujo=" ________"+"\n"+"|       |"+"\n"+"|       O"+"\n"+"|       |"+"\n"+"|"+"\n"+"|"+"\n"+"|________";

			break;
		case 3:
			dibujo=" ________"+"\n"+"|       |"+"\n"+"|       O"+"\n"+"|      /|"+"\n"+"|"+"\n"+"|"+"\n"+"|________";

			break;
		case 2:
			dibujo=" ________"+"\n"+"|       |"+"\n"+"|       O"+"\n"+"|      /|\\"+"\n"+"|"+"\n"+"|"+"\n"+"|________";


			break;
		case 1:
			dibujo=" ________"+"\n"+"|       |"+"\n"+"|       O"+"\n"+"|      /|\\"+"\n"+"|      /"+"\n"+"|"+"\n"+"|________";

			break;
		case 0:
			dibujo=" ________"+"\n"+"|       |"+"\n"+"|       O"+"\n"+"|      /|\\"+"\n"+"|      / \\"+"\n"+"|"+"\n"+"|________";


			break;
		}
		return dibujo;
	}

	public static boolean palabraAdivinada(char[] letrasAdivinadas) {
		for (char c : letrasAdivinadas) {
			if (c == '_') {
				return false;
			}
		}
		return true;
	}
	


}
