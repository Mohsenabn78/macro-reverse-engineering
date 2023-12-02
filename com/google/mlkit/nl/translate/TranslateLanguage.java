package com.google.mlkit.nl.translate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_translate.zzv;
import com.google.android.gms.internal.mlkit_translate.zzy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public class TranslateLanguage {
    @NonNull
    public static final String AFRIKAANS = "af";
    @NonNull
    public static final String ALBANIAN = "sq";
    @NonNull
    public static final String ARABIC = "ar";
    @NonNull
    public static final String BELARUSIAN = "be";
    @NonNull
    public static final String BENGALI = "bn";
    @NonNull
    public static final String BULGARIAN = "bg";
    @NonNull
    public static final String CATALAN = "ca";
    @NonNull
    public static final String CHINESE = "zh";
    @NonNull
    public static final String CROATIAN = "hr";
    @NonNull
    public static final String CZECH = "cs";
    @NonNull
    public static final String DANISH = "da";
    @NonNull
    public static final String DUTCH = "nl";
    @NonNull
    public static final String ENGLISH = "en";
    @NonNull
    public static final String ESPERANTO = "eo";
    @NonNull
    public static final String ESTONIAN = "et";
    @NonNull
    public static final String FINNISH = "fi";
    @NonNull
    public static final String FRENCH = "fr";
    @NonNull
    public static final String GALICIAN = "gl";
    @NonNull
    public static final String GEORGIAN = "ka";
    @NonNull
    public static final String GERMAN = "de";
    @NonNull
    public static final String GREEK = "el";
    @NonNull
    public static final String GUJARATI = "gu";
    @NonNull
    public static final String HAITIAN_CREOLE = "ht";
    @NonNull
    public static final String HINDI = "hi";
    @NonNull
    public static final String HUNGARIAN = "hu";
    @NonNull
    public static final String ICELANDIC = "is";
    @NonNull
    public static final String INDONESIAN = "id";
    @NonNull
    public static final String IRISH = "ga";
    @NonNull
    public static final String ITALIAN = "it";
    @NonNull
    public static final String JAPANESE = "ja";
    @NonNull
    public static final String KANNADA = "kn";
    @NonNull
    public static final String KOREAN = "ko";
    @NonNull
    public static final String LATVIAN = "lv";
    @NonNull
    public static final String LITHUANIAN = "lt";
    @NonNull
    public static final String MACEDONIAN = "mk";
    @NonNull
    public static final String MALAY = "ms";
    @NonNull
    public static final String MALTESE = "mt";
    @NonNull
    public static final String MARATHI = "mr";
    @NonNull
    public static final String PERSIAN = "fa";
    @NonNull
    public static final String POLISH = "pl";
    @NonNull
    public static final String PORTUGUESE = "pt";
    @NonNull
    public static final String ROMANIAN = "ro";
    @NonNull
    public static final String RUSSIAN = "ru";
    @NonNull
    public static final String SLOVAK = "sk";
    @NonNull
    public static final String SLOVENIAN = "sl";
    @NonNull
    public static final String SPANISH = "es";
    @NonNull
    public static final String SWAHILI = "sw";
    @NonNull
    public static final String SWEDISH = "sv";
    @NonNull
    public static final String TAGALOG = "tl";
    @NonNull
    public static final String TAMIL = "ta";
    @NonNull
    public static final String TELUGU = "te";
    @NonNull
    public static final String THAI = "th";
    @NonNull
    public static final String TURKISH = "tr";
    @NonNull
    public static final String UKRAINIAN = "uk";
    @NonNull
    public static final String URDU = "ur";
    @NonNull
    public static final String VIETNAMESE = "vi";
    @NonNull
    public static final String WELSH = "cy";
    @NonNull
    public static final String HEBREW = "he";
    @NonNull
    public static final String NORWEGIAN = "no";

    /* renamed from: a  reason: collision with root package name */
    private static final zzy f33052a = zzy.zze("iw", HEBREW, "in", "id", "nb", NORWEGIAN);

    /* compiled from: com.google.mlkit:translate@@17.0.1 */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes5.dex */
    public @interface Language {
    }

    private TranslateLanguage() {
    }

    @Nullable
    @Language
    public static String fromLanguageTag(@NonNull String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        zzy zzyVar = f33052a;
        if (zzyVar.containsKey(lowerCase)) {
            return (String) zzyVar.get(lowerCase);
        }
        if (!getAllLanguages().contains(lowerCase)) {
            return null;
        }
        return lowerCase;
    }

    @NonNull
    public static List<String> getAllLanguages() {
        return zzv.zzj(new String[]{AFRIKAANS, ALBANIAN, ARABIC, BELARUSIAN, BULGARIAN, BENGALI, CATALAN, CHINESE, CROATIAN, CZECH, DANISH, DUTCH, "en", ESPERANTO, ESTONIAN, FINNISH, FRENCH, GALICIAN, GEORGIAN, GERMAN, GREEK, GUJARATI, HAITIAN_CREOLE, HEBREW, HINDI, HUNGARIAN, ICELANDIC, "id", IRISH, ITALIAN, JAPANESE, KANNADA, KOREAN, LITHUANIAN, LATVIAN, MACEDONIAN, MARATHI, MALAY, MALTESE, NORWEGIAN, PERSIAN, POLISH, PORTUGUESE, ROMANIAN, RUSSIAN, SLOVAK, SLOVENIAN, SPANISH, SWEDISH, SWAHILI, TAGALOG, TAMIL, TELUGU, THAI, TURKISH, UKRAINIAN, URDU, VIETNAMESE, WELSH});
    }

    @NonNull
    public static String zza(@NonNull @Language String str) {
        if (str.equals(HEBREW)) {
            return "iw";
        }
        return str;
    }
}
