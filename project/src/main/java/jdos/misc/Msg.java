package jdos.misc;

import jdos.Dosbox;
import jdos.misc.setup.Prop_path;
import jdos.misc.setup.Section_prop;

import java.io.*;
import java.util.Objects;
import java.util.Vector;

public class Msg {
    static class MessageBlock {
        final String name;
        final String val;
        public MessageBlock(String _name, String _val) {
            name = _name;
            val = _val;
        }
    }

    static final Vector<MessageBlock> Lang = new Vector<>();

    static public void add(String name, String value) {
        for (int i=0;i<Lang.size();i++) {
            MessageBlock m = Lang.elementAt(i);
            if (m.name.equals(name))
                return;
        }
        Lang.add(new MessageBlock(name, value));
    }

    static public void replace(String name, String value) {
        for (int i=0;i<Lang.size();i++) {
            MessageBlock m = Lang.elementAt(i);
            if (m.name.equals(name))
                Lang.remove(m);
        }
        Lang.add(new MessageBlock(name, value));
    }

    static public void LoadMessageFile(String fname) {
        if (fname == null || fname.length()==0) return; //empty string=no languagefile
        FileReader fr=null;
        try {
            fr = new FileReader(fname);
        } catch (FileNotFoundException e) {
            Log.exit("MSG:Can't load messages: "+fname);
        }
        BufferedReader br = new BufferedReader(Objects.requireNonNull(fr));
        String linein;
        String name="";
        String string="";
        try {
            while ((linein=br.readLine()) != null) {
                /* New string name */
                if (linein.startsWith(":")) {
                    string="";
                    name=linein.substring(1);
                /* End of string marker */
                } else if (linein.startsWith(".")) {
                    /* Replace/Add the string to the internal languagefile */
			        /* Remove last newline (marker is \n.\n) */
                    if (string.endsWith("\n"))
                        string = string.substring(0, string.length()-1); //Second if should not be needed, but better be safe.
                    replace(name, string);
                } else {
                    string+=linein+"\n";
                }
            }
        } catch (IOException ignored) {

        }
        try {
            fr.close();
        } catch (Exception ignored) {
        }
    }

    static public String get(String msg) {
        for (int i=0;i<Lang.size();i++) {
            MessageBlock m = Lang.elementAt(i);
            if (m.name.equals(msg))
                return m.val;
        }
        return "Message not Found!\n";
    }

    static public void write(String location) {
        try (FileOutputStream fos = new FileOutputStream(location)) {
            for (int i = 0; i < Lang.size(); i++) {
                MessageBlock m = Lang.elementAt(i);
                String line = ":" + m.name + "\n" + m.val + "\n.\n";
                fos.write(line.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void init(Section_prop section) {
        String file_name = Dosbox.control.cmdline.FindString("-lang", true);
        if (file_name != null) {
            LoadMessageFile(file_name);
        } else {
            Prop_path pathprop = section.Get_path("language");
            if (pathprop != null) LoadMessageFile(pathprop.realpath);
        }
    }
}
