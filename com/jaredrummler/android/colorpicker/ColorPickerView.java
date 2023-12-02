package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes6.dex */
public class ColorPickerView extends View {
    private Rect A;
    private Rect B;
    private Rect C;
    private Rect D;
    private Point E;
    private com.jaredrummler.android.colorpicker.a F;
    private OnColorChangedListener G;

    /* renamed from: a  reason: collision with root package name */
    private int f34511a;

    /* renamed from: b  reason: collision with root package name */
    private int f34512b;

    /* renamed from: c  reason: collision with root package name */
    private int f34513c;

    /* renamed from: d  reason: collision with root package name */
    private int f34514d;

    /* renamed from: e  reason: collision with root package name */
    private int f34515e;

    /* renamed from: f  reason: collision with root package name */
    private int f34516f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f34517g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f34518h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f34519i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f34520j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f34521k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f34522l;

    /* renamed from: m  reason: collision with root package name */
    private Shader f34523m;

    /* renamed from: n  reason: collision with root package name */
    private Shader f34524n;

    /* renamed from: o  reason: collision with root package name */
    private Shader f34525o;

    /* renamed from: p  reason: collision with root package name */
    private b f34526p;

    /* renamed from: q  reason: collision with root package name */
    private b f34527q;

    /* renamed from: r  reason: collision with root package name */
    private int f34528r;

    /* renamed from: s  reason: collision with root package name */
    private float f34529s;

    /* renamed from: t  reason: collision with root package name */
    private float f34530t;

    /* renamed from: u  reason: collision with root package name */
    private float f34531u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f34532v;

    /* renamed from: w  reason: collision with root package name */
    private String f34533w;

    /* renamed from: x  reason: collision with root package name */
    private int f34534x;

    /* renamed from: y  reason: collision with root package name */
    private int f34535y;

    /* renamed from: z  reason: collision with root package name */
    private int f34536z;

    /* loaded from: classes6.dex */
    public interface OnColorChangedListener {
        void onColorChanged(int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public Canvas f34537a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f34538b;

        /* renamed from: c  reason: collision with root package name */
        public float f34539c;

        private b() {
        }
    }

    public ColorPickerView(Context context) {
        this(context, null);
    }

    private Point a(int i4) {
        Rect rect = this.D;
        float width = rect.width();
        Point point = new Point();
        point.x = (int) ((width - ((i4 * width) / 255.0f)) + rect.left);
        point.y = rect.top;
        return point;
    }

    private void b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
        if (this.f34535y == -9539986) {
            this.f34535y = obtainStyledAttributes.getColor(0, -9539986);
        }
        if (this.f34534x == -4342339) {
            this.f34534x = obtainStyledAttributes.getColor(0, -4342339);
        }
        obtainStyledAttributes.recycle();
    }

