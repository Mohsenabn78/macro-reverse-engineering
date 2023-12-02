package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzezn {
    public final String zzA;
    public final zzbwp zzB;
    public final String zzC;
    public final JSONObject zzD;
    public final JSONObject zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final String zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final int zzR;
    public final int zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final String zzV;
    public final zzfal zzW;
    public final boolean zzX;
    public final boolean zzY;
    public final int zzZ;
    public final List zza;
    public final String zzaa;
    public final int zzab;
    public final String zzac;
    public final boolean zzad;
    public final zzbrz zzae;
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzs zzaf;
    public final String zzag;
    public final boolean zzah;
    public final JSONObject zzai;
    public final boolean zzaj;
    public final JSONObject zzak;
    public final boolean zzal;
    @Nullable
    public final String zzam;
    public final boolean zzan;
    public final String zzao;
    public final String zzap;
    public final String zzaq;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final List zze;
    public final int zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final List zzj;
    public final String zzk;
    public final String zzl;
    @Nullable
    public final zzbvg zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final List zzq;
    public final int zzr;
    public final List zzs;
    @Nullable
    public final zzezs zzt;
    public final List zzu;
    public final List zzv;
    public final JSONObject zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r31v2, types: [java.util.List] */
    public zzezn(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str;
        List list;
        List list2;
        char c4;
        zzfsc zzfscVar;
        List emptyList = Collections.emptyList();
        List emptyList2 = Collections.emptyList();
        List emptyList3 = Collections.emptyList();
        List emptyList4 = Collections.emptyList();
        List emptyList5 = Collections.emptyList();
        List emptyList6 = Collections.emptyList();
        List emptyList7 = Collections.emptyList();
        List emptyList8 = Collections.emptyList();
        List emptyList9 = Collections.emptyList();
        List emptyList10 = Collections.emptyList();
        List emptyList11 = Collections.emptyList();
        List emptyList12 = Collections.emptyList();
        List emptyList13 = Collections.emptyList();
        List emptyList14 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        zzfsc zzl = zzfsc.zzl();
        jsonReader.beginObject();
        JSONObject jSONObject7 = jSONObject2;
        JSONObject jSONObject8 = jSONObject3;
        JSONObject jSONObject9 = jSONObject4;
        JSONObject jSONObject10 = jSONObject5;
        JSONObject jSONObject11 = jSONObject6;
        zzfsc zzfscVar2 = zzl;
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        String str13 = str12;
        String str14 = str13;
        String str15 = str14;
        String str16 = str15;
        String str17 = str16;
        String str18 = str17;
        zzezs zzezsVar = null;
        zzbwp zzbwpVar = null;
        zzbrz zzbrzVar = null;
        com.google.android.gms.ads.internal.client.zzs zzsVar = null;
        String str19 = null;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int i5 = -1;
        int i6 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        int i7 = 0;
        int i8 = -1;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        List list3 = emptyList11;
        List list4 = emptyList12;
        List list5 = emptyList13;
        List list6 = emptyList14;
        JSONObject jSONObject12 = jSONObject;
        String str20 = str18;
        String str21 = str20;
        zzbvg zzbvgVar = null;
        int i9 = 0;
        int i10 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName == null) {
                str = "";
            } else {
                str = nextName;
            }
            switch (str.hashCode()) {
                case -2138196627:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_source_instance_name")) {
                        c4 = TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1980587809:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("debug_signals")) {
                        c4 = 28;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1965512151:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("omid_settings")) {
                        c4 = ')';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1871425831:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("recursive_server_response_data")) {
                        c4 = 'E';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1812055556:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("play_prewarm_options")) {
                        c4 = '1';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1776946669:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_source_name")) {
                        c4 = '9';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1662989631:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("is_interscroller")) {
                        c4 = '5';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1620470467:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("backend_query_id")) {
                        c4 = '/';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1550155393:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("nofill_urls")) {
                        c4 = '\r';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1440104884:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("is_custom_close_blocked")) {
                        c4 = '#';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1439500848:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("orientation")) {
                        c4 = '%';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1428969291:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("enable_omid")) {
                        c4 = '\'';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1406227629:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("buffer_click_url_as_ready_to_ping")) {
                        c4 = 'C';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1403779768:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("showable_impression_type")) {
                        c4 = ',';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1375413093:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_cover")) {
                        c4 = '6';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1360811658:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_sizes")) {
                        c4 = 19;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1306015996:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("adapters")) {
                        c4 = 20;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1303332046:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("test_mode_enabled")) {
                        c4 = Typography.quote;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1289032093:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("extras")) {
                        c4 = 29;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1240082064:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_event_value")) {
                        c4 = '3';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1234181075:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("allow_pub_rendered_attribution")) {
                        c4 = 30;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1168140544:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("presentation_error_urls")) {
                        c4 = 14;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1152230954:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_type")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1146534047:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("is_scroll_aware")) {
                        c4 = SignatureVisitor.EXTENDS;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1115838944:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("fill_urls")) {
                        c4 = '\f';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1081936678:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("allocation_id")) {
                        c4 = 21;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1078050970:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("video_complete_urls")) {
                        c4 = '\b';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1051269058:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("active_view")) {
                        c4 = 25;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -982608540:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("valid_from_timestamp")) {
                        c4 = '\n';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -972056451:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_source_instance_id")) {
                        c4 = Typography.less;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -776859333:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("click_urls")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -544216775:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("safe_browsing")) {
                        c4 = 26;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -437057161:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("imp_urls")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -404433734:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("rtb_native_required_assets")) {
                        c4 = Typography.greater;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -404326515:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("render_timeout_ms")) {
                        c4 = Typography.amp;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -397704715:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_close_time_ms")) {
                        c4 = SignatureVisitor.SUPER;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -388807511:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("content_url")) {
                        c4 = '@';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -369773488:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("is_close_button_enabled")) {
                        c4 = '2';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -213449460:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("force_disable_hardware_acceleration")) {
                        c4 = 'A';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -213424028:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("watermark")) {
                        c4 = '.';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -180214626:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("native_required_asset_viewability")) {
                        c4 = '?';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -154616268:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("is_offline_ad")) {
                        c4 = SignatureVisitor.INSTANCEOF;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -29338502:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("allow_custom_click_gesture")) {
                        c4 = ' ';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3107:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad")) {
                        c4 = 18;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3355:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("id")) {
                        c4 = 23;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3076010:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("data")) {
                        c4 = 22;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 37109963:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID)) {
                        c4 = 'D';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 63195984:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("render_test_label")) {
                        c4 = '!';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 107433883:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("qdata")) {
                        c4 = 24;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 230323073:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_load_urls")) {
                        c4 = 4;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 418392395:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("is_closable_area_disabled")) {
                        c4 = Typography.dollar;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 549176928:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("presentation_error_timeout_ms")) {
                        c4 = 16;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 597473788:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("debug_dialog_string")) {
                        c4 = 27;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 754887508:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("container_sizes")) {
                        c4 = 17;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 791122864:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("impression_type")) {
                        c4 = 5;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1010584092:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("transaction_id")) {
                        c4 = '\t';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1100650276:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("rewards")) {
                        c4 = 11;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1141602460:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("adapter_response_info_key")) {
                        c4 = '8';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1186014765:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("cache_hit_urls")) {
                        c4 = 'B';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1321720943:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("allow_pub_owned_ad_view")) {
                        c4 = 31;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1437255331:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_source_id")) {
                        c4 = ':';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1637553475:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("bid_response")) {
                        c4 = '(';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1638957285:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("video_start_urls")) {
                        c4 = 6;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1686319423:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("ad_network_class_name")) {
                        c4 = '7';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1688341040:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("video_reward_urls")) {
                        c4 = 7;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1799285870:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("use_third_party_container_height")) {
                        c4 = '0';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1839650832:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("renderers")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1875425491:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("is_analytics_logging_enabled")) {
                        c4 = TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 2068142375:
                    list = emptyList9;
                    list2 = emptyList10;
                    if (str.equals("rule_line_external_id")) {
                        c4 = '4';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 2072888499:
                    list2 = emptyList10;
                    list = emptyList9;
                    if (str.equals("manual_tracking_urls")) {
                        c4 = 15;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    list = emptyList9;
                    list2 = emptyList10;
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                    emptyList = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 1:
                    i9 = zzb(jsonReader.nextString());
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 2:
                    emptyList2 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 3:
                    emptyList3 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 4:
                    emptyList4 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 5:
                    i10 = zzc(jsonReader.nextInt());
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 6:
                    emptyList5 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 7:
                    emptyList6 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '\b':
                    emptyList7 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '\t':
                    str21 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '\n':
                    str20 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 11:
                    zzbvgVar = zzbvg.zza(com.google.android.gms.ads.internal.util.zzbu.zze(jsonReader));
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '\f':
                    emptyList8 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '\r':
                    emptyList9 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    emptyList10 = list2;
                    continue;
                case 14:
                    emptyList10 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar2 = zzfscVar2;
                    break;
                case 15:
                    list3 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 16:
                    i4 = jsonReader.nextInt();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 17:
                    list4 = zzezo.zza(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 18:
                    zzezsVar = new zzezs(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 19:
                    list6 = zzezo.zza(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 20:
                    list5 = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 21:
                    str2 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 22:
                    jSONObject12 = com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 23:
                    str3 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 24:
                    str4 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 25:
                    str5 = com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader).toString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 26:
                    zzbwpVar = zzbwp.zza(com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader));
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 27:
                    str6 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 28:
                    jSONObject7 = com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 29:
                    jSONObject8 = com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 30:
                    z3 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 31:
                    z4 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case ' ':
                    z5 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '!':
                    z6 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '\"':
                    z7 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '#':
                    z8 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '$':
                    z9 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '%':
                    i5 = zzd(jsonReader.nextString());
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '&':
                    i6 = jsonReader.nextInt();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '\'':
                    z10 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '(':
                    str7 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case ')':
                    jSONObject9 = com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '*':
                    z11 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '+':
                    z12 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case ',':
                    i7 = jsonReader.nextInt();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '-':
                    i8 = jsonReader.nextInt();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '.':
                    str8 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '/':
                    str9 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '0':
                    z13 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '1':
                    zzbrzVar = zzbrz.zza(com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader));
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '2':
                    jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '3':
                    zzsVar = com.google.android.gms.ads.internal.client.zzs.zza(com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader));
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '4':
                    str10 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '5':
                    z14 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '6':
                    jSONObject10 = com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '7':
                    str11 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '8':
                    str18 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '9':
                    if (((Boolean) zzbbm.zzgB.zzl()).booleanValue()) {
                        str12 = jsonReader.nextString();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                        break;
                    } else {
                        jsonReader.skipValue();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                    }
                case ':':
                    if (((Boolean) zzbbm.zzgB.zzl()).booleanValue()) {
                        str13 = jsonReader.nextString();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                        break;
                    } else {
                        jsonReader.skipValue();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                    }
                case ';':
                    if (((Boolean) zzbbm.zzgB.zzl()).booleanValue()) {
                        str14 = jsonReader.nextString();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                        break;
                    } else {
                        jsonReader.skipValue();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                    }
                case '<':
                    if (((Boolean) zzbbm.zzgB.zzl()).booleanValue()) {
                        str15 = jsonReader.nextString();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                        break;
                    } else {
                        jsonReader.skipValue();
                        zzfscVar = zzfscVar2;
                        emptyList10 = list2;
                        zzfscVar2 = zzfscVar;
                    }
                case '=':
                    z15 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '>':
                    jSONObject11 = com.google.android.gms.ads.internal.util.zzbu.zzh(jsonReader);
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '?':
                    z16 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case '@':
                    str19 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 'A':
                    z17 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 'B':
                    zzfscVar = com.google.android.gms.ads.internal.util.zzbu.zzd(jsonReader);
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 'C':
                    z18 = jsonReader.nextBoolean();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 'D':
                    str16 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                case 'E':
                    str17 = jsonReader.nextString();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
                default:
                    jsonReader.skipValue();
                    zzfscVar = zzfscVar2;
                    emptyList10 = list2;
                    zzfscVar2 = zzfscVar;
                    break;
            }
            emptyList9 = list;
        }
        jsonReader.endObject();
        this.zza = emptyList;
        this.zzb = i9;
        this.zzc = emptyList2;
        this.zzd = emptyList3;
        this.zzg = emptyList4;
        this.zzf = i10;
        this.zzh = emptyList5;
        this.zzi = emptyList6;
        this.zzj = emptyList7;
        this.zzk = str21;
        this.zzl = str20;
        this.zzm = zzbvgVar;
        this.zzn = emptyList8;
        this.zzo = emptyList9;
        this.zzp = emptyList10;
        this.zzq = list3;
        this.zzr = i4;
        this.zzs = list4;
        this.zzt = zzezsVar;
        this.zzu = list5;
        this.zzv = list6;
        this.zzx = str2;
        this.zzw = jSONObject12;
        this.zzy = str3;
        this.zzz = str4;
        this.zzA = str5;
        this.zzB = zzbwpVar;
        this.zzC = str6;
        this.zzD = jSONObject7;
        this.zzE = jSONObject8;
        this.zzK = z3;
        this.zzL = z4;
        this.zzM = z5;
        this.zzN = z6;
        this.zzO = z7;
        this.zzP = z8;
        this.zzQ = z9;
        this.zzR = i5;
        this.zzS = i6;
        this.zzU = z10;
        this.zzV = str7;
        this.zzW = new zzfal(jSONObject9);
        this.zzX = z11;
        this.zzY = z12;
        this.zzZ = i7;
        this.zzaa = str8;
        this.zzab = i8;
        this.zzac = str9;
        this.zzad = z13;
        this.zzae = zzbrzVar;
        this.zzaf = zzsVar;
        this.zzag = str10;
        this.zzah = z14;
        this.zzai = jSONObject10;
        this.zzF = str11;
        this.zzG = str12;
        this.zzH = str13;
        this.zzI = str14;
        this.zzJ = str15;
        this.zzaj = z15;
        this.zzak = jSONObject11;
        this.zzal = z16;
        this.zzam = str19;
        this.zzan = z17;
        this.zze = zzfscVar2;
        this.zzT = z18;
        this.zzao = str16;
        this.zzap = str17;
        this.zzaq = str18;
    }

    public static String zza(int i4) {
        switch (i4) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        if ("rewarded_interstitial".equals(str)) {
            return 7;
        }
        return 0;
    }

    private static int zzc(int i4) {
        if (i4 != 0 && i4 != 1) {
            return 0;
        }
        return i4;
    }

    private static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            return 7;
        }
        return -1;
    }
}
