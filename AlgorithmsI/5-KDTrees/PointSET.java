public class PointSET {
    
    private static final double MINCOORD = 0.0;
    private static final double MAXCOORD = 1.0;
    private SET<Point2D> set;
    
    // construct an empty set of points
    public PointSET() {
        set = new SET<Point2D>();
    }
    
    // is the set empty?
    public boolean isEmpty() {
        return set.isEmpty();
    }
    
    // number of points in the set
    public int size() {
        return set.size();
    }
    
    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        set.add(p);
    }
    
    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return set.contains(p);
    }
    
    // draw all of the points to standard draw
    public void draw() {
        for (Point2D p : set)
            p.draw();
    }
    
    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (set.isEmpty()) return null;
        Queue<Point2D> q = new Queue<Point2D>();
        for (Point2D p : set) {
            if (rect.contains(p)) {
                q.enqueue(p);
            }
        }
        return q;
    }
    
    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        if (this.isEmpty()) return null;
        double mindist = Double.POSITIVE_INFINITY;
        Point2D min = null;
        for (Point2D other : set) {
            double otherdist = p.distanceSquaredTo(other);
            if (Double.compare(otherdist, mindist) < 0) {
                mindist = otherdist;
                min = other;
            }
        }
        return min;
    }    
}