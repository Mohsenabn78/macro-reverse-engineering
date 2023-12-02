package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes5.dex */
public class CrashlyticsReportDataCapture {

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Integer> f29495f;

    /* renamed from: g  reason: collision with root package name */
    static final String f29496g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f29497a;

    /* renamed from: b  reason: collision with root package name */
    private final IdManager f29498b;

    /* renamed from: c  reason: collision with root package name */
    private final AppData f29499c;

    /* renamed from: d  reason: collision with root package name */
    private final StackTraceTrimmingStrategy f29500d;

    /* renamed from: e  reason: collision with root package name */
    private final SettingsProvider f29501e;

    static {
        HashMap hashMap = new HashMap();
        f29495f = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
        f29496g = String.format(Locale.US, "Crashlytics Android SDK/%s", BuildConfig.VERSION_NAME);
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider) {
        this.f29497a = context;
        this.f29498b = idManager;
        this.f29499c = appData;
        this.f29500d = stackTraceTrimmingStrategy;
        this.f29501e = settingsProvider;
    }

    private CrashlyticsReport.ApplicationExitInfo a(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList;
        if (this.f29501e.getSettingsSync().featureFlagData.collectBuildIds && this.f29499c.buildIdInfoList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (BuildIdInfo buildIdInfo : this.f29499c.buildIdInfoList) {
                arrayList.add(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.builder().setLibraryName(buildIdInfo.getLibraryName()).setArch(buildIdInfo.getArch()).setBuildId(buildIdInfo.getBuildId()).build());
            }
            immutableList = ImmutableList.from(arrayList);
        } else {
            immutableList = null;
        }
        return CrashlyticsReport.ApplicationExitInfo.builder().setImportance(applicationExitInfo.getImportance()).setProcessName(applicationExitInfo.getProcessName()).setReasonCode(applicationExitInfo.getReasonCode()).setTimestamp(applicationExitInfo.getTimestamp()).setPid(applicationExitInfo.getPid()).setPss(applicationExitInfo.getPss()).setRss(applicationExitInfo.getRss()).setTraceFile(applicationExitInfo.getTraceFile()).setBuildIdMappingForArch(immutableList).build();
    }

    private CrashlyticsReport.Builder b() {
        return CrashlyticsReport.builder().setSdkVersion(BuildConfig.VERSION_NAME).setGmpAppId(this.f29499c.googleAppId).setInstallationUuid(this.f29498b.getInstallIds().getCrashlyticsInstallId()).setFirebaseInstallationId(this.f29498b.getInstallIds().getFirebaseInstallationId()).setBuildVersion(this.f29499c.versionCode).setDisplayVersion(this.f29499c.versionName).setPlatform(4);
    }

