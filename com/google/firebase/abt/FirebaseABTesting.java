package com.google.firebase.abt;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class FirebaseABTesting {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AnalyticsConnector> f28737a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28738b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Integer f28739c = null;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface OriginService {
        public static final String INAPP_MESSAGING = "fiam";
        public static final String REMOTE_CONFIG = "frc";
    }

    public FirebaseABTesting(Context context, Provider<AnalyticsConnector> provider, String str) {
        this.f28737a = provider;
        this.f28738b = str;
    }

    private void a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        this.f28737a.get().setConditionalUserProperty(conditionalUserProperty);
    }

    private void b(List<AbtExperimentInfo> list) {
        ArrayDeque arrayDeque = new ArrayDeque(e());
        int h4 = h();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            while (arrayDeque.size() >= h4) {
                i(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).name);
            }
            AnalyticsConnector.ConditionalUserProperty f4 = abtExperimentInfo.f(this.f28738b);
            a(f4);
            arrayDeque.offer(f4);
        }
    }

    private static List<AbtExperimentInfo> c(List<Map<String, String>> list) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : list) {
            arrayList.add(AbtExperimentInfo.b(map));
        }
        return arrayList;
    }

    private boolean d(List<AbtExperimentInfo> list, AbtExperimentInfo abtExperimentInfo) {
        String c4 = abtExperimentInfo.c();
        String e4 = abtExperimentInfo.e();
        for (AbtExperimentInfo abtExperimentInfo2 : list) {
            if (abtExperimentInfo2.c().equals(c4) && abtExperimentInfo2.e().equals(e4)) {
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    private List<AnalyticsConnector.ConditionalUserProperty> e() {
        return this.f28737a.get().getConditionalUserProperties(this.f28738b, "");
    }

    private ArrayList<AbtExperimentInfo> f(List<AbtExperimentInfo> list, List<AbtExperimentInfo> list2) {
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<>();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            if (!d(list2, abtExperimentInfo)) {
                arrayList.add(abtExperimentInfo);
            }
        }
        return arrayList;
    }

    private ArrayList<AnalyticsConnector.ConditionalUserProperty> g(List<AbtExperimentInfo> list, List<AbtExperimentInfo> list2) {
        ArrayList<AnalyticsConnector.ConditionalUserProperty> arrayList = new ArrayList<>();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            if (!d(list2, abtExperimentInfo)) {
                arrayList.add(abtExperimentInfo.f(this.f28738b));
            }
        }
        return arrayList;
    }

    @WorkerThread
    private int h() {
        if (this.f28739c == null) {
            this.f28739c = Integer.valueOf(this.f28737a.get().getMaxUserProperties(this.f28738b));
        }
        return this.f28739c.intValue();
    }

    private void i(String str) {
        this.f28737a.get().clearConditionalUserProperty(str, null, null);
    }

    private void j(Collection<AnalyticsConnector.ConditionalUserProperty> collection) {
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : collection) {
            i(conditionalUserProperty.name);
        }
    }

    private void k(List<AbtExperimentInfo> list) throws AbtException {
        if (list.isEmpty()) {
            removeAllExperiments();
            return;
        }
        List<AbtExperimentInfo> allExperiments = getAllExperiments();
        j(g(allExperiments, list));
        b(f(list, allExperiments));
    }

    private void l() throws AbtException {
        if (this.f28737a.get() != null) {
            return;
        }
        throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
    }

    @WorkerThread
    public List<AbtExperimentInfo> getAllExperiments() throws AbtException {
        l();
        List<AnalyticsConnector.ConditionalUserProperty> e4 = e();
        ArrayList arrayList = new ArrayList();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : e4) {
            arrayList.add(AbtExperimentInfo.a(conditionalUserProperty));
        }
        return arrayList;
    }

    @WorkerThread
    public void removeAllExperiments() throws AbtException {
        l();
        j(e());
    }

    @WorkerThread
    public void replaceAllExperiments(List<Map<String, String>> list) throws AbtException {
        l();
        if (list != null) {
            k(c(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }

    @WorkerThread
    public void reportActiveExperiment(AbtExperimentInfo abtExperimentInfo) throws AbtException {
        l();
        AbtExperimentInfo.h(abtExperimentInfo);
        ArrayList arrayList = new ArrayList();
        Map<String, String> g4 = abtExperimentInfo.g();
        g4.remove("triggerEvent");
        arrayList.add(AbtExperimentInfo.b(g4));
        b(arrayList);
    }

    @WorkerThread
    public void validateRunningExperiments(List<AbtExperimentInfo> list) throws AbtException {
        l();
        j(g(getAllExperiments(), list));
    }
}
