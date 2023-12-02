package com.github.javiersantos.piracychecker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.github.javiersantos.licensing.AESObfuscator;
import com.github.javiersantos.licensing.LibraryChecker;
import com.github.javiersantos.licensing.LibraryCheckerCallback;
import com.github.javiersantos.licensing.ServerManagedPolicy;
import com.github.javiersantos.piracychecker.callbacks.AllowCallback;
import com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback;
import com.github.javiersantos.piracychecker.callbacks.OnErrorCallback;
import com.github.javiersantos.piracychecker.callbacks.PiracyCheckerCallback;
import com.github.javiersantos.piracychecker.enums.AppType;
import com.github.javiersantos.piracychecker.enums.Display;
import com.github.javiersantos.piracychecker.enums.InstallerID;
import com.github.javiersantos.piracychecker.enums.PiracyCheckerError;
import com.github.javiersantos.piracychecker.enums.PirateApp;
import com.github.javiersantos.piracychecker.utils.LibraryUtilsKt;
import com.github.javiersantos.piracychecker.utils.SaltUtils;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PiracyChecker.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002\u0088\u0001B+\u0012\b\u0010u\u001a\u0004\u0018\u00010r\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001B\u0015\b\u0016\u0012\b\u0010u\u001a\u0004\u0018\u00010r¢\u0006\u0006\b\u0080\u0001\u0010\u0082\u0001B \b\u0016\u0012\b\u0010u\u001a\u0004\u0018\u00010r\u0012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0006\b\u0080\u0001\u0010\u0084\u0001B \b\u0016\u0012\b\u0010u\u001a\u0004\u0018\u00010r\u0012\t\b\u0001\u0010\u0083\u0001\u001a\u000200¢\u0006\u0006\b\u0080\u0001\u0010\u0085\u0001B+\b\u0016\u0012\b\u0010u\u001a\u0004\u0018\u00010r\u0012\t\b\u0001\u0010\u0083\u0001\u001a\u000200\u0012\t\b\u0001\u0010\u0086\u0001\u001a\u000200¢\u0006\u0006\b\u0080\u0001\u0010\u0087\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J!\u0010\u0018\u001a\u00020\u00002\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0016\"\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0018\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aJ!\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u0016\"\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0000J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0006J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0000J\u0006\u0010#\u001a\u00020\u0000J\u0006\u0010$\u001a\u00020\u0000J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u0000J!\u0010*\u001a\u00020\u00002\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0\u0016\"\u00020(¢\u0006\u0004\b*\u0010+J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010,\u001a\u00020(J\u0016\u0010-\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0006J\u0016\u0010-\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.J\"\u00104\u001a\u00020\u00002\b\b\u0001\u00101\u001a\u0002002\b\b\u0001\u00102\u001a\u0002002\u0006\u00103\u001a\u00020\nJ\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u00105\u001a\u000200J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000207J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u000209J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020;J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020>J\u0006\u0010@\u001a\u00020\u0004J\u0006\u0010A\u001a\u00020\u0004R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010BR\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010CR\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010CR\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010DR\u0016\u0010E\u001a\u0002008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010CR\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010DR\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010DR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010DR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010DR\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010DR\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010DR\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010DR\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010DR\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010DR\u0016\u0010N\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010DR\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010DR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010TR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020(0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR$\u0010{\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010T\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010\u007f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010T\u001a\u0004\b}\u0010x\"\u0004\b~\u0010z¨\u0006\u0089\u0001"}, d2 = {"Lcom/github/javiersantos/piracychecker/PiracyChecker;", "", "Landroid/content/SharedPreferences;", "preferences", "", "d", "", "preferencesName", "e", "f", "", "h", "g", "i", "possibleSuccess", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "b", "a", "licenseKeyBase64", "enableGooglePlayLicensing", "signature", "enableSigningCertificate", "", "signatures", "enableSigningCertificates", "([Ljava/lang/String;)Lcom/github/javiersantos/piracychecker/PiracyChecker;", "", "Lcom/github/javiersantos/piracychecker/enums/InstallerID;", "installerID", "enableInstallerId", "([Lcom/github/javiersantos/piracychecker/enums/InstallerID;)Lcom/github/javiersantos/piracychecker/PiracyChecker;", "enableUnauthorizedAppsCheck", "preferenceName", "blockIfUnauthorizedAppUninstalled", "enableStoresCheck", "enableDebugCheck", "enableAPKCheck", "deepCheck", "enableEmulatorCheck", "enableFoldersCheck", "Lcom/github/javiersantos/piracychecker/enums/PirateApp;", "apps", "addAppToCheck", "([Lcom/github/javiersantos/piracychecker/enums/PirateApp;)Lcom/github/javiersantos/piracychecker/PiracyChecker;", "app", "saveResultToSharedPreferences", "Lcom/github/javiersantos/piracychecker/enums/Display;", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "", "colorPrimary", "colorPrimaryDark", "withLightStatusBar", "withActivityColors", "layout", "withActivityLayout", "Lcom/github/javiersantos/piracychecker/callbacks/AllowCallback;", "allowCallback", "Lcom/github/javiersantos/piracychecker/callbacks/DoNotAllowCallback;", "doNotAllowCallback", "Lcom/github/javiersantos/piracychecker/callbacks/OnErrorCallback;", "errorCallback", "onErrorCallback", "Lcom/github/javiersantos/piracychecker/callbacks/PiracyCheckerCallback;", "callback", "destroy", "start", "Lcom/github/javiersantos/piracychecker/enums/Display;", "I", "Z", "layoutXML", "enableLVL", "j", "k", "enableDeepEmulatorCheck", "l", "m", "n", "o", "saveToSharedPreferences", "p", "blockUnauthorized", "q", "Landroid/content/SharedPreferences;", "r", "Ljava/lang/String;", "preferenceSaveResult", "s", "preferenceBlockUnauthorized", "t", "licenseBase64", "u", "[Ljava/lang/String;", "", RegisterSpec.PREFIX, "Ljava/util/List;", "installerIDs", "Ljava/util/ArrayList;", "w", "Ljava/util/ArrayList;", "extraApps", "x", "Lcom/github/javiersantos/piracychecker/callbacks/AllowCallback;", "y", "Lcom/github/javiersantos/piracychecker/callbacks/DoNotAllowCallback;", "z", "Lcom/github/javiersantos/piracychecker/callbacks/OnErrorCallback;", "Lcom/github/javiersantos/licensing/LibraryChecker;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/github/javiersantos/licensing/LibraryChecker;", "libraryLVLChecker", "Lcom/github/javiersantos/piracychecker/PiracyCheckerDialog;", "B", "Lcom/github/javiersantos/piracychecker/PiracyCheckerDialog;", "dialog", "Landroid/content/Context;", "C", "Landroid/content/Context;", "context", "D", "getUnlicensedDialogTitle", "()Ljava/lang/String;", "setUnlicensedDialogTitle", "(Ljava/lang/String;)V", "unlicensedDialogTitle", ExifInterface.LONGITUDE_EAST, "getUnlicensedDialogDescription", "setUnlicensedDialogDescription", "unlicensedDialogDescription", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/content/Context;)V", "title", "(Landroid/content/Context;Ljava/lang/String;)V", "(Landroid/content/Context;I)V", "description", "(Landroid/content/Context;II)V", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"HardwareIds"})
/* loaded from: classes3.dex */
public final class PiracyChecker {
    public static final Companion Companion = new Companion(null);
    private LibraryChecker A;
    private PiracyCheckerDialog B;
    private Context C;
    @Nullable
    private String D;
    @Nullable
    private String E;

