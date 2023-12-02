package com.github.javiersantos.piracychecker.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: InstallerID.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/github/javiersantos/piracychecker/enums/InstallerID;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toIDs", "", "toString", "GOOGLE_PLAY", "AMAZON_APP_STORE", "GALAXY_APPS", "HUAWEI_APP_GALLERY", "library_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public enum InstallerID {
    GOOGLE_PLAY("com.android.vending|com.google.android.feedback"),
    AMAZON_APP_STORE("com.amazon.venezia"),
    GALAXY_APPS("com.sec.android.app.samsungapps"),
    HUAWEI_APP_GALLERY("com.huawei.appmarket");
    
    private final String text;

    InstallerID(String str) {
        this.text = str;
    }

    @NotNull
    public final List<String> toIDs() {
        boolean contains$default;
        List listOf;
        List emptyList;
        List listOf2;
        boolean z3;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.text, (CharSequence) "|", false, 2, (Object) null);
        if (!contains$default) {
            listOf = e.listOf(this.text);
            return new ArrayList(listOf);
        }
        List<String> split = new Regex("\\|").split(this.text, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (!z3) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) ((String[]) Arrays.copyOf(strArr, strArr.length)));
            return new ArrayList(listOf2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.text;
    }
}
