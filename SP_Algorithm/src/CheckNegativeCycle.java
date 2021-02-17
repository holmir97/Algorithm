import java.util.LinkedList;

public class CheckNegativeCycle {

    // 코드가 bellman-Ford와 동일한 부분을 많이 포함하지만,
    // 음수 사이클을 찾는 방법을 Bellman-Ford 알고리즘을 통한 방법으로 적용한다
    // ---이유는 document에 기재
    static boolean isNeg(InputGraph.Graph graph, int start) {
        int vertices = graph.vertices; // 정점의 개수

        // edge의 개수를 의미.
        // 이 메소드에서는 list[] * get() = E 를 의미하여, for문의 중첩을 통해 표현되어 있다.
        int E = graph.edges;

        // Graph 가져옴
        LinkedList<InputGraph.edge> checkList[] = graph.getGraph();
        int[] distance = new int[vertices];

        //초기화
        for (int i = 0; i < vertices; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[start] = 0;

        // v-1 -> v-1 pass 만큼 반복
        // 첫번째 반복문은 Vertex의 개수만큼 반복하게 한다.
        for (int cnt = 0; cnt < vertices - 1; cnt++) {

            // 아래의 중첩 반복문이 모든 edge에 접근하게 해준다.
            for (int i = 0; i < vertices - 1; i++) {
                //checkList[i =vertex] 에 존재하는 각list edge의 개수까지 접근한다.
                for (int j = 0; j < checkList[i].size(); j++) {
                    int u = checkList[i].get(j).src;
                    int v = checkList[i].get(j).dest;
                    int weight = checkList[i].get(j).weight;
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                        distance[v] = distance[u] + weight;
                }
            }
        }

        // 모든 edge에 접근하여 Negative Cycle 검사
        // Negative Cycle 이 존재하면 -> True 반환 아니면 False
        // 교안의 의사코드 참고.
        for (int i = 0; i < vertices - 1; i++) {
            for (int j = 0; j < checkList[i].size(); j++) {
                int u = checkList[i].get(j).src;
                int v = checkList[i].get(j).dest;
                int weight = checkList[i].get(j).weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                    return true;
            }
        }
        return false;
    }
}