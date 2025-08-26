package com.chen.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public final class SymmetricCryptoUtil {

    private static final SecureRandom RANDOM = new SecureRandom();

    // AES-GCM 常量
    private static final String AES = "AES";
    private static final String AES_GCM_NO_PADDING = "AES/GCM/NoPadding";
    private static final int GCM_IV_LENGTH = 12; // 96 bits 推荐长度
    private static final int GCM_TAG_LENGTH = 128; // bits

    // AES-CBC 常量
    private static final String AES_CBC_PKCS5 = "AES/CBC/PKCS5Padding";
    private static final int CBC_IV_LENGTH = 16; // 128 bits

    private SymmetricCryptoUtil() {}

    /**
     * 生成随机 AES 密钥（bits = 128 / 192 / 256）
     */
    public static SecretKey generateAesKey(int bits) throws Exception {
        if (bits != 128 && bits != 192 && bits != 256) {
            throw new IllegalArgumentException("AES key size must be 128, 192 or 256 bits");
        }
        KeyGenerator kg = KeyGenerator.getInstance(AES);
        kg.init(bits, RANDOM);
        return kg.generateKey();
    }

    /**
     * AES-GCM 加密
     * 返回格式：Base64( IV || ciphertext )  （IV 前置，长度固定为 12 bytes）
     * 可选：additionalAuthData (AAD) 可为 null
     */
    public static String encryptAesGcm(SecretKey key, byte[] plaintext, byte[] aad) throws Exception {
        byte[] iv = new byte[GCM_IV_LENGTH];
        RANDOM.nextBytes(iv);
        Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING);
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        if (aad != null) cipher.updateAAD(aad);
        byte[] cipherBytes = cipher.doFinal(plaintext);

        // 拼接 IV + 密文（IV 固定长度）
        byte[] combined = new byte[iv.length + cipherBytes.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(cipherBytes, 0, combined, iv.length, cipherBytes.length);
        return Base64.getEncoder().encodeToString(combined);
    }

    /**
     * AES-GCM 解密
     * 输入为 Base64( IV || ciphertext )
     */
    public static byte[] decryptAesGcm(SecretKey key, String base64IvAndCipher, byte[] aad) throws Exception {
        byte[] combined = Base64.getDecoder().decode(base64IvAndCipher);
        if (combined.length < GCM_IV_LENGTH) throw new IllegalArgumentException("Invalid input");
        byte[] iv = new byte[GCM_IV_LENGTH];
        byte[] cipherBytes = new byte[combined.length - GCM_IV_LENGTH];
        System.arraycopy(combined, 0, iv, 0, GCM_IV_LENGTH);
        System.arraycopy(combined, GCM_IV_LENGTH, cipherBytes, 0, cipherBytes.length);

        Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING);
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        if (aad != null) cipher.updateAAD(aad);
        return cipher.doFinal(cipherBytes); // 若认证失败，这里会抛出 AEADBadTagException
    }

    /**
     * AES-CBC 加密（注意：没有认证）
     * 返回格式 Base64( IV || ciphertext )
     * 若对安全性有高要求，请对返回结果再做 HMAC-SHA256
     */
    public static String encryptAesCbc(SecretKey key, byte[] plaintext) throws Exception {
        byte[] iv = new byte[CBC_IV_LENGTH];
        RANDOM.nextBytes(iv);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5);
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] cipherBytes = cipher.doFinal(plaintext);

        byte[] combined = new byte[iv.length + cipherBytes.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(cipherBytes, 0, combined, iv.length, cipherBytes.length);
        return Base64.getEncoder().encodeToString(combined);
    }

    /**
     * AES-CBC 解密（输入 Base64( IV || ciphertext )）
     */
    public static byte[] decryptAesCbc(SecretKey key, String base64IvAndCipher) throws Exception {
        byte[] combined = Base64.getDecoder().decode(base64IvAndCipher);
        if (combined.length < CBC_IV_LENGTH) throw new IllegalArgumentException("Invalid input");
        byte[] iv = new byte[CBC_IV_LENGTH];
        byte[] cipherBytes = new byte[combined.length - CBC_IV_LENGTH];
        System.arraycopy(combined, 0, iv, 0, CBC_IV_LENGTH);
        System.arraycopy(combined, CBC_IV_LENGTH, cipherBytes, 0, cipherBytes.length);

        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5);
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        return cipher.doFinal(cipherBytes);
    }

    /**
     * 将 SecretKey 转为 Base64（方便保存/传输）
     */
    public static String secretKeyToBase64(SecretKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    /**
     * 从 Base64 恢复 SecretKey
     */
    public static SecretKey secretKeyFromBase64(String base64Key) {
        byte[] keyBytes = Base64.getDecoder().decode(base64Key);
        return new SecretKeySpec(keyBytes, AES);
    }

    // ------------------- 示例 main -------------------
    public static void main(String[] args) throws Exception {
        // 1) 生成或加载密钥（示例生成 256 位）
        SecretKey key = generateAesKey(256);
        String keyB64 = secretKeyToBase64(key);
        System.out.println("Base64 Key: " + keyB64);

        // 或者从 Base64 恢复：
        SecretKey loadedKey = secretKeyFromBase64(keyB64);

        String plain = "这是待加密的明文，包含中文/ASCII";
        byte[] aad = "associated-data".getBytes(StandardCharsets.UTF_8); // 可为空

        // AES-GCM 加密/解密（推荐）
        String cipherGcm = encryptAesGcm(loadedKey, plain.getBytes(StandardCharsets.UTF_8), aad);
        System.out.println("GCM Cipher(Base64 IV+C): " + cipherGcm);
        byte[] decGcm = decryptAesGcm(loadedKey, cipherGcm, aad);
        System.out.println("GCM Decrypted: " + new String(decGcm, StandardCharsets.UTF_8));

        // AES-CBC 加密/解密（兼容旧系统）
        String cipherCbc = encryptAesCbc(loadedKey, plain.getBytes(StandardCharsets.UTF_8));
        System.out.println("CBC Cipher(Base64 IV+C): " + cipherCbc);
        byte[] decCbc = decryptAesCbc(loadedKey, cipherCbc);
        System.out.println("CBC Decrypted: " + new String(decCbc, StandardCharsets.UTF_8));
    }
}

