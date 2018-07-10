import java.util.*;

public class Lab6 {
    public static int size;
    public static int n;
    public static int x1,y1;
    public static int x2,y2;
    public static char[][] map;

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the size you want:");
        size=input.nextInt();
        System.out.print("Enter the number:");
        n=input.nextInt();
        while(n>size){
            System.out.print("Please enter another number:");
            n=input.nextInt();
        }
        map();
        play();
    }

    public static void map(){
       map=new char[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                map[i][j]='-';
            }
        }
    }
    //map

    public static void play(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the x1 and the y1:") ;
        x1=input.nextInt();
        y1=input.nextInt();
        while(x1<0||x1>size-1||y1<0||y1>size-1||map[x1][y1]=='1'||map[x1][y1]=='2'){
            System.out.print("Enter another x1 and y1:");
            x1=input.nextInt();
            y1=input.nextInt();
        }
        map[x1][y1]='1';
        boolean a=win('1');
        if(a) {
            System.out.println("1 win");
            return;
        }
        System.out.print("Enter the x2 and the y2:") ;
        x2=input.nextInt();
        y2=input.nextInt();
        while(x2<0||x2>size-1||y2<0||y2>size-1||map[x2][y2]=='1'||map[x2][y2]=='2'){
            System.out.print("Enter another x2 and y2:");
            x2=input.nextInt();
            y2=input.nextInt();
        }
        map[x2][y2]='2';
        boolean b=win('2');
        if(b) {
            System.out.println("2 win");
            return;
        }
        else play();
    }
    //play games
    public static boolean win(char number){
        boolean a;
        a=false;
        int x=1;
        int k1=1;
        int k2=1;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(map[i][j]==number){
                    while(j-k1>=0&&map[i][j-k1]==number){
                        x++;
                        k1++;
                    }
                    while(j+k2<size&&map[i][j+k2]==number){
                        x++;
                        k2++;
                    }
                    if(x>=n)
                        a=true;
                    else{
                        x=1;
                        k1=1;
                        k2=1;
                    }
                    while(i-k1>=0&&map[i-k1][j]==number){
                        x++;
                        k1++;
                    }
                    while(i+k2<size&&map[i+k2][j]==number){
                        x++;
                        k2++;
                    }
                    if(x>=n)
                        a=true;
                    else{
                        x=1;
                        k1=1;
                        k2=1;
                    }
                    while(i-k1>=0&&j-k1>=0&&map[i-k1][j-k1]==number){
                        x++;
                        k1++;
                    }
                    while(i+k2<size&&j+k2<size&&map[i+k2][j+k2]==number){
                        x++;
                        k2++;
                    }
                    if(x>=n)
                        a=true;
                    else{
                        x=1;
                        k1=1;
                        k2=1;
                    }
                    if(i-k1>=0&&j+k1<size&&map[i-k1][j+k1]==number){
                        x++;
                        k1++;
                    }
                    while(i+k2<size&&j-k2>=0&&map[i+k2][j-k2]==number){
                        x++;
                        k2++;
                    }
                    if(x>=n)
                        a=true;
                    else{
                        x=1;
                        k1=1;
                        k2=1;
                    }
                }
            }
        }

        return a;
    }
    //whether win or not
}
