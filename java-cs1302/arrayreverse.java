//Ayman Tawaalai
//9-28-2021
//The purpose of this program is to switch the sets of 4 in a reverse pattern using array lists
import java.util.ArrayList; //imports the arraylist
public class arrayreverse{
public static void main(String[] args){
ArrayList<Integer> num=new ArrayList<Integer>(); //creates the object num
num.add(1);// feeds the object values
num.add(2);
num.add(3);
num.add(4);
num.add(5);
num.add(6);
num.add(7);
num.add(8);
num.add(9);
num.add(10);



System.out.print(num); //prints out the array in normal form
reverse4(num); //calls upon the reversal method
}
public static void reverse4(ArrayList num){
ArrayList<Integer> mun=new ArrayList<Integer>(); //creates a new object to feed the reversed numbers
int x = num.size()/4; //understands how many sets are needed within 4
int xx;
int xxx;
for(xx = 0; xx<x;xx++){//loop that will go through each set of 4
for(xxx = 3+(xx*4); xxx>=0+(xx*4); xxx--){//loop used to get the 4th number in the set of 4 and then go down by 4 without going into the previous set
int zz = (Integer)num.get(xxx);//turns the object pulled into an int
mun.add(zz);//feeds the int into the mun object
}
}
int j = num.size();
if(j%4==1){//if there is 1 extra number it will do this case
for(int o = num.size()-1;o<num.size();o++){
int zzz = (Integer)num.get(o);
mun.add(zzz);
}
}
else if(j%4==2){//if there is 2 extra number it will do this case
for(int o = num.size()-2;o<num.size();o++){
int zzz = (Integer)num.get(o);
mun.add(zzz);
}
}
else if(j%4==3){//if there is 3 extra number it will do this case
for(int o = num.size()-3;o<num.size();o++){
int zzz = (Integer)num.get(o);
mun.add(zzz);
}
}
System.out.println(mun);//prints the reversal mun
}
}