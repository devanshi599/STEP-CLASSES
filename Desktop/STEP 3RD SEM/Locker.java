public class Locker {

    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        System.out.println("First change completed");

        l.changeCode("0000", "9999");
        System.out.println("Second change rejected");
    }
}
