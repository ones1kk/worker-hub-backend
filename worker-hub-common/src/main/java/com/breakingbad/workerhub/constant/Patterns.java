package com.breakingbad.workerhub.constant;


import java.util.regex.Pattern;

public class Patterns {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z\\d-_.]{2,}.+?@.{2,}?\\..{2,}$");

    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*#?&])[a-zA-Z\\d@$!%*#?&]{8,}$");

    public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(\\d{2,3})(\\d{3,4})(\\d{4})$");

    public static final Pattern NAME_PATTERN = Pattern.compile("^([a-zA-Z]).{2,16}|([가-힣]).{1,6}");

}
