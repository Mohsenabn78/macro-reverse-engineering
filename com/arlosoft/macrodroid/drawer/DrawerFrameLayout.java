package com.arlosoft.macrodroid.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class DrawerFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private BackKeyListener f11431a;

    /* loaded from: classes3.dex */
    public interface BackKeyListener {
        void onBackPressed();
    }

    public DrawerFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            BackKeyListener backKeyListener = this.f11431a;
            if (backKeyListener != null) {
                backKeyListener.onBackPressed();
                return true;
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setBackKeyListener(BackKeyListener backKeyListener) {
        this.f11431a = backKeyListener;
    }
}
