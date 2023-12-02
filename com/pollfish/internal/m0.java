package com.pollfish.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import androidx.core.os.EnvironmentCompat;
import com.arlosoft.macrodroid.geofences.GeofenceInfo;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class m0 implements l0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f37077a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f37078b;

    public m0(@NotNull Context context) {
        String str;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f37077a = weakReference;
        Context context2 = weakReference.get();
        String str2 = null;
        if (context2 != null) {
            try {
                str = WebSettings.getDefaultUserAgent(context2);
            } catch (Exception unused) {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
        }
        this.f37078b = str2;
    }

    public static boolean f() {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        boolean contains$default7;
        boolean startsWith$default3;
        boolean startsWith$default4;
        boolean equals;
        try {
            String str = Build.FINGERPRINT;
            startsWith$default = kotlin.text.m.startsWith$default(str, GeofenceInfo.GEOFENCE_GENERIC_ID, false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = kotlin.text.m.startsWith$default(str, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, null);
                if (startsWith$default2) {
                    return true;
                }
                String str2 = Build.MODEL;
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "google_sdk", false, 2, (Object) null);
                if (!contains$default) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "Emulator", false, 2, (Object) null);
                    if (!contains$default2) {
                        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "Android SDK built for x86", false, 2, (Object) null);
                        if (!contains$default3) {
                            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) Build.MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null);
                            if (contains$default4) {
                                return true;
                            }
                            String str3 = Build.PRODUCT;
                            if (!str3.equals("sdk")) {
                                contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "_sdk", false, 2, (Object) null);
                                if (!contains$default5) {
                                    contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "sdk_", false, 2, (Object) null);
                                    if (!contains$default6 && !new Regex(".*_?sdk_?.*").matches(str3)) {
                                        contains$default7 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "google_sdk", false, 2, (Object) null);
                                        if (!contains$default7) {
                                            startsWith$default3 = kotlin.text.m.startsWith$default(Build.BRAND, GeofenceInfo.GEOFENCE_GENERIC_ID, false, 2, null);
                                            if (!startsWith$default3) {
                                                startsWith$default4 = kotlin.text.m.startsWith$default(Build.DEVICE, GeofenceInfo.GEOFENCE_GENERIC_ID, false, 2, null);
                                                if (!startsWith$default4) {
                                                    equals = kotlin.text.m.equals(Build.HARDWARE, "goldfish", true);
                                                    if (equals) {
                                                        return true;
                                                    }
                                                    return false;
                                                }
                                                return true;
                                            }
                                            return true;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void a(@NotNull Context context) {
        this.f37077a = new WeakReference<>(context);
    }

    @Override // com.pollfish.internal.l0
    public final int b() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.pollfish.internal.l0
    @NotNull
    public final String c() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(new Date());
        } catch (Exception unused) {
            return String.valueOf(new Date().getTime());
        }
    }

    @Override // com.pollfish.internal.l0
    @NotNull
    public final String d() {
        return String.valueOf(new Date().getTime()).substring(0, 13);
    }

    @Override // com.pollfish.internal.l0
    @Nullable
    public final String e() {
        String languageTag;
        LocaleList locales;
        Locale locale;
        Context context = this.f37077a.get();
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    locales = context.getResources().getConfiguration().getLocales();
                    locale = locales.get(0);
                    languageTag = locale.toLanguageTag();
                } else {
                    languageTag = context.getResources().getConfiguration().locale.toLanguageTag();
                }
                return languageTag;
            } catch (NoSuchMethodError unused) {
                return Locale.getDefault().getLanguage();
            }
        }
        return null;
    }

    public final boolean g() {
        Context context = this.f37077a.get();
        if (context == null) {
            return false;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt != null && (childAt instanceof ViewGroup)) {
                    return ((ViewGroup) childAt).isHardwareAccelerated();
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(76:1|(3:273|274|(1:276)(76:277|278|279|4|5|6|7|8|(3:263|264|(67:266|11|(5:252|253|(2:257|(64:259|14|(5:241|242|(2:246|(61:248|17|(5:233|234|(2:236|237)|239|237)(1:19)|20|(5:223|224|(1:226)(1:231)|227|(56:229|23|(3:217|218|(53:220|26|(1:28)(1:216)|(1:30)(1:215)|31|32|(1:34)(1:212)|35|(4:37|(1:39)(1:210)|40|(44:42|43|(2:45|(2:47|(2:49|(1:51)(1:189))(4:190|(3:192|(2:194|(2:196|(1:201)(2:198|199))(1:202))(2:203|204)|200)|205|206))(1:207))(1:208)|188|(1:54)(1:187)|55|(1:57)(1:186)|58|(36:182|183|61|(5:172|173|(1:175)(1:180)|176|(32:178|64|(5:162|163|(1:165)(1:170)|166|(29:168|67|(5:149|150|(1:152)(2:157|(1:159)(1:160))|153|(26:155|70|(5:139|140|(2:144|145)|147|145)(1:72)|73|74|75|76|77|(3:79|(1:81)(1:133)|(17:83|84|(4:122|123|(3:125|(1:127)|128)(1:131)|(14:130|87|(14:89|(1:120)(1:93)|(1:97)(1:(1:119))|98|99|100|101|102|103|(1:105)(1:113)|106|(1:108)(1:112)|109|110)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))(1:211)|209|43|(0)(0)|188|(0)(0)|55|(0)(0)|58|(0)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|25|26|(0)(0)|(0)(0)|31|32|(0)(0)|35|(0)(0)|209|43|(0)(0)|188|(0)(0)|55|(0)(0)|58|(0)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|22|23|(0)|25|26|(0)(0)|(0)(0)|31|32|(0)(0)|35|(0)(0)|209|43|(0)(0)|188|(0)(0)|55|(0)(0)|58|(0)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|250|(0))|16|17|(0)(0)|20|(0)|22|23|(0)|25|26|(0)(0)|(0)(0)|31|32|(0)(0)|35|(0)(0)|209|43|(0)(0)|188|(0)(0)|55|(0)(0)|58|(0)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|261|(0))|13|14|(0)|16|17|(0)(0)|20|(0)|22|23|(0)|25|26|(0)(0)|(0)(0)|31|32|(0)(0)|35|(0)(0)|209|43|(0)(0)|188|(0)(0)|55|(0)(0)|58|(0)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|10|11|(0)|13|14|(0)|16|17|(0)(0)|20|(0)|22|23|(0)|25|26|(0)(0)|(0)(0)|31|32|(0)(0)|35|(0)(0)|209|43|(0)(0)|188|(0)(0)|55|(0)(0)|58|(0)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110))|3|4|5|6|7|8|(0)|10|11|(0)|13|14|(0)|16|17|(0)(0)|20|(0)|22|23|(0)|25|26|(0)(0)|(0)(0)|31|32|(0)(0)|35|(0)(0)|209|43|(0)(0)|188|(0)(0)|55|(0)(0)|58|(0)|60|61|(0)|63|64|(0)|66|67|(0)|69|70|(0)(0)|73|74|75|76|77|(0)|135|84|(0)|86|87|(0)|121|99|100|101|102|103|(0)(0)|106|(0)(0)|109|110) */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0207, code lost:
        if (r9 == 0) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        r6 = androidx.core.os.EnvironmentCompat.MEDIA_UNKNOWN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0336, code lost:
        r36 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x03f0, code lost:
        r42 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x014a, code lost:
        r5 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x033c A[Catch: Exception -> 0x034a, TRY_LEAVE, TryCatch #3 {Exception -> 0x034a, blocks: (B:207:0x0338, B:209:0x033c), top: B:274:0x0338 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0283 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x035b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0313 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x02ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0151  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:267:0x0033 -> B:12:0x0033). Please submit an issue!!! */
    @Override // com.pollfish.internal.l0
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.pollfish.internal.k0 a() {
        /*
            Method dump skipped, instructions count: 1138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.m0.a():com.pollfish.internal.k0");
    }
}
