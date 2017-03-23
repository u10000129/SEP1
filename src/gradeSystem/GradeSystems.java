package gradeSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeSystems {
	float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	LinkedList<Grades> aList;
	
	
	public GradeSystems() {
		aList = new LinkedList<Grades>();

		try {
			File f = new File("gradeinput.txt");
			InputStreamReader read = new InputStreamReader (new FileInputStream(f));
			BufferedReader reader = new BufferedReader(read);
			String line;
			while((line = reader.readLine())!=null && line.length()!=0) {
				//System.out.println(line);
				String split_line[] = line.split(" ");
				Grades grade = new Grades(	split_line[0],
											split_line[1],
											Integer.valueOf(split_line[2]),
											Integer.valueOf(split_line[3]),
											Integer.valueOf(split_line[4]),
											Integer.valueOf(split_line[5]),
											Integer.valueOf(split_line[6]));
				grade.calculateTotalGrade(weights);
				aList.add(grade);
			}
			reader.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			System.out.println("Loading error");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean containID(String ID) {
		for (Grades temp : aList) {
            if(temp.ID.equals(ID)) return true;
        }
		return false;
	}
	
	public void showGrade(String ID) {
		for (Grades temp : aList) {
            if(temp.ID.equals(ID)) {
            	showGradePrint(temp);
            }
        }		
	}

	public int showRank(String ID) {
		int rank = 0;
		for (Grades current : aList) {
            if(current.ID.equals(ID)) {
            	rank = 1;
            	for (Grades temp : aList) {
                    if(temp.totalGrade > current.totalGrade) rank = rank+1; 
                }
            	return rank;
            }           
		}
		return 0;		
	}
	
	public void updateWeights() {
		System.out.println("舊配分");
		showWeight(weights);
		System.out.println("輸入新配分");
		float weights_temp[] = new float[5];
		Scanner scanner = new Scanner(System.in);
		scanWeight(weights_temp, scanner);
		System.out.println("請確認新配分");
		showWeight(weights_temp);
		System.out.print("以上正確嗎? Y (Yes) 或 N (No):");		
		if(scanner.next().equals("Y")) {
			for(int i=0;i<5;i++) weights[i] = weights_temp[i];
		}
		scanner.close();
		for (Grades temp : aList) temp.calculateTotalGrade(weights);
		
	}
	
	private void showWeight(float[] weights) {
		System.out.println("lab1         "+Math.round(weights[0]*100)+"%");
		System.out.println("lab2         "+Math.round(weights[1]*100)+"%");
		System.out.println("lab3         "+Math.round(weights[2]*100)+"%");
		System.out.println("mid-term     "+Math.round(weights[3]*100)+"%");
		System.out.println("final exam   "+Math.round(weights[4]*100)+"%");		
	}
	
	private void scanWeight(float[] weights, Scanner scanner) {		
		System.out.print("lab1       ");		
		weights[0] = scanner.nextFloat()/100;
		System.out.print("lab2       ");		
		weights[1] = scanner.nextFloat()/100;
		System.out.print("lab3       ");		
		weights[2] = scanner.nextFloat()/100;
		System.out.print("mid-term   ");		
		weights[3] = scanner.nextFloat()/100;
		System.out.print("final exam ");		
		weights[4] = scanner.nextFloat()/100;			
	}
	
	private void showGradePrint(Grades temp) {
		if(temp.lab1>59) System.out.println(temp.name+"成績:lab1:       "+temp.lab1);
    	else System.out.println(temp.name+"成績:lab1:       "+temp.lab1+"*");
    	if(temp.lab2>59)System.out.println("          lab2:       "+temp.lab2);
    	else System.out.println("          lab2:       "+temp.lab2+"*");
    	if(temp.lab3>59)System.out.println("          lab3:       "+temp.lab3);
    	else System.out.println("          lab3:       "+temp.lab3+"*");   
    	if(temp.midTerm>59)System.out.println("          mid-term:   "+temp.midTerm);
    	else System.out.println("          mid-term:   "+temp.midTerm+"*");          	
    	if(temp.finalExam>59)System.out.println("          finalExam:  "+temp.finalExam);
    	else System.out.println("          finalExam:  "+temp.finalExam+"*");      	
    	if(temp.totalGrade>59)System.out.println("          total grade:  "+temp.totalGrade);
    	else System.out.println("          total grade:  "+temp.totalGrade+"*");      	
		
	}
}
