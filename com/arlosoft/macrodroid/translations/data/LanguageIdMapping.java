package com.arlosoft.macrodroid.translations.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LanguageIdMapping.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LanguageIdMapping {
    public static final int $stable;
    @NotNull
    public static final LanguageIdMapping INSTANCE = new LanguageIdMapping();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Integer> f14304a;

    static {
        Map<String, Integer> mapOf;
        mapOf = s.mapOf(TuplesKt.to(TranslateLanguage.SPANISH, 79), TuplesKt.to(TranslateLanguage.FRENCH, 5), TuplesKt.to(TranslateLanguage.DUTCH, 12), TuplesKt.to(TranslateLanguage.PORTUGUESE, 563), TuplesKt.to(TranslateLanguage.SWEDISH, 17), TuplesKt.to(TranslateLanguage.TURKISH, 14), TuplesKt.to(TranslateLanguage.CZECH, 13), TuplesKt.to(TranslateLanguage.RUSSIAN, 11), TuplesKt.to(TranslateLanguage.JAPANESE, 4), TuplesKt.to("zh-CN", 3), TuplesKt.to(TranslateLanguage.PERSIAN, 29), TuplesKt.to(TranslateLanguage.ROMANIAN, 19), TuplesKt.to(TranslateLanguage.ITALIAN, 10), TuplesKt.to(TranslateLanguage.VIETNAMESE, 50), TuplesKt.to(TranslateLanguage.GERMAN, 6), TuplesKt.to(TranslateLanguage.HUNGARIAN, 21), TuplesKt.to(TranslateLanguage.BULGARIAN, 576), TuplesKt.to(TranslateLanguage.UKRAINIAN, 36), TuplesKt.to(TranslateLanguage.CATALAN, 23), TuplesKt.to(TranslateLanguage.HEBREW, 42), TuplesKt.to(TranslateLanguage.POLISH, 16), TuplesKt.to(TranslateLanguage.ARABIC, 28), TuplesKt.to(TranslateLanguage.GREEK, 20), TuplesKt.to(TranslateLanguage.KOREAN, 9), TuplesKt.to(TranslateLanguage.DANISH, 27), TuplesKt.to("id", 54), TuplesKt.to("zh-TW", 2), TuplesKt.to(TranslateLanguage.NORWEGIAN, 180), TuplesKt.to(TranslateLanguage.FINNISH, 18), TuplesKt.to(TranslateLanguage.SLOVAK, 34), TuplesKt.to("sr", 462), TuplesKt.to(TranslateLanguage.AFRIKAANS, 60), TuplesKt.to(TranslateLanguage.HINDI, 587), TuplesKt.to(TranslateLanguage.THAI, 56), TuplesKt.to("az", 249), TuplesKt.to(TranslateLanguage.URDU, 101));
        f14304a = mapOf;
        $stable = 8;
    }

    private LanguageIdMapping() {
    }

    @NotNull
    public final Map<String, Integer> getLanguageCodeMap() {
        return f14304a;
    }
}
