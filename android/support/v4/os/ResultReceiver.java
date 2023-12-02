package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f379a;

    /* renamed from: b  reason: collision with root package name */
    final Handler f380b;

    /* renamed from: c  reason: collision with root package name */
    IResultReceiver f381c;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<ResultReceiver> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ResultReceiver[] newArray(int i4) {
            return new ResultReceiver[i4];
        }
    }

    /* loaded from: classes.dex */
    class b extends IResultReceiver.Stub {
        b() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i4, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f380b;
            if (handler != null) {
                handler.post(new c(i4, bundle));
            } else {
                resultReceiver.a(i4, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f383a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f384b;

        c(int i4, Bundle bundle) {
            this.f383a = i4;
            this.f384b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f383a, this.f384b);
        }
    }

    public ResultReceiver(Handler handler) {
        this.f379a = true;
        this.f380b = handler;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void send(int i4, Bundle bundle) {
        if (this.f379a) {
            Handler handler = this.f380b;
            if (handler != null) {
                handler.post(new c(i4, bundle));
                return;
            } else {
                a(i4, bundle);
                return;
            }
        }
        IResultReceiver iResultReceiver = this.f381c;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.send(i4, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        synchronized (this) {
            if (this.f381c == null) {
                this.f381c = new b();
            }
            parcel.writeStrongBinder(this.f381c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f379a = false;
        this.f380b = null;
        this.f381c = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }

    protected void a(int i4, Bundle bundle) {
    }
}
