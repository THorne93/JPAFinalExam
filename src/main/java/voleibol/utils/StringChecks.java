package voleibol.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class StringChecks {

	public boolean isVacio(String input, String value) {
		if (input.length() == 0) {
			JOptionPane.showMessageDialog(null, value + " no puede estar vacío");
			return false;
		} else
			return true;
	}

	public boolean hasOnlyLetters(String input) {
		return input.matches("^[a-zA-Z]+$");
	}

	public boolean hasOnlyNumbers(String input) {
		return input.matches("^[0-9]+$");
	}

	public boolean checkLength(String input, String value, int length) {
		if (input.length() <= length) {
			JOptionPane.showMessageDialog(null, value + " debe tener un longitud mas de " + length);
			return false;
		} else
			return true;
	}

	public boolean isEmail(String input) {
		if (!input.matches(".*[@].*[.].*")) {
			JOptionPane.showMessageDialog(null, "El email no es válido");
			return false;
		} else
			return true;
	}

	public boolean esDni(String input) {
		return input.matches(".*[0-9]{8,}.*");

	}

	public boolean isFechaValida(String input, SimpleDateFormat sdf) {
		try {
			sdf.parse(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isFechaCaducidadValida(String input, SimpleDateFormat sdf) {

		if (input.trim().equals("")) {
			return true;
		}

		Date fechaCad = null;
		try {
			fechaCad = sdf.parse(input);
		} catch (Exception ex) {
			return false;
		}

		if ((new Date()).before(fechaCad)) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isFloat(String input) {

		try {
			Float.parseFloat(input);
		} catch (Exception e) {
			try {
				Integer.parseInt(input);
			} catch (Exception e2) {
				return false;
			}
		}
		return true;
	}

	private boolean isInteger(String input) {

		try {
			Integer.parseInt(input);
		} catch (Exception e2) {
			return false;
		}
		return true;
	}
}
