package MyGraphicsPrimitive;

import static java.lang.Math.pow;

public class MyCircle extends MyAreaPrimitive2D {

    /*
    Радиус и центр окружности
     */
    private double radius;
    private Point center;

    /**
     * Конструктор создания окружности
     *
     * @param radius радиус окружности
     * @param center центр окружности
     */
    public MyCircle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    /**
     * Вычисление площади круга
     *
     * @return площадь круга
     */
    @Override
    public double Square() {
        return 3.14 * radius * radius;
    }

    /**
     * Переместить примитив
     *
     * @param x на сколько сместить по x
     * @param y на сколько сместить по y
     */
    @Override
    public void move(double x, double y) {
        this.center.setX(x + center.X());
        this.center.setY(y + center.Y());
    }

    /**
     * Покрывает ли примитив заданную точку
     *
     * @param p точка
     * @return Покрывает ли примитив заданную точку
     */
    @Override
    public boolean cover(Point p) {
        return pow(p.X() - center.X(), 2) + pow(p.Y() - center.Y(), 2) <= pow(radius, 2); // (x – a)2 + (y – b)2 <= R2
    }

    /**
     * Прямоугольник, описывающий данную фигуру
     *
     * @return Примитив, описывающий данную фигуру
     */
    @Override
    public MyRectangle primitive() {
        MyRectangle rectangle = new MyRectangle
                (new Point(center.X() - radius, center.Y() + radius),
                        new Point(center.X() + radius, center.Y() - radius));
        return rectangle;
    }
}
