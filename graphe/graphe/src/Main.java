import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 图可视化演示 ===\n");
        
        // 创建初始图
        Graph graph = createInitialGraph();
        
        // 1. 显示初始图
        System.out.println("1. 图初始状态:");
        printGraph(graph);
        graph.generateHTML("graph_initial.html");
        
        // 2. 演示着色功能
        System.out.println("\n2. 演示顶点和边着色:");
        Graph coloredGraph = graph.copy(); // 基于初始图创建副本
        demonstrateColoring(coloredGraph);
        coloredGraph.generateHTML("graph_colored.html");
        
        // 3. 演示路径高亮
        System.out.println("\n3. 演示路径高亮 (A -> B -> D):");
        Graph pathGraph = graph.copy(); // 基于初始图创建副本
        demonstratePath(pathGraph);
        pathGraph.generateHTML("graph_path.html");
        
        // 4. 演示四个基本操作
        demonstrateOperations(graph); // 这里也会基于初始图创建副本
        
        System.out.println("\n=== 所有HTML文件已生成 ===");
        System.out.println("请在浏览器中打开以下文件查看可视化结果:");
        System.out.println("- graph_initial.html (初始图)");
        System.out.println("- graph_colored.html (着色演示)");
        System.out.println("- graph_path.html (路径高亮)");
        System.out.println("- graph_add_vertex.html (添加顶点后)");
        System.out.println("- graph_remove_vertex.html (删除顶点后)");
        System.out.println("- graph_add_edge.html (添加边后)");
        System.out.println("- graph_remove_edge.html (删除边后)");
    }
    
    private static Graph createInitialGraph() {
        Graph graph = new Graph();
        
        // 创建顶点 (排列成矩形)
        Vertex A = new Vertex("A", 1, 1);  // 左上
        Vertex B = new Vertex("B", 3, 1);  // 右上
        Vertex C = new Vertex("C", 1, 3);  // 左下
        Vertex D = new Vertex("D", 3, 3);  // 右下
        
        // 添加顶点到图
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        
        // 创建边
        graph.addEdge(new Edge(A, B));  // 上边
        graph.addEdge(new Edge(A, C));  // 左边
        graph.addEdge(new Edge(B, D));  // 右边
        graph.addEdge(new Edge(C, D));  // 下边
        graph.addEdge(new Edge(A, D));  // 对角线
        
        return graph;
    }
    
    private static void printGraph(Graph graph) {
        System.out.println("顶点: " + graph.getVertices().size() + " 个");
        for (Vertex v : graph.getVertices()) {
            System.out.println("  " + v);
        }
        
        System.out.println("边: " + graph.getEdges().size() + " 条");
        for (Edge e : graph.getEdges()) {
            System.out.println("  " + e);
        }
    }
    
    private static void demonstrateColoring(Graph graph) {
        // 给一些顶点着色
        for (Vertex v : graph.getVertices()) {
            if (v.getName().equals("A")) {
                v.setColor("red");
                System.out.println("顶点 A 着色为红色");
            } else if (v.getName().equals("B")) {
                v.setColor("green");
                System.out.println("顶点 B 着色为绿色");
            }
        }
        
        // 给一些边着色
        for (Edge e : graph.getEdges()) {
            if (e.toString().equals("(A,B)")) {
                e.setColor("blue");
                System.out.println("边 (A,B) 着色为蓝色");
            }
        }
    }
    
    private static void demonstratePath(Graph graph) {
        // 创建路径 A -> B -> D
        List<Vertex> path = new ArrayList<>();
        for (Vertex v : graph.getVertices()) {
            if (v.getName().equals("A") || v.getName().equals("B") || v.getName().equals("D")) {
                path.add(v);
            }
        }
        // 确保路径顺序正确
        path.sort((v1, v2) -> v1.getName().compareTo(v2.getName()));
        
        graph.highlightPath(path, "orange");
        System.out.println("路径 A -> B -> D 已高亮为橙色");
    }
    
    private static void demonstrateOperations(Graph originalGraph) {
        System.out.println("\n4. 演示四个基本图操作:");
        
        // 操作1: 添加顶点
        System.out.println("\n4.1 添加顶点 E(2,0):");
        Graph graph1 = originalGraph.copy();
        Vertex E = new Vertex("E", 2, 0);
        graph1.addVertex(E);
        System.out.println("操作后:");
        printGraph(graph1);
        graph1.generateHTML("graph_add_vertex.html");
        
        // 操作2: 删除顶点
        System.out.println("\n4.2 删除顶点 D (及其关联边):");
        Graph graph2 = originalGraph.copy();
        Vertex toRemove = null;
        for (Vertex v : graph2.getVertices()) {
            if (v.getName().equals("D")) {
                toRemove = v;
                break;
            }
        }
        if (toRemove != null) {
            graph2.removeVertex(toRemove);
        }
        System.out.println("操作后:");
        printGraph(graph2);
        graph2.generateHTML("graph_remove_vertex.html");
        
        // 操作3: 添加边
        System.out.println("\n4.3 添加边 (B,C):");
        Graph graph3 = originalGraph.copy();
        Vertex vB = null, vC = null;
        for (Vertex v : graph3.getVertices()) {
            if (v.getName().equals("B")) vB = v;
            if (v.getName().equals("C")) vC = v;
        }
        if (vB != null && vC != null) {
            graph3.addEdge(new Edge(vB, vC));
        }
        System.out.println("操作后:");
        printGraph(graph3);
        graph3.generateHTML("graph_add_edge.html");
        
        // 操作4: 删除边
        System.out.println("\n4.4 删除边 (A,D):");
        Graph graph4 = originalGraph.copy();
        Edge toRemoveEdge = null;
        for (Edge e : graph4.getEdges()) {
            if (e.toString().equals("(A,D)")) {
                toRemoveEdge = e;
                break;
            }
        }
        if (toRemoveEdge != null) {
            graph4.removeEdge(toRemoveEdge);
        }
        System.out.println("操作后:");
        printGraph(graph4);
        graph4.generateHTML("graph_remove_edge.html");
    }
}