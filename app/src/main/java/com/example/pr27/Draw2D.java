package com.example.pr27;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    public Draw2D(Context context) {
        super(context);

        // Выводим значок из ресурсов
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.image1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст
        mPaint.setColor(Color.parseColor("#04082d"));
        canvas.drawPaint(mPaint);

        // Рисуем луну
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#a3a4ca"));
        //canvas.drawCircle(950, 30, 25, mPaint);
        canvas.drawCircle(40, 40, 150, mPaint);

        // Рисуем зелёный прямоугольник
        mPaint.setColor(Color.parseColor("#264d24"));
        //canvas.drawRect(20, 650, 950, 680, mPaint);
        canvas.drawRect(0, canvas.getHeight() - 250, width, height, mPaint);

        // Рисуем текст
        mPaint.setColor(Color.parseColor("#e90009"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(80);
        //canvas.drawText("Лужайка только для котов", 30, 648, mPaint);
        canvas.drawText("только для заек", 400, height - 300, mPaint);

        // Текст под углом
        // int x = 810;

        int x ;
        int y ;
        if (isLandscape) {
            x = width - 1100;
            y = 0;
        } else {
            x = width - 200;
            y = 50;
        }
        mPaint.setColor(Color.parseColor("#a3a4ca"));
        mPaint.setTextSize(60);
        String beam = "звезда";

        canvas.save();
        // Создаём ограничивающий прямоугольник для наклонного текста
        // поворачиваем холст по центру текста
        canvas.rotate(25, 0, 0);

        // Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(beam, x, y, mPaint);

        // восстанавливаем холст
        canvas.restore();

        // Выводим изображение
        //canvas.drawBitmap(mBitmap, 450, 1620, mPaint);
        canvas.drawBitmap(mBitmap, width - mBitmap.getWidth() - 600, height - mBitmap.getHeight() - 30, mPaint);
    }
}
