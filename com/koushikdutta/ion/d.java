package com.koushikdutta.ion;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.Service;
import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: ContextReference.java */
/* loaded from: classes6.dex */
abstract class d<T> extends WeakReference<T> {

    /* compiled from: ContextReference.java */
    /* loaded from: classes6.dex */
    static class a extends e<Context> {
        a(Context context) {
            super(context);
        }

        @Override // com.koushikdutta.ion.d
        public String c() {
            if (((Context) get()) == null) {
                return "Context reference null";
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContextReference.java */
    /* loaded from: classes6.dex */
    public static class b extends e<Activity> {
        public b(Activity activity) {
            super(activity);
        }

        static String e(Activity activity) {
            if (activity == null) {
                return "Activity reference null";
            }
            if (activity.isFinishing()) {
                return "Activity finished";
            }
            return null;
        }

        @Override // com.koushikdutta.ion.d
        public String c() {
            return e((Activity) get());
        }
    }

    /* compiled from: ContextReference.java */
    @TargetApi(13)
    /* loaded from: classes6.dex */
    static class c extends d<Fragment> {
        public c(Fragment fragment) {
            super(fragment);
        }

        @Override // com.koushikdutta.ion.d
        public Context b() {
            Fragment fragment = get();
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }

        @Override // com.koushikdutta.ion.d
        public String c() {
            Fragment fragment = get();
            if (fragment == null) {
                return "Fragment reference null";
            }
            String e4 = b.e(fragment.getActivity());
            if (e4 != null) {
                return e4;
            }
            if (fragment.isDetached()) {
                return "Fragment detached";
            }
            return null;
        }
    }

    /* compiled from: ContextReference.java */
    /* renamed from: com.koushikdutta.ion.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0205d extends d<ImageView> {
        public C0205d(ImageView imageView) {
            super(imageView);
        }

        @Override // com.koushikdutta.ion.d
        public Context b() {
            ImageView imageView = get();
            if (imageView == null) {
                return null;
            }
            return imageView.getContext();
        }

        @Override // com.koushikdutta.ion.d
        public String c() {
            ImageView imageView = get();
            if (imageView == null) {
                return "ImageView reference null";
            }
            return e.d(imageView.getContext());
        }
    }

    /* compiled from: ContextReference.java */
    /* loaded from: classes6.dex */
    static abstract class e<T extends Context> extends d<T> {
        e(T t3) {
            super(t3);
        }

        static String d(Context context) {
            if (context instanceof Service) {
                return f.e((Service) context);
            }
            if (context instanceof Activity) {
                return b.e((Activity) context);
            }
            return null;
        }

        @Override // com.koushikdutta.ion.d
        public Context b() {
            return (Context) get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContextReference.java */
    /* loaded from: classes6.dex */
    public static class f extends e<Service> {
        public f(Service service) {
            super(service);
        }

        static String e(Service service) {
            if (service == null) {
                return "Service reference null";
            }
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) service.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                return "Could not retrieve services from service manager";
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (service.getClass().getName().equals(runningServiceInfo.service.getClassName())) {
                    return null;
                }
            }
            return "Service stopped";
        }

        @Override // com.koushikdutta.ion.d
        public String c() {
            return e((Service) get());
        }
    }

    /* compiled from: ContextReference.java */
    /* loaded from: classes6.dex */
    static class g extends d<androidx.fragment.app.Fragment> {
        public g(androidx.fragment.app.Fragment fragment) {
            super(fragment);
        }

        @Override // com.koushikdutta.ion.d
        public Context b() {
            androidx.fragment.app.Fragment fragment = get();
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }

        @Override // com.koushikdutta.ion.d
        public String c() {
            androidx.fragment.app.Fragment fragment = get();
            if (fragment == null) {
                return "Fragment reference null";
            }
            String e4 = b.e(fragment.getActivity());
            if (e4 != null) {
                return e4;
            }
            if (fragment.isDetached()) {
                return "Fragment detached";
            }
            return null;
        }
    }

    d(T t3) {
        super(t3);
    }

    public static d a(Context context) {
        if (context instanceof Service) {
            return new f((Service) context);
        }
        if (context instanceof Activity) {
            return new b((Activity) context);
        }
        return new a(context);
    }

    public abstract Context b();

    public abstract String c();
}
