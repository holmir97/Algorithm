import javafx.util.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraSP {
    int vertices;   // 정점 개수
    int E;          //각 정점별 추가된 모든 edge의 개수.
    LinkedList<InputGraph.edge>[] list;

    public DijkstraSP(InputGraph.Graph graph, int vertices) {
        this.vertices = vertices;
        this.list = graph.getGraph();   // 해당하는 그래프를 가져온다.
        this.E = graph.edges;
    }

    public void dijkstraSP(int start){

        // 해당 정점이 최단거리에 있는지 확인
        boolean[] CheckSP = new boolean[vertices];
        // start로부터의 해당 정점까지의 거리 저장 배열
        int [] distance = new int[vertices];

        // 모든 정점을 INF로 초기화 함.
        for (int i = 0; i <vertices ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 큐를 초기화
        // Compartor클래스를 사용하여 생성자에 매개변수를 이용.
        // 매개변수로 compare함수를 override해서 비교
        // vertices는 기본 사이즈 초기화, comprator는 queue들어온것을 min-heap과 똑같게 정렬
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {

            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                int key1 = p1.getKey();
                int key2 = p2.getKey();
                return key1-key2;
            }
        });
        
        // 앞선 초기화 과정과 이어지는 내용
        // 첫번째 정점의 distance를 0 으로 초기화 해주는 것
        // 즉 자기 자신까지의 거리가 d[0] = 0 이 된다는 것이다.
        distance[0] = 0;


        // pair을 사용해 바로 위의 첫 시작점의 정점을 입력(dist[0],0)
        Pair<Integer, Integer> p0 = new Pair<>(distance[0],0);
        pq.offer(p0);   //offer메소드를 통해 capacity를 +1 하고 큐에 저장

        // 큐에 정점이 들어가 있는 상태이므로 실행
        // 큐가 비기 전까지 실행
        while(!pq.isEmpty()){
            // poll 메소드로 큐를 하나 가져옴, 앞선 comprator로 min이 나옴
            Pair<Integer, Integer> pollPair = pq.poll();

            // 추출된 minPair의 정점을 저장
            int pollVertex = pollPair.getValue();
            if(CheckSP[pollVertex]==false) {
                CheckSP[pollVertex] = true;

                // 추출한 정점에 해당하는 인접 리스트를 dList에 저장
                LinkedList<InputGraph.edge> dList = list[pollVertex];
                
                // 해당 정점 인접리스트의 개수만큼 반복
                for (int i = 0; i < dList.size(); i++) {
                    // 각 엣지를 하나씩 저장하고 목적지 저장.
                    InputGraph.edge edge = dList.get(i);
                    int dest = edge.dest;

                    // 목적지가 shortest path에 위치하지 않을때 실행
                    if (CheckSP[dest] == false) {
                        // newDist는 추출정점 + 가중치 이다.
                        // currentDist는 현재 정점에 저장된 값이다.
                        // 현재 정점 값이 newDist보다 크다면 newDist가 더 최단거리임을 뜻하므로
                        // Pair에 newDist를 키로 가지는 새로운 정점 값을 입력한다.
                        int newDist =  distance[pollVertex] + edge.weight ;
                        int currentDist = distance[dest];
                        if(currentDist>newDist){
                            Pair<Integer, Integer> p = new Pair<>(newDist, dest);
                            pq.offer(p);    //newDist가 해당하는 Pair 입력
                            distance[dest] = newDist; // newDist 즉 새로운 정점 값으로 바꿈
                        }
                    }
                }
            }
        }
        printDijkstra(distance, start);
    }

    public void printDijkstra(int[] distance, int start){
        System.out.println("      <Dijkstra Algorithm>");

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
