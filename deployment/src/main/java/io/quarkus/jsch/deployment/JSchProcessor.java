package io.quarkus.jsch.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.ExtensionSslNativeSupportBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;
import io.quarkus.deployment.builditem.nativeimage.RuntimeInitializedClassBuildItem;
import io.quarkus.jsch.runtime.PortWatcherRunTime;

class JSchProcessor {

    private static final String FEATURE = "jsch";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    ExtensionSslNativeSupportBuildItem sslNativeSupport() {
        return new ExtensionSslNativeSupportBuildItem(FEATURE);
    }

    @BuildStep
    RuntimeInitializedClassBuildItem runtimeInitialized() {
        return new RuntimeInitializedClassBuildItem(PortWatcherRunTime.class.getName());
    }

    @BuildStep
    ReflectiveClassBuildItem reflection() {
        //Classes that use reflection
        return ReflectiveClassBuildItem.builder(
                "com.jcraft.jsch.CipherNone",
                "com.jcraft.jsch.DH448",
                "com.jcraft.jsch.DH25519",
                "com.jcraft.jsch.DHEC256",
                "com.jcraft.jsch.DHEC384",
                "com.jcraft.jsch.DHEC521",
                "com.jcraft.jsch.DHECN",
                "com.jcraft.jsch.DHG1",
                "com.jcraft.jsch.DHG14",
                "com.jcraft.jsch.DHG14N",
                "com.jcraft.jsch.DHG15",
                "com.jcraft.jsch.DHG15N",
                "com.jcraft.jsch.DHG16",
                "com.jcraft.jsch.DHG16N",
                "com.jcraft.jsch.DHG17",
                "com.jcraft.jsch.DHG18",
                "com.jcraft.jsch.DHG14224",
                "com.jcraft.jsch.DHG14256",
                "com.jcraft.jsch.DHG15256",
                "com.jcraft.jsch.DHG15384",
                "com.jcraft.jsch.DHG16384",
                "com.jcraft.jsch.DHGEX",
                "com.jcraft.jsch.DHGEX1",
                "com.jcraft.jsch.DHGEX224",
                "com.jcraft.jsch.DHGEX256",
                "com.jcraft.jsch.DHGEX384",
                "com.jcraft.jsch.DHGEX512",
                "com.jcraft.jsch.DHGN",
                "com.jcraft.jsch.DHXEC",
                "com.jcraft.jsch.jce.AES128CBC",
                "com.jcraft.jsch.jce.AES128CTR",
                "com.jcraft.jsch.jce.AES192CBC",
                "com.jcraft.jsch.jce.AES192CTR",
                "com.jcraft.jsch.jce.AES256CBC",
                "com.jcraft.jsch.jce.AES256CTR",
                "com.jcraft.jsch.jce.AES128GCM",
                "com.jcraft.jsch.jce.AES256GCM",
                "com.jcraft.jsch.jce.AESGCM",
                "com.jcraft.jsch.jce.ARCFOUR",
                "com.jcraft.jsch.jce.ARCFOUR128",
                "com.jcraft.jsch.jce.ARCFOUR256",
                "com.jcraft.jsch.jce.BlowfishCBC",
                "com.jcraft.jsch.jce.BlowfishCTR",
                "com.jcraft.jsch.jce.DH",
                "com.jcraft.jsch.jce.ECDHN",
                "com.jcraft.jsch.jce.ECDH256",
                "com.jcraft.jsch.jce.ECDH384",
                "com.jcraft.jsch.jce.ECDH521",
                "com.jcraft.jsch.jce.HMAC",
                "com.jcraft.jsch.jce.HMACMD5",
                "com.jcraft.jsch.jce.HMACMD5ETM",
                "com.jcraft.jsch.jce.HMACMD596",
                "com.jcraft.jsch.jce.HMACMD596ETM",
                "com.jcraft.jsch.jce.HMACSHA1",
                "com.jcraft.jsch.jce.HMACSHA1ETM",
                "com.jcraft.jsch.jce.HMACSHA196",
                "com.jcraft.jsch.jce.HMACSHA196ETM",
                "com.jcraft.jsch.jce.HMACSHA224SSHCOM",
                "com.jcraft.jsch.jce.HMACSHA256",
                "com.jcraft.jsch.jce.HMACSHA256ETM",
                "com.jcraft.jsch.jce.HMACSHA2562SSHCOM",
                "com.jcraft.jsch.jce.HMACSHA384SSHCOM",
                "com.jcraft.jsch.jce.HMACSHA512",
                "com.jcraft.jsch.jce.HMACSHA512ETM",
                "com.jcraft.jsch.jce.HMACSHA512SSHCOM",
                "com.jcraft.jsch.jce.KeyPairGenDSA",
                "com.jcraft.jsch.jce.KeyPairGenECDSA",
                "com.jcraft.jsch.jce.KeyPairGenRSA",
                "com.jcraft.jsch.jce.MD5",
                "com.jcraft.jsch.jce.PBKDF",
                "com.jcraft.jsch.jce.Random",
                "com.jcraft.jsch.jce.SHA1",
                "com.jcraft.jsch.jce.SHA224",
                "com.jcraft.jsch.jce.SHA256",
                "com.jcraft.jsch.jce.SHA384",
                "com.jcraft.jsch.jce.SHA512",
                "com.jcraft.jsch.jce.SignatureDSA",
                "com.jcraft.jsch.jce.SignatureECDSA256",
                "com.jcraft.jsch.jce.SignatureECDSA384",
                "com.jcraft.jsch.jce.SignatureECDSA521",
                "com.jcraft.jsch.jce.SignatureECDSAN",
                "com.jcraft.jsch.jce.SignatureRSA",
                "com.jcraft.jsch.jce.SignatureRSAN",
                "com.jcraft.jsch.jce.SignatureRSASHA224SSHCOM",
                "com.jcraft.jsch.jce.SignatureRSASHA256",
                "com.jcraft.jsch.jce.SignatureRSASHA256SSHCOM",
                "com.jcraft.jsch.jce.SignatureRSASHA384SSHCOM",
                "com.jcraft.jsch.jce.SignatureRSASHA512",
                "com.jcraft.jsch.jce.SignatureRSASHA512SSHCOM",
                "com.jcraft.jsch.jce.TripleDESCBC",
                "com.jcraft.jsch.jce.TripleDESCTR",
                "com.jcraft.jsch.jgss.GSSContextKrb5",
                "com.jcraft.jsch.UserAuthGSSAPIWithMIC",
                "com.jcraft.jsch.UserAuthKeyboardInteractive",
                "com.jcraft.jsch.UserAuthNone",
                "com.jcraft.jsch.UserAuthPassword",
                "com.jcraft.jsch.UserAuthPublicKey")
                .fields().methods().build();
    }
}
