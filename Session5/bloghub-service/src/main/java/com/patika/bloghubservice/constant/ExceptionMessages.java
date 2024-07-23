package com.patika.bloghubservice.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String USER_NOT_FOUND = "Kullanıcı bulunamadı!";

    public static final String USER_ALREADY_DEFINED = "Bu email ile kayıtlı kullanıcı zaten var!";

    public static final String USER_EMAIL_CAN_NOT_BE_EMPTY = "Email alanı boş olamaz!";

}
