package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public class Rpc {

    /* renamed from: h  reason: collision with root package name */
    private static int f19896h;

    /* renamed from: i  reason: collision with root package name */
    private static PendingIntent f19897i;

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f19898j = new Executor() { // from class: com.google.android.gms.cloudmessaging.zzz
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f19899k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: b  reason: collision with root package name */
    private final Context f19901b;

    /* renamed from: c  reason: collision with root package name */
    private final zzt f19902c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f19903d;

    /* renamed from: f  reason: collision with root package name */
    private Messenger f19905f;

    /* renamed from: g  reason: collision with root package name */
    private zzd f19906g;
    @GuardedBy("responseCallbacks")

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> f19900a = new SimpleArrayMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Messenger f19904e = new Messenger(new zzaa(this, Looper.getMainLooper()));

    public Rpc(@NonNull Context context) {
        this.f19901b = context;
        this.f19902c = new zzt(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f19903d = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Task a(Bundle bundle) throws Exception {
        if (g(bundle)) {
            return Tasks.forResult(null);
        }
        return Tasks.forResult(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void b(Rpc rpc, Message message) {
        String str;
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzc());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.f19906g = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.f19905f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String valueOf = String.valueOf(action);
                        if (valueOf.length() != 0) {
                            "Unexpected response action: ".concat(valueOf);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                    if (stringExtra2 == null) {
                        String valueOf2 = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(valueOf2.length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf2);
                        Log.w("Rpc", sb.toString());
                        return;
                    }
                    if (Log.isLoggable("Rpc", 3) && stringExtra2.length() != 0) {
                        "Received InstanceID error ".concat(stringExtra2);
                    }
                    if (stringExtra2.startsWith("|")) {
                        String[] split = stringExtra2.split("\\|");
                        if (split.length > 2 && "ID".equals(split[1])) {
                            String str2 = split[2];
                            String str3 = split[3];
                            if (str3.startsWith(":")) {
                                str3 = str3.substring(1);
                            }
                            rpc.f(str2, intent2.putExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str3).getExtras());
                            return;
                        }
                        if (stringExtra2.length() != 0) {
                            str = "Unexpected structured response ".concat(stringExtra2);
                        } else {
                            str = new String("Unexpected structured response ");
                        }
                        Log.w("Rpc", str);
                        return;
                    }
                    synchronized (rpc.f19900a) {
                        for (int i4 = 0; i4 < rpc.f19900a.size(); i4++) {
                            rpc.f(rpc.f19900a.keyAt(i4), intent2.getExtras());
                        }
                    }
                    return;
                }
                Matcher matcher = f19899k.matcher(stringExtra);
                if (!matcher.matches()) {
                    if (Log.isLoggable("Rpc", 3) && stringExtra.length() != 0) {
                        "Unexpected response string: ".concat(stringExtra);
                        return;
                    }
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (group != null) {
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", group2);
                    rpc.f(group, extras);
                    return;
                }
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    @AnyThread
    private final Task<Bundle> c(Bundle bundle) {
        final String d4 = d();
        final TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.f19900a) {
            this.f19900a.put(d4, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f19902c.zzb() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        e(this.f19901b, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(d4).length() + 5);
        sb.append("|ID|");
        sb.append(d4);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
            sb2.append("Sending ");
            sb2.append(valueOf);
        }
        intent.putExtra("google.messenger", this.f19904e);
        if (this.f19905f != null || this.f19906g != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f19905f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f19906g.zzb(obtain);
                }
            } catch (RemoteException unused) {
                Log.isLoggable("Rpc", 3);
            }
            final ScheduledFuture<?> schedule = this.f19903d.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzy
                @Override // java.lang.Runnable
                public final void run() {
                    if (TaskCompletionSource.this.trySetException(new IOException("TIMEOUT"))) {
                        Log.w("Rpc", "No response");
                    }
                }
            }, 30L, TimeUnit.SECONDS);
            taskCompletionSource.getTask().addOnCompleteListener(f19898j, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzw
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    Rpc.this.zzd(d4, schedule, task);
                }
            });
            return taskCompletionSource.getTask();
        }
        if (this.f19902c.zzb() == 2) {
            this.f19901b.sendBroadcast(intent);
        } else {
            this.f19901b.startService(intent);
        }
        final ScheduledFuture schedule2 = this.f19903d.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzy
            @Override // java.lang.Runnable
            public final void run() {
                if (TaskCompletionSource.this.trySetException(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.getTask().addOnCompleteListener(f19898j, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzw
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                Rpc.this.zzd(d4, schedule2, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    private static synchronized String d() {
        String num;
        synchronized (Rpc.class) {
            int i4 = f19896h;
            f19896h = i4 + 1;
            num = Integer.toString(i4);
        }
        return num;
    }

    private static synchronized void e(Context context, Intent intent) {
        synchronized (Rpc.class) {
            if (f19897i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f19897i = com.google.android.gms.internal.cloudmessaging.zza.zza(context, 0, intent2, com.google.android.gms.internal.cloudmessaging.zza.zza);
            }
            intent.putExtra("app", f19897i);
        }
    }

    private final void f(String str, @Nullable Bundle bundle) {
        String str2;
        synchronized (this.f19900a) {
            TaskCompletionSource<Bundle> remove = this.f19900a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "Missing callback for ".concat(valueOf);
                } else {
                    str2 = new String("Missing callback for ");
                }
                Log.w("Rpc", str2);
                return;
            }
            remove.setResult(bundle);
        }
    }

    private static boolean g(Bundle bundle) {
        if (bundle != null && bundle.containsKey("google.messenger")) {
            return true;
        }
        return false;
    }

    @NonNull
    public Task<Bundle> send(@NonNull final Bundle bundle) {
        if (this.f19902c.zza() < 12000000) {
            if (this.f19902c.zzb() != 0) {
                return c(bundle).continueWithTask(f19898j, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzu
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        return Rpc.this.zzb(bundle, task);
                    }
                });
            }
            return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return zzs.zzb(this.f19901b).zzd(1, bundle).continueWith(f19898j, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzv
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                if (task.isSuccessful()) {
                    return (Bundle) task.getResult();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    String valueOf = String.valueOf(task.getException());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 22);
                    sb.append("Error making request: ");
                    sb.append(valueOf);
                }
                throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, task.getException());
            }
        });
    }

    @NonNull
    public final /* synthetic */ Task zzb(@NonNull Bundle bundle, @NonNull Task task) throws Exception {
        if (!task.isSuccessful()) {
            return task;
        }
        if (!g((Bundle) task.getResult())) {
            return task;
        }
        return c(bundle).onSuccessTask(f19898j, new SuccessContinuation() { // from class: com.google.android.gms.cloudmessaging.zzx
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Rpc.a((Bundle) obj);
            }
        });
    }

    public final /* synthetic */ void zzd(@NonNull String str, @NonNull ScheduledFuture scheduledFuture, @NonNull Task task) {
        synchronized (this.f19900a) {
            this.f19900a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
