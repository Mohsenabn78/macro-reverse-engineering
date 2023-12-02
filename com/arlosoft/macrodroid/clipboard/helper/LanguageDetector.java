package com.arlosoft.macrodroid.clipboard.helper;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.FileOperationAction;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: LanguageDetector.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nLanguageDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageDetector.kt\ncom/arlosoft/macrodroid/clipboard/helper/LanguageDetector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
/* loaded from: classes3.dex */
public final class LanguageDetector {
    public static final int $stable;
    @NotNull
    public static final LanguageDetector INSTANCE = new LanguageDetector();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f9782a;

    static {
        Map<String, String> mutableMapOf;
        mutableMapOf = s.mutableMapOf(TuplesKt.to("en", FileOperationAction.OPTION_COPY_FIXED), TuplesKt.to(TranslateLanguage.AFRIKAANS, "Kopieer"), TuplesKt.to("am", "ቅዳ"), TuplesKt.to(TranslateLanguage.ARABIC, "نسخ"), TuplesKt.to("as", "প্ৰতিলিপি কৰক"), TuplesKt.to("az", "Kopyalayın"), TuplesKt.to("sr", "Kopiraj"), TuplesKt.to(TranslateLanguage.BELARUSIAN, "Капіраваць"), TuplesKt.to(TranslateLanguage.BULGARIAN, "Копиране"), TuplesKt.to(TranslateLanguage.BENGALI, "কপি করুন"), TuplesKt.to("bs", "Kopiraj"), TuplesKt.to(TranslateLanguage.CATALAN, "Copia"), TuplesKt.to(TranslateLanguage.CZECH, "Kopírovat"), TuplesKt.to(TranslateLanguage.DANISH, "Kopiér"), TuplesKt.to(TranslateLanguage.GERMAN, "Kopieren"), TuplesKt.to(TranslateLanguage.GREEK, "Αντιγραφή"), TuplesKt.to(TranslateLanguage.SPANISH, "Copiar"), TuplesKt.to(TranslateLanguage.ESTONIAN, "Kopeerimine"), TuplesKt.to("eu", "Kopiatu"), TuplesKt.to(TranslateLanguage.PERSIAN, "کپی"), TuplesKt.to(TranslateLanguage.FINNISH, "Kopioi"), TuplesKt.to(TranslateLanguage.FRENCH, "Copier"), TuplesKt.to(TranslateLanguage.GALICIAN, "Copiar"), TuplesKt.to(TranslateLanguage.GUJARATI, "કૉપિ કરો"), TuplesKt.to(TranslateLanguage.HINDI, "कॉपी करें"), TuplesKt.to(TranslateLanguage.CROATIAN, "Kopiraj"), TuplesKt.to(TranslateLanguage.HUNGARIAN, "Másolás"), TuplesKt.to("hy", "Պատճենել"), TuplesKt.to("in", "Salin"), TuplesKt.to(TranslateLanguage.ICELANDIC, "Afrita"), TuplesKt.to(TranslateLanguage.ITALIAN, "Copia"), TuplesKt.to("iw", "העתקה"), TuplesKt.to(TranslateLanguage.JAPANESE, "コピー"), TuplesKt.to(TranslateLanguage.GEORGIAN, "კოპირება"), TuplesKt.to("kk", "Көшіру"), TuplesKt.to("km", "ចម្លង"), TuplesKt.to(TranslateLanguage.KANNADA, "ನಕಲಿಸಿ"), TuplesKt.to(TranslateLanguage.KOREAN, "복사"), TuplesKt.to("ky", "Көчүрүү"), TuplesKt.to("lo", "ສຳເນົາ"), TuplesKt.to(TranslateLanguage.LITHUANIAN, "Kopijuoti"), TuplesKt.to(TranslateLanguage.LATVIAN, "Kopēt"), TuplesKt.to(TranslateLanguage.MACEDONIAN, "Копирај"), TuplesKt.to("m1", "പകർത്തുക"), TuplesKt.to(CloudMessages.TEMPLATE_STORE_DATA_MACRO_NAME, "Хуулах"), TuplesKt.to(TranslateLanguage.MARATHI, "कॉपी करा"), TuplesKt.to(TranslateLanguage.MALAY, "Salin"), TuplesKt.to("my", "မိတ္တူကူးရန်"), TuplesKt.to("nb", "Kopiér"), TuplesKt.to("ne", "प्रतिलिपि गर्नुहोस्"), TuplesKt.to(TranslateLanguage.DUTCH, "Kopiëren"), TuplesKt.to("or", "କପି କରନ୍ତୁ"), TuplesKt.to("pa", "ਕਾਪੀ ਕਰੋ"), TuplesKt.to(TranslateLanguage.POLISH, "Kopiuj"), TuplesKt.to(TranslateLanguage.PORTUGUESE, "Copiar"), TuplesKt.to(TranslateLanguage.ROMANIAN, "Copiați"), TuplesKt.to(TranslateLanguage.RUSSIAN, "Копировать"), TuplesKt.to("si", "පිටපත් කරන්න"), TuplesKt.to(TranslateLanguage.SLOVAK, "Kopírovať"), TuplesKt.to(TranslateLanguage.SLOVENIAN, "Kopiraj"), TuplesKt.to(TranslateLanguage.ALBANIAN, "Kopjo"), TuplesKt.to("sr", "Копирај"), TuplesKt.to(TranslateLanguage.SWEDISH, "Kopiera"), TuplesKt.to(TranslateLanguage.SWAHILI, "Nakili"), TuplesKt.to(TranslateLanguage.TAMIL, "நகலெடு"), TuplesKt.to(TranslateLanguage.TELUGU, "కాపీ చేయి"), TuplesKt.to(TranslateLanguage.THAI, "คัดลอก"), TuplesKt.to(TranslateLanguage.TAGALOG, "Kopyahin"), TuplesKt.to(TranslateLanguage.TURKISH, "Kopyala"), TuplesKt.to(TranslateLanguage.UKRAINIAN, "Скопіювати"), TuplesKt.to(TranslateLanguage.URDU, "کاپی کریں"), TuplesKt.to("uz", "Nusxa olish"), TuplesKt.to(TranslateLanguage.VIETNAMESE, "Sao chép"), TuplesKt.to(TranslateLanguage.CHINESE, "复制"), TuplesKt.to("zh-CN", "复制"), TuplesKt.to("zh-HK", "複製"), TuplesKt.to("zh-TW", "複製"), TuplesKt.to("zu", "Kopisha"));
        f9782a = mutableMapOf;
        $stable = 8;
    }

    private LanguageDetector() {
    }

    @NotNull
    public final String find(@NotNull Context context) {
        LocaleList locales;
        Locale locale;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            locales = context.getResources().getConfiguration().getLocales();
            locale = locales.get(0);
            String language = locale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "{\n            context.re…les[0].language\n        }");
            return language;
        }
        String language2 = context.getResources().getConfiguration().locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language2, "{\n            context.re…locale.language\n        }");
        return language2;
    }

    @NotNull
    public final String getCopyForLocale(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = f9782a.get(find(context));
        if (str == null) {
            str = FileOperationAction.OPTION_COPY_FIXED;
        }
        return str;
    }
}