    private static int c() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = f29495f.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage d() {
        return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder().setBaseAddress(0L).setSize(0L).setName(this.f29499c.packageName).setUuid(this.f29499c.buildId).build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> e() {
        return ImmutableList.from(d());
    }

    private CrashlyticsReport.Session.Event.Application f(int i4, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        boolean z3;
        if (applicationExitInfo.getImportance() != 100) {
            z3 = true;
        } else {
            z3 = false;
        }
        return CrashlyticsReport.Session.Event.Application.builder().setBackground(Boolean.valueOf(z3)).setUiOrientation(i4).setExecution(k(applicationExitInfo)).build();
    }

    private CrashlyticsReport.Session.Event.Application g(int i4, TrimmedThrowableData trimmedThrowableData, Thread thread, int i5, int i6, boolean z3) {
        Boolean bool;
        boolean z4;
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(this.f29499c.packageName, this.f29497a);
        if (appProcessInfo != null) {
            if (appProcessInfo.importance != 100) {
                z4 = true;
            } else {
                z4 = false;
            }
            bool = Boolean.valueOf(z4);
        } else {
            bool = null;
        }
        return CrashlyticsReport.Session.Event.Application.builder().setBackground(bool).setUiOrientation(i4).setExecution(l(trimmedThrowableData, thread, i5, i6, z3)).build();
    }

    private CrashlyticsReport.Session.Event.Device h(int i4) {
        Double d4;
        BatteryState a4 = BatteryState.a(this.f29497a);
        Float b4 = a4.b();
        if (b4 != null) {
            d4 = Double.valueOf(b4.doubleValue());
        } else {
            d4 = null;
        }
        int c4 = a4.c();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(this.f29497a);
        long totalRamInBytes = CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(this.f29497a);
        return CrashlyticsReport.Session.Event.Device.builder().setBatteryLevel(d4).setBatteryVelocity(c4).setProximityOn(proximitySensorEnabled).setOrientation(i4).setRamUsed(totalRamInBytes).setDiskUsed(CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath())).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception i(TrimmedThrowableData trimmedThrowableData, int i4, int i5) {
        return j(trimmedThrowableData, i4, i5, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception j(TrimmedThrowableData trimmedThrowableData, int i4, int i5, int i6) {
        String str = trimmedThrowableData.className;
        String str2 = trimmedThrowableData.localizedMessage;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        int i7 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (i6 >= i5) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.cause;
                i7++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder overflowCount = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder().setType(str).setReason(str2).setFrames(ImmutableList.from(n(stackTraceElementArr, i4))).setOverflowCount(i7);
        if (trimmedThrowableData2 != null && i7 == 0) {
            overflowCount.setCausedBy(j(trimmedThrowableData2, i4, i5, i6 + 1));
        }
        return overflowCount.build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution k(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.Execution.builder().setAppExitInfo(applicationExitInfo).setSignal(s()).setBinaries(e()).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution l(TrimmedThrowableData trimmedThrowableData, Thread thread, int i4, int i5, boolean z3) {
        return CrashlyticsReport.Session.Event.Application.Execution.builder().setThreads(v(trimmedThrowableData, thread, i4, z3)).setException(i(trimmedThrowableData, i4, i5)).setSignal(s()).setBinaries(e()).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame m(StackTraceElement stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder) {
        long j4;
        long j5 = 0;
        if (stackTraceElement.isNativeMethod()) {
            j4 = Math.max(stackTraceElement.getLineNumber(), 0L);
        } else {
            j4 = 0;
        }
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j5 = stackTraceElement.getLineNumber();
        }
        return builder.setPc(j4).setSymbol(str).setFile(fileName).setOffset(j5).build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> n(StackTraceElement[] stackTraceElementArr, int i4) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(m(stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder().setImportance(i4)));
        }
        return ImmutableList.from(arrayList);
    }

    private CrashlyticsReport.Session.Application o() {
        return CrashlyticsReport.Session.Application.builder().setIdentifier(this.f29498b.getAppIdentifier()).setVersion(this.f29499c.versionCode).setDisplayVersion(this.f29499c.versionName).setInstallationUuid(this.f29498b.getInstallIds().getCrashlyticsInstallId()).setDevelopmentPlatform(this.f29499c.developmentPlatformProvider.getDevelopmentPlatform()).setDevelopmentPlatformVersion(this.f29499c.developmentPlatformProvider.getDevelopmentPlatformVersion()).build();
    }

    private CrashlyticsReport.Session p(String str, long j4) {
        return CrashlyticsReport.Session.builder().setStartedAt(j4).setIdentifier(str).setGenerator(f29496g).setApp(o()).setOs(r()).setDevice(q()).setGeneratorType(3).build();
    }

    private CrashlyticsReport.Session.Device q() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int c4 = c();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean isEmulator = CommonUtils.isEmulator();
        int deviceState = CommonUtils.getDeviceState();
        String str = Build.MANUFACTURER;
        return CrashlyticsReport.Session.Device.builder().setArch(c4).setModel(Build.MODEL).setCores(availableProcessors).setRam(totalRamInBytes).setDiskSpace(blockCount).setSimulator(isEmulator).setState(deviceState).setManufacturer(str).setModelClass(Build.PRODUCT).build();
    }

    private CrashlyticsReport.Session.OperatingSystem r() {
        return CrashlyticsReport.Session.OperatingSystem.builder().setPlatform(3).setVersion(Build.VERSION.RELEASE).setBuildVersion(Build.VERSION.CODENAME).setJailbroken(CommonUtils.isRooted()).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Signal s() {
        return CrashlyticsReport.Session.Event.Application.Execution.Signal.builder().setName("0").setCode("0").setAddress(0L).build();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread t(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return u(thread, stackTraceElementArr, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread u(Thread thread, StackTraceElement[] stackTraceElementArr, int i4) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.builder().setName(thread.getName()).setImportance(i4).setFrames(ImmutableList.from(n(stackTraceElementArr, i4))).build();
    }

    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> v(TrimmedThrowableData trimmedThrowableData, Thread thread, int i4, boolean z3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(u(thread, trimmedThrowableData.stacktrace, i4));
        if (z3) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(t(key, this.f29500d.getTrimmedStackTrace(entry.getValue())));
                }
            }
        }
        return ImmutableList.from(arrayList);
    }

    public CrashlyticsReport.Session.Event captureAnrEventData(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        int i4 = this.f29497a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.builder().setType("anr").setTimestamp(applicationExitInfo.getTimestamp()).setApp(f(i4, a(applicationExitInfo))).setDevice(h(i4)).build();
    }

    public CrashlyticsReport.Session.Event captureEventData(Throwable th, Thread thread, String str, long j4, int i4, int i5, boolean z3) {
        int i6 = this.f29497a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.builder().setType(str).setTimestamp(j4).setApp(g(i6, new TrimmedThrowableData(th, this.f29500d), thread, i4, i5, z3)).setDevice(h(i6)).build();
    }

    public CrashlyticsReport captureReportData(String str, long j4) {
        return b().setSession(p(str, j4)).build();
    }
}
