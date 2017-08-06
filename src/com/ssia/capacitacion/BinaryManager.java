
package com.ssia.capacitacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;

public class BinaryManager {

	public void WriteFileLogistic(Logistic logReg, String path) throws FileNotFoundException, IOException{
		ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(path));
		file.writeObject(logReg);
		file.close();
	}
	
	public Logistic ReadFileLogistic(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("[BinaryManager:ReadFileLogistic] Inicio");
		
		Logistic logReg = new Logistic();
		System.out.println("[BinaryManager:ReadFileLogistic] Obteniendo ruta");
		ObjectInputStream file = new ObjectInputStream(new FileInputStream( path ));
		System.out.println("[BinaryManager:ReadFileLogistic] Leyendo archivo");
		logReg = (Logistic) file.readObject();
		System.out.println("[BinaryManager:ReadFileLogistic] Cerrando archivo");
		file.close();
		System.out.println("[BinaryManager:ReadFileLogistic] Fin");
		return logReg;
	}
	
	//EVALUADOR
	public void WriteFileEvaluator(Evaluation evaluator, String path) throws FileNotFoundException, IOException{
		ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(path));
		file.writeObject(evaluator);
		file.close();
	}
	
	public Evaluation ReadFileEvaluator(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println("[BinaryManager:ReadFileEvaluation] Inicio");
		Evaluation evaluator;
		System.out.println("[BinaryManager:ReadFileEvaluation] Obteniendo ruta");
		ObjectInputStream file = new ObjectInputStream(new FileInputStream( path ));
		System.out.println("[BinaryManager:ReadFileEvaluation] Leyendo archivo");
		evaluator = (Evaluation) file.readObject();
		System.out.println("[BinaryManager:ReadFileEvaluation] Fin");
		return evaluator;
	}
	
	public static void main(String[] args) {
	}

}
