public class PrintVisitor implements MyVisitor {
    StringBuilder result = new StringBuilder();
    @Override
    public void visitElement(Integer element) {
        result.append(element).append(" ");
    }

    String getResult() {
        return result.toString();
    }
}