    private void c(Canvas canvas) {
        Rect rect;
        if (this.f34532v && (rect = this.D) != null && this.F != null) {
            this.f34522l.setColor(this.f34535y);
            canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, this.f34522l);
            this.F.draw(canvas);
            float[] fArr = {this.f34529s, this.f34530t, this.f34531u};
            int HSVToColor = Color.HSVToColor(fArr);
            int HSVToColor2 = Color.HSVToColor(0, fArr);
            float f4 = rect.left;
            int i4 = rect.top;
            LinearGradient linearGradient = new LinearGradient(f4, i4, rect.right, i4, HSVToColor, HSVToColor2, Shader.TileMode.CLAMP);
            this.f34525o = linearGradient;
            this.f34519i.setShader(linearGradient);
            canvas.drawRect(rect, this.f34519i);
            String str = this.f34533w;
            if (str != null && !str.equals("")) {
                canvas.drawText(this.f34533w, rect.centerX(), rect.centerY() + c.a(getContext(), 4.0f), this.f34520j);
            }
            Point a4 = a(this.f34528r);
            RectF rectF = new RectF();
            int i5 = a4.x;
            int i6 = this.f34516f;
            rectF.left = i5 - (i6 / 2);
            rectF.right = i5 + (i6 / 2);
            int i7 = rect.top;
            int i8 = this.f34515e;
            rectF.top = i7 - i8;
            rectF.bottom = rect.bottom + i8;
            canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.f34521k);
        }
    }

    private void d(Canvas canvas) {
        b bVar;
        Rect rect = this.C;
        this.f34522l.setColor(this.f34535y);
        canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, this.f34522l);
        if (this.f34527q == null) {
            b bVar2 = new b();
            this.f34527q = bVar2;
            bVar2.f34538b = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            this.f34527q.f34537a = new Canvas(this.f34527q.f34538b);
            int height = (int) (rect.height() + 0.5f);
            int[] iArr = new int[height];
            float f4 = 360.0f;
            for (int i4 = 0; i4 < height; i4++) {
                iArr[i4] = Color.HSVToColor(new float[]{f4, 1.0f, 1.0f});
                f4 -= 360.0f / height;
            }
            Paint paint = new Paint();
            paint.setStrokeWidth(0.0f);
            for (int i5 = 0; i5 < height; i5++) {
                paint.setColor(iArr[i5]);
                float f5 = i5;
                this.f34527q.f34537a.drawLine(0.0f, f5, bVar.f34538b.getWidth(), f5, paint);
            }
        }
        canvas.drawBitmap(this.f34527q.f34538b, (Rect) null, rect, (Paint) null);
        Point f6 = f(this.f34529s);
        RectF rectF = new RectF();
        int i6 = rect.left;
        int i7 = this.f34515e;
        rectF.left = i6 - i7;
        rectF.right = rect.right + i7;
        int i8 = f6.y;
        int i9 = this.f34516f;
        rectF.top = i8 - (i9 / 2);
        rectF.bottom = i8 + (i9 / 2);
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.f34521k);
    }

    private void e(Canvas canvas) {
        b bVar;
        Rect rect = this.B;
        this.f34522l.setColor(this.f34535y);
        Rect rect2 = this.A;
        canvas.drawRect(rect2.left, rect2.top, rect.right + 1, rect.bottom + 1, this.f34522l);
        if (this.f34523m == null) {
            int i4 = rect.left;
            this.f34523m = new LinearGradient(i4, rect.top, i4, rect.bottom, -1, -16777216, Shader.TileMode.CLAMP);
        }
        b bVar2 = this.f34526p;
        if (bVar2 == null || bVar2.f34539c != this.f34529s) {
            if (bVar2 == null) {
                this.f34526p = new b();
            }
            b bVar3 = this.f34526p;
            if (bVar3.f34538b == null) {
                bVar3.f34538b = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            }
            b bVar4 = this.f34526p;
            if (bVar4.f34537a == null) {
                bVar4.f34537a = new Canvas(this.f34526p.f34538b);
            }
            int HSVToColor = Color.HSVToColor(new float[]{this.f34529s, 1.0f, 1.0f});
            float f4 = rect.left;
            int i5 = rect.top;
            this.f34524n = new LinearGradient(f4, i5, rect.right, i5, -1, HSVToColor, Shader.TileMode.CLAMP);
            this.f34517g.setShader(new ComposeShader(this.f34523m, this.f34524n, PorterDuff.Mode.MULTIPLY));
            this.f34526p.f34537a.drawRect(0.0f, 0.0f, bVar.f34538b.getWidth(), this.f34526p.f34538b.getHeight(), this.f34517g);
            this.f34526p.f34539c = this.f34529s;
        }
        canvas.drawBitmap(this.f34526p.f34538b, (Rect) null, rect, (Paint) null);
        Point m4 = m(this.f34530t, this.f34531u);
        this.f34518h.setColor(-16777216);
        canvas.drawCircle(m4.x, m4.y, this.f34514d - c.a(getContext(), 1.0f), this.f34518h);
        this.f34518h.setColor(-2236963);
        canvas.drawCircle(m4.x, m4.y, this.f34514d, this.f34518h);
    }

    private Point f(float f4) {
        Rect rect = this.C;
        float height = rect.height();
        Point point = new Point();
        point.y = (int) ((height - ((f4 * height) / 360.0f)) + rect.top);
        point.x = rect.left;
        return point;
    }

    private void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPickerView);
        this.f34532v = obtainStyledAttributes.getBoolean(R.styleable.ColorPickerView_cpv_alphaChannelVisible, false);
        this.f34533w = obtainStyledAttributes.getString(R.styleable.ColorPickerView_cpv_alphaChannelText);
        this.f34534x = obtainStyledAttributes.getColor(R.styleable.ColorPickerView_cpv_sliderColor, -4342339);
        this.f34535y = obtainStyledAttributes.getColor(R.styleable.ColorPickerView_cpv_borderColor, -9539986);
        obtainStyledAttributes.recycle();
        b(context);
        this.f34511a = c.a(getContext(), 30.0f);
        this.f34512b = c.a(getContext(), 20.0f);
        this.f34513c = c.a(getContext(), 10.0f);
        this.f34514d = c.a(getContext(), 5.0f);
        this.f34516f = c.a(getContext(), 4.0f);
        this.f34515e = c.a(getContext(), 2.0f);
        this.f34536z = getResources().getDimensionPixelSize(R.dimen.cpv_required_padding);
        h();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private int getPreferredHeight() {
        int a4 = c.a(getContext(), 200.0f);
        if (this.f34532v) {
            return a4 + this.f34513c + this.f34512b;
        }
        return a4;
    }

    private int getPreferredWidth() {
        return c.a(getContext(), 200.0f) + this.f34511a + this.f34513c;
    }

    private void h() {
        this.f34517g = new Paint();
        this.f34518h = new Paint();
        this.f34521k = new Paint();
        this.f34519i = new Paint();
        this.f34520j = new Paint();
        this.f34522l = new Paint();
        this.f34518h.setStyle(Paint.Style.STROKE);
        this.f34518h.setStrokeWidth(c.a(getContext(), 2.0f));
        this.f34518h.setAntiAlias(true);
        this.f34521k.setColor(this.f34534x);
        this.f34521k.setStyle(Paint.Style.STROKE);
        this.f34521k.setStrokeWidth(c.a(getContext(), 2.0f));
        this.f34521k.setAntiAlias(true);
        this.f34520j.setColor(-14935012);
        this.f34520j.setTextSize(c.a(getContext(), 14.0f));
        this.f34520j.setAntiAlias(true);
        this.f34520j.setTextAlign(Paint.Align.CENTER);
        this.f34520j.setFakeBoldText(true);
    }

    private boolean i(MotionEvent motionEvent) {
        Point point = this.E;
        if (point == null) {
            return false;
        }
        int i4 = point.x;
        int i5 = point.y;
        if (this.C.contains(i4, i5)) {
            this.f34529s = k(motionEvent.getY());
        } else if (this.B.contains(i4, i5)) {
            float[] l4 = l(motionEvent.getX(), motionEvent.getY());
            this.f34530t = l4[0];
            this.f34531u = l4[1];
        } else {
            Rect rect = this.D;
            if (rect == null || !rect.contains(i4, i5)) {
                return false;
            }
            this.f34528r = j((int) motionEvent.getX());
        }
        return true;
    }

    private int j(int i4) {
        int i5;
        Rect rect = this.D;
        int width = rect.width();
        int i6 = rect.left;
        if (i4 < i6) {
            i5 = 0;
        } else if (i4 > rect.right) {
            i5 = width;
        } else {
            i5 = i4 - i6;
        }
        return 255 - ((i5 * 255) / width);
    }

    private float k(float f4) {
        float f5;
        Rect rect = this.C;
        float height = rect.height();
        int i4 = rect.top;
        if (f4 < i4) {
            f5 = 0.0f;
        } else if (f4 > rect.bottom) {
            f5 = height;
        } else {
            f5 = f4 - i4;
        }
        return 360.0f - ((f5 * 360.0f) / height);
    }

    private float[] l(float f4, float f5) {
        float f6;
        Rect rect = this.B;
        float[] fArr = new float[2];
        float width = rect.width();
        float height = rect.height();
        int i4 = rect.left;
        float f7 = 0.0f;
        if (f4 < i4) {
            f6 = 0.0f;
        } else if (f4 > rect.right) {
            f6 = width;
        } else {
            f6 = f4 - i4;
        }
        int i5 = rect.top;
        if (f5 >= i5) {
            if (f5 > rect.bottom) {
                f7 = height;
            } else {
                f7 = f5 - i5;
            }
        }
        fArr[0] = (1.0f / width) * f6;
        fArr[1] = 1.0f - ((1.0f / height) * f7);
        return fArr;
    }

    private Point m(float f4, float f5) {
        Rect rect = this.B;
        Point point = new Point();
        point.x = (int) ((f4 * rect.width()) + rect.left);
        point.y = (int) (((1.0f - f5) * rect.height()) + rect.top);
        return point;
    }

    private void n() {
        if (!this.f34532v) {
            return;
        }
        Rect rect = this.A;
        int i4 = rect.bottom;
        this.D = new Rect(rect.left + 1, (i4 - this.f34512b) + 1, rect.right - 1, i4 - 1);
        com.jaredrummler.android.colorpicker.a aVar = new com.jaredrummler.android.colorpicker.a(c.a(getContext(), 4.0f));
        this.F = aVar;
        aVar.setBounds(Math.round(this.D.left), Math.round(this.D.top), Math.round(this.D.right), Math.round(this.D.bottom));
    }

    private void o() {
        int i4;
        Rect rect = this.A;
        int i5 = rect.right;
        int i6 = (i5 - this.f34511a) + 1;
        int i7 = rect.top + 1;
        int i8 = rect.bottom - 1;
        if (this.f34532v) {
            i4 = this.f34513c + this.f34512b;
        } else {
            i4 = 0;
        }
        this.C = new Rect(i6, i7, i5 - 1, i8 - i4);
    }

    private void p() {
        Rect rect = this.A;
        int i4 = rect.left + 1;
        int i5 = rect.top + 1;
        int i6 = rect.bottom - 1;
        int i7 = this.f34513c;
        int i8 = ((rect.right - 1) - i7) - this.f34511a;
        if (this.f34532v) {
            i6 -= this.f34512b + i7;
        }
        this.B = new Rect(i4, i5, i8, i6);
    }

    public String getAlphaSliderText() {
        return this.f34533w;
    }

    public int getBorderColor() {
        return this.f34535y;
    }

    public int getColor() {
        return Color.HSVToColor(this.f34528r, new float[]{this.f34529s, this.f34530t, this.f34531u});
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return Math.max(super.getPaddingBottom(), this.f34536z);
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return Math.max(super.getPaddingLeft(), this.f34536z);
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return Math.max(super.getPaddingRight(), this.f34536z);
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return Math.max(super.getPaddingTop(), this.f34536z);
    }

    public int getSliderTrackerColor() {
        return this.f34534x;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.A.width() > 0 && this.A.height() > 0) {
            e(canvas);
            d(canvas);
            c(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r0 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        if (r1 > r6) goto L15;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r2 = r5.getPaddingLeft()
            int r6 = r6 - r2
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r2 = r5.getPaddingBottom()
            int r7 = r7 - r2
            int r2 = r5.getPaddingTop()
            int r7 = r7 - r2
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L5c
            if (r1 != r2) goto L2b
            goto L5c
        L2b:
            int r0 = r5.f34513c
            int r1 = r7 + r0
            int r2 = r5.f34511a
            int r1 = r1 + r2
            int r3 = r6 - r0
            int r3 = r3 - r2
            boolean r2 = r5.f34532v
            if (r2 == 0) goto L40
            int r2 = r5.f34512b
            int r4 = r0 + r2
            int r1 = r1 - r4
            int r0 = r0 + r2
            int r3 = r3 + r0
        L40:
            r0 = 1
            r2 = 0
            if (r1 > r6) goto L46
            r4 = 1
            goto L47
        L46:
            r4 = 0
        L47:
            if (r3 > r7) goto L4a
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r4 == 0) goto L50
            if (r0 == 0) goto L50
            goto L5a
        L50:
            if (r0 != 0) goto L56
            if (r4 == 0) goto L56
        L54:
            r6 = r1
            goto L89
        L56:
            if (r4 != 0) goto L89
            if (r0 == 0) goto L89
        L5a:
            r7 = r3
            goto L89
        L5c:
            if (r0 != r2) goto L74
            if (r1 == r2) goto L74
            int r0 = r5.f34513c
            int r1 = r6 - r0
            int r2 = r5.f34511a
            int r1 = r1 - r2
            boolean r2 = r5.f34532v
            if (r2 == 0) goto L6f
            int r2 = r5.f34512b
            int r0 = r0 + r2
            int r1 = r1 + r0
        L6f:
            if (r1 <= r7) goto L72
            goto L89
        L72:
            r7 = r1
            goto L89
        L74:
            if (r1 != r2) goto L89
            if (r0 == r2) goto L89
            int r0 = r5.f34513c
            int r1 = r7 + r0
            int r2 = r5.f34511a
            int r1 = r1 + r2
            boolean r2 = r5.f34532v
            if (r2 == 0) goto L87
            int r2 = r5.f34512b
            int r0 = r0 + r2
            int r1 = r1 - r0
        L87:
            if (r1 <= r6) goto L54
        L89:
            int r0 = r5.getPaddingLeft()
            int r6 = r6 + r0
            int r0 = r5.getPaddingRight()
            int r6 = r6 + r0
            int r0 = r5.getPaddingTop()
            int r7 = r7 + r0
            int r0 = r5.getPaddingBottom()
            int r7 = r7 + r0
            r5.setMeasuredDimension(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaredrummler.android.colorpicker.ColorPickerView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f34528r = bundle.getInt("alpha");
            this.f34529s = bundle.getFloat("hue");
            this.f34530t = bundle.getFloat("sat");
            this.f34531u = bundle.getFloat("val");
            this.f34532v = bundle.getBoolean("show_alpha");
            this.f34533w = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("alpha", this.f34528r);
        bundle.putFloat("hue", this.f34529s);
        bundle.putFloat("sat", this.f34530t);
        bundle.putFloat("val", this.f34531u);
        bundle.putBoolean("show_alpha", this.f34532v);
        bundle.putString("alpha_text", this.f34533w);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        Rect rect = new Rect();
        this.A = rect;
        rect.left = getPaddingLeft();
        this.A.right = i4 - getPaddingRight();
        this.A.top = getPaddingTop();
        this.A.bottom = i5 - getPaddingBottom();
        this.f34523m = null;
        this.f34524n = null;
        this.f34525o = null;
        this.f34526p = null;
        this.f34527q = null;
        p();
        o();
        n();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean i4;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    i4 = false;
                } else {
                    i4 = i(motionEvent);
                }
            } else {
                this.E = null;
                i4 = i(motionEvent);
            }
        } else {
            this.E = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            i4 = i(motionEvent);
        }
        if (i4) {
            OnColorChangedListener onColorChangedListener = this.G;
            if (onColorChangedListener != null) {
                onColorChangedListener.onColorChanged(Color.HSVToColor(this.f34528r, new float[]{this.f34529s, this.f34530t, this.f34531u}));
            }
            invalidate();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAlphaSliderText(int i4) {
        setAlphaSliderText(getContext().getString(i4));
    }

    public void setAlphaSliderVisible(boolean z3) {
        if (this.f34532v != z3) {
            this.f34532v = z3;
            this.f34523m = null;
            this.f34524n = null;
            this.f34525o = null;
            this.f34527q = null;
            this.f34526p = null;
            requestLayout();
        }
    }

    public void setBorderColor(int i4) {
        this.f34535y = i4;
        invalidate();
    }

    public void setColor(int i4) {
        setColor(i4, false);
    }

    public void setOnColorChangedListener(OnColorChangedListener onColorChangedListener) {
        this.G = onColorChangedListener;
    }

    public void setSliderTrackerColor(int i4) {
        this.f34534x = i4;
        this.f34521k.setColor(i4);
        invalidate();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setColor(int i4, boolean z3) {
        OnColorChangedListener onColorChangedListener;
        int alpha = Color.alpha(i4);
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i4), Color.green(i4), Color.blue(i4), fArr);
        this.f34528r = alpha;
        float f4 = fArr[0];
        this.f34529s = f4;
        float f5 = fArr[1];
        this.f34530t = f5;
        float f6 = fArr[2];
        this.f34531u = f6;
        if (z3 && (onColorChangedListener = this.G) != null) {
            onColorChangedListener.onColorChanged(Color.HSVToColor(alpha, new float[]{f4, f5, f6}));
        }
        invalidate();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f34528r = 255;
        this.f34529s = 360.0f;
        this.f34530t = 0.0f;
        this.f34531u = 0.0f;
        this.f34532v = false;
        this.f34533w = null;
        this.f34534x = -4342339;
        this.f34535y = -9539986;
        this.E = null;
        g(context, attributeSet);
    }

    public void setAlphaSliderText(String str) {
        this.f34533w = str;
        invalidate();
    }
}
