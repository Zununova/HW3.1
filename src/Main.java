import java.util.Random;

public class Main {
    public static int evilHealth = 700;
    public  static int evilDamage = 50;
    public static String evilPower;
    public static int heroesHealth []={300,250,200, 250};
    public static int heroesDamage[]={20,25,30,0};
    public static String heroesNames  []={"Swordsman","Archer","Wizard","Medic"};
    public static void main(String[] args) {
        printStatistic();
        while (!gameFinish()){
            round();
        }
    }
    public static void evilHit(){

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i]<evilDamage){
                heroesHealth[i] =0;
            }
            else {
                heroesHealth[i] -= evilDamage;

            }

        }
    }
    public static void heroesHits(){
        bossTypeBarrier();
        for (int i = 0; i < heroesHealth.length; i++) {
            if (evilHealth < heroesDamage[i]){
                evilHealth =0;
            }
            else {
                evilHealth -=heroesDamage[i];

            }


        }
    }
    public static void round (){
        evilHit();
        heroesHits();
        MedicPower();
        printStatistic();
    }
    public static void bossTypeBarrier() {
        Random random = new Random();
        int index = random.nextInt(heroesNames.length);
        evilPower = heroesNames[index];
        for (int i = 0; i < heroesNames.length; i++) {
            if (evilPower.equals(heroesNames[i])) {
                System.out.println("Boss barrier equals " + evilPower);
                ;
                evilHealth += heroesDamage[i];
            }
        }
    }
    public  static boolean gameFinish(){
        if (evilHealth<=0 ){
            System.out.println("Heroes WIN!!!");
            return true;

        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
            if (allHeroesDead) {
                System.out.println("Evil WIN!!!");
            }
            return allHeroesDead;





    }
    public  static void MedicPower(){
        boolean isThereAreMedic =false;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesNames[i] == "Medic" && heroesHealth[i] > 0 ){
                isThereAreMedic=true;

            }
            if (isThereAreMedic){
                for (int j = 0; j < heroesNames.length; j++) {

                    if (heroesHealth[j]<=100 && heroesHealth[j] >0){
                        heroesHealth[j] +=80;
                        System.out.println(heroesNames[j]+" was cured by a Medic on 80");
                        break;
                    }

                }
            }

        }
    }
    public static void printStatistic (){
        System.out.println("Evil health: " + evilHealth +", Damage["+ evilDamage +"]");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesNames[i]+" health: "+heroesHealth [i]+", Damage ["+heroesDamage[i]+"]");

        }
        System.out.println("______________________________________________");
    }
}