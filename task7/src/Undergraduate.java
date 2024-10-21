public class Undergraduate extends Student {
    private Academic tutor;

    public Undergraduate(String login, String email, String name, Academic tutor) {
        super(login, email, name);
        this.tutor = tutor;
    }

    public Academic getTutor() {
        return tutor;
    }

    public void setTutor(Academic tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Undergraduate{" +
                "tutor=" + tutor +
                "} " + super.toString();
    }
}
