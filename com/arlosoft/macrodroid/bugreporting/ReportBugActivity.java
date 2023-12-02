package com.arlosoft.macrodroid.bugreporting;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.bugreporting.model.BugReport;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.EventLogging;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.database.room.LogFlag;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.emailservice.EmailServiceKt;
import com.arlosoft.macrodroid.emailservice.sendgrid.SendGridResponse;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.DamnYouPirates;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroDeserializer;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.sparkpostutil.EmailListener;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostFile;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostRecipient;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostSender;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.api.client.util.Base64;
import com.jaredrummler.android.device.DeviceName;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.f;
import kotlin.text.m;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportBugActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nReportBugActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportBugActivity.kt\ncom/arlosoft/macrodroid/bugreporting/ReportBugActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,479:1\n1855#2,2:480\n*S KotlinDebug\n*F\n+ 1 ReportBugActivity.kt\ncom/arlosoft/macrodroid/bugreporting/ReportBugActivity\n*L\n350#1:480,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReportBugActivity extends MacroDroidDaggerBaseActivity {
    @Inject
    public ActionBlockStore actionBlockStore;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9560f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private BugReport f9561g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final SimpleDateFormat f9562h = new SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale.getDefault());
    @BindView(R.id.loading_view)
    public ViewGroup loadingView;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public MacroDroidRoomDatabase roomDatabase;
    @Inject
    public SystemLogHelper systemLogHelper;
    @BindView(R.id.viewPager)
    public ViewPager viewPager;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ReportBugActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ReportBugActivity.kt */
    /* loaded from: classes3.dex */
    public final class PageAdapter extends FragmentPagerAdapter {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final BugReport f9563a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReportBugActivity f9564b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageAdapter(@NotNull ReportBugActivity reportBugActivity, @NotNull FragmentManager fm, BugReport bugReport) {
            super(fm);
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(bugReport, "bugReport");
            this.f9564b = reportBugActivity;
            this.f9563a = bugReport;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (this.f9564b.f9560f) {
                return 3;
            }
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int i4) {
            Fragment newInstance;
            Fragment newInstance2;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (this.f9564b.f9560f) {
                            SubmitBugFragment newInstance3 = SubmitBugFragment.newInstance();
                            Intrinsics.checkNotNullExpressionValue(newInstance3, "{\n                    if… page\")\n                }");
                            return newInstance3;
                        }
                        throw new IllegalArgumentException("Invalid page");
                    }
                    throw new IllegalArgumentException("Invalid page");
                }
                if (this.f9564b.f9560f) {
                    newInstance2 = BugDetailsFragment.Companion.newInstance();
                } else {
                    newInstance2 = SubmitBugFragment.newInstance();
                }
                Intrinsics.checkNotNullExpressionValue(newInstance2, "if (hasMacros) {\n       …tance()\n                }");
                return newInstance2;
            }
            if (this.f9564b.f9560f) {
                newInstance = SelectMacrosFragment.newInstance();
            } else {
                newInstance = BugDetailsFragment.Companion.newInstance();
            }
            Intrinsics.checkNotNullExpressionValue(newInstance, "if (hasMacros) {\n       …tance()\n                }");
            return newInstance;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i4) {
            return "";
        }
    }

    /* compiled from: ReportBugActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogFlag.values().length];
            try {
                iArr[LogFlag.TRIGGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogFlag.ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportBugActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReportBugActivity.this.m(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportBugActivity.kt */
    @SourceDebugExtension({"SMAP\nReportBugActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportBugActivity.kt\ncom/arlosoft/macrodroid/bugreporting/ReportBugActivity$sendViaSendGrid$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $emailBody;
        final /* synthetic */ List<Macro> $macroList;
        final /* synthetic */ ArrayList<Uri> $screenshotUris;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReportBugActivity.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<SendGridResponse, Unit> {
            final /* synthetic */ String $emailBody;
            final /* synthetic */ ReportBugActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ReportBugActivity reportBugActivity, String str) {
                super(1);
                this.this$0 = reportBugActivity;
                this.$emailBody = str;
            }

            public final void a(@NotNull SendGridResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    ToastCompat.makeText(this.this$0.getApplicationContext(), (int) R.string.bug_submitted_ok, 0).show();
                    if (!this.this$0.isDestroyedOrFinishing()) {
                        this.this$0.finish();
                        return;
                    }
                    return;
                }
                String errorMessage = response.getErrorMessage();
                SystemLog.logError("Submit bug failed: " + errorMessage);
                ReportBugActivity reportBugActivity = this.this$0;
                String str = this.$emailBody;
                BugReport bugReport = reportBugActivity.f9561g;
                Intrinsics.checkNotNull(bugReport);
                List<Macro> macroList = bugReport.getMacroList();
                Intrinsics.checkNotNullExpressionValue(macroList, "bugReport!!.macroList");
                reportBugActivity.r(str, macroList);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SendGridResponse sendGridResponse) {
                a(sendGridResponse);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReportBugActivity.kt */
        /* renamed from: com.arlosoft.macrodroid.bugreporting.ReportBugActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0093b extends Lambda implements Function1<Throwable, Unit> {
            final /* synthetic */ String $emailBody;
            final /* synthetic */ ReportBugActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0093b(ReportBugActivity reportBugActivity, String str) {
                super(1);
                this.this$0 = reportBugActivity;
                this.$emailBody = str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                SystemLog.logError("Submit bug failed: " + error);
                ReportBugActivity reportBugActivity = this.this$0;
                String str = this.$emailBody;
                BugReport bugReport = reportBugActivity.f9561g;
                Intrinsics.checkNotNull(bugReport);
                List<Macro> macroList = bugReport.getMacroList();
                Intrinsics.checkNotNullExpressionValue(macroList, "bugReport!!.macroList");
                reportBugActivity.r(str, macroList);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, List<? extends Macro> list, ArrayList<Uri> arrayList, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$emailBody = str;
            this.$macroList = list;
            this.$screenshotUris = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$emailBody, this.$macroList, this.$screenshotUris, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x010d A[Catch: all -> 0x0172, TryCatch #0 {all -> 0x0172, blocks: (B:7:0x0016, B:43:0x0109, B:45:0x010d, B:46:0x0115, B:48:0x011d, B:49:0x0120, B:51:0x0124, B:52:0x012a, B:54:0x0130, B:55:0x013a, B:12:0x002b, B:36:0x00ec, B:38:0x00f0, B:39:0x00f8, B:15:0x0033, B:17:0x005b, B:19:0x006b, B:20:0x0092, B:22:0x0099, B:24:0x00b8, B:25:0x00bc, B:29:0x00d1, B:32:0x00da), top: B:61:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x011d A[Catch: all -> 0x0172, TryCatch #0 {all -> 0x0172, blocks: (B:7:0x0016, B:43:0x0109, B:45:0x010d, B:46:0x0115, B:48:0x011d, B:49:0x0120, B:51:0x0124, B:52:0x012a, B:54:0x0130, B:55:0x013a, B:12:0x002b, B:36:0x00ec, B:38:0x00f0, B:39:0x00f8, B:15:0x0033, B:17:0x005b, B:19:0x006b, B:20:0x0092, B:22:0x0099, B:24:0x00b8, B:25:0x00bc, B:29:0x00d1, B:32:0x00da), top: B:61:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0124 A[Catch: all -> 0x0172, TryCatch #0 {all -> 0x0172, blocks: (B:7:0x0016, B:43:0x0109, B:45:0x010d, B:46:0x0115, B:48:0x011d, B:49:0x0120, B:51:0x0124, B:52:0x012a, B:54:0x0130, B:55:0x013a, B:12:0x002b, B:36:0x00ec, B:38:0x00f0, B:39:0x00f8, B:15:0x0033, B:17:0x005b, B:19:0x006b, B:20:0x0092, B:22:0x0099, B:24:0x00b8, B:25:0x00bc, B:29:0x00d1, B:32:0x00da), top: B:61:0x0008 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 417
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.bugreporting.ReportBugActivity.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089 A[Catch: Exception -> 0x00df, LOOP:0: B:22:0x0083->B:24:0x0089, LOOP_END, TryCatch #0 {Exception -> 0x00df, blocks: (B:12:0x002e, B:21:0x006c, B:22:0x0083, B:24:0x0089, B:25:0x00db, B:17:0x003d), top: B:30:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.bugreporting.ReportBugActivity.m(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String n(LogFlag logFlag) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[logFlag.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return "";
            }
            return LogActivity.ACTION_RUN_TEXT_NEW;
        }
        return LogActivity.TRIGGER_FIRED_TEXT_NEW;
    }

    private final String o(SystemLogEntry systemLogEntry) {
        String str;
        String str2 = "";
        if (systemLogEntry.getMacroId() != 0) {
            if (MacroStore.getInstance().getMacroByGUID(systemLogEntry.getMacroId()) != null) {
                Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(systemLogEntry.getMacroId());
                if (macroByGUID != null) {
                    str = macroByGUID.getName();
                } else {
                    str = null;
                }
                if (str != null) {
                    str2 = str;
                }
                return " (" + str2 + ")";
            }
        } else if (systemLogEntry.getWebLink() != null) {
            String webLink = systemLogEntry.getWebLink();
            String webLink2 = systemLogEntry.getWebLink();
            return " (<a href=\"" + webLink + "\">" + webLink2 + "</a>)";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File p() throws Exception {
        String jsonFromAtomicFile = MacroDroidVariableStore.getInstance().getJsonFromAtomicFile();
        if (jsonFromAtomicFile != null) {
            File file = new File(getFilesDir(), "variables.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bytes = jsonFromAtomicFile.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                return file;
            } finally {
                fileOutputStream.close();
            }
        }
        return null;
    }

    private final void q(String str, List<? extends Macro> list, ArrayList<Uri> arrayList) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new b(str, list, arrayList, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String str, List<? extends Macro> list) {
        String str2;
        String str3;
        String replace$default;
        ArrayList arrayList = new ArrayList();
        for (Macro macro : list) {
            String json = GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(getApplicationContext(), true, true, true)).registerTypeAdapter(ActionBlock.class, new MacroDeserializer(getApplicationContext(), true, true, true)).create().toJson(macro);
            String name = macro.getName();
            Intrinsics.checkNotNullExpressionValue(name, "macro.name");
            replace$default = m.replace$default(name, ' ', '_', false, 4, (Object) null);
            Intrinsics.checkNotNullExpressionValue(json, "json");
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            arrayList.add(new SparkPostFile("text/plain", new Regex("[\\\\/:*?\"<>|]").replace(replace$default, "-") + ".macro", Base64.encodeBase64String(bytes)));
        }
        List<String> allLogLines = EventLogging.getAllLogLines(this);
        StringBuilder sb = new StringBuilder();
        if (allLogLines != null) {
            for (String str4 : allLogLines) {
                sb.append(str4);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        Charset charset = Charsets.UTF_8;
        byte[] bytes2 = sb2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        arrayList.add(new SparkPostFile("text/html", "MacroDroidLog.txt", Base64.encodeBase64String(bytes2)));
        String jsonFromAtomicFile = MacroDroidVariableStore.getInstance().getJsonFromAtomicFile();
        if (jsonFromAtomicFile != null) {
            byte[] bytes3 = jsonFromAtomicFile.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
            arrayList.add(new SparkPostFile("text/html", "Variables.txt", Base64.encodeBase64String(bytes3)));
        }
        String decrypt = StringExtensionsKt.decrypt(EmailServiceKt.SPARK_POST_ENCRYPTED_KEY);
        SparkPostRecipient sparkPostRecipient = new SparkPostRecipient("arlosoftmacrodroid@gmail.com");
        BugReport bugReport = this.f9561g;
        Intrinsics.checkNotNull(bugReport);
        if (!TextUtils.isEmpty(bugReport.getEmail())) {
            BugReport bugReport2 = this.f9561g;
            Intrinsics.checkNotNull(bugReport2);
            str2 = bugReport2.getEmail();
        } else {
            str2 = "Anonymous";
        }
        SparkPostSender sparkPostSender = new SparkPostSender("support@macrodroid.com", str2);
        BugReport bugReport3 = this.f9561g;
        Intrinsics.checkNotNull(bugReport3);
        if (!TextUtils.isEmpty(bugReport3.getEmail())) {
            BugReport bugReport4 = this.f9561g;
            Intrinsics.checkNotNull(bugReport4);
            str3 = bugReport4.getEmail();
        } else {
            str3 = "noreply@macrodroid.com";
        }
        SparkPostEmailUtil.sendEmail(this, decrypt, "Bug Report", str, sparkPostRecipient, sparkPostSender, str, arrayList, str3, new EmailListener() { // from class: com.arlosoft.macrodroid.bugreporting.ReportBugActivity$sendViaSparkPost$1
            @Override // com.arlosoft.macrodroid.utils.sparkpostutil.EmailListener
            public void onError(@NotNull String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SystemLog.logError("Submit bug failed: " + errorMessage);
                ToastCompat.makeText(ReportBugActivity.this.getApplicationContext(), (int) R.string.submit_bug_upload_failed, 1).show();
                if (!ReportBugActivity.this.isDestroyedOrFinishing()) {
                    ReportBugActivity.this.getLoadingView().setVisibility(8);
                }
            }

            @Override // com.arlosoft.macrodroid.utils.sparkpostutil.EmailListener
            public void onSuccess() {
                ToastCompat.makeText(ReportBugActivity.this.getApplicationContext(), (int) R.string.bug_submitted_ok, 0).show();
                if (!ReportBugActivity.this.isDestroyedOrFinishing()) {
                    ReportBugActivity.this.finish();
                }
            }
        });
    }

    public final void detailsEntered(@Nullable String str, @NotNull ArrayList<Uri> screenshotUris) {
        Intrinsics.checkNotNullParameter(screenshotUris, "screenshotUris");
        getViewPager().setCurrentItem(getViewPager().getCurrentItem() + 1);
        BugReport bugReport = this.f9561g;
        Intrinsics.checkNotNull(bugReport);
        bugReport.setDescription(str);
        BugReport bugReport2 = this.f9561g;
        Intrinsics.checkNotNull(bugReport2);
        bugReport2.setScreenshotUris(screenshotUris);
    }

    @NotNull
    public final ActionBlockStore getActionBlockStore() {
        ActionBlockStore actionBlockStore = this.actionBlockStore;
        if (actionBlockStore != null) {
            return actionBlockStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("actionBlockStore");
        return null;
    }

    @NotNull
    public final ViewGroup getLoadingView() {
        ViewGroup viewGroup = this.loadingView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        return null;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @NotNull
    public final MacroDroidRoomDatabase getRoomDatabase() {
        MacroDroidRoomDatabase macroDroidRoomDatabase = this.roomDatabase;
        if (macroDroidRoomDatabase != null) {
            return macroDroidRoomDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roomDatabase");
        return null;
    }

    @NotNull
    public final SystemLogHelper getSystemLogHelper() {
        SystemLogHelper systemLogHelper = this.systemLogHelper;
        if (systemLogHelper != null) {
            return systemLogHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("systemLogHelper");
        return null;
    }

    @NotNull
    public final ViewPager getViewPager() {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            return viewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    public final void handleBackPressed() {
        if (getViewPager().getCurrentItem() > 0) {
            getViewPager().setCurrentItem(getViewPager().getCurrentItem() - 1);
        } else {
            finish();
        }
    }

    public final void macrosSelected(@Nullable List<? extends Macro> list) {
        getViewPager().setCurrentItem(getViewPager().getCurrentItem() + 1);
        BugReport bugReport = this.f9561g;
        Intrinsics.checkNotNull(bugReport);
        bugReport.setMacroList(list);
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z3;
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_report_bug);
        ButterKnife.bind(this);
        setTitle(R.string.report_a_bug);
        if (MacroStore.getInstance().getAllCompletedMacros().size() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f9560f = z3;
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            val pkg = … 0).versionName\n        }");
        } catch (PackageManager.NameNotFoundException unused) {
            str = TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        if (bundle != null) {
            this.f9561g = (BugReport) bundle.getParcelable("bug_report_data");
        } else {
            BugReport bugReport = new BugReport(str, DamnYouPirates.isPirate(this), RootToolsHelper.isAccessGiven(), getPremiumStatusHandler().getPremiumStatus().isPro());
            this.f9561g = bugReport;
            Intrinsics.checkNotNull(bugReport);
            bugReport.setMacroList(new ArrayList());
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
        BugReport bugReport2 = this.f9561g;
        Intrinsics.checkNotNull(bugReport2);
        getViewPager().setAdapter(new PageAdapter(this, supportFragmentManager, bugReport2));
        getViewPager().setOffscreenPageLimit(3);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.bugreporting.ReportBugActivity$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                ReportBugActivity.this.handleBackPressed();
            }
        });
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            handleBackPressed();
            return true;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putParcelable("bug_report_data", this.f9561g);
        super.onSaveInstanceState(outState);
    }

    public final void setActionBlockStore(@NotNull ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(actionBlockStore, "<set-?>");
        this.actionBlockStore = actionBlockStore;
    }

    public final void setLoadingView(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.loadingView = viewGroup;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    public final void setSystemLogHelper(@NotNull SystemLogHelper systemLogHelper) {
        Intrinsics.checkNotNullParameter(systemLogHelper, "<set-?>");
        this.systemLogHelper = systemLogHelper;
    }

    public final void setViewPager(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
        this.viewPager = viewPager;
    }

    public final void submitBug(@Nullable String str) {
        ActivityManager.MemoryInfo memoryInfo;
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        String str4;
        boolean isNotificationPolicyAccessGranted;
        boolean canDrawOverlays;
        String str5;
        String trimIndent;
        boolean isIgnoringBatteryOptimizations;
        BugReport bugReport = this.f9561g;
        Intrinsics.checkNotNull(bugReport);
        bugReport.setEmail(str);
        BugReport bugReport2 = this.f9561g;
        Intrinsics.checkNotNull(bugReport2);
        bugReport2.setGoogleAccountEmail(Settings.getEmailGmailAddress(this));
        View currentFocus = getCurrentFocus();
        boolean z5 = false;
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        getLoadingView().setVisibility(0);
        Object systemService2 = getSystemService("activity");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService2).getMemoryInfo(new ActivityManager.MemoryInfo());
        String format = String.format("%.2fGB", Arrays.copyOf(new Object[]{Double.valueOf(memoryInfo.totalMem / 1000000000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        String str6 = Build.MANUFACTURER;
        String deviceName = DeviceName.getDeviceName();
        String str7 = Build.VERSION.RELEASE;
        BugReport bugReport3 = this.f9561g;
        Intrinsics.checkNotNull(bugReport3);
        String appVersion = bugReport3.getAppVersion();
        BugReport bugReport4 = this.f9561g;
        Intrinsics.checkNotNull(bugReport4);
        String str8 = "";
        if (!bugReport4.isPro()) {
            str2 = "";
        } else {
            str2 = " Pro";
        }
        BugReport bugReport5 = this.f9561g;
        Intrinsics.checkNotNull(bugReport5);
        if (!bugReport5.isPirate()) {
            str3 = "";
        } else {
            str3 = " (Pirate)";
        }
        BugReport bugReport6 = this.f9561g;
        Intrinsics.checkNotNull(bugReport6);
        if (bugReport6.isRoot()) {
            str8 = " (Root)";
        }
        String str9 = "[" + str6 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + deviceName + " (" + format + ") - " + str7 + "], " + appVersion + str2 + str3 + str8;
        BugReport bugReport7 = this.f9561g;
        Intrinsics.checkNotNull(bugReport7);
        String str10 = str9 + "\r\n\r\n" + bugReport7.getDescription();
        BugReport bugReport8 = this.f9561g;
        Intrinsics.checkNotNull(bugReport8);
        if (bugReport8.getGoogleAccountEmail() == null) {
            str10 = str10 + "\r\n\r\n(Google account unknown)";
        } else {
            BugReport bugReport9 = this.f9561g;
            Intrinsics.checkNotNull(bugReport9);
            String googleAccountEmail = bugReport9.getGoogleAccountEmail();
            BugReport bugReport10 = this.f9561g;
            Intrinsics.checkNotNull(bugReport10);
            if (!Intrinsics.areEqual(googleAccountEmail, bugReport10.getEmail())) {
                BugReport bugReport11 = this.f9561g;
                Intrinsics.checkNotNull(bugReport11);
                str10 = str10 + "\r\n\r\nGoogle account = " + bugReport11.getGoogleAccountEmail();
            }
        }
        if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
            String orderId = Settings.getOrderId(this);
            if (orderId != null) {
                str10 = str10 + "\r\n\r\nOrder id = " + orderId;
            } else if (Settings.getUpgradeSerial(this) != null) {
                str10 = str10 + "\r\n\r\nSerial = " + orderId;
            } else {
                str10 = str10 + "\r\n\r\nPurchase Info Unknown";
            }
        }
        String str11 = str10 + "\r\nTotal macros = " + MacroStore.getInstance().getAllCompletedMacros().size();
        if (Settings.Global.getInt(getContentResolver(), "always_finish_activities", 0) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            str11 = str11 + "\r\n\r\nDon't keep activities enabled";
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService3 = getSystemService("power");
            Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.os.PowerManager");
            isIgnoringBatteryOptimizations = ((PowerManager) systemService3).isIgnoringBatteryOptimizations(getPackageName());
            str11 = str11 + "\r\n\r\nBattery optimization disabled: " + isIgnoringBatteryOptimizations;
        }
        try {
            int i4 = Settings.Secure.getInt(getContentResolver(), "location_mode");
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        str5 = "High Accuracy";
                    } else {
                        str5 = "Battery Saving";
                    }
                } else {
                    str5 = "Sensors Only";
                }
            } else {
                str5 = "Off";
            }
            trimIndent = f.trimIndent("\r\n\r\nLocation services: " + str5);
            str11 = str11 + trimIndent;
        } catch (Settings.SettingNotFoundException unused) {
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        String str12 = "Enabled";
        if (z4) {
            str4 = "Enabled";
        } else {
            str4 = "Disabled";
        }
        String str13 = str11 + "\r\nCoarse location permission: " + str4;
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            z5 = true;
        }
        if (!z5) {
            str12 = "Disabled";
        }
        String str14 = (((str13 + "\r\nFine location permission: " + str12) + "\r\nAccessibility enabled: " + Util.isMacroDroidAccessibilityEnabled(this)) + "\r\nUI Interaction accessibility enabled: " + Util.isUIInteractionAccessibilityEnabled(this)) + "\r\nVolume button accessibility enabled: " + Util.isMacroDroidVolumeAccessibilityEnabled(this);
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService4 = getSystemService("notification");
            Intrinsics.checkNotNull(systemService4, "null cannot be cast to non-null type android.app.NotificationManager");
            isNotificationPolicyAccessGranted = ((NotificationManager) systemService4).isNotificationPolicyAccessGranted();
            String str15 = str14 + "\r\nNotification service enabled: " + isNotificationPolicyAccessGranted;
            canDrawOverlays = android.provider.Settings.canDrawOverlays(this);
            str14 = str15 + "\r\nDisplay over other apps enabled: " + canDrawOverlays;
        }
        String macroDroidHelperVersionName = ApplicationChecker.getMacroDroidHelperVersionName();
        if (macroDroidHelperVersionName == null) {
            macroDroidHelperVersionName = "Not installed";
        }
        String str16 = str14 + "\r\nHelper File: " + macroDroidHelperVersionName;
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            str16 = str16 + "\r\nNotifications are disabled for MacroDroid.";
        }
        if (!ApplicationChecker.isPlayStoreInstalled()) {
            str16 = str16 + "\r\n\r\nGoogle Play Store is not installed";
        }
        String str17 = str16 + "\r\n\r\nId: " + com.arlosoft.macrodroid.settings.Settings.getAnonymousUserId(this);
        BugReport bugReport12 = this.f9561g;
        Intrinsics.checkNotNull(bugReport12);
        List<Macro> macroList = bugReport12.getMacroList();
        Intrinsics.checkNotNullExpressionValue(macroList, "bugReport!!.macroList");
        BugReport bugReport13 = this.f9561g;
        Intrinsics.checkNotNull(bugReport13);
        q(str17, macroList, bugReport13.getScreenshotUris());
    }
}
