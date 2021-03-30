

import java.util.List;

public class Application {

    public RBTree<Integer, Person> createTree() {
        // ########## YOUR CODE STARTS HERE ##########

        return null;
        // ########## YOUR CODE ENDS HERE ##########
    }

    public void saveXML(RBTree<Integer, Person> tree) {
        List<Node> nodeList = tree.inorder();
        // ########## YOUR CODE STARTS HERE ##########

        // ########## YOUR CODE ENDS HERE ##########
    }

    public static void main(String[] args) {
        Application application = new Application();
        RBTree<Integer, Person> tree = application.createTree();
        application.saveXML(tree);
    }
}
