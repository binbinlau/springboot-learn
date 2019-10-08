package binbinlau.springboot.converter;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * @Author LiuBin
 * @Date 2019/9/23 20:20
 **/
public class SerializableObjectConverter {

    public static String serialize(OAuth2Authentication object) {
        try {
            byte[] bytes = SerializationUtils.serialize(object);
            return Base64.encodeBase64String(bytes);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static OAuth2Authentication deserialize(String encodedObject) {
        try {
            byte[] bytes = Base64.decodeBase64(encodedObject);
            return (OAuth2Authentication) SerializationUtils.deserialize(bytes);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String serialize(OAuth2AccessToken object) {
        try {
            byte[] bytes = SerializationUtils.serialize(object);
            return Base64.encodeBase64String(bytes);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static OAuth2AccessToken deserialize1(String encodedObject) {
        try {
            byte[] bytes = Base64.decodeBase64(encodedObject);
            return (OAuth2AccessToken) SerializationUtils.deserialize(bytes);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String serialize(OAuth2RefreshToken object) {
        try {
            byte[] bytes = SerializationUtils.serialize(object);
            return Base64.encodeBase64String(bytes);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static OAuth2RefreshToken deserialize2(String encodedObject) {
        try {
            byte[] bytes = Base64.decodeBase64(encodedObject);
            return (OAuth2RefreshToken) SerializationUtils.deserialize(bytes);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
