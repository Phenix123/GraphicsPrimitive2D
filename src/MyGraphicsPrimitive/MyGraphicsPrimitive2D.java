package MyGraphicsPrimitive;

public abstract class MyGraphicsPrimitive2D {

    /**
     * Переместить примитив
     *
     * @param x на сколько сместить по x
     * @param y на сколько сместить по y
     */
    public abstract void move(double x, double y);

    /**
     * Покрывает ли примитив заданную точку
     *
     * @param p точка
     * @return Покрывает ли примитив заданную точку
     */
    public abstract boolean cover(Point p);

    /**
     * Прямоугольник, описывающий данную фигуру
     *
     * @return Примитив, описывающий данную фигуру
     */
    public abstract MyRectangle primitive();
}
