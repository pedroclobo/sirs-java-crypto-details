package pt.ulisboa.tecnico.meic.sirs;

import java.nio.charset.StandardCharsets;

import javax.xml.bind.DatatypeConverter;

/**
 * Decode a file with Base64
 */
public class Base64Decode {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("This program decodes a file with base64.");
            System.out.println("Usage: base64-decode <inputFile> <outputFile>");
            return;
        }

        FileMixer.mix(args[0], args[1], new ByteArrayMixer() {
            @Override
            public byte[] mix(byte[] byteArray1, byte[] byteArray2) {
                return DatatypeConverter.parseBase64Binary(new String(byteArray1, StandardCharsets.UTF_8));
            }
        });
    }
}
