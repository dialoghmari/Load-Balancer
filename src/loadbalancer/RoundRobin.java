/**
 *
 * @author Dia LOGHMARI & Wael LATIRI
 * github.com/dialoghmari
 */
package loadbalancer;

/**
 *
 * @author Asus
 */
public class RoundRobin {

    int min;
    int max;
    int actual;

    public RoundRobin(int min, int max) {
        this.min = min;
        this.max = max;
        this.actual = this.min - 1;
    }

    public int next() {
        actual++;
        if (actual > max) {
            actual = min;
        }
        return actual;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        RoundRobin RR = new RoundRobin(6001, 6004);
        System.out.println(RR.next());
        System.out.println(RR.next());
        System.out.println(RR.next());

    }

}
