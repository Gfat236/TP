import java.util.*;

public class Graph {
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Edge, Set<Vertex>> edgeToVertices;

    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
        edgeToVertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void addEdge(Edge e) {
        edges.add(e);
        // 简化：不再使用edgeToVertices映射，因为Edge对象本身包含顶点信息
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    // 删除顶点（及其相关的所有边）
    public void removeVertex(Vertex v) {
        vertices.remove(v);
        // 删除所有与该顶点相关的边
        edges.removeIf(e -> e.getVertex1().equals(v) || e.getVertex2().equals(v));
    }
    
    // 删除边
    public void removeEdge(Edge e) {
        edges.remove(e);
    }
    
    // 高亮路径（给路径上的顶点和边着色）
    public void highlightPath(java.util.List<Vertex> path, String color) {
        // 给路径上的顶点着色
        for (Vertex v : path) {
            v.setColor(color);
        }
        
        // 给路径上的边着色
        for (int i = 0; i < path.size() - 1; i++) {
            Vertex v1 = path.get(i);
            Vertex v2 = path.get(i + 1);
            
            // 找到连接这两个顶点的边
            for (Edge e : edges) {
                if ((e.getVertex1().equals(v1) && e.getVertex2().equals(v2)) ||
                    (e.getVertex1().equals(v2) && e.getVertex2().equals(v1))) {
                    e.setColor(color);
                }
            }
        }
    }
    
    // 复制图（用于演示操作前后的对比）
    public Graph copy() {
        Graph newGraph = new Graph();
        
        // 复制顶点
        for (Vertex v : vertices) {
            Vertex newV = new Vertex(v.getName(), v.getX(), v.getY());
            newV.setColor(v.getColor());
            newGraph.addVertex(newV);
        }
        
        // 复制边
        for (Edge e : edges) {
            // 找到新图中对应的顶点
            Vertex newV1 = null, newV2 = null;
            for (Vertex v : newGraph.getVertices()) {
                if (v.getName().equals(e.getVertex1().getName())) {
                    newV1 = v;
                }
                if (v.getName().equals(e.getVertex2().getName())) {
                    newV2 = v;
                }
            }
            
            if (newV1 != null && newV2 != null) {
                Edge newE = new Edge(newV1, newV2);
                newE.setColor(e.getColor());
                newGraph.addEdge(newE);
            }
        }
        
        return newGraph;
    }
    
    // 生成HTML文件（简单版本）
    public void generateHTML(String filename) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(filename);
            
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n<head>\n");
            writer.write("<title>Graph</title>\n");
            writer.write("<style>\n");
            writer.write("body { font-family: Arial; margin: 20px; }\n");
            writer.write(".graph-container { position: relative; width: 600px; height: 400px; border: 1px solid #ccc; }\n");
            writer.write(".vertex { position: absolute; width: 30px; height: 30px; border-radius: 50%; ");
            writer.write("display: flex; align-items: center; justify-content: center; ");
            writer.write("font-weight: bold; color: white; font-size: 12px; }\n");
            writer.write(".edge { position: absolute; height: 2px; transform-origin: left center; }\n");
            writer.write("</style>\n");
            writer.write("</head>\n<body>\n");
            
            writer.write("<h2>Graph - " + filename + "</h2>\n");
            writer.write("<div class=\"graph-container\">\n");
            
            // 绘制边（先画边，这样顶点会在上面）
            for (Edge e : edges) {
                Vertex v1 = e.getVertex1();
                Vertex v2 = e.getVertex2();
                
                double x1 = v1.getX() * 100 + 15; // 缩放坐标并居中到顶点中心
                double y1 = v1.getY() * 100 + 15;
                double x2 = v2.getX() * 100 + 15;
                double y2 = v2.getY() * 100 + 15;
                
                double length = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
                double angle = Math.atan2(y2-y1, x2-x1) * 180 / Math.PI;
                
                writer.write("<div class=\"edge\" style=\"");
                writer.write("left: " + x1 + "px; ");
                writer.write("top: " + y1 + "px; ");
                writer.write("width: " + length + "px; ");
                writer.write("background-color: " + e.getColor() + "; ");
                writer.write("transform: rotate(" + angle + "deg);");
                writer.write("\"></div>\n");
            }
            
            // 绘制顶点
            for (Vertex v : vertices) {
                double x = v.getX() * 100; // 缩放坐标
                double y = v.getY() * 100;
                
                writer.write("<div class=\"vertex\" style=\"");
                writer.write("left: " + x + "px; ");
                writer.write("top: " + y + "px; ");
                writer.write("background-color: " + v.getColor() + ";");
                writer.write("\">" + v.getName() + "</div>\n");
            }
            
            writer.write("</div>\n");
            writer.write("</body>\n</html>");
            writer.close();
            
            System.out.println("HTML文件已生成: " + filename);
            
        } catch (java.io.IOException e) {
            System.out.println("生成HTML文件时出错: " + e.getMessage());
        }
    }


}
