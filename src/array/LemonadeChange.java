package array;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        int count20=0;

        for(int bill: bills){
            // if encounter 5 then collect it simply
            if(bill==5 ) count5+=5;

            else if(bill==10){
                if(count5>=5){
                    count5-=5;
                    count10+=10;
                }else return false;
            }else{

                if(count5>=5 && count10>=10){
                    count5-=5;
                    count10-=10;
                    count20+=20;
                }else if(count5>=15){
                    count5-=15;
                    count20+=20;
                }
                else return false;
            }
        }
        return true;
    }

}
