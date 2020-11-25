package MyGraphicsPrimitive;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MyLineSegment extends MyGraphicsPrimitive2D {

    private Point begin;
    private Point end;
    private double length;

    /**
     * Конструктор отрезка
     *
     * @param begin точка начала отрезка
     * @param end   точка конца отрезка
     */
    public MyLineSegment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
        length = sqrt(pow((begin.X() - end.X()), 2) + pow((begin.Y() - end.Y()), 2));
    }

    /**
     * Получить длину отрезка
     *
     * @return длина отрезка
     */
    public double Length() {
        return length;
    }

    /**
     * Переместить примитив
     *
     * @param x на сколько сместить по x
     * @param y на сколько сместить по y
     */
    @Override
    public void move(double x, double y) {
        this.begin.setX(begin.X() + x);
        this.begin.setY(begin.Y() + y);

        this.end.setX(end.X() + x);
        this.end.setY(end.Y() + y);
    }

    /**
     * Покрывает ли примитив заданную точку
     *
     * @param p точка
     * @return Покрывает ли примитив заданную точку
     */
    @Override
    public boolean cover(Point p) {
        //(x-x1)/(x2-x1)=(y-y1)/(y2-y1)
        return (p.X() - begin.X()) / (end.X() - begin.X()) == (p.Y() - begin.Y()) / (end.Y() - begin.Y());
    }

    /**
     * Прямоугольник, описывающий данную фигуру
     *
     * @return Примитив, описывающий данную фигуру
     */
    @Override
    public MyRectangle primitive() {
        if (begin.X() == end.X() || begin.Y() == end.Y())
            throw new RuntimeException("Нельзя описать прямоугольник вокруг отрезка, параллельного одной из осей");
        MyRectangle res = new MyRectangle(begin, end);
        return res;
    }

    @Override
    public boolean equals(Object o) {
        MyLineSegment other = (MyLineSegment) o;
        return this.begin.equals(other.begin) && this.end.equals(other.end);
    }

}