    /* renamed from: a  reason: collision with root package name */
    private Display f18413a;
    @ColorRes

    /* renamed from: b  reason: collision with root package name */
    private int f18414b;
    @ColorRes

    /* renamed from: c  reason: collision with root package name */
    private int f18415c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18416d;
    @LayoutRes

    /* renamed from: e  reason: collision with root package name */
    private int f18417e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18418f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18419g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18420h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18421i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18422j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18423k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18424l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18425m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f18426n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f18427o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f18428p;

    /* renamed from: q  reason: collision with root package name */
    private SharedPreferences f18429q;

    /* renamed from: r  reason: collision with root package name */
    private String f18430r;

    /* renamed from: s  reason: collision with root package name */
    private String f18431s;

    /* renamed from: t  reason: collision with root package name */
    private String f18432t;

    /* renamed from: u  reason: collision with root package name */
    private String[] f18433u;

    /* renamed from: v  reason: collision with root package name */
    private final List<InstallerID> f18434v;

    /* renamed from: w  reason: collision with root package name */
    private final ArrayList<PirateApp> f18435w;

    /* renamed from: x  reason: collision with root package name */
    private AllowCallback f18436x;

    /* renamed from: y  reason: collision with root package name */
    private DoNotAllowCallback f18437y;

    /* renamed from: z  reason: collision with root package name */
    private OnErrorCallback f18438z;

