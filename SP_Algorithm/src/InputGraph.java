// adjacencylist를 이용한 graph 생성
import java.util.LinkedList;

public class InputGraph {
    static class edge {
        int src;
        int dest;
        int weight;
        public edge(int source, int destination, int weight) {
            this.src = source;
            this.dest = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        // 리스트 배열을 만들어 각 노드(정점,간선,가중치)를 저장
        LinkedList<edge> [] list;
        int edges;  // edge의 개수

        Graph(int vertices) {
            // 총 정점 수를 선택하여 반환
            this.vertices = vertices;
            list = new LinkedList[vertices];

            // 정점이 많기 때문에 adjacencylist 방법으로 graph 생성
            // adjacencylist 방법이기 때문에 LinkedList 컬렉션을 사용.
            for (int i = 0; i <vertices ; i++) {
                list[i] = new LinkedList<>();
            }
        }

        // 과제에 맞게 단방향 그래프를 생성.
        // 그래프는 방향과 가중치를 가진다.
        public void addEdge(int source, int destination, int weight) {
            edge edge = new edge(source, destination, weight);
            list[source].addFirst(edge);
            edges++;
        }
        // 랜덤으로 Weight를 받을 수 있는 Graph
        // 가중치는 랜덤으로 생성되고, vertex와 edge는 사용자가 입력.
        public void addNodeRandomW(int source, int destination) {
            //가중치는 -5 ~ 5로 랜덤생성
            int randomWeight = (int) ((Math.random() * 10) - 5);

            edge edge = new edge(source, destination, randomWeight);
            list[source].addFirst(edge);
            edges++;
        }
        public LinkedList<edge>[] getGraph(){
            return list;
        }

        // 현재 그래프 출력
        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<edge> plist = list[i];
                for (int j = 0; j <plist.size() ; j++) {
                    System.out.println("V(" + i + ") -> V(" +
                            plist.get(j).dest + "), weight= " +  plist.get(j).weight);
                }
            }
        }
        // 입력된 그래프를 출력.
        // 현재 과제에서는 사용x
        public void printGraph_Test(LinkedList<InputGraph.edge> [] list){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<edge> plist = list[i];
                for (int j = 0; j <plist.size() ; j++) {
                    System.out.println("V(" + i + ") -> V(" +
                            plist.get(j).dest + "), weight= " +  plist.get(j).weight);
                }
            }
        }
    }
}