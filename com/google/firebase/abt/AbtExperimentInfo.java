package com.google.firebase.abt;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes5.dex */
public class AbtExperimentInfo {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f28729g = {RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID};
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    static final DateFormat f28730h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    private final String f28731a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28732b;

    /* renamed from: c  reason: collision with root package name */
    private final String f28733c;

    /* renamed from: d  reason: collision with root package name */
    private final Date f28734d;

    /* renamed from: e  reason: collision with root package name */
    private final long f28735e;

    /* renamed from: f  reason: collision with root package name */
    private final long f28736f;

    public AbtExperimentInfo(String str, String str2, String str3, Date date, long j4, long j5) {
        this.f28731a = str;
        this.f28732b = str2;
        this.f28733c = str3;
        this.f28734d = date;
        this.f28735e = j4;
        this.f28736f = j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AbtExperimentInfo a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str = conditionalUserProperty.triggerEventName;
        if (str == null) {
            str = "";
        }
        return new AbtExperimentInfo(conditionalUserProperty.name, String.valueOf(conditionalUserProperty.value), str, new Date(conditionalUserProperty.creationTimestamp), conditionalUserProperty.triggerTimeout, conditionalUserProperty.timeToLive);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AbtExperimentInfo b(Map<String, String> map) throws AbtException {
        String str;
        i(map);
        try {
            Date parse = f28730h.parse(map.get("experimentStartTime"));
            long parseLong = Long.parseLong(map.get("triggerTimeoutMillis"));
            long parseLong2 = Long.parseLong(map.get("timeToLiveMillis"));
            String str2 = map.get(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID);
            String str3 = map.get(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID);
            if (map.containsKey("triggerEvent")) {
                str = map.get("triggerEvent");
            } else {
                str = "";
            }
            return new AbtExperimentInfo(str2, str3, str, parse, parseLong, parseLong2);
        } catch (NumberFormatException e4) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e4);
        } catch (ParseException e5) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(AbtExperimentInfo abtExperimentInfo) throws AbtException {
        i(abtExperimentInfo.g());
    }

    private static void i(Map<String, String> map) throws AbtException {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : f28729g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f28731a;
    }

    long d() {
        return this.f28734d.getTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f28732b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnalyticsConnector.ConditionalUserProperty f(String str) {
        String str2;
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = str;
        conditionalUserProperty.creationTimestamp = d();
        conditionalUserProperty.name = this.f28731a;
        conditionalUserProperty.value = this.f28732b;
        if (TextUtils.isEmpty(this.f28733c)) {
            str2 = null;
        } else {
            str2 = this.f28733c;
        }
        conditionalUserProperty.triggerEventName = str2;
        conditionalUserProperty.triggerTimeout = this.f28735e;
        conditionalUserProperty.timeToLive = this.f28736f;
        return conditionalUserProperty;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public Map<String, String> g() {
        HashMap hashMap = new HashMap();
        hashMap.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, this.f28731a);
        hashMap.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, this.f28732b);
        hashMap.put("triggerEvent", this.f28733c);
        hashMap.put("experimentStartTime", f28730h.format(this.f28734d));
        hashMap.put("triggerTimeoutMillis", Long.toString(this.f28735e));
        hashMap.put("timeToLiveMillis", Long.toString(this.f28736f));
        return hashMap;
    }
}
