package com.github.stephenvinouze.shapeview.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import com.github.stephenvinouze.shapeview.ShapeView;

/**
 * Created by stephenvinouze on 05/10/16.
 */
public class HalfCircleEdgeShapeView extends ShapeView {

    private static final int SWEEP_ANGLE = 180;

    public HalfCircleEdgeShapeView(Context context) {
        super(context);
    }

    public HalfCircleEdgeShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int width = w - strokeSize;
        int height = h - strokeSize;

        shapePath = new Path();
        shapePath.moveTo(height + strokeSize, strokeSize);
        shapePath.lineTo(width - height, strokeSize);
        // right corner
        shapeCurveRect.set(width - height, strokeSize, width, height);
        shapePath.arcTo(shapeCurveRect, 270, SWEEP_ANGLE);
        shapePath.lineTo(height + 2 * strokeSize, height);
        // left corner
        shapeCurveRect.set(strokeSize, strokeSize, height + 2 * strokeSize, height);
        shapePath.arcTo(shapeCurveRect, 90, SWEEP_ANGLE);
        shapePath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(shapePath, shapePaint);
        canvas.drawPath(shapePath, shapeBorderPaint);
    }
}
