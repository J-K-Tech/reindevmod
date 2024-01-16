package kn.jktech.anether;

import com.fox2code.foxloader.loader.Mod;
import com.fox2code.foxloader.registry.*;

import java.util.Random;

public class Anether extends Mod {

    @Override
    public void onPreInit() {
        log("initializing");
    }
public static void log(String str){System.out.println("!!! ANETHER !!! "+str);}
}
