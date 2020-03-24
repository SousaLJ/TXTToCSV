package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import CSVModel.Deploy;


public class Main {
	public static String[] versaoData;
	private static final String FILE_HEADER = "Versão;Data;Tipo;Módulo;Descrição";

	public final static String SEPARADOR = ";";
	public final static String QUEBRA_LINHA = "\n";
	public static List<Deploy> listaObj = new ArrayList<Deploy>();


	public static void main(String[] args) throws Exception, IOException {
		String path = "C:\\Users\\Leandro Jesus Sousa\\Downloads\\AGHUse 7.txt";
		File txtFile = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(txtFile, StandardCharsets.UTF_8)); 
		String fileName = "C:\\Users\\Leandro Jesus Sousa\\Downloads\\"+(txtFile.getName().replace(".txt", ".csv"));
		try {
			String st;
			while ((st = br.readLine()) != null) {
				Deploy deployObj = new Deploy();
				if (st.contains("|")) {
					versaoData = null;
					versaoData = st.split("[|]");
				} else {
					System.out.println(st);
					String[] arrOfStr = st.split("[:]+");
					String[] tipoModulo = arrOfStr[0].split("\\(");
					System.out.println(tipoModulo);
					deployObj.setVersao(versaoData[0].trim());
					deployObj.setData(versaoData[1].trim());
					if (tipoModulo[0].contains("Arquitetura") | tipoModulo[0].contains("Design") ) {
						deployObj.setTipo(tipoModulo[0].trim());
						deployObj.setModulo("");
					} else {
						deployObj.setTipo(tipoModulo[0].trim());
						deployObj.setModulo(tipoModulo[1].replace(")", ""));
					}
					String desc = arrOfStr[1].replace("#", "");
					deployObj.setDescricao(desc);
				}
				if (deployObj.getVersao()!=null) {
					listaObj.add(deployObj);
				}
			}
			writeCSV(listaObj, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}	
	}

	public static void writeCSV(List<Deploy> listaObj, String fileName) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);

			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(QUEBRA_LINHA);
			for (Deploy deploy : listaObj) {
				fileWriter.append(deploy.getVersao());
				fileWriter.append(SEPARADOR);
				fileWriter.append(deploy.getData());
				fileWriter.append(SEPARADOR);
				fileWriter.append(deploy.getTipo());
				fileWriter.append(SEPARADOR);
				fileWriter.append(deploy.getModulo());
				fileWriter.append(SEPARADOR);
				fileWriter.append(deploy.getDescricao());
				fileWriter.append(QUEBRA_LINHA);
			}

			System.out.println("Arquivo CSV criado com sucesso.");
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}

	}

}
