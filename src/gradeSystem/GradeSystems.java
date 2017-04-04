package gradeSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public class GradeSystems {
	float[] weights = {0.1f,0.1f,0.1f,0.3f,0.4f};	
	LinkedList<Grades> aList;
	String[] gradeItemList = {	"lab1          ",
								"lab2          ",
								"lab3          ",
								"mid-term      ",
								"final exam    ",
								"total grade   "};
	
	/**Constructor Usage
	 * read input data and keep them in a linked list.
	 * 
	 * @throws IOException - throws exception when error occur during input.
	 * @throws UnsupportedEncodingException - throws exception when input encoding is not supported.
	 * @throws FileNotFoundException - throws exception when input file is not found.
	 * 
	 * pseudo code: 
	 * 1.create a LinkedList instance for aList to store aGrade.
	 * 2.read input file line by line.
	 * 3.split the input line by space and use it to initialize aGrade for the student.
	 * 4.repeat step 2 and 3 until the end of the file.
	 * 
	 * Time estimate: O(N), N for number of students.
	 */
	public GradeSystems() {
		aList = new LinkedList<Grades>();

		try {
			File f = new File("inputdata.txt");
			InputStreamReader read = new InputStreamReader (new FileInputStream(f),"UTF-8");
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
			System.out.println("Loading error");
			e.printStackTrace();
		}
	}
	/**containID usage
	 * check if ID is in GradeSystem
	 * @param ID - ID to check.
	 * @return true if ID exists. otherwise, return false.
	 * 
	 * pseudo code: 
	 * 1.go through aList and check if ID exists.
	 * 2.if ID match, return true.
	 * 3.if ID is not fount after going through the list, return false.
	 * 
	 * Time estimate: O(N), N for number of students. 
	 */
	public boolean containID(String ID) {
		for (Grades temp : aList) {
            if(temp.ID.equals(ID)) return true;
        }
		return false;
	}
	
	/**showGrade usage
	 * show the student's grade on console.
	 * 
	 * @param ID - ID to search.
	 * 
	 * pseudo code: 
	 * 1.go through aList and find the aGrade that matches the ID.
	 * 2.print the studnet's grades on console.
	 * 3.if the grade is lower than 60, add a '*' after the score.
	 * 
	 * Time estimate: O(N), N for number of students. 
	 */
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
	/**showRank usage
	 * show the student's rank on console.
	 * 
	 * @param ID - ID to search.
	 * @return student's rank. 0 if ID not found.
	 * 
	 * pseudo code: 
	 * 1.reset rank to 0.
	 * 2.go through aList to find aGrade of the student to search.
	 * 3.set rank to 1.
	 * 4.go through aList, if the total grade is higher than the student to search, add 1 to rank.
	 * 5.after going through aList, return rank.
	 * 6.if ID is not found, return 0.
	 * 
	 * Time estimate: O(N), N for number of students. 
	 */
	public int showRank(String ID) {
		int rank = 0;
		for (Grades current : aList) {
            if(current.ID.equals(ID)) {
            	rank = 1;
            	for (Grades temp : aList) {
                    if(temp.totalGrade > current.totalGrade) rank = rank+1; 
                }
            	System.out.println(current.name+"排名第"+rank);
            	return rank;
            }           
		}
		return 0;		
	}
	/**updateWeights usage
	 * set the weights for grades.
	 * 
	 * pseudo code: 
	 * 1.show old weights on console
	 * 2.let user input the new weights.
	 * 3.show new weights on console.
	 * 4.ask if the new weights is correct.
	 * 5.update the weights by new weights if the user inputs 'y' or 'Y'.
	 * 6.recalculate all students' total grades.
	 * 
	 * Time estimate: O(N), N for number of students. 
	 */
	public void updateWeights() {
		System.out.println("舊配分");
		for(int i=0;i<5;i++) System.out.println(gradeItemList[i]+"         "+Math.round(weights[i]*100)+"%");		
		System.out.println("輸入新配分");
		float weights_temp[] = new float[5];
		for(int i=0;i<5;i++) {
			System.out.print(gradeItemList[i]+"       ");		
			weights_temp[i] = Main.scanner.nextFloat()/100;
		}
		System.out.println("請確認新配分");
		for(int i=0;i<5;i++) System.out.println(gradeItemList[i]+"         "+Math.round(weights_temp[i]*100)+"%");		
		System.out.print("以上正確嗎? Y (Yes) 或 N (No):");		
		if(Main.scanner.next().toUpperCase().equals("Y")) {
			weights = weights_temp.clone();
			System.out.println("更新成功");
		}
		else System.out.println("取消更新配分");		
		//scanner.close();
		Main.scanner.nextLine();
		for (Grades temp : aList) temp.calculateTotalGrade(weights);
		
	}
	/**showAverages usage
	 * show averages of every items in grades on console.
	 * 
	 * pseudo code: 
	 * 1.new a instance of averageList to store every averages.
	 * 2.go through aList to get the sum of each item.
	 * 3.divided each sum by the number of student.
	 * 4.show averages score on console.
	 * 
	 * Time estimate: O(N), N for number of students. 
	 */
	public void showAverages() {
		int[] averageList = new int[6];		
		for (Grades temp : aList) {
			for(int i=0;i<5;i++) averageList[i] += temp.gradeList[i];
			averageList[5] += temp.totalGrade;
        }
		System.out.println("平均成績：");
		for(int i=0;i<6;i++) {
			averageList[i] = Math.round(averageList[i]/aList.size());
			System.out.println("           "+gradeItemList[i]+averageList[i]);
		}
	}
	/**getStudentName usage
	 * return the name of the student ID to search.
	 * @param ID - ID to search.
	 * @return student name.
	 * 
	 * pseudo code: 
	 * 1.go through the List and find the matches ID.
	 * 2.return the name.
	 * 
	 * Time estimate: O(N), N for number of students. 
	 */
	public String getStudentName(String ID) {
		for (Grades temp : aList) {
            if(temp.ID.equals(ID)) return temp.name;
        }
		return null;
	}
	
}
