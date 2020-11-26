package MyGraphicsPrimitive;

import static java.lang.Math.abs;

public class MyRectangle extends MyAbstractPolygon {

    /**
     * Конструктор создания прямоугольника
     *
     * @param width  ширина
     * @param height высота
     */
    public MyRectangle(Point start, double width, double height) {
        super(4,
                new double[]{start.X(), start.X(), start.X()+width, start.X()+width},
                new double[]{start.Y(), start.Y() + height, start.Y() + height, start.Y()});

        if (width == 0 || height == 0)
            throw new RuntimeException("Прямоугольник не может быть создан");
    }

    public MyRectangle(int npoints, double[] xpoints, double[] ypoints) {
        super(npoints, xpoints, ypoints);
        if(npoints != 4)
            throw new RuntimeException("В прямоугольнике не 4 точки");
    }

    /**
     * Конструктор создания прямоугольника
     *
     * @param leftTop  левая верхняя точка
     * @param rightBot правая нижняя точка
     */
    public MyRectangle(Point leftTop, Point rightBot) {
        super(4, new double[]{leftTop.X(), leftTop.X(), rightBot.X(), rightBot.X()}, new double[]{rightBot.Y(), leftTop.Y(), leftTop.Y(), rightBot.Y()});
        //if (leftTop.X() == rightBot.X() || leftTop.Y() == rightBot.Y())
            //throw new RuntimeException("Прямоугольник не может быть создан");
    }

    /**
     * Вычислить площаль
     *
     * @return площадь прямоугольника
     */
    @Override
    public double Square() {
        return this.width() * this.height();
    }

    private double width() {
        return abs(xpoints[0] - xpoints[2]);
    }

    private double height() {
        return abs(ypoints[0] - ypoints[2]);
    }

    /**
     * Покрывает ли примитив заданную точку
     *
     * @param p точка
     * @return Покрывает ли примитив заданную точку
     */
    @Override
    public boolean cover(Point p) {
        return p.X() > xpoints[0] == p.X() < xpoints[2]
                && p.Y() > ypoints[0] == p.Y() < ypoints[2];

    }

    /**
     * Прямоугольник, описывающий данную фигуру
     *
     * @return Примитив, описывающий данную фигуру
     */
    @Override
    public MyRectangle primitive() {
        return this;
    }

    public boolean equals(MyRectangle rec) {
        boolean equalX = abs(this.xpoints[0] + this.xpoints[2]) == abs(rec.xpoints[0] + rec.xpoints[2]);
        boolean equalY = abs(this.ypoints[0] + this.ypoints[2]) == abs(rec.ypoints[0] + rec.ypoints[2]);
        boolean equalW = this.width() == rec.width();
        boolean equalH = this.height() == rec.height();
        return equalX && equalY && equalH && equalW;
    }
}
/*
 * Переместить примитив
 *
 * @param x на сколько сместить по x
 * @param y на сколько сместить по y
 */
    /*@Override
    public void move(double x, double y) {
        for (int i = 0; i < npoints; i++) {
            xpoints[i] += x;
            ypoints[i] += y;
        }
    }*/