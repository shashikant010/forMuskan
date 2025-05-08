package com.example.formuskan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;

public class ScratchView extends androidx.appcompat.widget.AppCompatImageView {

    private Bitmap overlayBitmap;
    private Canvas overlayCanvas;
    private Paint overlayPaint;
    private Paint clearPaint;
    private Path path;
    private float lastX, lastY;
    private boolean isScratchedEnough = false;

    private String hiddenText = "You are my everything 💘\nRedeem: 10 Hugs 😄";
    private Paint textPaint;

    public ScratchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        overlayPaint = new Paint();
        overlayPaint.setColor(Color.GRAY);
        overlayPaint.setStyle(Paint.Style.FILL);

        clearPaint = new Paint();
        clearPaint.setColor(Color.TRANSPARENT);
        clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        clearPaint.setAntiAlias(true);
        clearPaint.setStrokeJoin(Paint.Join.ROUND);
        clearPaint.setStrokeCap(Paint.Cap.ROUND);
        clearPaint.setStrokeWidth(50f);

        path = new Path();

        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(42f);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        overlayBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        overlayCanvas = new Canvas(overlayBitmap);
        overlayCanvas.drawRect(0, 0, w, h, overlayPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the hidden message first
        canvas.drawText(hiddenText, getWidth() / 2f, getHeight() / 2f, textPaint);

        // Draw scratch layer
        canvas.drawBitmap(overlayBitmap, 0, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                overlayCanvas.drawPath(path, clearPaint);
                path.reset();
                break;
        }

        invalidate();

        if (!isScratchedEnough && getScratchedPercentage() > 0.4f) {
            isScratchedEnough = true;
            Toast.makeText(getContext(), "Surprise Revealed! 💝", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private float getScratchedPercentage() {
        int w = overlayBitmap.getWidth();
        int h = overlayBitmap.getHeight();
        int total = w * h;
        int cleared = 0;

        int[] pixels = new int[total];
        overlayBitmap.getPixels(pixels, 0, w, 0, 0, w, h);
        for (int pixel : pixels) {
            if (pixel == 0) cleared++;
        }

        return cleared / (float) total;
    }
}
