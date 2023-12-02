package com.google.api.client.testing.json.webtoken;

import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Lists;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

@Beta
/* loaded from: classes5.dex */
public class TestCertificates {
    public static final String CA_KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDN5Q1zhtJYeE5N\nT7kxD+U6aaNBal8GL4Um7G+h46ZDCLp+s8oqxoopgZ8JM+UoTR2asQ/3lueL+ovn\nECk/XuiuNR7opG0kDAU0jkRlp0h+NuH+r7zkLUKnYFLZia5lDNdkc/rfLIGnTlhx\nswrAIEddoCBhuZNOT7j7WmM2kc/piIXaAI+9J/OiQbKFu8Gqc9udN0j3Dp+M0FgB\nuv+4E5NTS8riS3OVaTmW+ybnV7y+wtKpaGgcAOrQCuIB6VThIexIAKRFRBLFZXQr\nmHNO/h5y8Jsb12ySIMLBaD65NFKgAV5k6E40vTTSrtV7LcNlNwuXz87g1BVplHmI\nCBVaVZyzAgMBAAECggEANfRuP/X2rURpkIzxxM+bjGEebQgI+r/9LqQK5OuZKDvj\nU0yeD/OTRSk4mdrFlHgQ5/a6bnFXIDF59AUiKf8fDnfRL7nW9/lGa+1UMydRMfID\n6w/2efz6WI4/Z85SqxxgXWyfM1igaU14k+MNUCelS/2oPrO4zG7L1OJs2WIAj/vE\nHnndSBa3rvTXmY37JclkChFokG0svuZMmaXWG1JI6JziSsvO4YZAYvZ10yCvbFzZ\niczMCyyGhRcUeG3wbVDK0lPp5f1jKtyfuQtR2uFhdRHUk2+cMY6s/o3hgdW5b/z9\nYddyw28tC6/uECHJs8dsmNM4hPc+n2+wCVwB9HbSMQKBgQD3V640Tv5UWiHM4lGq\npSdUViNsLgDLmNplWLB0aRbBgTsJLGlzI1sGqSEydlZORYZT4GBdLmTJdumBGBAn\n4FxfyyAVjjn8WjYo9ocyMrIGLFKF3EvSyx4opsOX6QOyuyzdDhzt+BkY66Zb0Bgl\nlzUQ4S6hhvvEQc5COiNmTuDT/QKBgQDVGfpp8yBamTyRgGQWTwRqIQuJC2QHOrhV\nOKQ7NwMyMObyML0ZQm2SCu+Oo0qsMxz8Ix6sNtnJfxZxpUYCLG3HWc6EfaGT1hDR\nEgWsdl9J/xP/KwgSzHuSqZTCuNQRTg/XbNfjXnMHy8UaTBL+0jHLAnmvczBrSnEM\nr8RgkjoabwKBgQCkuklz3vQ1O33tVQEs1Cc4XNHkl1LCRb+V5ZZHQUH9h9LIjkKA\ngxh5fCR21icuo9ENhY7IIEDRiBeFeYAw/pSm28I3eOyXa4FMkLuDrA2yXMxtCEWb\nUtl4G3CCeJaU72G2q1KLDkOwvCikVxft2SFnZ4FF5H9CuszigJPY7EmCBQKBgD+/\nfra1IWeY0ZKhOs+loadx7TZ47tpuyXfM8uw337/i+yNWSytEQOzgUptz48GxpKkU\nhHd2DR6G4xrqGxBJZCmvhuUBhBVqgytX3dSisIy9PqkloUumWg0cp8C8c8wdcwW5\nrLd6qKSbY4IjYcdS78xQGEDRD5n48eqepftRowoHAoGBAMdJ5/QwIymaTBhblYiL\nnvzZZ6kvxqId+JF93skZJ4NdQ346CVcWWbjTwO/oaJ9ri3MsWY18t4uSIYeYyaCa\n5dqQo3nObq2jqxFby92GWSNrwape2FvRGzJ7hnr44EkxUlQPeICod84RI/1mdOM8\nE+VTo/KjRA8P2ogks9bltd6f\n-----END PRIVATE KEY-----";
    public static final String FOO_BAR_COM_KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCzFVKJOkqTmyyj\nMHWBOrLdpYmc0EcvG3MohaV+UJrVrI2SDykY8YWSkTKz9BKmF8HP/GjPPDs3184C\nej9b1WeyvVB8Rj3guH3oL+sJT3u9V2y4zyo5xO6FWMBYEQ6X8DkGlYtTp5theYbR\nrXNELul4lF+LtHTCaAANRMkOl0NEoLa6BRhOG68gFfIAxx5lT8REE9utvPuy+rCa\nBHnfHOPf8pn0LSvceBijSIFoS3Y5crjPVjyiPAZUHWnHTFAilfHnpLBlGxpCyleP\nQhMKrPcgvDoD9nd0LA6xYLF7DPXXSa8FLO+fPV8CNJCAsFuq9Rlf2Tt3SjLtWRYu\nh5LuctP7AgMBAAECggEBAJZQomue6vQEfq4nQaoL/BCBHwXp6KYIs1ti+msQ+zW4\n1Ueww/001LoWd+mGR5T0QfDy24J++vG/iSKZO884TAdCUmlNiCi0krIubmjtN17R\nH+frs3Sz8MUqnqANCSPNNgBpy32XJJvnppserK6hdcSJPb2E5bA8HTcF8oD1xDe4\nCgPK9PKL2PxrR0ofs09RLGTSdh2+rPWvvefk1x1uBfg+wHRlfvqMSKpZ3SDabjhy\nPgB21D86SlF5L1AfeqSTfQvmwMLtOpJCVjLK2WZmvdoY7kbwE416AMLxX4tw2a/l\nvzVyo2T/B0Wc3be+5m2o96TctHRH1yEK4huEOJojvBECgYEA5RloFMOnYNMZdoEf\nyl6TAPEmFD7vCYHXpSlQdFFKu988CNF5+grn9kjC7rF+JxPEYUsnNA11TFzFEfki\nLu0uXirJH+0gQzEp/qGd2SjDANCk+kORjeOOmefbxziG/Y74rnJ1A7gZjL8Abrie\nK0mTfOk9DcgqX96PP4HXgX3+XYkCgYEAyBx28UNZoL3Dy8iquTV0VmXCOq2c5+aW\n3YS2BKP9rAPy5mWWy6PR28yduomuUu04GxHYf2yw0+0UxpPyWu8TdQHJKjLX4On7\nL+ZholvXpyqs51btsbBiRK022akh/MPnqdD9zt/RS2b1QM4yfEWN8kVE3zsMWxMP\ngBf9EH4taGMCgYBfsD3ttk65vVI8UfBiSSAjW5WpDSQwF2BnpprpCm8pizL7B+tn\niZibIIbyxYXIcpQqgwZL0nc0vua8/A7QBNbCFCLPR+6awfUlWoGgi0rvkzXlJcWs\nuuf71oDQdAbF7yplSn8fX4ykYb6fgFLoB6InoQ+UKw+v3Th9sRC/EE3m6QKBgDBN\nRpyHwDufcoJe5m6cK3+rQk29mFEVhLblkLXgC5wYu+nG/bYbzcz7P9tF3nEf11oZ\nXaOsTaZp5IjmLyqp6I1mp/LqoNcmQz5Vop15A73S/Dc+8VLhm2auVL4HKDAF7YY8\n7vafabqEmJBS9Tav50piU/R6IUpeeHBX2frAKh+3AoGAPTLxTMMEbhZGJFs8GRP9\nfFyWZeEkf3tgUK19tAAOk3TX+O0TNvD8UouXq7Z/EUaE1mYhKPf5LbI6nbYEVll4\nmWLGd+o8FNFp6E5083O3Tgf0BI4l+sKnwpP/Sqg9BDGARTPS5taeX0SWtQ+HPYGC\n4e5m59uhN7t8tHtDVcK0/Pk=\n-----END PRIVATE KEY-----";
    public static final String JWS_SIGNATURE = "eyJhbGciOiJSUzI1NiIsIng1YyI6WyJNSUlDNlRDQ0FkRUNBU293RFFZSktvWklodmNOQVFFTEJRQXdEekVOTUFzR0ExVUVBd3dFVW05dmREQWVGdzB4TkRFeE1UZ3hOalUwTUROYUZ3MHpOREV4TVRNeE5qVTBNRE5hTUdZeEN6QUpCZ05WQkFZVEFsVlRNUk13RVFZRFZRUUlEQXBEWVd4cFptOXlibWxoTVJZd0ZBWURWUVFIREExTmIzVnVkR0ZwYmlCV2FXVjNNUlF3RWdZRFZRUUtEQXRIYjI5bmJHVWdTVzVqTGpFVU1CSUdBMVVFQXd3TFptOXZMbUpoY2k1amIyMHdnZ0VpTUEwR0NTcUdTSWIzRFFFQkFRVUFBNElCRHdBd2dnRUtBb0lCQVFDekZWS0pPa3FUbXl5ak1IV0JPckxkcFltYzBFY3ZHM01vaGFWK1VKclZySTJTRHlrWThZV1NrVEt6OUJLbUY4SFAvR2pQUERzMzE4NENlajliMVdleXZWQjhSajNndUgzb0wrc0pUM3U5VjJ5NHp5bzV4TzZGV01CWUVRNlg4RGtHbFl0VHA1dGhlWWJSclhORUx1bDRsRitMdEhUQ2FBQU5STWtPbDBORW9MYTZCUmhPRzY4Z0ZmSUF4eDVsVDhSRUU5dXR2UHV5K3JDYUJIbmZIT1BmOHBuMExTdmNlQmlqU0lGb1MzWTVjcmpQVmp5aVBBWlVIV25IVEZBaWxmSG5wTEJsR3hwQ3lsZVBRaE1LclBjZ3ZEb0Q5bmQwTEE2eFlMRjdEUFhYU2E4RkxPK2ZQVjhDTkpDQXNGdXE5UmxmMlR0M1NqTHRXUll1aDVMdWN0UDdBZ01CQUFFd0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFFc01BQlpsKzhSbGswaHFCa3RzRHVycmk0bkYvMDdDblNCZS96VWJUaVloTXByN1ZSSURsSExvZTVsc2xMaWxmWHp2YXltY01GZUgxdUJ4TndoZjdJTzdXdkl3UWVVSFNWK3JIeU55Z1RUaWVPMEpuOEh3KzRTQ29oSEFkTXZENXVXRXduM0x2K1c0eTdPaGFTYnpsaFZDVkNuRkxWS2ljQmF5VVhIdGRKWEpJQ29rUjQraC9XTk03ZzBpS1RoYWtaT3lmYjhoMXBoeTdUTVRWbFBGS3JjVkRvNW05K0dodFBDNFBOakdMb2s2ci9qeDlDSU9DYXBJcWk4ZlhKRU94S3ZpbFllQVlxZmpXdmh4MDBqdUVVQkhycENROHdUNFRBK0xsSTAyY1J6NXJ4VzRGUUF6MU5kb0c5SFpEWldhK05ORlRaZEFtdFdQSk1MZCs4TDhzbDQ9IiwiTUlJQzhUQ0NBZG1nQXdJQkFnSUpBTU5JMTVIckd5bGtNQTBHQ1NxR1NJYjNEUUVCQ3dVQU1BOHhEVEFMQmdOVkJBTU1CRkp2YjNRd0hoY05NVFF4TVRFNE1UWTFOREF6V2hjTk16UXhNVEV6TVRZMU5EQXpXakFQTVEwd0N3WURWUVFEREFSU2IyOTBNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQXplVU5jNGJTV0hoT1RVKzVNUS9sT21talFXcGZCaStGSnV4dm9lT21Rd2k2ZnJQS0tzYUtLWUdmQ1RQbEtFMGRtckVQOTVibmkvcUw1eEFwUDE3b3JqVWU2S1J0SkF3Rk5JNUVaYWRJZmpiaC9xKzg1QzFDcDJCUzJZbXVaUXpYWkhQNjN5eUJwMDVZY2JNS3dDQkhYYUFnWWJtVFRrKzQrMXBqTnBIUDZZaUYyZ0NQdlNmem9rR3loYnZCcW5QYm5UZEk5dzZmak5CWUFici91Qk9UVTB2SzRrdHpsV2s1bHZzbTUxZTh2c0xTcVdob0hBRHEwQXJpQWVsVTRTSHNTQUNrUlVRU3hXVjBLNWh6VHY0ZWN2Q2JHOWRza2lEQ3dXZyt1VFJTb0FGZVpPaE9OTDAwMHE3VmV5M0RaVGNMbDgvTzROUVZhWlI1aUFnVldsV2Nzd0lEQVFBQm8xQXdUakFkQmdOVkhRNEVGZ1FVc2ltbElSRGNKUjBvZlI3b004S3dIRk9IK3NJd0h3WURWUjBqQkJnd0ZvQVVzaW1sSVJEY0pSMG9mUjdvTThLd0hGT0grc0l3REFZRFZSMFRCQVV3QXdFQi96QU5CZ2txaGtpRzl3MEJBUXNGQUFPQ0FRRUFXUWw4U21iUW9CVjN0ak9KOHpNbGNOMHhPUHBTU05ieDBnN0VML2RRZ0pwZXQwTWNXNjJSSGxnUUFPS2JTM1BSZW8ybnNSQi9aUnlZRHU0aTEzWkhaOGJNc0dPRVM0QlFwejEzbXRtWGc5UmhzWHFMMGVEWWZCY2pqdGxydVVieGhuQUxwNFZOMXpWZHlXQVBDajBldTNNeHBnTVdjeW41MFFtaUpTai9FcXUvbExodmUvd0t2akc1V2huVjh1UktSdUZiRmN0MERIQUhNblpxRkhjR1M1U28wY1luU2ZLNWZiQlJOZWxHZmxocGJiUHAwVjBhWGlxaW5xRDBZZTNPYVpkRnErMnJQMW9DL2E1L091NExzcFkzYjVvRDlyRU5keTdicTBLZXdQRnRnUHZVa0pySjNUemJpd3ZwZ2haN3pHMjZibko1STd1YzR5MVZ1anFhT0E9PSJdfQ.eyJmb28iOiJiYXIifQ.eWzIsJF4PExQap9HK6Vlz8DGlgGwoiLCtyOEK0Bfu_yHTAZeApn5rh6Uzfx06Gv6eHdM34YL_tgLRb4bjuZVA8xvQ9uHNs8UtpBIOiUcagzvtKyyfCofk5U5sNb54GgVVYxa6p4A1ObdJv1jjlUOnzR8keX5LsAM4Ia7xeqiFh0GER4l0ulVChy_bSn0IeNiKFW7HKcxtcGO_zZTtlv4HiifuyPSk_ar2IDX1w599KXniVcWkQ_W1zcp5YuPDw8mIQDVCH2uQY7qs2ejdZj5LIgIz4CbQ0wg53rlwE7DDQM6MNUgZLnzNmMSMfFrpE7_PQyxe2qJCsucHODzEHX4Tg";
    public static final CertData FOO_BAR_COM_CERT = new CertData("-----BEGIN CERTIFICATE-----\nMIIC6TCCAdECASowDQYJKoZIhvcNAQELBQAwDzENMAsGA1UEAwwEUm9vdDAeFw0x\nNDExMTgxNjU0MDNaFw0zNDExMTMxNjU0MDNaMGYxCzAJBgNVBAYTAlVTMRMwEQYD\nVQQIDApDYWxpZm9ybmlhMRYwFAYDVQQHDA1Nb3VudGFpbiBWaWV3MRQwEgYDVQQK\nDAtHb29nbGUgSW5jLjEUMBIGA1UEAwwLZm9vLmJhci5jb20wggEiMA0GCSqGSIb3\nDQEBAQUAA4IBDwAwggEKAoIBAQCzFVKJOkqTmyyjMHWBOrLdpYmc0EcvG3MohaV+\nUJrVrI2SDykY8YWSkTKz9BKmF8HP/GjPPDs3184Cej9b1WeyvVB8Rj3guH3oL+sJ\nT3u9V2y4zyo5xO6FWMBYEQ6X8DkGlYtTp5theYbRrXNELul4lF+LtHTCaAANRMkO\nl0NEoLa6BRhOG68gFfIAxx5lT8REE9utvPuy+rCaBHnfHOPf8pn0LSvceBijSIFo\nS3Y5crjPVjyiPAZUHWnHTFAilfHnpLBlGxpCylePQhMKrPcgvDoD9nd0LA6xYLF7\nDPXXSa8FLO+fPV8CNJCAsFuq9Rlf2Tt3SjLtWRYuh5LuctP7AgMBAAEwDQYJKoZI\nhvcNAQELBQADggEBAEsMABZl+8Rlk0hqBktsDurri4nF/07CnSBe/zUbTiYhMpr7\nVRIDlHLoe5lslLilfXzvaymcMFeH1uBxNwhf7IO7WvIwQeUHSV+rHyNygTTieO0J\nn8Hw+4SCohHAdMvD5uWEwn3Lv+W4y7OhaSbzlhVCVCnFLVKicBayUXHtdJXJICok\nR4+h/WNM7g0iKThakZOyfb8h1phy7TMTVlPFKrcVDo5m9+GhtPC4PNjGLok6r/jx\n9CIOCapIqi8fXJEOxKvilYeAYqfjWvhx00juEUBHrpCQ8wT4TA+LlI02cRz5rxW4\nFQAz1NdoG9HZDZWa+NNFTZdAmtWPJMLd+8L8sl4=\n-----END CERTIFICATE-----");
    public static final CertData CA_CERT = new CertData("-----BEGIN CERTIFICATE-----\nMIIC8TCCAdmgAwIBAgIJAMNI15HrGylkMA0GCSqGSIb3DQEBCwUAMA8xDTALBgNV\nBAMMBFJvb3QwHhcNMTQxMTE4MTY1NDAzWhcNMzQxMTEzMTY1NDAzWjAPMQ0wCwYD\nVQQDDARSb290MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzeUNc4bS\nWHhOTU+5MQ/lOmmjQWpfBi+FJuxvoeOmQwi6frPKKsaKKYGfCTPlKE0dmrEP95bn\ni/qL5xApP17orjUe6KRtJAwFNI5EZadIfjbh/q+85C1Cp2BS2YmuZQzXZHP63yyB\np05YcbMKwCBHXaAgYbmTTk+4+1pjNpHP6YiF2gCPvSfzokGyhbvBqnPbnTdI9w6f\njNBYAbr/uBOTU0vK4ktzlWk5lvsm51e8vsLSqWhoHADq0AriAelU4SHsSACkRUQS\nxWV0K5hzTv4ecvCbG9dskiDCwWg+uTRSoAFeZOhONL000q7Vey3DZTcLl8/O4NQV\naZR5iAgVWlWcswIDAQABo1AwTjAdBgNVHQ4EFgQUsimlIRDcJR0ofR7oM8KwHFOH\n+sIwHwYDVR0jBBgwFoAUsimlIRDcJR0ofR7oM8KwHFOH+sIwDAYDVR0TBAUwAwEB\n/zANBgkqhkiG9w0BAQsFAAOCAQEAWQl8SmbQoBV3tjOJ8zMlcN0xOPpSSNbx0g7E\nL/dQgJpet0McW62RHlgQAOKbS3PReo2nsRB/ZRyYDu4i13ZHZ8bMsGOES4BQpz13\nmtmXg9RhsXqL0eDYfBcjjtlruUbxhnALp4VN1zVdyWAPCj0eu3MxpgMWcyn50Qmi\nJSj/Equ/lLhve/wKvjG5WhnV8uRKRuFbFct0DHAHMnZqFHcGS5So0cYnSfK5fbBR\nNelGflhpbbPp0V0aXiqinqD0Ye3OaZdFq+2rP1oC/a5/Ou4LspY3b5oD9rENdy7b\nq0KewPFtgPvUkJrJ3TzbiwvpghZ7zG26bnJ5I7uc4y1VujqaOA==\n-----END CERTIFICATE-----");
    public static final CertData BOGUS_CA_CERT = new CertData("-----BEGIN CERTIFICATE-----\nMIIC8TCCAdmgAwIBAgIJAP2af/EIgk6oMA0GCSqGSIb3DQEBCwUAMA8xDTALBgNV\nBAMMBFJvb3QwHhcNMTQxMTE5MTEwNDMyWhcNMzQxMTE0MTEwNDMyWjAPMQ0wCwYD\nVQQDDARSb290MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtPB0EtUf\naVS9LRljaL4NTYp0tJooMrRTI4ht4ixIv7m6XTSbxVjOtY0228ZPWeUE/3wduezW\n1rWNU4Uh4ezW0rw9CmW6m2zsMjjGwjY4A5ctMRDlgQtxzfHSPWPtTixtBr3YpdcP\nmg9xVIYvSHZ+fA3x5dRFRxdNidVrndVINzUoaoD9hZ/sgCKg9c2hdDSO9prrTpXD\nyatgLZ8LsFJO94HrkfFsQqquwxxvpixyWtjWUpnO28jnbDRC0ADOp/WZQ8exOP+a\nXUcrHdIsC0RcB6csnM6EarfwEm1jnBwDi37Rxk2BFiBYyzEbCrn7M6QY/DQrZJbw\n9gzSIvT2+5OvawIDAQABo1AwTjAdBgNVHQ4EFgQUYo97/In/SDI+pKRTSrSVhPyq\n5UQwHwYDVR0jBBgwFoAUYo97/In/SDI+pKRTSrSVhPyq5UQwDAYDVR0TBAUwAwEB\n/zANBgkqhkiG9w0BAQsFAAOCAQEABuUZ+sF4QD8H+PHvJLz+3+puXYvvE2IpcC65\nRQznp5iq5Rs4oGJvYwyD1bVUbCNz1IoyB9Lfo5QmSuyV1JybalBZ9FCDzZunBT3O\n4Tr6KfziVPHat3vYMNzzJY/IU3u6uLDmqm1J6qoSBkq4yL1AaHFon2j9gT3FXvVk\n7f1DjztAplWQBC4ScepJbiIRJkLxThDmM2g1xKUtZ6LlPL5J5CmXutzWbV5YS1eo\nuVrDRTmXr4wLzpcURWWB2gbPc0l7+1TfvTydVEp7YqN1EhvNmvsejiQCy+4Cq/D1\nm4rBV4SLLaHstTQNqcK1djxy2FbpYD7j5Himdc0oUeYif9gZ9g==\n-----END CERTIFICATE-----\n");

