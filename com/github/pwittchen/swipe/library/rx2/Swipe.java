package com.github.pwittchen.swipe.library.rx2;

import android.view.MotionEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* loaded from: classes3.dex */
public class Swipe {
    public static final int DEFAULT_SWIPED_THRESHOLD = 100;
    public static final int DEFAULT_SWIPING_THRESHOLD = 20;

    /* renamed from: a  reason: collision with root package name */
    private final int f18465a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18466b;

    /* renamed from: c  reason: collision with root package name */
    private SwipeListener f18467c;

    /* renamed from: d  reason: collision with root package name */
    private ObservableEmitter<SwipeEvent> f18468d;

    /* renamed from: e  reason: collision with root package name */
    private float f18469e;

    /* renamed from: f  reason: collision with root package name */
    private float f18470f;

    /* renamed from: g  reason: collision with root package name */
    private float f18471g;

    /* renamed from: h  reason: collision with root package name */
    private float f18472h;

    /* renamed from: i  reason: collision with root package name */
    private float f18473i;

    /* renamed from: j  reason: collision with root package name */
    private float f18474j;

    /* loaded from: classes3.dex */
    class a implements ObservableOnSubscribe<SwipeEvent> {
        a() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<SwipeEvent> observableEmitter) throws Exception {
            Swipe.this.f18468d = observableEmitter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements SwipeListener {
        b() {
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public boolean onSwipedDown(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPED_DOWN);
            return false;
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public boolean onSwipedLeft(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPED_LEFT);
            return false;
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public boolean onSwipedRight(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPED_RIGHT);
            return false;
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public boolean onSwipedUp(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPED_UP);
            return false;
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public void onSwipingDown(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPING_DOWN);
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public void onSwipingLeft(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPING_LEFT);
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public void onSwipingRight(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPING_RIGHT);
        }

        @Override // com.github.pwittchen.swipe.library.rx2.SwipeListener
        public void onSwipingUp(MotionEvent motionEvent) {
            Swipe.this.h(SwipeEvent.SWIPING_UP);
        }
    }

    public Swipe() {
        this(20, 100);
    }

    private void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    private SwipeListener d() {
        return new b();
    }

    private void e(MotionEvent motionEvent) {
        this.f18469e = motionEvent.getX();
        this.f18471g = motionEvent.getY();
    }

    private void f(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        this.f18473i = motionEvent.getX();
        this.f18474j = motionEvent.getY();
        boolean z8 = true;
        if (Math.abs(this.f18473i - this.f18469e) > getSwipingThreshold()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (Math.abs(this.f18474j - this.f18471g) > getSwipingThreshold()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3) {
            float f4 = this.f18473i;
            float f5 = this.f18469e;
            if (f4 > f5) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (f4 < f5) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z6) {
                this.f18467c.onSwipingRight(motionEvent);
            }
            if (z7) {
                this.f18467c.onSwipingLeft(motionEvent);
            }
        }
        if (z4) {
            float f6 = this.f18471g;
            float f7 = this.f18474j;
            if (f6 < f7) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (f6 <= f7) {
                z8 = false;
            }
            if (z5) {
                this.f18467c.onSwipingDown(motionEvent);
            }
            if (z8) {
                this.f18467c.onSwipingUp(motionEvent);
            }
        }
    }

    private boolean g(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        this.f18470f = motionEvent.getX();
        this.f18472h = motionEvent.getY();
        boolean z9 = true;
        if (Math.abs(this.f18470f - this.f18469e) > getSwipedThreshold()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (Math.abs(this.f18472h - this.f18471g) > getSwipedThreshold()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3) {
            float f4 = this.f18470f;
            float f5 = this.f18469e;
            if (f4 > f5) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (f4 < f5) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z7) {
                z5 = this.f18467c.onSwipedRight(motionEvent);
            } else {
                z5 = false;
            }
            if (z8) {
                z5 |= this.f18467c.onSwipedLeft(motionEvent);
            }
        } else {
            z5 = false;
        }
        if (z4) {
            float f6 = this.f18471g;
            float f7 = this.f18472h;
            if (f6 < f7) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (f6 <= f7) {
                z9 = false;
            }
            if (z6) {
                z5 |= this.f18467c.onSwipedDown(motionEvent);
            }
            if (z9) {
                return z5 | this.f18467c.onSwipedUp(motionEvent);
            }
            return z5;
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(SwipeEvent swipeEvent) {
        ObservableEmitter<SwipeEvent> observableEmitter = this.f18468d;
        if (observableEmitter != null) {
            observableEmitter.onNext(swipeEvent);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        c(motionEvent, "event == null");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    f(motionEvent);
                }
            } else {
                return g(motionEvent);
            }
        } else {
            e(motionEvent);
        }
        return false;
    }

    public int getSwipedThreshold() {
        return this.f18466b;
    }

    public int getSwipingThreshold() {
        return this.f18465a;
    }

    public Observable<SwipeEvent> observe() {
        this.f18467c = d();
        return Observable.create(new a());
    }

    public void setListener(SwipeListener swipeListener) {
        c(swipeListener, "swipeListener == null");
        this.f18467c = swipeListener;
    }

    public Swipe(int i4, int i5) {
        this.f18465a = i4;
        this.f18466b = i5;
    }
}
