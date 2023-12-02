package com.hanks.htextview.typer;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;
import java.util.Random;

/* loaded from: classes6.dex */
public class TyperTextView extends HTextView {
    public static final int INVALIDATE = 1895;

    /* renamed from: a  reason: collision with root package name */
    private Random f34042a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f34043b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f34044c;

    /* renamed from: d  reason: collision with root package name */
    private int f34045d;

    /* renamed from: e  reason: collision with root package name */
    private int f34046e;

    /* renamed from: f  reason: collision with root package name */
    private AnimationListener f34047f;

    /* loaded from: classes6.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int length = TyperTextView.this.getText().length();
            if (length < TyperTextView.this.f34043b.length()) {
                if (TyperTextView.this.f34045d + length > TyperTextView.this.f34043b.length()) {
                    TyperTextView typerTextView = TyperTextView.this;
                    typerTextView.f34045d = typerTextView.f34043b.length() - length;
                }
                TyperTextView typerTextView2 = TyperTextView.this;
                typerTextView2.append(typerTextView2.f34043b.subSequence(length, TyperTextView.this.f34045d + length));
                long nextInt = TyperTextView.this.f34046e + TyperTextView.this.f34042a.nextInt(TyperTextView.this.f34046e);
                Message obtain = Message.obtain();
                obtain.what = TyperTextView.INVALIDATE;
                TyperTextView.this.f34044c.sendMessageDelayed(obtain, nextInt);
                return false;
            }
            if (TyperTextView.this.f34047f != null) {
                TyperTextView.this.f34047f.onAnimationEnd(TyperTextView.this);
            }
            return false;
        }
    }

    public TyperTextView(Context context) {
        this(context, null);
    }

    @Override // com.hanks.htextview.base.HTextView
    public void animateText(CharSequence charSequence) {
        if (charSequence != null) {
            this.f34043b = charSequence;
            setText("");
            Message obtain = Message.obtain();
            obtain.what = INVALIDATE;
            this.f34044c.sendMessage(obtain);
            return;
        }
        throw new RuntimeException("text must not  be null");
    }

    public int getCharIncrease() {
        return this.f34045d;
    }

    public int getTyperSpeed() {
        return this.f34046e;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f34044c.removeMessages(INVALIDATE);
    }

    @Override // com.hanks.htextview.base.HTextView
    public void setAnimationListener(AnimationListener animationListener) {
        this.f34047f = animationListener;
    }

    public void setCharIncrease(int i4) {
        this.f34045d = i4;
    }

    @Override // com.hanks.htextview.base.HTextView
    public void setProgress(float f4) {
        CharSequence charSequence = this.f34043b;
        setText(charSequence.subSequence(0, (int) (charSequence.length() * f4)));
    }

    public void setTyperSpeed(int i4) {
        this.f34046e = i4;
    }

    public TyperTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TyperTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TyperTextView);
        this.f34046e = obtainStyledAttributes.getInt(R.styleable.TyperTextView_typerSpeed, 100);
        this.f34045d = obtainStyledAttributes.getInt(R.styleable.TyperTextView_charIncrease, 2);
        obtainStyledAttributes.recycle();
        this.f34042a = new Random();
        this.f34043b = getText();
        this.f34044c = new Handler(new a());
    }
}
