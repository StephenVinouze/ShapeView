package com.github.stephenvinouze.shapeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by stephenvinouze on 05/10/16.
 */
public abstract class ShapeView extends RelativeLayout {

    protected Path shapePath;
    protected final Paint shapePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    protected final Paint shapeBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    protected final RectF shapeCurveRect = new RectF();

    protected int color = Color.TRANSPARENT;
    protected int strokeColor = Color.TRANSPARENT;
    protected int strokeSize = 0;

    public ShapeView(Context context) {
        super(context);
    }

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ShapeView, 0, 0);

        setColor(a.getColor(R.styleable.ShapeView_shapeColor, Color.TRANSPARENT));
        setStrokeColor(a.getColor(R.styleable.ShapeView_shapeStrokeColor, Color.TRANSPARENT));
        setStrokeSize(a.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeWidth, 0));

        a.recycle();

        initView(context);
    }

    protected void initView(Context context) {
        setBackgroundColor(Color.TRANSPARENT);

        shapePaint.setDither(true);
        shapePaint.setStyle(Paint.Style.FILL);
        shapePaint.setColor(color);

        shapeBorderPaint.setDither(true);
        shapeBorderPaint.setStyle(Paint.Style.STROKE);
        shapeBorderPaint.setColor(strokeColor);
        shapeBorderPaint.setStrokeWidth(strokeSize);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        shapePaint.setColor(color);
        invalidate();
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        shapeBorderPaint.setColor(strokeColor);
        invalidate();
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
        shapeBorderPaint.setStrokeWidth(strokeSize);
        invalidate();
    }

}
