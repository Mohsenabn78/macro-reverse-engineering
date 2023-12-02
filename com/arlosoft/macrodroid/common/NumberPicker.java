package com.arlosoft.macrodroid.common;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.arlosoft.macrodroid.R;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public class NumberPicker extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f9997a;

    /* renamed from: b  reason: collision with root package name */
    private int f9998b;

    /* renamed from: c  reason: collision with root package name */
    private int f9999c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f10000d;

    /* renamed from: e  reason: collision with root package name */
    private Button f10001e;

    /* renamed from: f  reason: collision with root package name */
    private Button f10002f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f10003g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f10004h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10005i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10006j;

    /* renamed from: k  reason: collision with root package name */
    private Listener f10007k;

    /* loaded from: classes3.dex */
    public interface Listener {
        void valueUpdated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NumberPicker.this.f10005i) {
                NumberPicker.this.o();
                NumberPicker.this.f10004h.postDelayed(new b(), 50L);
            } else if (NumberPicker.this.f10006j) {
                NumberPicker.this.n();
                NumberPicker.this.f10004h.postDelayed(new b(), 50L);
            }
        }
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9997a = -999;
        this.f9998b = 999;
        this.f9999c = 1;
        this.f10004h = new Handler();
        this.f10005i = false;
        this.f10006j = false;
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 55.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()));
        p(context);
        r(context);
        q(context);
        if (getOrientation() == 1) {
            addView(this.f10002f, layoutParams);
            addView(this.f10003g, layoutParams);
            addView(this.f10001e, layoutParams);
            return;
        }
        addView(this.f10001e, layoutParams);
        addView(this.f10003g, layoutParams);
        addView(this.f10002f, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f10000d.intValue() > this.f9997a) {
            Integer valueOf = Integer.valueOf(this.f10000d.intValue() - this.f9999c);
            this.f10000d = valueOf;
            this.f10003g.setText(valueOf.toString());
            Listener listener = this.f10007k;
            if (listener != null) {
                listener.valueUpdated();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f10000d.intValue() < this.f9998b) {
            Integer valueOf = Integer.valueOf(this.f10000d.intValue() + this.f9999c);
            this.f10000d = valueOf;
            this.f10003g.setText(valueOf.toString());
            Listener listener = this.f10007k;
            if (listener != null) {
                listener.valueUpdated();
            }
        }
    }

    private void p(Context context) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.selectableItemBackgroundBorderless, typedValue, true);
        Button button = new Button(context);
        this.f10001e = button;
        button.setBackgroundResource(typedValue.resourceId);
        this.f10001e.setTextSize(26.0f);
        this.f10001e.setText("-");
        this.f10001e.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumberPicker.this.s(view);
            }
        });
        this.f10001e.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.common.d0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean t3;
                t3 = NumberPicker.this.t(view);
                return t3;
            }
        });
        this.f10001e.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.common.e0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean u3;
                u3 = NumberPicker.this.u(view, motionEvent);
                return u3;
            }
        });
    }

    private void q(Context context) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.selectableItemBackgroundBorderless, typedValue, true);
        Button button = new Button(context);
        this.f10002f = button;
        button.setBackgroundResource(typedValue.resourceId);
        this.f10002f.setTextSize(26.0f);
        this.f10002f.setText(Marker.ANY_NON_NULL_MARKER);
        this.f10002f.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumberPicker.this.v(view);
            }
        });
        this.f10002f.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.common.i0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean w3;
                w3 = NumberPicker.this.w(view);
                return w3;
            }
        });
        this.f10002f.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.common.j0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean x3;
                x3 = NumberPicker.this.x(view, motionEvent);
                return x3;
            }
        });
    }

    private void r(Context context) {
        this.f10000d = 0;
        EditText editText = new EditText(context);
        this.f10003g = editText;
        editText.setTextSize(20.0f);
        this.f10003g.setOnKeyListener(new View.OnKeyListener() { // from class: com.arlosoft.macrodroid.common.f0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
                boolean y3;
                y3 = NumberPicker.this.y(view, i4, keyEvent);
                return y3;
            }
        });
        this.f10003g.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.arlosoft.macrodroid.common.g0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                NumberPicker.z(view, z3);
            }
        });
        this.f10003g.setGravity(17);
        this.f10003g.setText(this.f10000d.toString());
        this.f10003g.setInputType(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean t(View view) {
        this.f10006j = true;
        this.f10004h.post(new b());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean u(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f10006j) {
            this.f10006j = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean w(View view) {
        this.f10005i = true;
        this.f10004h.post(new b());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f10005i) {
            this.f10005i = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean y(View view, int i4, KeyEvent keyEvent) {
        int intValue = this.f10000d.intValue();
        try {
            this.f10000d = Integer.valueOf(Integer.parseInt(((EditText) view).getText().toString()));
        } catch (NumberFormatException unused) {
            this.f10000d = Integer.valueOf(intValue);
        }
        Listener listener = this.f10007k;
        if (listener != null) {
            listener.valueUpdated();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(View view, boolean z3) {
        if (z3) {
            ((EditText) view).selectAll();
        }
    }

    public int getValue() {
        int intValue = this.f10000d.intValue();
        try {
            this.f10000d = Integer.valueOf(Integer.parseInt(this.f10003g.getText().toString()));
        } catch (NumberFormatException unused) {
            this.f10000d = Integer.valueOf(intValue);
        }
        return this.f10000d.intValue();
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        this.f10001e.setEnabled(z3);
        this.f10002f.setEnabled(z3);
        this.f10003g.setEnabled(z3);
    }

    public void setIncrementStep(int i4) {
        this.f9999c = i4;
    }

    public void setListener(Listener listener) {
        this.f10007k = listener;
    }

    public void setMaximum(int i4) {
        this.f9998b = i4;
    }

    public void setMinimum(int i4) {
        this.f9997a = i4;
    }

    public void setValue(int i4) {
        int i5 = this.f9998b;
        if (i4 > i5) {
            i4 = i5;
        }
        int i6 = this.f9997a;
        if (i4 < i6) {
            i4 = i6;
        }
        Integer valueOf = Integer.valueOf(i4);
        this.f10000d = valueOf;
        this.f10003g.setText(valueOf.toString());
        Listener listener = this.f10007k;
        if (listener != null) {
            listener.valueUpdated();
        }
    }
}
