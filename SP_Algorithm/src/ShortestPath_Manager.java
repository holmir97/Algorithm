
public class ShortestPath_Manager {

    // 실행 메소드
    public static void run(InputGraph.Graph graph, int vertices, int count){
        System.out.println("---------------그래프 #"+ count+"---------------");
        // 그래프 확인
        graph.printGraph();

        // Negative Cycle 검사
        // Negative Cycle 가 있다면 Bellman 없다면 dijkstra
        if( CheckNegativeCycle.isNeg(graph,0)) {
            System.out.println("\nNegative Cycle 존재O -> Bellman-Ford 실행");
            BellmanSP bSP = new BellmanSP(graph, vertices);
            bSP.bellmanSP(0);
            System.out.println("\n");
        }
        else {
            System.out.println("\nNegative Cycle 존재X -> dijkstra 실행");
            DijkstraSP dSP = new DijkstraSP(graph,vertices);
            dSP.dijkstraSP(0);
            System.out.println("\n");
        }

    }

    public static void main(String[] args) {
        // Graph 생성

        // VERTICES = 10 , not exists NegativeCycle_DijkstraSP
        int vertices1 = 10;
        InputGraph.Graph graph1 = new InputGraph.Graph(vertices1);
        graph1.addEdge(0, 1, 10);
        graph1.addEdge(0, 3, 20);
        graph1.addEdge(0, 4, 20);
        graph1.addEdge(0, 5, 5);
        graph1.addEdge(0, 6, 15);
        graph1.addEdge(1, 2, 5);
        graph1.addEdge(1, 3, 10);
        graph1.addEdge(2, 1, 5);
        graph1.addEdge(2, 3, 5);
        graph1.addEdge(3, 4, 10);
        graph1.addEdge(4, 5, 5);
        graph1.addEdge(6, 5, 10);
        graph1.addEdge(7, 0, 5);
        graph1.addEdge(7, 1, 20);
        graph1.addEdge(7, 6, 5);
        graph1.addEdge(8, 1, 15);
        graph1.addEdge(8, 7, 20);
        graph1.addEdge(8, 9, 10);
        graph1.addEdge(9, 1, 5);
        graph1.addEdge(9, 2, 15);

        // VERTICES = 11 , exists NegativeCycle_BellmanSP
        int vertices2 = 11;
        InputGraph.Graph graph2 = new InputGraph.Graph(vertices2);
        graph2.addEdge(0, 1, 2);
        graph2.addEdge(0, 2, 1);
        graph2.addEdge(0, 6, 1);
        graph2.addEdge(1, 2, 4);
        graph2.addEdge(1, 3, 4);
        graph2.addEdge(1, 10, 1);
        graph2.addEdge(3, 6, -2);
        graph2.addEdge(3, 5, 4);
        graph2.addEdge(4, 3, 2);
        graph2.addEdge(4, 9, 3);
        graph2.addEdge(4, 1, 3);
        graph2.addEdge(5, 7, -2);
        graph2.addEdge(6, 2, 3);
        graph2.addEdge(6, 5, -3);
        graph2.addEdge(7, 8, 2);
        graph2.addEdge(8, 5, -2);
        graph2.addEdge(9, 10, 1);


        // VERTICES = 10 , not exists NegativeCycle_DijkstraSP
        int vertices3 = 10;
        InputGraph.Graph graph3 = new InputGraph.Graph(vertices3);
        graph3.addEdge(0, 1, 40);
        graph3.addEdge(0, 2, 8);
        graph3.addEdge(0, 3, 10);
        graph3.addEdge(1, 4, 6);
        graph3.addEdge(1, 6, 10);
        graph3.addEdge(2, 1, 4);
        graph3.addEdge(2, 3, 12);
        graph3.addEdge(2, 5, 2);
        graph3.addEdge(3, 5, 1);
        graph3.addEdge(4, 2, 2);
        graph3.addEdge(4, 5, 2);
        graph3.addEdge(4, 6, 4);
        graph3.addEdge(5, 7, 4);
        graph3.addEdge(5, 8, 3);
        graph3.addEdge(6, 7, 20);
        graph3.addEdge(6, 9, 1);
        graph3.addEdge(7, 4, 0);
        graph3.addEdge(7, 9, 20);
        graph3.addEdge(8, 3, 6);
        graph3.addEdge(8, 7, 10);
        graph3.addEdge(8, 9, 20);


        // VERTICES = 12 , exists NegativeCycle_BellmanSP
        int vertices4 = 12;
        InputGraph.Graph graph4 = new InputGraph.Graph(vertices4);
        graph4.addEdge(0, 1, 1);
        graph4.addEdge(0, 5, 3);
        graph4.addEdge(1, 2, 2);
        graph4.addEdge(2, 4, 1);
        graph4.addEdge(3, 1, 3);
        graph4.addEdge(3, 2, -3);
        graph4.addEdge(4, 3, -3);
        graph4.addEdge(5, 8, 2);
        graph4.addEdge(6, 4, -1);
        graph4.addEdge(7, 9, 3);
        graph4.addEdge(8, 10, -1);
        graph4.addEdge(9, 11, -2);
        graph4.addEdge(10, 4, 2);
        graph4.addEdge(10, 5, 4);
        graph4.addEdge(10, 6, -1);
        graph4.addEdge(10, 7, 1);
        graph4.addEdge(11, 4, 2);
        graph4.addEdge(11, 7, 1);

        // VERTICES = 10 , not exists NegativeCycle_DijkstraSP
        int vertices5 = 10;
        InputGraph.Graph graph5 = new InputGraph.Graph(vertices5);
        graph5.addEdge(0, 1, 5);
        graph5.addEdge(0, 2, 2);
        graph5.addEdge(1, 3, 3);
        graph5.addEdge(1, 4, 7);
        graph5.addEdge(2, 1, 2);
        graph5.addEdge(2, 6, 9);
        graph5.addEdge(3, 2, 3);
        graph5.addEdge(3, 4, 2);
        graph5.addEdge(3, 6, 6);
        graph5.addEdge(4, 5, 8);
        graph5.addEdge(4, 6, 5);
        graph5.addEdge(4, 7, 7);
        graph5.addEdge(5, 8, 4);
        graph5.addEdge(6, 7, 2);
        graph5.addEdge(7, 5, 3);
        graph5.addEdge(7, 9, 1);
        graph5.addEdge(9, 3, 3);




        // 그래프 검사 후 Algorithm 실행
        run(graph1, vertices1,1);  //1번 그래프
        run(graph2, vertices2,2);  //2번 그래프
        run(graph3, vertices3,3);  //3번 그래프
        run(graph4, vertices4,4);  //4번 그래프
        run(graph5, vertices5,5);  //5번 그래프

    }

}