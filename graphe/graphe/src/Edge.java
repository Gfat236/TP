public class Edge {
    private Vertex vertex1;
    private Vertex vertex2;
    private String color; // 边的颜色

    public Edge(Vertex v1, Vertex v2) {
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.color = "black"; // 默认颜色
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "(" + vertex1.getName() + "," + vertex2.getName() + ")";
    }
    
    // 添加equals方法，用于Set操作
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge edge = (Edge) obj;
        return (vertex1.equals(edge.vertex1) && vertex2.equals(edge.vertex2)) ||
               (vertex1.equals(edge.vertex2) && vertex2.equals(edge.vertex1));
    }
}
