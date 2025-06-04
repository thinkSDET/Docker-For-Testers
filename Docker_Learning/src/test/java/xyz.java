public class xyz {

    public static void main(String[] args) {
        String phoneNumber = "+919876543210";
        if (phoneNumber.startsWith("+91")) {
            System.out.println("Indian number");
        } else {
            System.out.println("Not an Indian number");
        }
    }
}
