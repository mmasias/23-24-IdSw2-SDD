package Views;

import Enums.ImpreciseTime;

public class Viewport {
    private int viewportStartX;
    private int viewportStartY;
    private int viewportEndX;
    private int viewportEndY;
    private int viewDistance;
    private ImpreciseTime time;

    public Viewport(int viewportStartX, int viewportStartY, int viewportEndX, int viewportEndY, int viewDistance, ImpreciseTime time) {
        this.viewportStartX = viewportStartX;
        this.viewportStartY = viewportStartY;
        this.viewportEndX = viewportEndX;
        this.viewportEndY = viewportEndY;
        this.viewDistance = viewDistance;
        this.time = time;
    }

    public int getViewportStartX() {
        return viewportStartX;
    }

    public int getViewportStartY() {
        return viewportStartY;
    }

    public int getViewportEndX() {
        return viewportEndX;
    }

    public int getViewportEndY() {
        return viewportEndY;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public ImpreciseTime getTime() {
        return time;
    }
}
