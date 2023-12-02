package com.arlosoft.macrodroid.triggers.swipe;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.SwipeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SwipeTriggerView extends OverlayView {

    /* renamed from: d  reason: collision with root package name */
    private int f15591d;

    /* renamed from: e  reason: collision with root package name */
    private int f15592e;

    /* renamed from: f  reason: collision with root package name */
    private final int f15593f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15594g;

    public SwipeTriggerView(OverlayService overlayService, int i4) {
        super(overlayService, R.layout.overlay, 1, i4);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f15593f = displayMetrics.widthPixels;
        this.f15594g = displayMetrics.heightPixels;
    }

    private void m(int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof SwipeTrigger) {
                        SwipeTrigger swipeTrigger = (SwipeTrigger) next;
                        if (swipeTrigger.getSwipeStartArea() == i4 && swipeTrigger.getSwipeMotion() == i5 && next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                            }
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.swipe.OverlayView
    protected void h(MotionEvent motionEvent) {
        this.f15591d = (int) motionEvent.getX();
        this.f15592e = (int) motionEvent.getY();
    }

    @Override // com.arlosoft.macrodroid.triggers.swipe.OverlayView
    protected void i(MotionEvent motionEvent) {
        int x3 = ((int) motionEvent.getX()) - this.f15591d;
        int y3 = ((int) motionEvent.getY()) - this.f15592e;
        int i4 = this.f15587c;
        if (i4 == 0) {
            int i5 = this.f15593f;
            if (x3 > i5 / 2) {
                if (y3 > this.f15594g / 4) {
                    m(0, 1);
                } else {
                    m(0, 0);
                }
            } else if (x3 < i5 / 8 && y3 > this.f15594g / 4) {
                m(0, 2);
            }
        } else if (i4 == 1) {
            int i6 = this.f15593f;
            if (x3 < (-(i6 / 2))) {
                if (y3 > this.f15594g / 4) {
                    m(1, 1);
                } else {
                    m(1, 0);
                }
            } else if (x3 < i6 / 8 && y3 > this.f15594g / 4) {
                m(1, 2);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.swipe.OverlayView
    public boolean onTouchEvent_LongPress() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.triggers.swipe.OverlayView
    protected void g(MotionEvent motionEvent) {
    }
}
