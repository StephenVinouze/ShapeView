# ShapeView
[![Release](https://jitpack.io/v/StephenVinouze/ShapeView.svg)](https://jitpack.io/#StephenVinouze/ShapeView)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=1)
[![GitHub
license](http://img.shields.io/badge/license-APACHE2-blue.svg)](https://github.com/StephenVinouze/AdvancedRecyclerView/blob/master/LICENSE)

Drawing shapes can be achieved in many ways and depend mostly on how complex your shape is. This library intends to leverage how to draw basic shapes so that you need only focus on how to draw your shape using this toolbox.

## Gradle Dependency
Add this in your root `build.gradle` file:

```gradle
allprojects {
	repositories {
		// ... other repositories
		maven { url "https://jitpack.io" }
	}
}
```
Then add the dependencies that you need in your project.

```gradle
dependencies {
  compile 'com.github.StephenVinouze:ShapeView:1.0.0'
}
```

## Usage
An abstract *ShapeView* class allows you to configure two paths: one path is used to fill your content while the other can be used to draw a stroke around your shape. This class exposes three custom XML attributes:

* shapeColor: define which color will fill your shape
* shapeStrokeColor: define which color will be used for the stroke around your shape (if any)
* shapeStrokeWidth: define the width of your stroke (if any)

These attributes lets you define both in XML and programmatically your basic shapes. Starting from that, you can easily extend *ShapeView* to draw your own shapes by using the `Path` instance that the class provides.

Finally, *ShapeView* extends from *RelativeLayout* so you can easily put any view inside your shape.

## Examples

This library provides two shapes: a basic *HalfCircleEdgeShapeView* and a more complex *TicketShapeView*

### HalfCircleEdgeShapeView
This class extends from *ShapeView* and overrides both `onSizeChanged()` and `onDraw()` methods. The idea is to draw a shape with half circle at both left and right edges by using the `Path` instance. This shape can then be convenently used as a *Button*.
