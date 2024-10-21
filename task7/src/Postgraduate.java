public class Postgraduate extends Student {
    private Academic supervisor;

    public Postgraduate(String login, String email, String name, Academic supervisor) {
        super(login, email, name);
        this.supervisor = supervisor;
    }

    public Academic getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Academic supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Postgraduate{" +
                "supervisor=" + supervisor +
                "} " + super.toString();
    }
}
