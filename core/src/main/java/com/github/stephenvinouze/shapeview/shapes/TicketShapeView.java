package com.github.stephenvinouze.shapeview.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import com.github.stephenvinouze.shapeview.R;
import com.github.stephenvinouze.shapeview.ShapeView;

/**
 * Created by stephenvinouze on 05/10/16.
 */
public class TicketShapeView extends ShapeView {

    private static final int SWEEP_ANGLE = 90;

    private int innerRadius = 0;
    private int outerRadius = 0;
    private int innerOffset = 0;
    private int innerMargin = 0;

    public TicketShapeView(Context context) {
        super(context);
    }

    public TicketShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TicketShapeView, 0, 0);

        setInnerRadius(a.getDimensionPixelSize(R.styleable.TicketShapeView_outerRadius, 0));
        setOuterRadius(a.getDimensionPixelSize(R.styleable.TicketShapeView_innerRadius, 0));
        setInnerOffset(a.getDimensionPixelSize(R.styleable.TicketShapeView_innerOffset, 0));
        setInnerMargin(a.getDimensionPixelSize(R.styleable.TicketShapeView_innerMargin, 0));

        a.recycle();

        initView(context);
    }

    public int getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(int innerRadius) {
        this.innerRadius = innerRadius;
    }

    public int getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(int outerRadius) {
        this.outerRadius = outerRadius;
    }

    public int getInnerOffset() {
        return innerOffset;
    }

    public void setInnerOffset(int innerOffset) {
        this.innerOffset = innerOffset;
    }

    public int getInnerMargin() {
        return innerMargin;
    }

    public void setInnerMargin(int innerMargin) {
        this.innerMargin = innerMargin;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float width = w - innerMargin;
        float height = h - innerMargin;

        shapePath = new Path();
        //top left corner
        shapePath.moveTo(width - innerRadius, innerMargin);
        shapePath.lineTo(width - innerRadius, innerMargin);
        //top right corner
        shapeCurveRect.set(width - innerRadius, innerMargin, width, innerMargin + innerRadius);
        shapePath.arcTo(shapeCurveRect, 270, SWEEP_ANGLE);
        shapePath.lineTo(width, innerOffset - innerMargin);
        //top right curve
        shapeCurveRect.set(width - outerRadius, innerOffset - innerMargin, width, innerOffset - innerMargin + outerRadius);
        shapePath.arcTo(shapeCurveRect, 270, -SWEEP_ANGLE);
        shapePath.lineTo(width - outerRadius, height - innerOffset - outerRadius);
        //bottom right curve
        shapeCurveRect.set(width - outerRadius, height - innerOffset + innerMargin - outerRadius, width, height - innerOffset + 2 * innerMargin);
        shapePath.arcTo(shapeCurveRect, 180, -SWEEP_ANGLE);
        shapePath.lineTo(width, height - innerOffset + 2 * innerMargin);
        //bottom right corner
        shapePath.lineTo(width, height - innerRadius);
        shapeCurveRect.set(width - innerRadius, height - innerRadius, width, height);
        shapePath.arcTo(shapeCurveRect, 0, SWEEP_ANGLE);
        //bottom left corner
        shapePath.lineTo(innerRadius, height);
        shapeCurveRect.set(innerMargin, height - innerRadius, innerRadius, height);
        shapePath.arcTo(shapeCurveRect, 90, SWEEP_ANGLE);
        shapePath.lineTo(innerMargin, height - innerOffset + 2 * innerMargin);
        // bottom left curve
        shapeCurveRect.set(innerMargin, height - innerOffset + innerMargin - outerRadius, innerMargin + outerRadius, height - innerOffset + 2 * innerMargin);
        shapePath.arcTo(shapeCurveRect, 90, -SWEEP_ANGLE);
        shapePath.lineTo(innerMargin + outerRadius, innerMargin + innerOffset + outerRadius);
        //top left curve
        shapeCurveRect.set(innerMargin, innerOffset - innerMargin, innerMargin + outerRadius, innerOffset - innerMargin + outerRadius);
        shapePath.arcTo(shapeCurveRect, 0, -SWEEP_ANGLE);
        shapePath.lineTo(innerMargin, innerOffset - innerMargin);
        shapePath.lineTo(innerMargin, innerRadius);
        shapeCurveRect.set(innerMargin, innerMargin, innerRadius, innerMargin + innerRadius);
        shapePath.arcTo(shapeCurveRect, 180, SWEEP_ANGLE);
        shapePath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.clipPath(shapePath);
        canvas.drawPath(shapePath, shapePaint);
    }
}
