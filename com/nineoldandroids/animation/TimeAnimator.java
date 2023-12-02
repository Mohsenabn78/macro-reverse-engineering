package com.nineoldandroids.animation;

/* loaded from: classes6.dex */
public class TimeAnimator extends ValueAnimator {
    private TimeListener E;
    private long F = -1;

    /* loaded from: classes6.dex */
    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j4, long j5);
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    boolean m(long j4) {
        long j5 = 0;
        if (this.f36367i == 0) {
            this.f36367i = 1;
            long j6 = this.f36361c;
            if (j6 < 0) {
                this.f36360b = j4;
            } else {
                this.f36360b = j4 - j6;
                this.f36361c = -1L;
            }
        }
        TimeListener timeListener = this.E;
        if (timeListener != null) {
            long j7 = j4 - this.f36360b;
            long j8 = this.F;
            if (j8 >= 0) {
                j5 = j4 - j8;
            }
            this.F = j4;
            timeListener.onTimeUpdate(this, j7, j5);
            return false;
        }
        return false;
    }

    public void setTimeListener(TimeListener timeListener) {
        this.E = timeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void l(float f4) {
    }
}
