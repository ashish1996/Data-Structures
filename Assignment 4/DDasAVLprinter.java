import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DDasAVLprinter {

    public static void printDiagram(AVLtree t) {
        int maxLevel = DDasAVLprinter.maxLevel(t); // same as t.height+1

        printNodeInternal(Collections.singletonList(t), 1, maxLevel);
    }

    private static void printNodeInternal(List<AVLtree> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || DDasAVLprinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        DDasAVLprinter.printWhitespaces(firstSpaces);

        List<AVLtree> newNodes = new ArrayList<AVLtree>();
        for (AVLtree t : nodes) {
            if (t != null) {
                //System.out.print(node.data); // can modify this as needed
            	if(t.deleteStatus) // comment this out if lazy delete isn't implemented
            		System.out.print("X");
            	else
            		System.out.print(t.element.toString());
                newNodes.add(t.left);
                newNodes.add(t.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            DDasAVLprinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
            	DDasAVLprinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                	DDasAVLprinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                	DDasAVLprinter.printWhitespaces(1);

                DDasAVLprinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                	DDasAVLprinter.printWhitespaces(1);

                DDasAVLprinter.printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(AVLtree t) {
        if (t == null)
            return 0;

        return Math.max(DDasAVLprinter.maxLevel(t.left), DDasAVLprinter.maxLevel(t.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}