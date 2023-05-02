//Ayman Tawaalai
//9-28-2021
//The purpose of this program is to use ISBN to check if they are valid and attain its information

public class ISBN{
public String digits;//relates back to the client
public String checkSymbol;//relates back to the client
public String ISBN(String digits, String checkSymbol){
String book = digits + checkSymbol;// combines both into a book string
getDigits(book);
getCheckSymbol(book);
return null;
}
public String getDigits(String book){//gets the digit values
String boook = book.replaceAll("-","");
isValid(boook);
return boook;
}
public String getCheckSymbol(String book){//gets what the check is
int j = 0;
if(book.endsWith("X")){
j =book.indexOf("X");

}

return String.valueOf(j);
}
public boolean isValid(String boook){//checks to see if the ISBN inputed is valid
int sum = Integer.parseInt(boook.substring(0,1))+Integer.parseInt(boook.substring(1,2))*2+Integer.parseInt(boook.substring(2,3))*3+Integer.parseInt(boook.substring(3,4))*4+Integer.parseInt(boook.substring(4,5))*5+Integer.parseInt(boook.substring(5,6))*6+Integer.parseInt(boook.substring(6,7))*7+Integer.parseInt(boook.substring(7,8))*8+Integer.parseInt(boook.substring(8,9))*9;
if(sum%11<10){
if(boook.substring(boook.length()-1,boook.length()).equals(checkSymbol)){
return true;
}
}
else if(sum%11>10){
return true;
}else{
return false;
}
return false;
}
public String toString(String boook){

return boook;
}
}