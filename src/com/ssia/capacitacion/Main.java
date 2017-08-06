package com.ssia.capacitacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.MultiClassClassifierUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class Main {

	
	public static void main(String[] args) throws Exception {
		long tiempoInicio = System.currentTimeMillis();
		System.out.println("--------------Inicio---------------");
		System.out.println("Tiempo Inicio    : " + tiempoInicio);
		//incrementalTraining();
		Recuperar();
		long tiempoFin = System.currentTimeMillis();
		System.out.println("Tiempo Inicio    : " + tiempoInicio);
		System.out.println("Tiempo Fin       : " + tiempoFin);
		System.out.println("Tiempo Ejecucion : " + (tiempoFin - tiempoInicio));

	}
	
	public static void Recuperar() throws FileNotFoundException, ClassNotFoundException, IOException{
		BinaryManager bm = new BinaryManager();
		Logistic logReg = bm.ReadFileLogistic("D:\\ML\\logisticNuevo.bin");
		Evaluation eval = bm.ReadFileEvaluator("D:\\ML\\evaluatorNuevo.bin");
		System.out.println(eval.toSummaryString("Resultados:\n\n", false));
		System.out.println("fMeasure: "+eval.fMeasure(1)+"\nPrecision: "+eval.precision(1)+ "\nRecall: "+eval.recall(1));
	}
	
	public static void incrementalTraining() throws Exception{
		System.out.println("Creando Loader");
		ArffLoader loader = new ArffLoader();
		System.out.println("Asignando Archivo");
		loader.setFile(new File("D:\\ML\\marsyas\\bin\\Release\\midTrain.arff"));
		System.out.println("Creando Estructura");
		Instances structure = loader.getStructure();
		System.out.println("Asignando clase index");
		structure.setClassIndex(structure.numAttributes() - 1);
		
		System.out.println("Creando clasificador");
		//IBk nb = new IBk();
		NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
		//MultiClassClassifierUpdateable nb = new MultiClassClassifierUpdateable();
		System.out.println("Build Classifier");
		nb.buildClassifier(structure);
		System.out.println("Creando instancia");
		Instance current;
		System.out.println("While");
		int cont = 1;
		while((current = loader.getNextInstance(structure)) != null){
			System.out.println("Iteracion #" + cont);
			nb.updateClassifier(current);
			cont++;
		}
		System.out.println("Creando Evaluacion");
		Evaluation eval = new Evaluation(structure);
		cont = 1;
		loader.reset();
		loader.setFile(new File("D:\\ML\\marsyas\\bin\\Release\\midTrain.arff"));
		structure = loader.getStructure();
		structure.setClassIndex(structure.numAttributes() - 1);
		Instance instance;
		while((instance = loader.getNextInstance(structure)) != null){
			System.out.println("Prueba #" + cont);
			eval.evaluateModelOnce(nb, instance);
			cont++;
		}
		System.out.println("Imprimiendo Resultados");
		System.out.println(eval.toSummaryString("Resultados:\n\n", false));
		System.out.println("fMeasure: "+eval.fMeasure(1)+"\nPrecision: "+eval.precision(1)+ "\nRecall: "+eval.recall(1));
		System.out.println("----------------FIN----------------");
	}
}
