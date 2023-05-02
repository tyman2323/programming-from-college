public class taskone {
    public static void main(String[] args){
        int x = 5;
        for (int y = 5; y>0; y--){
            System.out.println("      ");
            for(int z = 0;z<=x;z++){
                if(z>=y){
                    System.out.print(z);
                }
            }
        }
    }
}
