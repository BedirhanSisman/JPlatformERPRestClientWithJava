/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclientjplatform;


import java.util.Base64;
import javax.swing.ImageIcon;

/**
 *
 * @author Bedirhan.Sisman
 */
public class CommonFunctions {
    
    public static String getEncodedAuthToken(){
        String USER_NAME = InformationsDTO.getInstance().getUserName();
        String CLIENT_TOKEN = InformationsDTO.getInstance().getClientToken();
        String AUTH_TOKEN = InformationsDTO.getInstance().getAuthToken();
        String header = CLIENT_TOKEN + ":" + AUTH_TOKEN + ":" + USER_NAME;
        //1:3e11f7fa1206775136:admin
        String basicAuth = Base64.getEncoder().encodeToString(header.getBytes());
        
        return basicAuth;
    }
    
    public static String formatJSONStr(final String json_str, final int indent_width) {
        final char[] chars = json_str.toCharArray();
        final String newline = System.lineSeparator();

        String ret = "";
        boolean begin_quotes = false;

        for (int i = 0, indent = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == '\"') {
                ret += c;
                begin_quotes = !begin_quotes;
                continue;
            }

            if (!begin_quotes) {
                switch (c) {
                case '{':
                case '[':
                    ret += c + newline + String.format("%" + (indent += indent_width) + "s", "");
                    continue;
                case '}':
                case ']':
                    ret += newline + ((indent -= indent_width) > 0 ? String.format("%" + indent + "s", "") : "") + c;
                    continue;
                case ':':
                    ret += c + " ";
                    continue;
                case ',':
                    ret += c + newline + (indent > 0 ? String.format("%" + indent + "s", "") : "");
                    continue;
                default:
                    if (Character.isWhitespace(c)) continue;
                }
            }

            ret += c + (c == '\\' ? "" + chars[++i] : "");
        }

        return ret;
    }
    
}
