package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import androidx.core.view.GravityCompat;

/* loaded from: classes2.dex */
public enum GravityEnum {
    START,
    CENTER,
    END;
    

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f974a = true;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f976a;

        static {
            int[] iArr = new int[GravityEnum.values().length];
            f976a = iArr;
            try {
                iArr[GravityEnum.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f976a[GravityEnum.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f976a[GravityEnum.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @SuppressLint({"RtlHardcoded"})
    public int getGravityInt() {
        int i4 = a.f976a[ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return 1;
            }
            if (i4 == 3) {
                if (f974a) {
                    return GravityCompat.END;
                }
                return 5;
            }
            throw new IllegalStateException("Invalid gravity constant");
        } else if (!f974a) {
            return 3;
        } else {
            return GravityCompat.START;
        }
    }

    @TargetApi(17)
    public int getTextAlignment() {
        int i4 = a.f976a[ordinal()];
        if (i4 != 2) {
            if (i4 != 3) {
                return 5;
            }
            return 6;
        }
        return 4;
    }
}
