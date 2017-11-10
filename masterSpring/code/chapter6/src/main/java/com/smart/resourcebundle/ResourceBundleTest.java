package com.smart.resourcebundle;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    public static void main(String[] args)
    {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("resource", Locale.US);
        ResourceBundle resourceBundle2 = ResourceBundle.getBundle("resource", Locale.CHINA);

        Object[] params = {"Leil", new GregorianCalendar().getTime()};

        String str1 = new MessageFormat(resourceBundle1.getString("greeting.common"), Locale.US).format(params);
        String str2 = new MessageFormat(resourceBundle2.getString("greeting.common"), Locale.CHINA).format(params);
        String str3 = new MessageFormat(resourceBundle2.getString("greeting.morning"), Locale.CHINA).format(params);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
