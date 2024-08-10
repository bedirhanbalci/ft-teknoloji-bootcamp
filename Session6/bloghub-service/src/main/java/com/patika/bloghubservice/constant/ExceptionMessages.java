package com.patika.bloghubservice.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String USER_NOT_FOUND = "Kullanıcı bulunamadı!";

    public static final String USER_ALREADY_DEFINED = "Bu email ile kayıtlı kullanıcı zaten var!";

    public static final String USER_EMAIL_CAN_NOT_BE_EMPTY = "Email alanı boş olamaz!";

    public static final String BLOG_NOT_FOUND = "Blog bulunamadı!";

    public static final String BLOG_CANNOT_BE_DELETED_IF_PUBLISHED = "Status'u PUBLISHED olan bir blog silinemez!";

}
