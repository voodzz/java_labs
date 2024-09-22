public class Numbers {
    public int add(String a, String b) {
        int x;
        int y;
        try {
            x = Integer.parseInt(a);
        } catch (NumberFormatException e) {
            x = 0;
        }
        try {
            y = Integer.parseInt(b);
        } catch (NumberFormatException e) {
            y = 0;
        }
        return x + y;
    }
}
