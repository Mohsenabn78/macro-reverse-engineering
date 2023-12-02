package com.google.firebase.auth.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import java.util.Arrays;
import java.util.List;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzai {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    private static Status a(String str, @Nullable String str2) {
        char c4;
        int i4;
        switch (str.hashCode()) {
            case -2130504259:
                if (str.equals("USER_CANCELLED")) {
                    c4 = 'C';
                    break;
                }
                c4 = 65535;
                break;
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    c4 = 28;
                    break;
                }
                c4 = 65535;
                break;
            case -2014808264:
                if (str.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                    c4 = '/';
                    break;
                }
                c4 = 65535;
                break;
            case -2005236790:
                if (str.equals("INTERNAL_SUCCESS_SIGN_OUT")) {
                    c4 = '@';
                    break;
                }
                c4 = 65535;
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -1944433728:
                if (str.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                    c4 = SignatureVisitor.SUPER;
                    break;
                }
                c4 = 65535;
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    c4 = '\'';
                    break;
                }
                c4 = 65535;
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    c4 = ')';
                    break;
                }
                c4 = 65535;
                break;
            case -1699246888:
                if (str.equals("INVALID_RECAPTCHA_VERSION")) {
                    c4 = 'K';
                    break;
                }
                c4 = 65535;
                break;
            case -1603818979:
                if (str.equals("RECAPTCHA_NOT_ENABLED")) {
                    c4 = 'H';
                    break;
                }
                c4 = 65535;
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    c4 = 25;
                    break;
                }
                c4 = 65535;
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    c4 = 24;
                    break;
                }
                c4 = 65535;
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    c4 = 29;
                    break;
                }
                c4 = 65535;
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    c4 = Typography.quote;
                    break;
                }
                c4 = 65535;
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    c4 = 23;
                    break;
                }
                c4 = 65535;
                break;
            case -1340100504:
                if (str.equals("INVALID_TENANT_ID")) {
                    c4 = '2';
                    break;
                }
                c4 = 65535;
                break;
            case -1242922234:
                if (str.equals("ALTERNATE_CLIENT_IDENTIFIER_REQUIRED")) {
                    c4 = 'N';
                    break;
                }
                c4 = 65535;
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    c4 = Typography.dollar;
                    break;
                }
                c4 = 65535;
                break;
            case -1202691903:
                if (str.equals("SECOND_FACTOR_EXISTS")) {
                    c4 = Typography.less;
                    break;
                }
                c4 = 65535;
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case -1063710844:
                if (str.equals("ADMIN_ONLY_OPERATION")) {
                    c4 = ':';
                    break;
                }
                c4 = 65535;
                break;
            case -974503964:
                if (str.equals("MISSING_OR_INVALID_NONCE")) {
                    c4 = 'B';
                    break;
                }
                c4 = 65535;
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    c4 = '(';
                    break;
                }
                c4 = 65535;
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -749743758:
                if (str.equals("MFA_ENROLLMENT_NOT_FOUND")) {
                    c4 = '9';
                    break;
                }
                c4 = 65535;
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    c4 = 30;
                    break;
                }
                c4 = 65535;
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    c4 = 20;
                    break;
                }
                c4 = 65535;
                break;
            case -595928767:
                if (str.equals("TIMEOUT")) {
                    c4 = 14;
                    break;
                }
                c4 = 65535;
                break;
            case -505579581:
                if (str.equals("INVALID_REQ_TYPE")) {
                    c4 = 'L';
                    break;
                }
                c4 = 65535;
                break;
            case -380728810:
                if (str.equals("INVALID_RECAPTCHA_ACTION")) {
                    c4 = 'G';
                    break;
                }
                c4 = 65535;
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    c4 = 17;
                    break;
                }
                c4 = 65535;
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    c4 = TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH;
                    break;
                }
                c4 = 65535;
                break;
            case -217128228:
                if (str.equals("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                    c4 = SignatureVisitor.INSTANCEOF;
                    break;
                }
                c4 = 65535;
                break;
            case -122667194:
                if (str.equals("MISSING_MFA_ENROLLMENT_ID")) {
                    c4 = '7';
                    break;
                }
                c4 = 65535;
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case -52772551:
                if (str.equals("CAPTCHA_CHECK_FAILED")) {
                    c4 = 'M';
                    break;
                }
                c4 = 65535;
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    c4 = 16;
                    break;
                }
                c4 = 65535;
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case 210308040:
                if (str.equals("UNSUPPORTED_FIRST_FACTOR")) {
                    c4 = Typography.greater;
                    break;
                }
                c4 = 65535;
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    c4 = 27;
                    break;
                }
                c4 = 65535;
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    c4 = 31;
                    break;
                }
                c4 = 65535;
                break;
            case 408411681:
                if (str.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                    c4 = '3';
                    break;
                }
                c4 = 65535;
                break;
            case 423563023:
                if (str.equals("MISSING_MFA_PENDING_CREDENTIAL")) {
                    c4 = '6';
                    break;
                }
                c4 = 65535;
                break;
            case 429251986:
                if (str.equals("UNSUPPORTED_PASSTHROUGH_OPERATION")) {
                    c4 = 'D';
                    break;
                }
                c4 = 65535;
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    c4 = '\r';
                    break;
                }
                c4 = 65535;
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    c4 = SignatureVisitor.EXTENDS;
                    break;
                }
                c4 = 65535;
                break;
            case 492515765:
                if (str.equals("MISSING_CLIENT_TYPE")) {
                    c4 = 'I';
                    break;
                }
                c4 = 65535;
                break;
            case 530628231:
                if (str.equals("MISSING_RECAPTCHA_VERSION")) {
                    c4 = 'J';
                    break;
                }
                c4 = 65535;
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    c4 = 18;
                    break;
                }
                c4 = 65535;
                break;
            case 582457886:
                if (str.equals("UNVERIFIED_EMAIL")) {
                    c4 = TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
                    break;
                }
                c4 = 65535;
                break;
            case 605031096:
                if (str.equals("REJECTED_CREDENTIAL")) {
                    c4 = '4';
                    break;
                }
                c4 = 65535;
                break;
            case 745638750:
                if (str.equals("INVALID_MFA_PENDING_CREDENTIAL")) {
                    c4 = '8';
                    break;
                }
                c4 = 65535;
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    c4 = '%';
                    break;
                }
                c4 = 65535;
                break;
            case 799258561:
                if (str.equals("INVALID_PROVIDER_ID")) {
                    c4 = '.';
                    break;
                }
                c4 = 65535;
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 844240628:
                if (str.equals("WEB_CONTEXT_CANCELED")) {
                    c4 = '0';
                    break;
                }
                c4 = 65535;
                break;
            case 886186878:
                if (str.equals("REQUIRES_SECOND_FACTOR_AUTH")) {
                    c4 = '5';
                    break;
                }
                c4 = 65535;
                break;
            case 895302372:
                if (str.equals("MISSING_CLIENT_IDENTIFIER")) {
                    c4 = 'A';
                    break;
                }
                c4 = 65535;
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    c4 = 26;
                    break;
                }
                c4 = 65535;
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    c4 = 22;
                    break;
                }
                c4 = 65535;
                break;
            case 1034932393:
                if (str.equals("INVALID_PENDING_TOKEN")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    c4 = 11;
                    break;
                }
                c4 = 65535;
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    c4 = 15;
                    break;
                }
                c4 = 65535;
                break;
            case 1113992697:
                if (str.equals("INVALID_RECAPTCHA_TOKEN")) {
                    c4 = 'F';
                    break;
                }
                c4 = 65535;
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    c4 = Typography.amp;
                    break;
                }
                c4 = 65535;
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    c4 = '!';
                    break;
                }
                c4 = 65535;
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    c4 = '\f';
                    break;
                }
                c4 = 65535;
                break;
            case 1308491624:
                if (str.equals("MISSING_RECAPTCHA_TOKEN")) {
                    c4 = 'E';
                    break;
                }
                c4 = 65535;
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    c4 = ' ';
                    break;
                }
                c4 = 65535;
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    c4 = 19;
                    break;
                }
                c4 = 65535;
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    c4 = 21;
                    break;
                }
                c4 = 65535;
                break;
            case 1803454477:
                if (str.equals("MISSING_CONTINUE_URI")) {
                    c4 = ',';
                    break;
                }
                c4 = 65535;
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    c4 = '#';
                    break;
                }
                c4 = 65535;
                break;
            case 2063209097:
                if (str.equals("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                    c4 = '?';
                    break;
                }
                c4 = 65535;
                break;
            case 2082564316:
                if (str.equals("UNSUPPORTED_TENANT_OPERATION")) {
                    c4 = '1';
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                i4 = FirebaseError.ERROR_NO_SUCH_PROVIDER;
                break;
            case 1:
                i4 = FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH;
                break;
            case 2:
                i4 = FirebaseError.ERROR_INVALID_CUSTOM_TOKEN;
                break;
            case 3:
            case 4:
                i4 = FirebaseError.ERROR_INVALID_CREDENTIAL;
                break;
            case 5:
                i4 = FirebaseError.ERROR_USER_DISABLED;
                break;
            case 6:
            case 7:
                i4 = FirebaseError.ERROR_INVALID_EMAIL;
                break;
            case '\b':
            case '\t':
                i4 = FirebaseError.ERROR_USER_NOT_FOUND;
                break;
            case '\n':
                i4 = FirebaseError.ERROR_EMAIL_ALREADY_IN_USE;
                break;
            case 11:
                i4 = FirebaseError.ERROR_WRONG_PASSWORD;
                break;
            case '\f':
                i4 = FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE;
                break;
            case '\r':
                i4 = FirebaseError.ERROR_INVALID_USER_TOKEN;
                break;
            case 14:
            case 15:
                i4 = FirebaseError.ERROR_NETWORK_REQUEST_FAILED;
                break;
            case 16:
                i4 = FirebaseError.ERROR_WEAK_PASSWORD;
                break;
            case 17:
            case 18:
                i4 = FirebaseError.ERROR_OPERATION_NOT_ALLOWED;
                break;
            case 19:
                i4 = FirebaseError.ERROR_APP_NOT_AUTHORIZED;
                break;
            case 20:
                i4 = FirebaseError.ERROR_REQUIRES_RECENT_LOGIN;
                break;
            case 21:
            case 22:
                i4 = FirebaseError.ERROR_TOO_MANY_REQUESTS;
                break;
            case 23:
                i4 = FirebaseError.ERROR_USER_TOKEN_EXPIRED;
                break;
            case 24:
                i4 = 17030;
                break;
            case 25:
                i4 = 17029;
                break;
            case 26:
                i4 = 17031;
                break;
            case 27:
                i4 = 17032;
                break;
            case 28:
                i4 = 17033;
                break;
            case 29:
                i4 = 17034;
                break;
            case 30:
                i4 = 17035;
                break;
            case 31:
                i4 = 17041;
                break;
            case ' ':
                i4 = 17042;
                break;
            case '!':
                i4 = 17043;
                break;
            case '\"':
                i4 = 17044;
                break;
            case '#':
                i4 = 17045;
                break;
            case '$':
                i4 = 17046;
                break;
            case '%':
                i4 = 17049;
                break;
            case '&':
                i4 = 17051;
                break;
            case '\'':
                i4 = 17052;
                break;
            case '(':
                i4 = 17064;
                break;
            case ')':
                i4 = 17061;
                break;
            case '*':
                i4 = 17062;
                break;
            case '+':
                i4 = 17065;
                break;
            case ',':
                i4 = 17040;
                break;
            case '-':
                i4 = 17068;
                break;
            case '.':
                i4 = 17071;
                break;
            case '/':
                i4 = 17057;
                break;
            case '0':
                i4 = 17058;
                break;
            case '1':
                i4 = 17073;
                break;
            case '2':
                i4 = 17079;
                break;
            case '3':
                i4 = 17074;
                break;
            case '4':
                i4 = 17075;
                break;
            case '5':
                i4 = 17078;
                break;
            case '6':
                i4 = 17081;
                break;
            case '7':
                i4 = 17082;
                break;
            case '8':
                i4 = 17083;
                break;
            case '9':
                i4 = 17084;
                break;
            case ':':
                i4 = 17085;
                break;
            case ';':
                i4 = 17086;
                break;
            case '<':
                i4 = 17087;
                break;
            case '=':
                i4 = 17088;
                break;
            case '>':
                i4 = 17089;
                break;
            case '?':
                i4 = 17090;
                break;
            case '@':
                i4 = 17091;
                break;
            case 'A':
                i4 = 17093;
                break;
            case 'B':
                i4 = 17094;
                break;
            case 'C':
                i4 = 18001;
                break;
            case 'D':
                i4 = 17095;
                break;
            case 'E':
                i4 = 17201;
                break;
            case 'F':
                i4 = 17202;
                break;
            case 'G':
                i4 = 17203;
                break;
            case 'H':
                i4 = 17200;
                break;
            case 'I':
                i4 = 17204;
                break;
            case 'J':
                i4 = 17205;
                break;
            case 'K':
                i4 = 17206;
                break;
            case 'L':
                i4 = 17207;
                break;
            case 'M':
                i4 = 17056;
                break;
            case 'N':
                i4 = 18002;
                break;
            default:
                i4 = FirebaseError.ERROR_INTERNAL_ERROR;
                break;
        }
        if (i4 == 17499) {
            if (str2 != null) {
                return new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, str + ":" + str2);
            }
            return new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, str);
        }
        return new Status(i4, str2);
    }

    @NonNull
    public static Status zza(@Nullable String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            split[0] = split[0].trim();
            if (split.length > 1 && (str2 = split[1]) != null) {
                split[1] = str2.trim();
            }
            List asList = Arrays.asList(split);
            if (asList.size() > 1) {
                return a((String) asList.get(0), (String) asList.get(1));
            }
            return a((String) asList.get(0), null);
        }
        return new Status(FirebaseError.ERROR_INTERNAL_ERROR);
    }
}
