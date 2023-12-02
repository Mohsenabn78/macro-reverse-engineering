package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class RxPermissionsFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private Map<String, PublishSubject<Permission>> f38007b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private boolean f38008c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    public boolean b(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    public boolean c(String str) {
        boolean isPermissionRevokedByPolicy;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            isPermissionRevokedByPolicy = activity.getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
            return isPermissionRevokedByPolicy;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    public boolean containsByPermission(@NonNull String str) {
        return this.f38007b.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        if (this.f38008c) {
            String str2 = RxPermissions.f37991b;
        }
    }

    void e(String[] strArr, int[] iArr, boolean[] zArr) {
        boolean z3;
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            d("onRequestPermissionsResult  " + strArr[i4]);
            PublishSubject<Permission> publishSubject = this.f38007b.get(strArr[i4]);
            if (publishSubject == null) {
                Log.e(RxPermissions.f37991b, "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.f38007b.remove(strArr[i4]);
            if (iArr[i4] == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            publishSubject.onNext(new Permission(strArr[i4], z3, zArr[i4]));
            publishSubject.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    public void f(@NonNull String[] strArr) {
        requestPermissions(strArr, 42);
    }

    public PublishSubject<Permission> getSubjectByPermission(@NonNull String str) {
        return this.f38007b.get(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    @TargetApi(23)
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i4, strArr, iArr);
        if (i4 != 42) {
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            zArr[i5] = shouldShowRequestPermissionRationale(strArr[i5]);
        }
        e(strArr, iArr, zArr);
    }

    public void setLogging(boolean z3) {
        this.f38008c = z3;
    }

    public void setSubjectForPermission(@NonNull String str, @NonNull PublishSubject<Permission> publishSubject) {
        this.f38007b.put(str, publishSubject);
    }
}
