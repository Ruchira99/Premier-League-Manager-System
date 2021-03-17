package com.leaguemanager.premierleaguemanager;

import java.io.File;
import java.io.IOException;

public class GuiThread implements Runnable{
    @Override
    public void run() { //execute cmd
        try {
            Process pr = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "cmd.exe", "/K", "\"ng serve --o\""}, null,
                    new File("../\\premier-league-manager\\ui"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
