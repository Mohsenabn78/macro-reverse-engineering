package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StringWithLanguages.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@SourceDebugExtension({"SMAP\nStringWithLanguages.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringWithLanguages.kt\ncom/arlosoft/macrodroid/extras/data/StringWithLanguages\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,20:1\n1#2:21\n*E\n"})
/* loaded from: classes3.dex */
public final class StringWithLanguages {
    @NotNull
    public static final String DEFAULT_LANGUAGE_CODE = "en";
    @NotNull
    private final List<StringWithLanguage> strings;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: StringWithLanguages.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StringWithLanguages(@NotNull List<StringWithLanguage> strings) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        this.strings = strings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StringWithLanguages copy$default(StringWithLanguages stringWithLanguages, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = stringWithLanguages.strings;
        }
        return stringWithLanguages.copy(list);
    }

    @NotNull
    public final List<StringWithLanguage> component1() {
        return this.strings;
    }

    @NotNull
    public final StringWithLanguages copy(@NotNull List<StringWithLanguage> strings) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        return new StringWithLanguages(strings);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof StringWithLanguages) && Intrinsics.areEqual(this.strings, ((StringWithLanguages) obj).strings)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getStringForLanguage(@NotNull String languageCode) {
        String str;
        Object obj;
        String str2;
        Object obj2;
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Iterator<T> it = this.strings.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((StringWithLanguage) obj).getLanguageCode(), languageCode)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        StringWithLanguage stringWithLanguage = (StringWithLanguage) obj;
        if (stringWithLanguage != null) {
            str2 = stringWithLanguage.getText();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            Iterator<T> it2 = this.strings.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    if (Intrinsics.areEqual(((StringWithLanguage) obj2).getLanguageCode(), "en")) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            StringWithLanguage stringWithLanguage2 = (StringWithLanguage) obj2;
            if (stringWithLanguage2 != null) {
                str = stringWithLanguage2.getText();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return str2;
    }

    @NotNull
    public final List<StringWithLanguage> getStrings() {
        return this.strings;
    }

    public int hashCode() {
        return this.strings.hashCode();
    }

    @NotNull
    public String toString() {
        List<StringWithLanguage> list = this.strings;
        return "StringWithLanguages(strings=" + list + ")";
    }
}
