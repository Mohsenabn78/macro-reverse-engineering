package com.pollfish.internal;

import android.app.Activity;
import com.pollfish.callback.PollfishClosedListener;
import com.pollfish.callback.PollfishOpenedListener;
import com.pollfish.callback.PollfishSurveyCompletedListener;
import com.pollfish.callback.PollfishSurveyNotAvailableListener;
import com.pollfish.callback.PollfishSurveyReceivedListener;
import com.pollfish.callback.PollfishUserNotEligibleListener;
import com.pollfish.callback.PollfishUserRejectedSurveyListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class t2 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public PollfishOpenedListener f37225a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public PollfishClosedListener f37226b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public PollfishSurveyCompletedListener f37227c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public PollfishSurveyReceivedListener f37228d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public PollfishSurveyNotAvailableListener f37229e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public PollfishUserNotEligibleListener f37230f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public PollfishUserRejectedSurveyListener f37231g;

    public t2(@Nullable PollfishOpenedListener pollfishOpenedListener, @Nullable PollfishClosedListener pollfishClosedListener, @Nullable PollfishSurveyCompletedListener pollfishSurveyCompletedListener, @Nullable PollfishSurveyReceivedListener pollfishSurveyReceivedListener, @Nullable PollfishSurveyNotAvailableListener pollfishSurveyNotAvailableListener, @Nullable PollfishUserNotEligibleListener pollfishUserNotEligibleListener, @Nullable PollfishUserRejectedSurveyListener pollfishUserRejectedSurveyListener) {
        this.f37225a = pollfishOpenedListener;
        this.f37226b = pollfishClosedListener;
        this.f37227c = pollfishSurveyCompletedListener;
        this.f37228d = pollfishSurveyReceivedListener;
        this.f37229e = pollfishSurveyNotAvailableListener;
        this.f37230f = pollfishUserNotEligibleListener;
        this.f37231g = pollfishUserRejectedSurveyListener;
    }

    @Nullable
    public final PollfishClosedListener a() {
        return this.f37226b;
    }

    @Nullable
    public final PollfishOpenedListener b() {
        return this.f37225a;
    }

    @Nullable
    public final PollfishSurveyCompletedListener c() {
        return this.f37227c;
    }

    @Nullable
    public final PollfishSurveyNotAvailableListener d() {
        return this.f37229e;
    }

    @Nullable
    public final PollfishSurveyReceivedListener e() {
        return this.f37228d;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t2)) {
            return false;
        }
        t2 t2Var = (t2) obj;
        if (Intrinsics.areEqual(this.f37225a, t2Var.f37225a) && Intrinsics.areEqual(this.f37226b, t2Var.f37226b) && Intrinsics.areEqual(this.f37227c, t2Var.f37227c) && Intrinsics.areEqual(this.f37228d, t2Var.f37228d) && Intrinsics.areEqual(this.f37229e, t2Var.f37229e) && Intrinsics.areEqual(this.f37230f, t2Var.f37230f) && Intrinsics.areEqual(this.f37231g, t2Var.f37231g)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final PollfishUserNotEligibleListener f() {
        return this.f37230f;
    }

    @Nullable
    public final PollfishUserRejectedSurveyListener g() {
        return this.f37231g;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        PollfishOpenedListener pollfishOpenedListener = this.f37225a;
        int i4 = 0;
        if (pollfishOpenedListener == null) {
            hashCode = 0;
        } else {
            hashCode = pollfishOpenedListener.hashCode();
        }
        int i5 = hashCode * 31;
        PollfishClosedListener pollfishClosedListener = this.f37226b;
        if (pollfishClosedListener == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = pollfishClosedListener.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        PollfishSurveyCompletedListener pollfishSurveyCompletedListener = this.f37227c;
        if (pollfishSurveyCompletedListener == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = pollfishSurveyCompletedListener.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        PollfishSurveyReceivedListener pollfishSurveyReceivedListener = this.f37228d;
        if (pollfishSurveyReceivedListener == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = pollfishSurveyReceivedListener.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        PollfishSurveyNotAvailableListener pollfishSurveyNotAvailableListener = this.f37229e;
        if (pollfishSurveyNotAvailableListener == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = pollfishSurveyNotAvailableListener.hashCode();
        }
        int i9 = (i8 + hashCode5) * 31;
        PollfishUserNotEligibleListener pollfishUserNotEligibleListener = this.f37230f;
        if (pollfishUserNotEligibleListener == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = pollfishUserNotEligibleListener.hashCode();
        }
        int i10 = (i9 + hashCode6) * 31;
        PollfishUserRejectedSurveyListener pollfishUserRejectedSurveyListener = this.f37231g;
        if (pollfishUserRejectedSurveyListener != null) {
            i4 = pollfishUserRejectedSurveyListener.hashCode();
        }
        return i10 + i4;
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("PollfishListeners(openedListener=");
        a4.append(this.f37225a);
        a4.append(", closedListener=");
        a4.append(this.f37226b);
        a4.append(", surveyCompletedListener=");
        a4.append(this.f37227c);
        a4.append(", surveyReceivedListener=");
        a4.append(this.f37228d);
        a4.append(", surveyNotAvailableListener=");
        a4.append(this.f37229e);
        a4.append(", userNotEligibleListener=");
        a4.append(this.f37230f);
        a4.append(", userRejectedSurveyListener=");
        a4.append(this.f37231g);
        a4.append(')');
        return a4.toString();
    }

    public final void a(@NotNull Activity activity) {
        PollfishOpenedListener pollfishOpenedListener = activity instanceof PollfishOpenedListener ? (PollfishOpenedListener) activity : null;
        if (pollfishOpenedListener != null) {
            this.f37225a = pollfishOpenedListener;
        }
        PollfishClosedListener pollfishClosedListener = activity instanceof PollfishClosedListener ? (PollfishClosedListener) activity : null;
        if (pollfishClosedListener != null) {
            this.f37226b = pollfishClosedListener;
        }
        PollfishSurveyCompletedListener pollfishSurveyCompletedListener = activity instanceof PollfishSurveyCompletedListener ? (PollfishSurveyCompletedListener) activity : null;
        if (pollfishSurveyCompletedListener != null) {
            this.f37227c = pollfishSurveyCompletedListener;
        }
        PollfishSurveyReceivedListener pollfishSurveyReceivedListener = activity instanceof PollfishSurveyReceivedListener ? (PollfishSurveyReceivedListener) activity : null;
        if (pollfishSurveyReceivedListener != null) {
            this.f37228d = pollfishSurveyReceivedListener;
        }
        PollfishSurveyNotAvailableListener pollfishSurveyNotAvailableListener = activity instanceof PollfishSurveyNotAvailableListener ? (PollfishSurveyNotAvailableListener) activity : null;
        if (pollfishSurveyNotAvailableListener != null) {
            this.f37229e = pollfishSurveyNotAvailableListener;
        }
        PollfishUserNotEligibleListener pollfishUserNotEligibleListener = activity instanceof PollfishUserNotEligibleListener ? (PollfishUserNotEligibleListener) activity : null;
        if (pollfishUserNotEligibleListener != null) {
            this.f37230f = pollfishUserNotEligibleListener;
        }
        PollfishUserRejectedSurveyListener pollfishUserRejectedSurveyListener = activity instanceof PollfishUserRejectedSurveyListener ? (PollfishUserRejectedSurveyListener) activity : null;
        if (pollfishUserRejectedSurveyListener != null) {
            this.f37231g = pollfishUserRejectedSurveyListener;
        }
    }
}
