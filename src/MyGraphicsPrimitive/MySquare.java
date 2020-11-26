package MyGraphicsPrimitive;

public class MySquare extends MyRectangle {

    /**
     * Создать прямоугольник с равными сторонами
     *
     * @param side сторона квадрата
     */
    public MySquare(Point start, double side) {
        super(new Point(start.X(), start.Y()+side), new Point(start.X()+side,start.Y()));
    }
}
