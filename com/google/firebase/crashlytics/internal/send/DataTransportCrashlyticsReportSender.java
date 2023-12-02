package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public class DataTransportCrashlyticsReportSender {

    /* renamed from: c  reason: collision with root package name */
    private static final CrashlyticsReportJsonTransform f29979c = new CrashlyticsReportJsonTransform();

    /* renamed from: d  reason: collision with root package name */
    private static final String f29980d = c("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e  reason: collision with root package name */
    private static final String f29981e = c("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f  reason: collision with root package name */
    private static final Transformer<CrashlyticsReport, byte[]> f29982f = new Transformer() { // from class: com.google.firebase.crashlytics.internal.send.a
        @Override // com.google.android.datatransport.Transformer
        public final Object apply(Object obj) {
            byte[] b4;
            b4 = DataTransportCrashlyticsReportSender.b((CrashlyticsReport) obj);
            return b4;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final ReportQueue f29983a;

    /* renamed from: b  reason: collision with root package name */
    private final Transformer<CrashlyticsReport, byte[]> f29984b;

    DataTransportCrashlyticsReportSender(ReportQueue reportQueue, Transformer<CrashlyticsReport, byte[]> transformer) {
        this.f29983a = reportQueue;
        this.f29984b = transformer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] b(CrashlyticsReport crashlyticsReport) {
        return f29979c.reportToJson(crashlyticsReport).getBytes(Charset.forName("UTF-8"));
    }

    private static String c(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str.length() + str2.length());
            for (int i4 = 0; i4 < str.length(); i4++) {
                sb.append(str.charAt(i4));
                if (str2.length() > i4) {
                    sb.append(str2.charAt(i4));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }

    public static DataTransportCrashlyticsReportSender create(Context context, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        TransportRuntime.initialize(context);
        TransportFactory newFactory = TransportRuntime.getInstance().newFactory(new CCTDestination(f29980d, f29981e));
        Encoding of = Encoding.of("json");
        Transformer<CrashlyticsReport, byte[]> transformer = f29982f;
        return new DataTransportCrashlyticsReportSender(new ReportQueue(newFactory.getTransport("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, of, transformer), settingsProvider.getSettingsSync(), onDemandCounter), transformer);
    }

    @NonNull
    public Task<CrashlyticsReportWithSessionId> enqueueReport(@NonNull CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z3) {
        return this.f29983a.i(crashlyticsReportWithSessionId, z3).getTask();
    }
}
