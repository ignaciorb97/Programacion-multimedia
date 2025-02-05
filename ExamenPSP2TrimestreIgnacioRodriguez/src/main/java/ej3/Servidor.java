package ej3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ej2.Pokemon;

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 6000;

		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando al cliente en el puerto: " + puerto);
			cliente = servidor.accept();

			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			MessageDigest md = MessageDigest.getInstance("MD5");
			String texto = "cenec";
			byte dataBytes[] = texto.getBytes(); // Texto a bytes
			md.update(dataBytes); // Se introduce texto en bytes a resumir
			byte resumen[] = md.digest();
			oos.writeObject("Ingresa la contraseña: ");

			InputStream input = cliente.getInputStream(); // Recibe entrada de bajo nivel
			ObjectInputStream ois = new ObjectInputStream(input); // Transforma ese bajo nivel en proceso
			String cadenaLeida = ois.readObject().toString(); // Transforma el objeto en una cadena de texto y lo lee

			if (Hexadecimal(resumen).equals(cadenaLeida)) {
				System.out.println("Contraseña correcta");
			} else {
				System.out.println("Contraseña incorrecta");
			}
			
			String respuesta = (String) ois.readObject();
			if (respuesta.equals("Y")) {
				Pokemon pokemon = (Pokemon) ois.readObject();

				String nName = "Gengar";
				System.out.println(pokemon.pkName + " esta evolucionando en " + nName);
				pokemon.pkName = nName;
				pokemon.pkVida = pokemon.pkVida*2;
				pokemon.pkAtk = pokemon.pkAtk*2;
				pokemon.pkDef = pokemon.pkDef*2;
				System.out.println("Nombre:" + pokemon.pkName + " - Vida:" + pokemon.pkVida + " - Ataque:" + pokemon.pkAtk + " - Defensa:" + pokemon.pkDef);

				oos.writeObject(pokemon);
			}

			ois.close();

			cliente.close();
			servidor.close();
		} catch (IOException | NoSuchAlgorithmException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// Convierte un array de bytes en hexadecimal
	static String Hexadecimal(byte[] resumen) {
		String hex = " ";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			if (h.length() == 1)
				hex += "0";
			hex += h;

		}
		return hex.toUpperCase();
	}
}