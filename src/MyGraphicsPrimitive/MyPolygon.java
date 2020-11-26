package MyGraphicsPrimitive;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class MyPolygon extends MyAbstractPolygon {

    /**
     * Конструктор создания многоугольника
     *
     * @param npoints количество вершин
     * @param xpoints координаты x
     * @param ypoints координаты y
     */
    public MyPolygon(int npoints, double[] xpoints, double[] ypoints) {
        super(npoints, xpoints, ypoints);
        for (int i = 0; i < npoints; i++) {
            for (int j = 0; j < npoints; j++) {
                if(xpoints[i] == xpoints[j] && ypoints[i] == ypoints[j])
                    throw new RuntimeException("Введены повторяющиеся точки");
            }
        }
    }

    /**
     * Вычислить площадь мноуольника
     *
     * @return площадь мноуольника
     */
    @Override
    public double Square() {
        double resX = 0, resY = 0;
        for (int i = 0; i < super.Npoints(); i++) {

            if (i == super.Npoints() - 1) {
                resX += super.Xpoints(i) * super.Ypoints(0);
                resY += super.Ypoints(i) * super.Xpoints(0);
            } else {
                resX += super.Xpoints(i) * super.Ypoints(i + 1);
                resY += super.Ypoints(i) * super.Xpoints(i + 1);
            }
        }

        return (resX - resY)*0.5;
    }


    /**
     * Покрывает ли примитив заданную точку
     *
     * @param p точка
     * @return Покрывает ли примитив заданную точку
     */
    @Override
    public boolean cover(Point p) {
        //TODO Невозможно составить условие
        return false;

    }

    /**
     * Прямоугольник, описывающий данную фигуру
     *
     * @return Примитив, описывающий данную фигуру
     */
    @Override
    public MyRectangle primitive() {
        double left = xpoints[0];
        double right = xpoints[0];
        double up = ypoints[0];
        double bot = ypoints[0];
        for (int i = 1; i < npoints; i++) {
            left = min(left, xpoints[i]);
            right = max(right, xpoints[i]);
            up = max(up, ypoints[i]);
            bot = min(bot, ypoints[i]);
        }
        return new MyRectangle(new Point(left, up), new Point(right, bot));
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