package com.github.stephenvinouze.shapeview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.RelativeLayout

/**
 * Created by stephenvinouze on 05/10/16.
 */
abstract class ShapeView : RelativeLayout {

    protected var shapePath: Path? = null
    protected val shapePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    protected val shapeBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    protected val shapeCurveRect = RectF()

    protected var color: Int = Color.TRANSPARENT
        set(value) {
            field = value
            shapePaint.color = value
            invalidate()
        }
    protected var strokeColor: Int = Color.TRANSPARENT
        set(value) {
            field = value
            shapeBorderPaint.color = value
            invalidate()
        }
    protected var strokeSize: Int = 0
        set(value) {
            field = value
            shapeBorderPaint.strokeWidth = value.toFloat()
            invalidate()
        }

    protected var dashOnSize: Int = 0
        set(value) {
            field = value
            applyDashEffect()
            invalidate()
        }

    protected var dashOffSize: Int = 0
        set(value) {
            field = value
            applyDashEffect()
            invalidate()
        }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setBackgroundColor(Color.TRANSPARENT)

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.ShapeView, 0, 0)

        color = a.getColor(R.styleable.ShapeView_shapeColor, Color.TRANSPARENT)
        strokeColor = a.getColor(R.styleable.ShapeView_shapeStrokeColor, Color.TRANSPARENT)
        strokeSize = a.getDimensionPixelSize(R.styleable.ShapeView_shapeStrokeWidth, 0)
        dashOnSize = a.getDimensionPixelSize(R.styleable.ShapeView_shapeDashOnWidth, 0)
        dashOffSize = a.getDimensionPixelSize(R.styleable.ShapeView_shapeDashOffWidth, 0)

        a.recycle()

        shapePaint.isDither = true
        shapePaint.style = Paint.Style.FILL

        shapeBorderPaint.isDither = true
        shapeBorderPaint.style = Paint.Style.STROKE
    }

    private fun applyDashEffect() {
        shapeBorderPaint.pathEffect = DashPathEffect(floatArrayOf(dashOnSize.toFloat(), dashOffSize.toFloat()), 0f)
    }

}
