package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ContentType {

    /* 텍스트 */
    TEXT("text/plain", "text"),

    CSS("text/css", "css"),

    HTML("text/html", "html"),

    JAVASCRIPT("text/javascript", "javascript"),

    PLAIN("text/plain", "plain"),
    /* 텍스트 */

    /* 이미지 */
    PNG("image/png", "png"),

    JPEG("image/Jpeg", "jpeg"),

    GIF("image/gif", "gif"),

    WEBP("image/webp", "webp"),
    /* 이미지 */

    /* 파일 */
    DOC("application/msword", "msword"),

    PDF("application/pdf", "pdf"),

    XLS("application/vnd.ms-excel", "xls"),

    JS("application/javascript", "javascript"),

    ZIP("application/zip", "zip"),

    TXT("text/plain", "plain"),

    XML("text/xml", "xml"),

    XSL("text/xsl", "xsl"),
    /* 파일 */

    MULTIPART("multipart/form-data", "multipart"),

    /* 어플리케이션 */
    FORM("application/x-www-form-urlencode", "form"),

    JSON("application/json", "json");
    /* 어플리케이션 */

    private final String value;

    private final String var;

}
