package MyGraphicsPrimitive;

public abstract class MyAbstractPolygon extends MyAreaPrimitive2D {

    protected int npoints;
    protected double[] xpoints = new double[npoints];
    protected double[] ypoints = new double[npoints];

    /**
     * Получить количество вершин многоугольника
     *
     * @return количество вершин многоугольника
     */
    public int Npoints() {
        return npoints;
    }

    /**
     * Получить x координату i-ой вершины
     *
     * @param i номер вершины
     * @return x координата вершины
     */
    public double Xpoints(int i) {
        return xpoints[i];
    }

    /**
     * Получить y координату i-ой вершины
     *
     * @param i номер вершины
     * @return y координата вершины
     */
    public double Ypoints(int i) {
        return ypoints[i];
    }

    /**
     * Абстрактный конструктор создания многоугольника
     *
     * @param npoints количество вершин
     * @param xpoints x коордианты
     * @param ypoints y координаты
     */
    public MyAbstractPolygon(int npoints, double[] xpoints, double[] ypoints) {
        this.npoints = npoints;
        this.xpoints = xpoints;
        this.ypoints = ypoints;
    }

    /**
     * Перемистить примитив на заданные координаты
     *
     * @param x на сколько сместить по x
     * @param y на сколько сместить по y
     */
    @Override
    public void move(double x, double y) {
        for (int i = 0; i < npoints; i++) {
            xpoints[i] += x;
            ypoints[i] += y;
        }
    }
}
