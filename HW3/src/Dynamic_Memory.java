import java.io.*;
import java.util.StringTokenizer;
public class Dynamic_Memory 
{
	public static void main(String[] args)throws Exception
	{
		FileReader filereader1 =  new FileReader("D:\\New Folder\\Documents\\JAVA Lab 6060\\csx-351-hw3-Swap-23-master\\Input_Code.txt");
        BufferedReader InputCodeReader  =  new BufferedReader(filereader1);// Object of the input file reader.
        FileReader filereader2 =  new FileReader("D:\\New Folder\\Documents\\JAVA Lab 6060\\csx-351-hw3-Swap-23-master\\Unsorted-keywords.txt");
        BufferedReader Keywords  =  new BufferedReader(filereader2); // Object for reading the Keywords file
        FileWriter W1 = new FileWriter("D:\\New Folder\\Documents\\JAVA Lab 6060\\csx-351-hw3-Swap-23-master\\Output.txt"); 
        BufferedWriter Output = new BufferedWriter(W1); // Object for writing into the output file.
        String S1,S2; // Strings to read and store the input files line by line.
        int count=0;
        // Step.1 Counting the number of words from the unsorted Keywords file
        while((S1=Keywords.readLine()) != null)
        {
        	++count;
        }
        // Step.2 Dynamically allocating memory to the keywords array.
        String Keyword_Array[]=new String[count];
        int i=0,token=0,line=0;
        count=0;
        // Step.3 Re-reading the keywords file second time and then storing the words in an array.
        Keywords  =  new BufferedReader(new FileReader("D:\\New Folder\\Documents\\JAVA Lab 6060\\csx-351-hw3-Swap-23-master\\Unsorted-keywords.txt"));
        while((S1=Keywords.readLine()) != null)
        {
        	Keyword_Array[i]=S1;
        	++i;
        }
        // Step.4 Sorting the array of the unsorted keywords
        Sort_Array(Keyword_Array);
        // Step.5 Searching the keywords in the given input code according to the conditions 
        while((S1=InputCodeReader.readLine()) != null) 
        {
        	int flag=0;
        	++line;
        	token=0;
        	StringTokenizer String_Tokens = new StringTokenizer(S1); // String Tokenizer class to tokenize the string into words.
        	while(String_Tokens.hasMoreTokens())
        	{
        		S2=String_Tokens.nextToken();
        		if(S2=="\\")
        			continue;
        		// Searching and then writing the formatted output to the file.
        		if(SearchInArray(Keyword_Array,S2))
        		{
        			if(flag==0)
        				{
        				Output.write("Line "+line+" : ");
        				flag=1;
        				}
        			Output.write(S2+"("+token+") ");
        		    ++count;
        	    }
        		++token;
            }
        	if(flag==1)
        	Output.newLine();
        }
       	Output.write("Number of keywords found : "+count);
       	//Closing the objects created for writing and reading.
        InputCodeReader.close();
        Keywords.close();
        Output.close();
}
// Function to Sort an array of strings
static void Sort_Array(String[] A) 
	{
		int l=A.length;
		for(int k=0;k<l-1;++k)
		{
			for(int j=0;j<l-k-1;++j)
			{
				if(A[j].compareTo(A[j+1])>0) // Inbuilt compareTo function for comparing two strings
				{                            
					String temp=A[j]; 
					A[j]=A[j+1];
					A[j+1]=temp;
				}
			}
		}
	}
// Function which linearly searches a given word in an array.
static boolean SearchInArray(String S[] , String s)
{
	int a,l=S.length;
	for(a=0;a<l;++a)
    {
    	if(s.equalsIgnoreCase(S[a])) // Linearly searching the given string in the array of Keywords.
    		return true;
   	}
    return false;
}
}

