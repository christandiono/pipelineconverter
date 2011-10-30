import string
"""A simple python script To read the .xml file and create corresponding individual tree class for each complextype"""

def readInputFile(file):	
	""" Read the LONI. xml file"""
	fileInput=open(file,"r")	#input the LONI .xsd file
	fileOutput=open(file+"_edited","w")	#output the edited LONI .xsd file which contain classes and coressponding attribute

	content=fileInput.readline()
	classFile = open("test.java", "w+")
	while content!="":
		
		if (content.find("<xsd:complexType name=")>=0):
			classIncompleteName=(content.split("="))[1]
			classCompleteName=classIncompleteName[1:len(classIncompleteName)-3]
			#Start with a capital letter
			classCompleteName=string.upper(classCompleteName[0])+classCompleteName[1:]
			tempName = classCompleteName;
			#Add the title and structure to the module name
			classCompleteName="public class "+classCompleteName+" extends LoniNode {\n"			

			print("}")
			print("#")
			fileOutput.write("}"+"\n")
			fileOutput.write("#"+"\n")
			classFile.write("}\n")

			classFile = open(tempName + ".java" , "w+")

			print(classCompleteName)
			fileOutput.write(classCompleteName+"\n")
			classFile.write("package LONI.tree;\n")
			classFile.write("\n")
			classFile.write(classCompleteName+"\n")
			classFile.write("\n")


		if (content.find("<xsd:attribute name=")>=0):
			elementIncompleteName=(content.split(" "))
			elementCompleteName=(elementIncompleteName[1].split("="))[1][1:-1]
			elementIncompleteType=(((elementIncompleteName[2].split(":"))[1]).split("/"))[0]
			elementCompleteType=(elementIncompleteType)[:-1]

			# To make the name to start with a Capital letter. If the name is too short, then all CAP
			#elementCompleteName=string.upper(elementCompleteName[0])+elementCompleteName[1:]

			#To make the type start with CAP
			elementCompleteType=string.upper(elementCompleteType[0])+elementCompleteType[1:]
			#change "integer" to "int" (syntax of Java
			if elementCompleteType=="Integer":
				elementCompleteType="int"
			if elementCompleteType=="Boolean":
				elementCompleteType="boolean"

			if elementCompleteName == "package":
				elementCompleteName = "myPackage";

			print("\tprivate " + elementCompleteType+" "+elementCompleteName+";")
			fileOutput.write("\tprivate " + elementCompleteType+" "+elementCompleteName+";"+"\n")
			classFile.write("\tprivate " + elementCompleteType + " " + elementCompleteName + ";" + "\n")
		content=fileInput.readline()	
		
	

rootDir="/home/johnny5550822/Desktop/CS130/project/loni_schema/"
inputFile="LONI_Schema_Complex_Type"
readInputFile(rootDir+inputFile);
