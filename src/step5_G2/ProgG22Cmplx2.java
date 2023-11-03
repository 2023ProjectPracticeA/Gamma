package step5_G2;

/*
 * 課題番号      ： 第5回 演習問題G2-2
 * ファイル名    ： ProgG22Cmplx2.java
 * 作成年月日    ： 2023年11月7日
 * 学生番号・氏名：
 * グループ      ： Γ
 */

class Vector3 {
    public double x, y, z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 cross(Vector3 v) {
        return new Vector3(
                this.y * v.z - this.z * v.y,
                this.z * v.x - this.x * v.z,
                this.x * v.y - this.y * v.x);
    }

    public double dot(Vector3 v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public double norm() {
        return Math.sqrt(this.dot(this));
    }

    public void normalize() {
        double magnitude = this.norm();
        this.x /= magnitude;
        this.y /= magnitude;
        this.z /= magnitude;
    }

    public Vector3 scale(double factor) {
        return new Vector3(this.x * factor, this.y * factor, this.z * factor);
    }
}

public class ProgG22Cmplx2 {
    private static final char[] chars = new char[] { ' ', '.', ':', '-', '=', '+', '*', '#', 'P', '@' };

    public static void main(String[] args) {
        int diameter = 25;
        int radius = diameter / 2;

        Vector3 focus = new Vector3(0, 0, 1);
        Complex2 complex = new Complex2(1, 1, 1, 1);
        complex.normalize();

        for (int screenY = 0; screenY <= diameter; screenY++) {
            int y = screenY - radius;
            for (int screenX = 0; screenX <= diameter; screenX++) {
                int x = screenX - radius;
                double distance = Math.sqrt(x * x + y * y);

                if (distance <= radius) {
                    Vector3 ray = new Vector3(x, y, 0);
                    ray.normalize();

                    double cos = ray.dot(focus);
                    double theta = Math.acos(cos);

                    Vector3 cros = ray.cross(focus);
                    cros.normalize();

                    Vector3 vectorPart = cros.scale(Math.sin(theta / 2));

                    Complex2 c = new Complex2(cos, vectorPart.x, vectorPart.y, vectorPart.z);
                    c.normalize();

                    double d = complex.dot(c);
                    d = d / 2 + 0.5;

                    int index = (int) (d * d * 10);
                    System.out.print(chars[index]);
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
