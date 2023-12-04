import java.awt.geom.Point2D;

public class Problem5 {

    static class Ray {
        Point2D.Double origin;
        Point2D.Double direction;

        public Ray(Point2D.Double origin, Point2D.Double direction) {
            this.origin = origin;
            this.direction = direction;
        }
    }

    static class Plane {
        Point2D.Double normal;
        Point2D.Double point;

        public Plane(Point2D.Double normal, Point2D.Double point) {
            this.normal = normal;
            this.point = point;
        }
    }

    public static Point2D.Double rayPlaneIntersection(Ray ray, Plane plane) {
        // Calculate the denominator of the t parameter
        double denominator = plane.normal.x * ray.direction.x +
                plane.normal.y * ray.direction.y;

        // Check if the ray and plane are not parallel
        if (denominator != 0) {
            // Calculate the t parameter
            double t = ((plane.point.x - ray.origin.x) * plane.normal.x +
                    (plane.point.y - ray.origin.y) * plane.normal.y) / denominator;

            // Calculate the intersection point
            double intersectionX = ray.origin.x + t * ray.direction.x;
            double intersectionY = ray.origin.y + t * ray.direction.y;

            return new Point2D.Double(intersectionX, intersectionY);
        }

        // If the ray and plane are parallel, return null (no intersection)
        return null;
    }

    public static void main(String[] args) {
        // Example: Ray-Plane Intersection
        Ray ray = new Ray(new Point2D.Double(1, 1), new Point2D.Double(1, 0));
        Plane plane = new Plane(new Point2D.Double(0, 1), new Point2D.Double(0, 0));

        Point2D.Double intersection = rayPlaneIntersection(ray, plane);

        if (intersection != null) {
            System.out.println("Intersection Point: (" + intersection.x + ", " + intersection.y + ")");
        } else {
            System.out.println("No Intersection");
        }
    }
}
