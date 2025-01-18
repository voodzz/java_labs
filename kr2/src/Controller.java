public class Controller {
    private BinaryTree model;
    private View view;

    Controller(BinaryTree model, View view) {
        this.model = model;
        this.view = view;
        view.getArrayTextField().setText(model.getElements().toString());
        view.getToMinTextField().setText(model.moveToMin());
        showMin();
        showTraversal();
        view.getAddButton().addActionListener(e -> {
            int number = Integer.parseInt(view.getAddTextField().getText());
            addElement(number);
        });
        view.getSaveButton().addActionListener(e -> {
            model.save();
        });
    }

    public void addElement(int number) {
        model.add(number);
        view.getArrayTextField().setText(model.getElements().toString());
        showMin();
        showTraversal();
    }

    public void showMin() {
        int min = model.min();
        view.getMinLabel1().setText(Integer.toString(min));
        view.getMinLabel2().setText(Integer.toString(min));
        view.getToMinTextField().setText(model.moveToMin());
    }

    public void showTraversal() {
        view.getTraversalTextField().setText(model.getPreOrderTraversal());
    }

}
