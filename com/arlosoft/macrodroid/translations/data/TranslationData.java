package com.arlosoft.macrodroid.translations.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TranslationData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@SourceDebugExtension({"SMAP\nTranslationData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslationData.kt\ncom/arlosoft/macrodroid/translations/data/TranslationData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,13:1\n1054#2:14\n*S KotlinDebug\n*F\n+ 1 TranslationData.kt\ncom/arlosoft/macrodroid/translations/data/TranslationData\n*L\n10#1:14\n*E\n"})
/* loaded from: classes3.dex */
public final class TranslationData {
    public static final int $stable = 8;
    @NotNull
    private final List<Translation> data;

    public TranslationData(@NotNull List<Translation> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TranslationData copy$default(TranslationData translationData, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = translationData.data;
        }
        return translationData.copy(list);
    }

    @NotNull
    public final List<Translation> component1() {
        return this.data;
    }

    @NotNull
    public final TranslationData copy(@NotNull List<Translation> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new TranslationData(data);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TranslationData) && Intrinsics.areEqual(this.data, ((TranslationData) obj).data)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<Translation> getData() {
        return this.data;
    }

    @NotNull
    public final List<Translation> getSortedTranslations() {
        List<Translation> sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.data, new Comparator() { // from class: com.arlosoft.macrodroid.translations.data.TranslationData$getSortedTranslations$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int compareValues;
                compareValues = f.compareValues(Integer.valueOf(((Translation) t4).getProgress().getTranslated()), Integer.valueOf(((Translation) t3).getProgress().getTranslated()));
                return compareValues;
            }
        });
        return sortedWith;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        List<Translation> list = this.data;
        return "TranslationData(data=" + list + ")";
    }
}
