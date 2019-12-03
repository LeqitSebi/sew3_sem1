package Hutter.ue04_Rekursion;

public class CoinSums {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5,10,20,50,100,200};

        System.out.println(coinSums(200,coins.length-1,coins));
    }

    /**
     * coinSums Methode
     * @param pence
     * @param index
     * @param coins
     * @return
     */
    public static int coinSums(int pence,int index,int[]coins) {
        int counter = 0;
        if(pence < 0){
            return 0;
        }else if(pence == 0){
            return 1;
        }else if(index < 0){
            return 0;
        }else {
            return coinSums(pence-coins[index],index,coins) + coinSums(pence,index-1,coins);
        }
    }
}
