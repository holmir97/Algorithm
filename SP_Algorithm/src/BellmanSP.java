import java.util.LinkedList;

public class BellmanSP {
    int vertices;   // 정점 개수

    //각 정점별 추가된 모든 edge의 개수.
    // 이 메소드에서는 list[] * get() = E 를 의미하여, for문의 중첩을 통해 표현되어 있다.
    int E;
    LinkedList<InputGraph.edge>[] list;

    public BellmanSP(InputGraph.Graph graph, int vertices) {
        this.vertices = vertices;
        this.list = graph.getGraph();   // 해당하는 그래프를 가져온다.
        this.E = graph.edges;
    }

    public void bellmanSP(int start){
        int[] distance = new int[vertices];

        // 모든 정점의 distance를 INF로 초기화,
        for (int i = 0; i < vertices; i++)
            distance[i] = Integer.MAX_VALUE;

        // 첫번째 정점의 distance를 0 으로 초기화 해주는 것
        // 즉 자기 자신까지의 거리가 d[0] = 0 이 된다는 것이다.
        distance[start] = 0;

        // v-1 -> v-1 pass 만큼 반복
        // 첫번째 반복문은 Vertex의 개수만큼 반복하게 한다.
        for (int cnt = 0; cnt < vertices - 1; cnt++) {

            // 아래의 중첩 반복문이 모든 edge에 접근하게 해준다.
            for (int i = 0; i < vertices - 1; i++) {
                //list[i =vertex] 에 존재하는 각list edge의 개수까지 접근한다.
                for (int j = 0; j < list[i].size(); j++) {
                    int u = list[i].get(j).src;
                    int v = list[i].get(j).dest;
                    int weight = list[i].get(j).weight;
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                        distance[v] = distance[u] + weight;
                }
            }
        }
        printBellman(distance,start);
    }
    public void printBellman(int[] distance, int start){
        System.out.println("    <Bellman-Ford Algorithm>");
        for (int i = 0; i <vertices ; i++) {
            if(distance[i] > 1000000000){
                System.out.println("출발(" + start + ") -> 도착(" +   + i +
                        ") >> 거리(SP): Can't Go!" );
            }else {
                System.out.println("출발(" + start + ") -> 도착(" + +i +
                        ") >> 거리(SP): " + distance[i]);
            }
        }
    }
}

