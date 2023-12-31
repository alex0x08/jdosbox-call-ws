package jdos.misc.setup;

import jdos.util.StringRef;

import java.util.Collections;
import java.util.Vector;

public class CommandLine {
    public CommandLine(String[] args) {
        cmds = new Vector<>(args.length);
        Collections.addAll(cmds, args);
        // :TODO: file_name = ?
    }

    public CommandLine(String name,String cmdline) {
        cmds = new Vector<>();
        file_name=name;
        /* Parse the cmds and put them in the list */
        boolean inword,inquote;char c;
        inword=false;inquote=false;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<cmdline.length();i++) {
            c = cmdline.charAt(i);
            if (inquote) {
                if (c!='"')
                    str.append(c);
                else {
                    inquote=false;
                    cmds.addElement(str.toString());
                    str = new StringBuilder();
                }
            } else if (inword) {
                if (c!=' ')
                    str.append(c);
                else {
                    inword=false;
                    cmds.addElement(str.toString());
                    str = new StringBuilder();
                }
            }
            else if (c=='"') { inquote=true;}
            else if (c!=' ') { str.append(c);inword=true;}
        }
        if (inword || inquote) cmds.addElement(str.toString());
    }

    public String GetFileName() {
        return file_name;
    }
    public boolean FindExist(String name) {
        return FindExist(name, false);
    }
    public boolean FindExist(String name, boolean remove) {
        int index = FindEntry(name, false);
        if (index < 0) return false;
        if (remove) cmds.removeElementAt(index);
        return true;
    }
    public Integer FindInt(String name) {
        return FindInt(name, false);
    }
    public Integer FindInt(String name, boolean remove) {
        int index = FindEntry(name, true);
        if (index < 0) return null;
        try {
            Integer result = Integer.parseInt(cmds.elementAt(index+1), 10);
            if (remove) {
                cmds.removeElementAt(index);
                cmds.removeElementAt(index);
            }
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String FindString(String name, boolean remove) {
        int index = FindEntry(name, true);
        if (index < 0) return null;
        String result = cmds.elementAt(index+1);
        if (remove) {
            cmds.removeElementAt(index);
            cmds.removeElementAt(index);
        }
        return result;
    }

    public String FindCommand(int which) {
        if (which<1) return null;
        if (which>cmds.size()) return null;
        return cmds.elementAt(which-1);
    }

    public String FindStringBegin(String begin, boolean remove) {
        begin = begin.toLowerCase();
        for (int i=0;i<cmds.size();i++) {
            if (cmds.elementAt(i).toLowerCase().startsWith(begin)) {
                String result = cmds.elementAt(i);
                if (remove)
                    cmds.removeElementAt(i);
                return result;
            }
        }
        return null;
    }
    /* Only used for parsing command.com /C
     * Allowing /C dir and /Cdir
     * Restoring quotes back into the commands so command /C mount d "/tmp/a b" works as intended
     */
    public boolean FindStringRemainBegin(String name,StringRef value) {
        int i;
        value.value = "";
        if ((i=FindEntry(name, false)) < 0) {
            int len = name.length();
            boolean found = false;
            for (i = 0; i < cmds.size(); i++) {
                String s = cmds.elementAt(i);
                if (s.length() > len) s = s.substring(0, len);
                if (s.equalsIgnoreCase(name)) {
                    String temp = "";
                    s = cmds.elementAt(i);
                    if (s.length() > len)
                        temp = s.substring(len);
                    //Restore quotes for correct parsing in later stages
                    if (temp.contains(" "))
                        value.value = "\"" + temp + "\"";
                    else
                        value.value = temp;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        i++;
        StringBuilder sb = new StringBuilder(value.value);
        for (; i < cmds.size(); i++) {
            sb.append(" ");
            String temp = cmds.elementAt(i);
            if (temp.contains(" "))
                sb.append("\"").append(temp).append("\"");
            else
                sb.append(temp);
        }
        value.value = sb.toString();
        return true;
    }

    public String GetStringRemain() {
        if (cmds.size() == 0) return null;
        StringBuilder value = new StringBuilder();
        for (int i=0;i<cmds.size();i++) {
            if (i>0)
                value.append(" ");
            value.append(cmds.elementAt(i));
        }
        return value.toString();
    }

  public void Shift(int amount) {
        for (int i=0;i<amount;i++) {
            file_name = cmds.size()>0? cmds.elementAt(0) :"";
            if (cmds.size()>0) cmds.removeElementAt(0);
        }
    }
    public int GetCount() {
        return cmds.size();
    }
    public int Get_arglength() {
        int result = 0;
        for (int i=0;i<cmds.size();i++) {
            if (i>0)
                result++;
            result+= cmds.elementAt(i).length();
        }
        return result;
    }

    private final Vector<String> cmds;
    private String file_name;
    private int FindEntry(String name, boolean needNext) {
        for (int i=0;i<cmds.size();i++) {
            if (cmds.elementAt(i).equalsIgnoreCase(name)) {
                if (needNext && i==cmds.size()-1)
                    return -1;
                return i;
            }
        }
        return -1;
    }
}
