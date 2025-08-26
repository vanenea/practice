package com.chen.crypto;

import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.*;
import org.bouncycastle.crypto.signers.SM2Signer;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 非对称加解密算法
 */
public class RSA {

    public static void main(String[] args) throws Exception {
        bouncyCastleDemo();
        pemKeyLoadDemo();
    }


    public static void jdkRSA() throws Exception {
        // 1. 生成 RSA 密钥对（公钥 + 私钥）
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // 密钥长度
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("公钥：" + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("私钥：" + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // 待加密内容
        String message = "Hello, 非对称加密！";

        // 2. 公钥加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("加密后的密文：" + encryptedText);

        // 3. 私钥解密
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("解密后的明文：" + new String(decrypted));

        // 4. 私钥签名
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signBytes = signature.sign();
        String signText = Base64.getEncoder().encodeToString(signBytes);
        System.out.println("数字签名：" + signText);

        // 5. 公钥验签
        Signature verifySig = Signature.getInstance("SHA256withRSA");
        verifySig.initVerify(publicKey);
        verifySig.update(message.getBytes());
        boolean verifyResult = verifySig.verify(signBytes);
        System.out.println("验签结果：" + verifyResult);

    }

    public static void bouncyCastleDemo() throws Exception {
        // 注册 Bouncy Castle 提供者
        Security.addProvider(new BouncyCastleProvider());

        // 1. 生成 RSA 密钥对
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String message = "Hello, RSA with BouncyCastle!";

        // 2. 公钥加密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        String encryptedText = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
        System.out.println("RSA 加密：" + encryptedText);

        // 3. 私钥解密
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        String decryptedText = new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
        System.out.println("RSA 解密：" + decryptedText);

        // 4. 私钥签名
        Signature signature = Signature.getInstance("SHA256withRSA", "BC");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        String signText = Base64.getEncoder().encodeToString(signature.sign());
        System.out.println("RSA 签名：" + signText);

        // 5. 公钥验签
        Signature verifySig = Signature.getInstance("SHA256withRSA", "BC");
        verifySig.initVerify(publicKey);
        verifySig.update(message.getBytes());
        boolean verifyResult = verifySig.verify(Base64.getDecoder().decode(signText));
        System.out.println("RSA 验签结果：" + verifyResult);

    }

    /**
     * 国密算法
     */
    public static void bcSm2Demo() throws Exception {

        // 1) 准备域参数（不要用 ECParameterSpec，要用 ECDomainParameters）
        X9ECParameters x9 = GMNamedCurves.getByName("sm2p256v1");
        ECDomainParameters domain = new ECDomainParameters(
                x9.getCurve(), x9.getG(), x9.getN(), x9.getH(), x9.getSeed()
        );

        // 2) 生成密钥对
        SecureRandom random = new SecureRandom();
        ECKeyPairGenerator generator = new ECKeyPairGenerator();
        ECKeyGenerationParameters keyGenParam = new ECKeyGenerationParameters(domain, random);
        generator.init(keyGenParam);
        AsymmetricCipherKeyPair keyPair = generator.generateKeyPair();

        ECPrivateKeyParameters priKey = (ECPrivateKeyParameters) keyPair.getPrivate();
        ECPublicKeyParameters pubKey = (ECPublicKeyParameters) keyPair.getPublic();

        String msg = "Hello, SM2 国密加密！";
        byte[] data = msg.getBytes(StandardCharsets.UTF_8);

        // 3) 公钥加密（推荐 C1C3C2 模式）
        SM2Engine encEngine = new SM2Engine(SM2Engine.Mode.C1C3C2);
        encEngine.init(true, new ParametersWithRandom(pubKey, random));
        byte[] cipher = encEngine.processBlock(data, 0, data.length);
        System.out.println("SM2 加密：" + Base64.getEncoder().encodeToString(cipher));

        // 4) 私钥解密
        SM2Engine decEngine = new SM2Engine(SM2Engine.Mode.C1C3C2);
        decEngine.init(false, priKey);
        byte[] plain = decEngine.processBlock(cipher, 0, cipher.length);
        System.out.println("SM2 解密：" + new String(plain, StandardCharsets.UTF_8));

        // 5) 私钥签名（注意 ID，验签要一致；默认常用 "1234567812345678"）
        byte[] userId = "1234567812345678".getBytes(StandardCharsets.UTF_8);
        SM2Signer signer = new SM2Signer();
        signer.init(true, new ParametersWithID(new ParametersWithRandom(priKey, random), userId));
        signer.update(data, 0, data.length);
        byte[] sig = signer.generateSignature();
        System.out.println("SM2 签名：" + Base64.getEncoder().encodeToString(sig));

        // 6) 公钥验签（ID 必须与签名时一致）
        SM2Signer verifier = new SM2Signer();
        verifier.init(false, new ParametersWithID(pubKey, userId));
        verifier.update(data, 0, data.length);
        boolean ok = verifier.verifySignature(sig);
        System.out.println("SM2 验签结果：" + ok);
    }

    public static void pemKeyLoadDemo() throws Exception {
        // 假设这是已有的 Base64 公钥/私钥
        String pubPem = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE...";
        String priPem = "MIGHAgEAMBMGByqGSM49AgEGCCqB...";

        KeyFactory kf = KeyFactory.getInstance("EC", "BC");

        // 恢复公钥
        byte[] pubBytes = Base64.getDecoder().decode(pubPem);
        X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubBytes);
        PublicKey pubKey = kf.generatePublic(pubSpec);

        // 恢复私钥
        byte[] priBytes = Base64.getDecoder().decode(priPem);
        PKCS8EncodedKeySpec priSpec = new PKCS8EncodedKeySpec(priBytes);
        PrivateKey priKey = kf.generatePrivate(priSpec);

        System.out.println("公钥对象: " + pubKey);
        System.out.println("私钥对象: " + priKey);
    }
}
