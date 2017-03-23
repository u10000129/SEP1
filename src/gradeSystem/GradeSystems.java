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
	float[] weights = {0.1f,0.1f,0.1f,0.3f,0.4f};
	LinkedList<Grades> aList;
	String[] gradeItemList = {	"lab1          ",
								"lab2          ",
								"lab3          ",
								"mid-term      ",
								"final exam    ",
								"total grade   "};
	
	
	public GradeSystems() {
		aList = new LinkedList<Grades>();

		try {
			File f = new File("inputdata.txt");
			InputStreamReader read = new InputStreamReader (new FileInputStream(f),"UTF-8");
			BufferedReader reader = new BufferedReader(read);
			String line;
			while((line = reader.readLine())!=null && line.length()!=0) {
				System.out.println(line);
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
            	System.out.println(temp.name+"成績：");
            	for(int i=0;i<5;i++) {
        			if(temp.gradeList[i]>59) System.out.println("           "+gradeItemList[i]+temp.gradeList[i]);
        	    	else System.out.println("           "+gradeItemList[i]+temp.gradeList[i]+"*");
        		}
            	if(temp.totalGrade>59) System.out.println("           "+gradeItemList[5]+temp.totalGrade);
    	    	else System.out.println("           "+gradeItemList[5]+temp.totalGrade+"*");
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
		for(int i=0;i<5;i++) System.out.println(gradeItemList[i]+"         "+Math.round(weights[i]*100)+"%");		
		System.out.println("輸入新配分");
		float weights_temp[] = new float[5];
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.print(gradeItemList[i]+"       ");		
			weights_temp[i] = scanner.nextFloat()/100;
		}
		System.out.println("請確認新配分");
		for(int i=0;i<5;i++) System.out.println(gradeItemList[i]+"         "+Math.round(weights[i]*100)+"%");		
		System.out.print("以上正確嗎? Y (Yes) 或 N (No):");		
		if(scanner.next().equals("Y")) weights = weights_temp.clone();
		scanner.close();
		for (Grades temp : aList) temp.calculateTotalGrade(weights);
		
	}
	
	public void showAverages() {
		int[] averageList = new int[6];		
		for (Grades temp : aList) {
			for(int i=0;i<5;i++) averageList[i] += temp.gradeList[i];
			averageList[5] += temp.totalGrade;
        }
		System.out.println("平均成績：");
		for(int i=0;i<6;i++) {
			averageList[i] = averageList[i]/aList.size();
			System.out.println("           "+gradeItemList[i]+averageList[i]);
		}
	}
	
	private void showWeight(float[] weights) {
		for(int i=0;i<5;i++)
			System.out.println(gradeItemList[i]+"         "+Math.round(weights[i]*100)+"%");		
	}
	
	private void scanWeight(float[] weights, Scanner scanner) {		
		for(int i=0;i<5;i++) {
			System.out.print(gradeItemList[i]+"       ");		
			weights[i] = scanner.nextFloat()/100;
		}				
	}	
	
}
