package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.facebook.stetho.dumpapp.Framer;
import crashguard.android.library.d6;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.objenesis.instantiator.util.ClassDefinitionUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class u5 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f39065b;

    /* renamed from: c  reason: collision with root package name */
    private final z5 f39066c;

    /* renamed from: e  reason: collision with root package name */
    private final y0 f39068e;

    /* renamed from: d  reason: collision with root package name */
    private final k2 f39067d = new k2();

    /* renamed from: a  reason: collision with root package name */
    private final j5 f39064a = new j5();

    /* JADX INFO: Access modifiers changed from: package-private */
    public u5(Context context, z5 z5Var) {
        this.f39065b = new WeakReference<>(context);
        this.f39066c = z5Var;
        this.f39068e = new y0(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e2, code lost:
        if (android.os.Build.VERSION.SDK_INT > 25) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0200 A[Catch: all -> 0x0223, TryCatch #1 {all -> 0x0223, blocks: (B:104:0x01e6, B:106:0x0200, B:112:0x021a, B:107:0x020a, B:111:0x0217), top: B:145:0x01e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x020a A[Catch: all -> 0x0223, TryCatch #1 {all -> 0x0223, blocks: (B:104:0x01e6, B:106:0x0200, B:112:0x021a, B:107:0x020a, B:111:0x0217), top: B:145:0x01e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x023b A[Catch: all -> 0x025d, TryCatch #16 {all -> 0x025d, blocks: (B:113:0x0223, B:115:0x023b, B:116:0x0241, B:118:0x0244, B:122:0x024e, B:123:0x0258), top: B:158:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0176 A[Catch: all -> 0x01a7, TryCatch #5 {all -> 0x01a7, blocks: (B:88:0x0168, B:90:0x0176, B:91:0x0191), top: B:149:0x0168 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0191 A[Catch: all -> 0x01a7, TRY_LEAVE, TryCatch #5 {all -> 0x01a7, blocks: (B:88:0x0168, B:90:0x0176, B:91:0x0191), top: B:149:0x0168 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(android.content.Context r25) {
        /*
            Method dump skipped, instructions count: 905
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.u5.c(android.content.Context):void");
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    private void g(Context context) {
        int i4;
        long currentTimeMillis = System.currentTimeMillis();
        long a02 = this.f39068e.a0();
        if (a02 == 0 || a02 <= currentTimeMillis) {
            JSONArray jSONArray = new JSONArray();
            PackageManager packageManager = context.getPackageManager();
            try {
                for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("PackageName", k2.a(applicationInfo.packageName));
                    jSONObject.put("SourceDir", k2.a(applicationInfo.sourceDir));
                    jSONObject.put("FirstInstallTime", y4.a(packageManager.getPackageInfo(applicationInfo.packageName, 0).firstInstallTime));
                    jSONObject.put("LastUpdateTime", y4.a(packageManager.getPackageInfo(applicationInfo.packageName, 0).lastUpdateTime));
                    if (Build.VERSION.SDK_INT > 25) {
                        try {
                            i4 = applicationInfo.category;
                            if (i4 == -1) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 78, 68, 69, 70, 73, 78, 69, 68}));
                            } else if (i4 == 0) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 71, 65, 77, 69}));
                            } else if (i4 == 1) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 65, 85, 68, 73, 79}));
                            } else if (i4 == 2) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 86, 73, 68, 69, 79}));
                            } else if (i4 == 3) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, 77, 65, 71, 69}));
                            } else if (i4 == 4) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 79, 67, 73, 65, 76}));
                            } else if (i4 == 5) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 69, 87, 83}));
                            } else if (i4 == 6) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 77, 65, 80, 83}));
                            } else if (i4 == 7) {
                                jSONObject.put("Category", new String(new byte[]{67, 65, 84, 69, 71, 79, 82, ClassDefinitionUtils.OPS_dup, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 82, 79, 68, 85, 67, 84, 73, 86, 73, 84, ClassDefinitionUtils.OPS_dup}));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    PackageInfo packageInfo = packageManager.getPackageInfo(applicationInfo.packageName, 4096);
                    String[] strArr = packageInfo.requestedPermissions;
                    if (strArr != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (int i5 = 0; i5 < strArr.length; i5++) {
                            if ((packageInfo.requestedPermissionsFlags[i5] & 2) != 0) {
                                jSONObject2.put(strArr[i5], true);
                            }
                        }
                        jSONObject.put("Permissions", jSONObject2);
                    }
                    ServiceInfo[] serviceInfoArr = packageManager.getPackageInfo(applicationInfo.packageName, 4).services;
                    JSONObject jSONObject3 = new JSONObject();
                    if (serviceInfoArr != null) {
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            try {
                                if (serviceInfo.isEnabled()) {
                                    jSONObject3.put(k2.a(serviceInfo.name), serviceInfo.isEnabled());
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                        jSONObject.put("Services", jSONObject3);
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable unused3) {
            }
            this.f39064a.G(jSONArray);
            this.f39068e.K(currentTimeMillis + 302400000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(19:1|(2:2|3)|4|(2:5|(1:110)(2:7|(2:10|11)(1:9)))|12|(4:98|99|(1:105)|(1:107))|(3:14|15|16)|(18:18|(1:20)(1:89)|21|(1:23)|24|(2:28|29)|30|(1:32)|34|35|36|37|38|39|40|(9:42|43|44|(4:47|(3:55|56|57)|58|45)|62|63|(4:65|66|67|(4:69|(1:71)|72|73))|76|77)|82|83)(15:90|(2:92|(1:94)(13:95|30|(0)|34|35|36|37|38|39|40|(0)|82|83))(1:96)|29|30|(0)|34|35|36|37|38|39|40|(0)|82|83)|97|34|35|36|37|38|39|40|(0)|82|83) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:1|(2:2|3)|4|(2:5|(1:110)(2:7|(2:10|11)(1:9)))|12|(4:98|99|(1:105)|(1:107))|14|15|16|(18:18|(1:20)(1:89)|21|(1:23)|24|(2:28|29)|30|(1:32)|34|35|36|37|38|39|40|(9:42|43|44|(4:47|(3:55|56|57)|58|45)|62|63|(4:65|66|67|(4:69|(1:71)|72|73))|76|77)|82|83)(15:90|(2:92|(1:94)(13:95|30|(0)|34|35|36|37|38|39|40|(0)|82|83))(1:96)|29|30|(0)|34|35|36|37|38|39|40|(0)|82|83)|97|34|35|36|37|38|39|40|(0)|82|83) */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0209 A[Catch: all -> 0x020e, TRY_LEAVE, TryCatch #11 {all -> 0x020e, blocks: (B:31:0x01a2, B:34:0x01aa, B:36:0x01b8, B:38:0x01be, B:40:0x01ce, B:43:0x01d6, B:45:0x01e8, B:54:0x0203, B:56:0x0209, B:48:0x01f1, B:50:0x01f9, B:52:0x0200), top: B:113:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0246  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final crashguard.android.library.j5 a(boolean r27) {
        /*
            Method dump skipped, instructions count: 824
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: crashguard.android.library.u5.a(boolean):crashguard.android.library.j5");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j4) {
        long j5;
        j5 j5Var = this.f39064a;
        if (Math.abs(j4) < 1000) {
            j5 = 0;
        } else {
            j5 = j4 / 1000;
        }
        j5Var.J(j5);
        List<w> I = this.f39064a.I();
        if (I != null) {
            for (w wVar : I) {
                wVar.b(wVar.c() + j4);
            }
        }
        j5 j5Var2 = this.f39064a;
        j5Var2.O(j5Var2.f() + j4);
        List<y1> y02 = this.f39064a.y0();
        if (y02 != null) {
            for (y1 y1Var : y02) {
                y1Var.c(y1Var.j() + j4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(d6.a aVar) {
        this.f39064a.K(aVar.f38701a);
        this.f39064a.P(aVar.f38702b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(String str) {
        this.f39064a.z0(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(long j4) {
        this.f39064a.D(j4);
    }
}
