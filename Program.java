public class Program {
    public static void main(String[] args) {
        var console = System.console();
        var communicator = new Communicator(console);

        var activities = new Activity[2];
        activities[0] = new HelloWorld(communicator);
        activities[1] = new DrawStar(communicator);


        var menu = new ActivityMenu(activities, communicator);

        try {
            menu.run();
        } catch (TypeQException e) {
            System.exit(1);
        }
    }
}

// drawStar'ın seçeneklerini de activity arrayi olarak nasıl tanımlarsın ve çizdirirsin ve seçtirirsin onu düşün 


/*DONE  q deyince menu opsiyonu olarak yazıldığında sadece quit etsin, onu ayrıştır.
ters üçgen activitesi /  draw reverse star 3/ helloworld 1  

****
***
**
*
sağa dayalı star 

    *
   **
  ***
 ****
 
 ters sağa dayalı
 ****
  ***
   **
    *

bunları draw star içine 4 opsiyon olarak koy ( tek metodla parametre değişikliği ile çözebiliyor musun bak)

exception yerine başka bir şekilde quit yap, communicator class ı içinde int kontrolü olmasın başka bir yol bak
 
 */

 /* DONE
sayı sor kullanıcıya 
 0: 
 1: 
 * 
 4: 
 * 
 ** 
 *** 
 **** 
 5: 
 * 
 ** 
 *** 
 **** 
 ***** 

 integer girmesi lazım 
 Activity menu bu 1 olsun 
 helloworld 2 olsun 
 arada boşluk olsun q quit olsun 
 
 activite listesi olsun her activitenin menu sırası, 
  adı olsun 
--dependency injection --code formatı düzgün olsun --no static * * */