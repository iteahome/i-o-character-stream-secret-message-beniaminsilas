package com.secretmessage;

import java.io.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
        import java.util.regex.PatternSyntaxException;

    public class SecretMessage {
        public static void main(String[] args) throws IOException {

            FileReader inputStream = new FileReader("src/main/resources/secret.txt");

            StringBuilder inputStringBuilder = new StringBuilder();
            try {
                int chars;
                while ((chars = inputStream.read()) != -1) {
                    inputStringBuilder.append((char)chars);
                }
            } finally {
                inputStream.close();
            }
            String firstMessage = inputStringBuilder.toString();

            StringBuilder parseStringBuilder = new StringBuilder();
            try {
                Pattern pattern = Pattern.compile("[A-Z]+");
                Matcher matcher = pattern.matcher(firstMessage);
                while (matcher.find()) {
                    for (int i = 0; i <= matcher.groupCount(); i++) {
                        parseStringBuilder.append(matcher.group(i));
                    }
                }
            } catch (PatternSyntaxException e) {}
            String hiddenMessage = parseStringBuilder.toString().replace("X", " ");

            System.out.println(hiddenMessage);

        }
    }
