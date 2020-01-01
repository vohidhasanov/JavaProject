package JavaConcepts.GenericCollections.GenericMap;

import java.util.ArrayList;
import java.util.List;

public class DataNode extends Tree  {

}

class Tree {



    public static void main(String[] args) {
        List<DataNode> a1 = new ArrayList<>();
       // List <Tree> b1 = a1;

        DataNode [] dataNodes = new DataNode[1];
        Tree [] trees = dataNodes;

        Tree[] trees1=new Tree[1];
        DataNode [] dataNodes1= (DataNode[]) trees1;



        //trees[0] =new DataNode();

    }

}


