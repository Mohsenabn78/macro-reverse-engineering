package com.arlosoft.macrodroid.extensions;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ParcelableExtensions.kt */
/* loaded from: classes3.dex */
public final class ParcelableExtensionsKt {
    @Nullable
    public static final Parcelable copy(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "<this>");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        parcelable.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        try {
            Object newInstance = parcelable.getClass().getDeclaredConstructor(Parcel.class).newInstance(obtain);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type android.os.Parcelable");
            return (Parcelable) newInstance;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static final <T extends Parcelable> T deepClone(@NotNull Parcelable parcelable) {
        Parcel parcel;
        Intrinsics.checkNotNullParameter(parcelable, "<this>");
        try {
            parcel = Parcel.obtain();
        } catch (Throwable th) {
            th = th;
            parcel = null;
        }
        try {
            parcel.writeParcelable(parcelable, 0);
            parcel.setDataPosition(0);
            T t3 = (T) parcel.readParcelable(parcelable.getClass().getClassLoader());
            parcel.recycle();
            return t3;
        } catch (Throwable th2) {
            th = th2;
            if (parcel != null) {
                parcel.recycle();
            }
            throw th;
        }
    }
}
