package com.arlosoft.macrodroid.templatestore.common;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.google.mlkit.nl.translate.TranslateLanguage;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlagProvider.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class FlagProvider {
    public static final int $stable = 0;

    @DrawableRes
    @Nullable
    public final Integer getFlagResourceFromLanguage(@NotNull String languageCode) {
        String take;
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        take = StringsKt___StringsKt.take(languageCode, 2);
        int hashCode = take.hashCode();
        Integer valueOf = Integer.valueOf((int) R.drawable.flag_zh_rcn);
        switch (hashCode) {
            case -704712386:
                if (take.equals("zh-rCN")) {
                    return valueOf;
                }
                break;
            case 3109:
                if (take.equals(TranslateLanguage.AFRIKAANS)) {
                    return Integer.valueOf((int) R.drawable.flag_za);
                }
                break;
            case 3121:
                if (take.equals(TranslateLanguage.ARABIC)) {
                    return Integer.valueOf((int) R.drawable.flag_ar);
                }
                break;
            case 3129:
                if (take.equals("az")) {
                    return Integer.valueOf((int) R.drawable.flag_az);
                }
                break;
            case 3141:
                if (take.equals(TranslateLanguage.BULGARIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_bg);
                }
                break;
            case 3166:
                if (take.equals(TranslateLanguage.CATALAN)) {
                    return Integer.valueOf((int) R.drawable.flag_ca);
                }
                break;
            case 3184:
                if (take.equals(TranslateLanguage.CZECH)) {
                    return Integer.valueOf((int) R.drawable.flag_cs);
                }
                break;
            case 3197:
                if (take.equals(TranslateLanguage.DANISH)) {
                    return Integer.valueOf((int) R.drawable.flag_da);
                }
                break;
            case 3201:
                if (take.equals(TranslateLanguage.GERMAN)) {
                    return Integer.valueOf((int) R.drawable.flag_de);
                }
                break;
            case 3239:
                if (take.equals(TranslateLanguage.GREEK)) {
                    return Integer.valueOf((int) R.drawable.flag_el);
                }
                break;
            case 3241:
                if (take.equals("en")) {
                    return Integer.valueOf((int) R.drawable.flag_en);
                }
                break;
            case 3246:
                if (take.equals(TranslateLanguage.SPANISH)) {
                    return Integer.valueOf((int) R.drawable.flag_es);
                }
                break;
            case 3259:
                if (take.equals(TranslateLanguage.PERSIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_fa);
                }
                break;
            case 3267:
                if (take.equals(TranslateLanguage.FINNISH)) {
                    return Integer.valueOf((int) R.drawable.flag_fi);
                }
                break;
            case 3276:
                if (take.equals(TranslateLanguage.FRENCH)) {
                    return Integer.valueOf((int) R.drawable.flag_fr);
                }
                break;
            case 3325:
                if (take.equals(TranslateLanguage.HEBREW)) {
                    return Integer.valueOf((int) R.drawable.flag_he);
                }
                break;
            case 3329:
                if (take.equals(TranslateLanguage.HINDI)) {
                    return Integer.valueOf((int) R.drawable.flag_in);
                }
                break;
            case 3341:
                if (take.equals(TranslateLanguage.HUNGARIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_hu);
                }
                break;
            case 3355:
                if (take.equals("id")) {
                    return Integer.valueOf((int) R.drawable.flag_id);
                }
                break;
            case 3371:
                if (take.equals(TranslateLanguage.ITALIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_it);
                }
                break;
            case 3383:
                if (take.equals(TranslateLanguage.JAPANESE)) {
                    return Integer.valueOf((int) R.drawable.flag_ja);
                }
                break;
            case 3424:
                if (take.equals("kk")) {
                    return Integer.valueOf((int) R.drawable.flag_kk);
                }
                break;
            case 3428:
                if (take.equals(TranslateLanguage.KOREAN)) {
                    return Integer.valueOf((int) R.drawable.flag_ko);
                }
                break;
            case 3464:
                if (take.equals(TranslateLanguage.LITHUANIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_lt);
                }
                break;
            case 3518:
                if (take.equals(TranslateLanguage.DUTCH)) {
                    return Integer.valueOf((int) R.drawable.flag_nl);
                }
                break;
            case 3521:
                if (take.equals(TranslateLanguage.NORWEGIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_no);
                }
                break;
            case 3580:
                if (take.equals(TranslateLanguage.POLISH)) {
                    return Integer.valueOf((int) R.drawable.flag_pl);
                }
                break;
            case 3588:
                if (take.equals(TranslateLanguage.PORTUGUESE)) {
                    return Integer.valueOf((int) R.drawable.flag_pt);
                }
                break;
            case 3645:
                if (take.equals(TranslateLanguage.ROMANIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_ro);
                }
                break;
            case 3651:
                if (take.equals(TranslateLanguage.RUSSIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_ru);
                }
                break;
            case 3672:
                if (take.equals(TranslateLanguage.SLOVAK)) {
                    return Integer.valueOf((int) R.drawable.flag_sk);
                }
                break;
            case 3679:
                if (take.equals("sr")) {
                    return Integer.valueOf((int) R.drawable.flag_sr);
                }
                break;
            case 3683:
                if (take.equals(TranslateLanguage.SWEDISH)) {
                    return Integer.valueOf((int) R.drawable.flag_sv);
                }
                break;
            case 3700:
                if (take.equals(TranslateLanguage.THAI)) {
                    return Integer.valueOf((int) R.drawable.flag_th);
                }
                break;
            case 3710:
                if (take.equals(TranslateLanguage.TURKISH)) {
                    return Integer.valueOf((int) R.drawable.flag_tr);
                }
                break;
            case 3734:
                if (take.equals(TranslateLanguage.UKRAINIAN)) {
                    return Integer.valueOf((int) R.drawable.flag_ua);
                }
                break;
            case 3741:
                if (take.equals(TranslateLanguage.URDU)) {
                    return Integer.valueOf((int) R.drawable.flag_pk);
                }
                break;
            case 3763:
                if (take.equals(TranslateLanguage.VIETNAMESE)) {
                    return Integer.valueOf((int) R.drawable.flag_vi);
                }
                break;
            case 3886:
                if (take.equals(TranslateLanguage.CHINESE)) {
                    return valueOf;
                }
                break;
            case 115813226:
                if (take.equals("zh-CN")) {
                    return valueOf;
                }
                break;
            case 115813762:
                if (take.equals("zh-TW")) {
                    return Integer.valueOf((int) R.drawable.flag_tw);
                }
                break;
        }
        return null;
    }
}