    /* renamed from: a  reason: collision with root package name */
    private static JsonWebSignature f26047a = null;

    @Beta
    /* loaded from: classes5.dex */
    public static class CertData {

        /* renamed from: a  reason: collision with root package name */
        private String f26048a;

        public CertData(String str) {
            this.f26048a = str;
        }

        public String getBase64Der() throws IOException {
            return Base64.encodeBase64String(getDer());
        }

        public Certificate getCertfificate() throws IOException, CertificateException {
            return SecurityUtils.getX509CertificateFactory().generateCertificate(new ByteArrayInputStream(getDer()));
        }

        public byte[] getDer() throws IOException {
            return PemReader.readFirstSectionAndClose(new StringReader(this.f26048a), "CERTIFICATE").getBase64DecodedBytes();
        }

        public X509TrustManager getTrustManager() throws IOException, GeneralSecurityException {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry(TranslateLanguage.CATALAN, getCertfificate());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        }
    }

    public static JsonWebSignature getJsonWebSignature() throws IOException {
        if (f26047a == null) {
            JsonWebSignature.Header header = new JsonWebSignature.Header();
            header.setAlgorithm("RS256");
            ArrayList newArrayList = Lists.newArrayList();
            newArrayList.add(FOO_BAR_COM_CERT.getBase64Der());
            newArrayList.add(CA_CERT.getBase64Der());
            header.setX509Certificates(newArrayList);
            JsonWebToken.Payload payload = new JsonWebToken.Payload();
            payload.set("foo", (Object) "bar");
            int indexOf = JWS_SIGNATURE.indexOf(46, 2723);
            f26047a = new JsonWebSignature(header, payload, Base64.decodeBase64(JWS_SIGNATURE.substring(indexOf + 1)), StringUtils.getBytesUtf8(JWS_SIGNATURE.substring(0, indexOf)));
        }
        return f26047a;
    }
}
