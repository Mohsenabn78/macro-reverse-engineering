package com.arlosoft.macrodroid.extensions;

import android.os.Bundle;
import android.os.Parcel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: ParcelExtensions.kt */
@SourceDebugExtension({"SMAP\nParcelExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParcelExtensions.kt\ncom/arlosoft/macrodroid/extensions/ParcelExtensionsKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,29:1\n215#2,2:30\n1855#3,2:32\n*S KotlinDebug\n*F\n+ 1 ParcelExtensions.kt\ncom/arlosoft/macrodroid/extensions/ParcelExtensionsKt\n*L\n14#1:30,2\n25#1:32,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ParcelExtensionsKt {
    public static final boolean readBoolean(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Map<String, String> readStringMap(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Bundle readBundle = parcel.readBundle();
        Intrinsics.checkNotNull(readBundle);
        Set<String> keySet = readBundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        for (String it : keySet) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            String string = readBundle.getString(it, "");
            Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(it, \"\")");
            linkedHashMap.put(it, string);
        }
        return linkedHashMap;
    }

    public static final void writeBoolean(@NotNull Parcel parcel, boolean z3) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        parcel.writeInt(z3 ? 1 : 0);
    }

    public static final void writeStringMap(@NotNull Parcel parcel, @NotNull Map<String, String> stringMap) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        Intrinsics.checkNotNullParameter(stringMap, "stringMap");
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            if (entry.getValue() != null) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        parcel.writeBundle(bundle);
    }
}