    /* compiled from: PiracyChecker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/github/javiersantos/piracychecker/PiracyChecker$Companion;", "", "()V", "LIBRARY_PREFERENCES_NAME", "", "library_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PiracyChecker(@Nullable Context context, @Nullable String str, @Nullable String str2) {
        this.C = context;
        this.D = str;
        this.E = str2;
        this.f18417e = -1;
        this.f18433u = new String[0];
        this.f18413a = Display.DIALOG;
        this.f18434v = new ArrayList();
        this.f18435w = new ArrayList<>();
        this.f18414b = R.color.colorPrimary;
        this.f18415c = R.color.colorPrimaryDark;
    }

    private final void a() {
        LibraryChecker libraryChecker = this.A;
        if (libraryChecker != null) {
            libraryChecker.finishAllChecks();
        }
        LibraryChecker libraryChecker2 = this.A;
        if (libraryChecker2 != null) {
            libraryChecker2.onDestroy();
        }
        this.A = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        PiracyCheckerDialog piracyCheckerDialog = this.B;
        if (piracyCheckerDialog != null) {
            piracyCheckerDialog.dismiss();
        }
        this.B = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean z3) {
        PirateApp pirateApp;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        PiracyCheckerError piracyCheckerError;
        SharedPreferences sharedPreferences2;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor putBoolean2;
        SharedPreferences sharedPreferences3;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor putBoolean3;
        SharedPreferences sharedPreferences4;
        SharedPreferences.Editor edit4;
        SharedPreferences.Editor putBoolean4;
        PiracyCheckerError piracyCheckerError2;
        SharedPreferences sharedPreferences5;
        SharedPreferences.Editor edit5;
        SharedPreferences.Editor putBoolean5;
        SharedPreferences sharedPreferences6;
        SharedPreferences.Editor edit6;
        SharedPreferences.Editor putBoolean6;
        SharedPreferences sharedPreferences7;
        SharedPreferences.Editor edit7;
        SharedPreferences.Editor putBoolean7;
        Context context;
        SharedPreferences sharedPreferences8;
        SharedPreferences.Editor edit8;
        SharedPreferences.Editor putBoolean8;
        Context context2 = this.C;
        if (context2 != null) {
            pirateApp = LibraryUtilsKt.getPirateApp(context2, this.f18420h, this.f18421i, this.f18425m, this.f18426n, this.f18435w);
        } else {
            pirateApp = null;
        }
        if (z3) {
            if (this.f18424l && (context = this.C) != null && LibraryUtilsKt.isDebug(context)) {
                if (this.f18427o && (sharedPreferences8 = this.f18429q) != null && (edit8 = sharedPreferences8.edit()) != null && (putBoolean8 = edit8.putBoolean(this.f18430r, false)) != null) {
                    putBoolean8.apply();
                }
                DoNotAllowCallback doNotAllowCallback = this.f18437y;
                if (doNotAllowCallback != null) {
                    doNotAllowCallback.doNotAllow(PiracyCheckerError.USING_DEBUG_APP, null);
                }
            } else if (this.f18422j && LibraryUtilsKt.isInEmulator(this.f18423k)) {
                if (this.f18427o && (sharedPreferences7 = this.f18429q) != null && (edit7 = sharedPreferences7.edit()) != null && (putBoolean7 = edit7.putBoolean(this.f18430r, false)) != null) {
                    putBoolean7.apply();
                }
                DoNotAllowCallback doNotAllowCallback2 = this.f18437y;
                if (doNotAllowCallback2 != null) {
                    doNotAllowCallback2.doNotAllow(PiracyCheckerError.USING_APP_IN_EMULATOR, null);
                }
            } else if (pirateApp != null) {
                if (this.f18427o && (sharedPreferences6 = this.f18429q) != null && (edit6 = sharedPreferences6.edit()) != null && (putBoolean6 = edit6.putBoolean(this.f18430r, false)) != null) {
                    putBoolean6.apply();
                }
                if (this.f18428p && pirateApp.getType() == AppType.PIRATE && (sharedPreferences5 = this.f18429q) != null && (edit5 = sharedPreferences5.edit()) != null && (putBoolean5 = edit5.putBoolean(this.f18431s, true)) != null) {
                    putBoolean5.apply();
                }
                DoNotAllowCallback doNotAllowCallback3 = this.f18437y;
                if (doNotAllowCallback3 != null) {
                    if (pirateApp.getType() == AppType.STORE) {
                        piracyCheckerError2 = PiracyCheckerError.THIRD_PARTY_STORE_INSTALLED;
                    } else {
                        piracyCheckerError2 = PiracyCheckerError.PIRATE_APP_INSTALLED;
                    }
                    doNotAllowCallback3.doNotAllow(piracyCheckerError2, pirateApp);
                }
            } else {
                if (this.f18427o && (sharedPreferences4 = this.f18429q) != null && (edit4 = sharedPreferences4.edit()) != null && (putBoolean4 = edit4.putBoolean(this.f18430r, true)) != null) {
                    putBoolean4.apply();
                }
                AllowCallback allowCallback = this.f18436x;
                if (allowCallback != null) {
                    allowCallback.allow();
                }
            }
        } else if (pirateApp != null) {
            if (this.f18427o && (sharedPreferences3 = this.f18429q) != null && (edit3 = sharedPreferences3.edit()) != null && (putBoolean3 = edit3.putBoolean(this.f18430r, false)) != null) {
                putBoolean3.apply();
            }
            if (this.f18428p && pirateApp.getType() == AppType.PIRATE && (sharedPreferences2 = this.f18429q) != null && (edit2 = sharedPreferences2.edit()) != null && (putBoolean2 = edit2.putBoolean(this.f18431s, true)) != null) {
                putBoolean2.apply();
            }
            DoNotAllowCallback doNotAllowCallback4 = this.f18437y;
            if (doNotAllowCallback4 != null) {
                if (pirateApp.getType() == AppType.STORE) {
                    piracyCheckerError = PiracyCheckerError.THIRD_PARTY_STORE_INSTALLED;
                } else {
                    piracyCheckerError = PiracyCheckerError.PIRATE_APP_INSTALLED;
                }
                doNotAllowCallback4.doNotAllow(piracyCheckerError, pirateApp);
            }
        } else {
            if (this.f18427o && (sharedPreferences = this.f18429q) != null && (edit = sharedPreferences.edit()) != null && (putBoolean = edit.putBoolean(this.f18430r, false)) != null) {
                putBoolean.apply();
            }
            DoNotAllowCallback doNotAllowCallback5 = this.f18437y;
            if (doNotAllowCallback5 != null) {
                doNotAllowCallback5.doNotAllow(PiracyCheckerError.NOT_LICENSED, null);
            }
        }
    }

    private final void d(SharedPreferences sharedPreferences) {
        SharedPreferences sharedPreferences2;
        if (sharedPreferences != null) {
            this.f18429q = sharedPreferences;
            return;
        }
        SharedPreferences sharedPreferences3 = null;
        try {
            Context context = this.C;
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                sharedPreferences2 = activity.getPreferences(0);
            } else {
                sharedPreferences2 = null;
            }
            this.f18429q = sharedPreferences2;
        } catch (Exception unused) {
            Context context2 = this.C;
            if (context2 != null) {
                sharedPreferences3 = context2.getSharedPreferences("license_check", 0);
            }
            this.f18429q = sharedPreferences3;
        }
    }

    private final void e(String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2 = null;
        if (str != null) {
            Context context = this.C;
            if (context != null) {
                sharedPreferences2 = context.getSharedPreferences(str, 0);
            }
            this.f18429q = sharedPreferences2;
            return;
        }
        try {
            Context context2 = this.C;
            if (!(context2 instanceof Activity)) {
                context2 = null;
            }
            Activity activity = (Activity) context2;
            if (activity != null) {
                sharedPreferences = activity.getPreferences(0);
            } else {
                sharedPreferences = null;
            }
            this.f18429q = sharedPreferences;
        } catch (Exception unused) {
            Context context3 = this.C;
            if (context3 != null) {
                sharedPreferences2 = context3.getSharedPreferences("license_check", 0);
            }
            this.f18429q = sharedPreferences2;
        }
    }

    private final void f() {
        ContentResolver contentResolver;
        String str = null;
        if (!h()) {
            DoNotAllowCallback doNotAllowCallback = this.f18437y;
            if (doNotAllowCallback != null) {
                doNotAllowCallback.doNotAllow(PiracyCheckerError.SIGNATURE_NOT_VALID, null);
            }
        } else if (!g()) {
            DoNotAllowCallback doNotAllowCallback2 = this.f18437y;
            if (doNotAllowCallback2 != null) {
                doNotAllowCallback2.doNotAllow(PiracyCheckerError.INVALID_INSTALLER_ID, null);
            }
        } else if (!i()) {
            DoNotAllowCallback doNotAllowCallback3 = this.f18437y;
            if (doNotAllowCallback3 != null) {
                doNotAllowCallback3.doNotAllow(PiracyCheckerError.BLOCK_PIRATE_APP, null);
            }
        } else if (this.f18418f) {
            Context context = this.C;
            if (context != null) {
                contentResolver = context.getContentResolver();
            } else {
                contentResolver = null;
            }
            String string = Settings.Secure.getString(contentResolver, "android_id");
            a();
            Context context2 = this.C;
            byte[] salt = SaltUtils.INSTANCE.getSalt(this.C);
            Context context3 = this.C;
            if (context3 != null) {
                str = context3.getPackageName();
            }
            LibraryChecker libraryChecker = new LibraryChecker(context2, new ServerManagedPolicy(context2, new AESObfuscator(salt, str, string)), this.f18432t);
            this.A = libraryChecker;
            libraryChecker.checkAccess(new LibraryCheckerCallback() { // from class: com.github.javiersantos.piracychecker.PiracyChecker$verify$1
                @Override // com.github.javiersantos.licensing.LibraryCheckerCallback
                public void allow(int i4) {
                    PiracyChecker.this.c(true);
                }

                @Override // com.github.javiersantos.licensing.LibraryCheckerCallback
                public void applicationError(int i4) {
                    OnErrorCallback onErrorCallback;
                    onErrorCallback = PiracyChecker.this.f18438z;
                    if (onErrorCallback != null) {
                        onErrorCallback.onError(PiracyCheckerError.Companion.getCheckerErrorFromCode(i4));
                    }
                }

                @Override // com.github.javiersantos.licensing.LibraryCheckerCallback
                public void dontAllow(int i4) {
                    PiracyChecker.this.c(false);
                }
            });
        } else {
            c(true);
        }
    }

    private final boolean g() {
        if (this.f18434v.isEmpty()) {
            return true;
        }
        Context context = this.C;
        if (context != null && LibraryUtilsKt.verifyInstallerId(context, this.f18434v)) {
            return true;
        }
        return false;
    }

    private final boolean h() {
        if (!this.f18419g) {
            return true;
        }
        Context context = this.C;
        if (context != null && LibraryUtilsKt.verifySigningCertificates(context, this.f18433u)) {
            return true;
        }
        return false;
    }

    private final boolean i() {
        boolean z3;
        if (this.f18428p) {
            SharedPreferences sharedPreferences = this.f18429q;
            if (sharedPreferences != null) {
                z3 = sharedPreferences.getBoolean(this.f18431s, false);
            } else {
                z3 = false;
            }
            if (z3) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final PiracyChecker addAppToCheck(@NotNull PirateApp... apps) {
        Intrinsics.checkParameterIsNotNull(apps, "apps");
        this.f18435w.addAll(Arrays.asList((PirateApp[]) Arrays.copyOf(apps, apps.length)));
        return this;
    }

    @NotNull
    public final PiracyChecker allowCallback(@NotNull AllowCallback allowCallback) {
        Intrinsics.checkParameterIsNotNull(allowCallback, "allowCallback");
        this.f18436x = allowCallback;
        return this;
    }

    @NotNull
    public final PiracyChecker blockIfUnauthorizedAppUninstalled(@NotNull SharedPreferences preferences, @NotNull String preferenceName) {
        Intrinsics.checkParameterIsNotNull(preferences, "preferences");
        Intrinsics.checkParameterIsNotNull(preferenceName, "preferenceName");
        this.f18428p = true;
        this.f18431s = preferenceName;
        d(preferences);
        return this;
    }

    @NotNull
    public final PiracyChecker callback(@NotNull final PiracyCheckerCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.f18436x = new AllowCallback() { // from class: com.github.javiersantos.piracychecker.PiracyChecker$callback$1
            @Override // com.github.javiersantos.piracychecker.callbacks.AllowCallback
            public void allow() {
                PiracyCheckerCallback.this.allow();
            }
        };
        this.f18437y = new DoNotAllowCallback() { // from class: com.github.javiersantos.piracychecker.PiracyChecker$callback$2
            @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
            public void doNotAllow(@NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                PiracyCheckerCallback.this.doNotAllow(error, pirateApp);
            }

            @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
            @Deprecated(message = "dontAllow has been deprecated in favor of doNotAllow", replaceWith = @ReplaceWith(expression = "doNotAllow", imports = {}))
            public void dontAllow(@NotNull PiracyCheckerError error, @Nullable PirateApp pirateApp) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                DoNotAllowCallback.DefaultImpls.dontAllow(this, error, pirateApp);
            }
        };
        this.f18438z = new OnErrorCallback() { // from class: com.github.javiersantos.piracychecker.PiracyChecker$callback$3
            @Override // com.github.javiersantos.piracychecker.callbacks.OnErrorCallback
            public void onError(@NotNull PiracyCheckerError error) {
                Intrinsics.checkParameterIsNotNull(error, "error");
                OnErrorCallback.DefaultImpls.onError(this, error);
                PiracyCheckerCallback.this.onError(error);
            }
        };
        return this;
    }

    public final void destroy() {
        b();
        a();
        this.C = null;
    }

    @NotNull
    public final PiracyChecker display(@NotNull Display display) {
        Intrinsics.checkParameterIsNotNull(display, "display");
        this.f18413a = display;
        return this;
    }

    @NotNull
    public final PiracyChecker doNotAllowCallback(@NotNull DoNotAllowCallback doNotAllowCallback) {
        Intrinsics.checkParameterIsNotNull(doNotAllowCallback, "doNotAllowCallback");
        this.f18437y = doNotAllowCallback;
        return this;
    }

    @NotNull
    public final PiracyChecker enableAPKCheck() {
        this.f18426n = true;
        return this;
    }

    @NotNull
    public final PiracyChecker enableDebugCheck() {
        this.f18424l = true;
        return this;
    }

    @NotNull
    public final PiracyChecker enableEmulatorCheck(boolean z3) {
        this.f18422j = true;
        this.f18423k = z3;
        return this;
    }

    @NotNull
    public final PiracyChecker enableFoldersCheck() {
        this.f18425m = true;
        return this;
    }

    @NotNull
    public final PiracyChecker enableGooglePlayLicensing(@NotNull String licenseKeyBase64) {
        Intrinsics.checkParameterIsNotNull(licenseKeyBase64, "licenseKeyBase64");
        this.f18418f = true;
        this.f18432t = licenseKeyBase64;
        return this;
    }

    @NotNull
    public final PiracyChecker enableInstallerId(@NotNull InstallerID... installerID) {
        List listOf;
        Intrinsics.checkParameterIsNotNull(installerID, "installerID");
        List<InstallerID> list = this.f18434v;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) ((InstallerID[]) Arrays.copyOf(installerID, installerID.length)));
        list.addAll(listOf);
        return this;
    }

    @Deprecated(message = "Deprecated in favor of enableSigningCertificates so you can check for multiple signatures", replaceWith = @ReplaceWith(expression = "enableSigningCertificates(signature)", imports = {}))
    @NotNull
    public final PiracyChecker enableSigningCertificate(@NotNull String signature) {
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        this.f18419g = true;
        this.f18433u = new String[]{signature};
        return this;
    }

    @NotNull
    public final PiracyChecker enableSigningCertificates(@NotNull String... signatures) {
        Intrinsics.checkParameterIsNotNull(signatures, "signatures");
        this.f18419g = true;
        this.f18433u = (String[]) Arrays.copyOf(signatures, signatures.length);
        return this;
    }

    @NotNull
    public final PiracyChecker enableStoresCheck() {
        this.f18421i = true;
        return this;
    }

    @NotNull
    public final PiracyChecker enableUnauthorizedAppsCheck() {
        this.f18420h = true;
        return this;
    }

    @Nullable
    public final String getUnlicensedDialogDescription() {
        return this.E;
    }

    @Nullable
    public final String getUnlicensedDialogTitle() {
        return this.D;
    }

    @NotNull
    public final PiracyChecker onErrorCallback(@NotNull OnErrorCallback errorCallback) {
        Intrinsics.checkParameterIsNotNull(errorCallback, "errorCallback");
        this.f18438z = errorCallback;
        return this;
    }

    @NotNull
    public final PiracyChecker saveResultToSharedPreferences(@NotNull SharedPreferences preferences, @NotNull String preferenceName) {
        Intrinsics.checkParameterIsNotNull(preferences, "preferences");
        Intrinsics.checkParameterIsNotNull(preferenceName, "preferenceName");
        this.f18427o = true;
        this.f18430r = preferenceName;
        d(preferences);
        return this;
    }

    public final void setUnlicensedDialogDescription(@Nullable String str) {
        this.E = str;
    }

    public final void setUnlicensedDialogTitle(@Nullable String str) {
        this.D = str;
    }

    public final void start() {
        if (this.f18436x == null && this.f18437y == null) {
            callback(new PiracyCheckerCallback() { // from class: com.github.javiersantos.piracychecker.PiracyChecker$start$1
                /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
                    if (r6 != null) goto L18;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
                    r6 = "";
                 */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
                    if (r6 != null) goto L18;
                 */
                @Override // com.github.javiersantos.piracychecker.callbacks.DoNotAllowCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void doNotAllow(@org.jetbrains.annotations.NotNull com.github.javiersantos.piracychecker.enums.PiracyCheckerError r6, @org.jetbrains.annotations.Nullable com.github.javiersantos.piracychecker.enums.PirateApp r7) {
                    /*
                        Method dump skipped, instructions count: 276
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.PiracyChecker$start$1.doNotAllow(com.github.javiersantos.piracychecker.enums.PiracyCheckerError, com.github.javiersantos.piracychecker.enums.PirateApp):void");
                }

                @Override // com.github.javiersantos.piracychecker.callbacks.AllowCallback
                public void allow() {
                }
            });
        }
        f();
    }

    @NotNull
    public final PiracyChecker withActivityColors(@ColorRes int i4, @ColorRes int i5, boolean z3) {
        this.f18414b = i4;
        this.f18415c = i5;
        this.f18416d = z3;
        return this;
    }

    @NotNull
    public final PiracyChecker withActivityLayout(@LayoutRes int i4) {
        this.f18417e = i4;
        return this;
    }

    @NotNull
    public final PiracyChecker addAppToCheck(@NotNull PirateApp app) {
        Intrinsics.checkParameterIsNotNull(app, "app");
        this.f18435w.add(app);
        return this;
    }

    @NotNull
    public final PiracyChecker enableSigningCertificates(@NotNull List<String> signatures) {
        Intrinsics.checkParameterIsNotNull(signatures, "signatures");
        this.f18419g = true;
        Object[] array = signatures.toArray(new String[0]);
        if (array != null) {
            this.f18433u = (String[]) array;
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final PiracyChecker blockIfUnauthorizedAppUninstalled(@NotNull String preferencesName, @NotNull String preferenceName) {
        Intrinsics.checkParameterIsNotNull(preferencesName, "preferencesName");
        Intrinsics.checkParameterIsNotNull(preferenceName, "preferenceName");
        this.f18428p = true;
        this.f18431s = preferenceName;
        e(preferencesName);
        return this;
    }

    @NotNull
    public final PiracyChecker saveResultToSharedPreferences(@NotNull String preferencesName, @NotNull String preferenceName) {
        Intrinsics.checkParameterIsNotNull(preferencesName, "preferencesName");
        Intrinsics.checkParameterIsNotNull(preferenceName, "preferenceName");
        this.f18427o = true;
        this.f18430r = preferenceName;
        e(preferencesName);
        return this;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ PiracyChecker(android.content.Context r3, java.lang.String r4, java.lang.String r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = r6 & 2
            java.lang.String r0 = ""
            r1 = 0
            if (r7 == 0) goto L15
            if (r3 == 0) goto L10
            int r4 = com.github.javiersantos.piracychecker.R.string.app_unlicensed
            java.lang.String r4 = r3.getString(r4)
            goto L11
        L10:
            r4 = r1
        L11:
            if (r4 == 0) goto L14
            goto L15
        L14:
            r4 = r0
        L15:
            r6 = r6 & 4
            if (r6 == 0) goto L26
            if (r3 == 0) goto L21
            int r5 = com.github.javiersantos.piracychecker.R.string.app_unlicensed_description
            java.lang.String r1 = r3.getString(r5)
        L21:
            if (r1 == 0) goto L25
            r5 = r1
            goto L26
        L25:
            r5 = r0
        L26:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.PiracyChecker.<init>(android.content.Context, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PiracyChecker(@org.jetbrains.annotations.Nullable android.content.Context r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto La
            int r1 = com.github.javiersantos.piracychecker.R.string.app_unlicensed
            java.lang.String r1 = r4.getString(r1)
            goto Lb
        La:
            r1 = r0
        Lb:
            java.lang.String r2 = ""
            if (r1 == 0) goto L10
            goto L11
        L10:
            r1 = r2
        L11:
            if (r4 == 0) goto L19
            int r0 = com.github.javiersantos.piracychecker.R.string.app_unlicensed_description
            java.lang.String r0 = r4.getString(r0)
        L19:
            if (r0 == 0) goto L1c
            r2 = r0
        L1c:
            r3.<init>(r4, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.PiracyChecker.<init>(android.content.Context):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PiracyChecker(@org.jetbrains.annotations.Nullable android.content.Context r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            if (r4 == 0) goto L5
            goto L6
        L5:
            r4 = r0
        L6:
            if (r3 == 0) goto Lf
            int r1 = com.github.javiersantos.piracychecker.R.string.app_unlicensed_description
            java.lang.String r1 = r3.getString(r1)
            goto L10
        Lf:
            r1 = 0
        L10:
            if (r1 == 0) goto L13
            r0 = r1
        L13:
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.PiracyChecker.<init>(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PiracyChecker(@org.jetbrains.annotations.Nullable android.content.Context r2, @androidx.annotation.StringRes int r3) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            if (r3 == 0) goto Lf
            if (r2 == 0) goto Lb
            java.lang.String r3 = r2.getString(r3)
            goto Lc
        Lb:
            r3 = 0
        Lc:
            if (r3 == 0) goto Lf
            r0 = r3
        Lf:
            r1.<init>(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.PiracyChecker.<init>(android.content.Context, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r4 != null) goto L6;
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PiracyChecker(@org.jetbrains.annotations.Nullable android.content.Context r3, @androidx.annotation.StringRes int r4, @androidx.annotation.StringRes int r5) {
        /*
            r2 = this;
            r0 = 0
            java.lang.String r1 = ""
            if (r4 == 0) goto L10
            if (r3 == 0) goto Lc
            java.lang.String r4 = r3.getString(r4)
            goto Ld
        Lc:
            r4 = r0
        Ld:
            if (r4 == 0) goto L10
            goto L11
        L10:
            r4 = r1
        L11:
            if (r5 == 0) goto L1c
            if (r3 == 0) goto L19
            java.lang.String r0 = r3.getString(r5)
        L19:
            if (r0 == 0) goto L1c
            r1 = r0
        L1c:
            r2.<init>(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.PiracyChecker.<init>(android.content.Context, int, int):void");
    }
}
