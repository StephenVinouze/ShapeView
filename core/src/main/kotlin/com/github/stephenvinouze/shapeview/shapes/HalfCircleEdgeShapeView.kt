package com.github.stephenvinouze.shapeview.shapes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet

import com.github.stephenvinouze.shapeview.ShapeView

/**
 * Created by stephenvinouze on 05/10/16.
 */
class HalfCircleEdgeShapeView : ShapeView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        val width = w - strokeSize
        val height = h - strokeSize
        
        shapePath = Path()
        shapePath?.let {
            it.moveTo((height + strokeSize).toFloat(), strokeSize.toFloat())
            it.lineTo((width - height).toFloat(), strokeSize.toFloat())
            // right corner
            shapeCurveRect.set((width - height).toFloat(), strokeSize.toFloat(), width.toFloat(), height.toFloat())
            it.arcTo(shapeCurveRect, 270f, SWEEP_ANGLE.toFloat())
            it.lineTo((height + 2 * strokeSize).toFloat(), height.toFloat())
            // left corner
            shapeCurveRect.set(strokeSize.toFloat(), strokeSize.toFloat(), (height + 2 * strokeSize).toFloat(), height.toFloat())
            it.arcTo(shapeCurveRect, 90f, SWEEP_ANGLE.toFloat())
            it.close()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        shapePath?.let {
            canvas.drawPath(it, shapePaint)
            canvas.drawPath(it, shapeBorderPaint)
        }
    }

    companion object {
        private val SWEEP_ANGLE = 180
    }
}
