public class Vertex {
    private String name;
    private double x;
    private double y;
    private String color; // 顶点颜色

    public Vertex(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = "black"; // 默认颜色
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return name + "(" + x + "," + y + ")";
    }
    
    // 添加equals方法，用于Set操作
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex vertex = (Vertex) obj;
        return name.equals(vertex.name);
    }
}

