package com.google.android.gms.maps.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
public class zzbz {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21279a = "zzbz";
    @Nullable
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static Context f21280b;

    /* renamed from: c  reason: collision with root package name */
    private static zze f21281c;

    private static <T> T a(Class<?> cls) {
        String str;
        String str2;
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException unused) {
            String name = cls.getName();
            if (name.length() != 0) {
                str2 = "Unable to call the default constructor of ".concat(name);
            } else {
                str2 = new String("Unable to call the default constructor of ");
            }
            throw new IllegalStateException(str2);
        } catch (InstantiationException unused2) {
            String name2 = cls.getName();
            if (name2.length() != 0) {
                str = "Unable to instantiate the dynamic class ".concat(name2);
            } else {
                str = new String("Unable to instantiate the dynamic class ");
            }
            throw new IllegalStateException(str);
        }
    }

    private static <T> T b(ClassLoader classLoader, String str) {
        String str2;
        try {
            return (T) a(((ClassLoader) Preconditions.checkNotNull(classLoader)).loadClass(str));
        } catch (ClassNotFoundException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Unable to find dynamic class ".concat(valueOf);
            } else {
                str2 = new String("Unable to find dynamic class ");
            }
            throw new IllegalStateException(str2);
        }
    }

    @Nullable
    private static Context c(Context context) {
        Context context2 = f21280b;
        if (context2 != null) {
            return context2;
        }
        Context d4 = d(context);
        f21280b = d4;
        return d4;
    }

    @Nullable
    private static Context d(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
        } catch (Exception e4) {
            Log.e(f21279a, "Failed to load maps module, use legacy", e4);
            return GooglePlayServicesUtil.getRemoteContext(context);
        }
    }

    public static zze zza(Context context) throws GooglePlayServicesNotAvailableException {
        zze zzfVar;
        Preconditions.checkNotNull(context);
        zze zzeVar = f21281c;
        if (zzeVar != null) {
            return zzeVar;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
        if (isGooglePlayServicesAvailable == 0) {
            Log.i(f21279a, "Making Creator dynamically");
            IBinder iBinder = (IBinder) b(c(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
            if (iBinder == null) {
                zzfVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                if (queryLocalInterface instanceof zze) {
                    zzfVar = (zze) queryLocalInterface;
                } else {
                    zzfVar = new zzf(iBinder);
                }
            }
            f21281c = zzfVar;
            try {
                zzfVar.zza(ObjectWrapper.wrap(c(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return f21281c;
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }
        throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
    }
}
