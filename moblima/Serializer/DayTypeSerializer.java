package moblima.Serializer;

import java.util.*;

import moblima.Entity.DayType;

import java.io.*;

public class DayTypeSerializer extends Serializer {
	public DayTypeSerializer() {
		super();
	}

	public static void saveDayTypeDict(HashMap<String, Double> o, String filename) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public static HashMap<String, Double> getDayTypeDict(String fileName) {
		FileInputStream fi = null;
		ObjectInputStream os = null;
		HashMap<String, Double> dayTypeDict = null;
		try {
			fi = new FileInputStream(fileName);
			os = new ObjectInputStream(fi);
			dayTypeDict = ((HashMap<String, Double>) os.readObject());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				os.close();
				fi.close();
			} catch (Exception e) {
				// if this fails, it's probably open, so just do nothing
			}
		}
		return dayTypeDict;
	}
}